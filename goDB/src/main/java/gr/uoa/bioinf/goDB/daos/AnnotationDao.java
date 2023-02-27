package gr.uoa.bioinf.goDB.daos;


import gr.uoa.bioinf.goDB.models.Annotation;
import gr.uoa.bioinf.goDB.models.GeneGnprod;
import gr.uoa.bioinf.goDB.models.GoClass;
import gr.uoa.bioinf.goDB.models.SearchObject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import org.thymeleaf.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AnnotationDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Annotation findByGeneSymbolAndGoClassAccession(String geneSymbol, String goClassAccession) {
        Query query =  entityManager.createQuery("select a from Annotation a where a.geneSymbol=:geneSymbol and a.goClassAccession=:goClassAccession");
        query.setParameter("geneSymbol", geneSymbol);
        query.setParameter("goClassAccession", goClassAccession);
        return (Annotation) query.getResultList().get(0);
    }

    public List search(SearchObject searchObject) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Annotation> cq = cb.createQuery(Annotation.class);
        Root<Annotation> annotationRoot = cq.from(Annotation.class);
        Join<Annotation, GoClass> annotationGoClass = null;
        List<Predicate> orPredicates = new ArrayList<>();
        List<Predicate> andPredicates = new ArrayList<>();
        Predicate finalQuery;
        cq.select(annotationRoot);

        if(!StringUtils.isEmpty(searchObject.getGeneTerm())) {
            String geneTerm = "%" + searchObject.getGeneTerm() + "%";
            Join<Annotation, GeneGnprod> annotationGene = annotationRoot.join("geneGnprod");
            orPredicates.add(cb.like(annotationRoot.get("geneSymbol"), geneTerm));
            orPredicates.add(cb.like(annotationGene.get("name"), geneTerm));
        }

        if(!StringUtils.isEmpty(searchObject.getGoClassTerm())) {
            String goClassTerm = "%" + searchObject.getGoClassTerm() + "%";
            annotationGoClass = annotationRoot.join("goClass");
            orPredicates.add(cb.like(annotationRoot.get("goClassAccession"), goClassTerm));
            orPredicates.add(cb.like(annotationGoClass.get("definition"), goClassTerm ));
        }

        if(!StringUtils.isEmpty(searchObject.getOrganism()) && !"0".equals(searchObject.getOrganism())) {
            andPredicates.add(cb.equal(annotationRoot.get("organism"), searchObject.getOrganism()));
        }

        if(!StringUtils.isEmpty(searchObject.getOntologySource()) && !"0".equals(searchObject.getOntologySource())) {
            if (annotationGoClass == null ) {
                annotationGoClass = annotationRoot.join("goClass");
            }
            andPredicates.add(cb.equal(annotationGoClass.get("ontologySource"), searchObject.getOntologySource()));
        }

        Predicate orQueries = cb.or(orPredicates.toArray(new Predicate[0]));
        Predicate andQueries = cb.and(andPredicates.toArray(new Predicate[0]));

        if(orPredicates.isEmpty() && !andPredicates.isEmpty()) {
            finalQuery = andQueries;
            cq.where(finalQuery);
        }
        if(!orPredicates.isEmpty() && andPredicates.isEmpty()) {
            finalQuery = orQueries;
            cq.where(finalQuery);
        }
        if(!orPredicates.isEmpty() && !andPredicates.isEmpty()) {
            finalQuery = cb.and(orQueries, andQueries);
            cq.where(finalQuery);
        }

        TypedQuery<Annotation> typedQuery = entityManager.createQuery(cq);
        List<Annotation> results = typedQuery.setMaxResults(200).getResultList(); // instead of pagination
        return results;
    }

    @Transactional
    public void persist(Annotation annotation) {
        annotation.getGeneGnprod().setSymbol(annotation.getGeneSymbol());
        annotation.getGeneGnprod().setOrganism(annotation.getOrganism());
        annotation.getGoClass().setAccession(annotation.getGoClassAccession());

        entityManager.persist(annotation.getGeneGnprod());
        entityManager.persist(annotation.getGoClass());
        entityManager.persist(annotation);
    }

    @Transactional
    public void update(Annotation annotation) {
        annotation.getGeneGnprod().setSymbol(annotation.getGeneSymbol());
        annotation.getGeneGnprod().setOrganism(annotation.getOrganism());
        annotation.getGoClass().setAccession(annotation.getGoClassAccession());

        entityManager.merge(annotation);
    }

    @Transactional
    public void delete(Annotation annotation) {
        entityManager.remove(annotation);
        flushAndClear();
        entityManager.remove(annotation.getGeneGnprod());
        flushAndClear();
        entityManager.remove(annotation.getGoClass());
        flushAndClear();
    }

    void flushAndClear() {
        entityManager.flush();
        entityManager.clear();
    }

    public List getGenesGroupedByOrganism() {
        Query query =  entityManager.createQuery("select g.organism, count(*) from GeneGnprod g group by g.organism");
        return query.getResultList();
    }

    public List getGoClassesGroupedByOntologySource() {
        Query query =  entityManager.createQuery("select g.ontologySource, count(*) from GoClass g group by g.ontologySource");
        return query.getResultList();
    }

    public List getOrganisms() {
        Query query =  entityManager.createQuery("select distinct(a.organism) from Annotation a");
        return query.getResultList();
    }

    public List getOntologySources() {
        Query query = entityManager.createQuery("select distinct(a.goClass.ontologySource) from Annotation a");
        return query.getResultList();
    }

    public List getEvidences() {
        Query query = entityManager.createQuery("select distinct(a.evidence) from Annotation a");
        return query.getResultList();
    }

    public List getSynonyms() {
        Query query = entityManager.createQuery("select distinct(a.geneGnprod.synonyms) from Annotation a");
        return query.getResultList();
    }

}
