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
import org.springframework.stereotype.Repository;
import org.thymeleaf.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Repository
// afti i klasi sindeetai me ti vasi
public class AnnotationDao {
    @PersistenceContext
    private EntityManager entityManager;

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
        List<Annotation> results = typedQuery.getResultList();
        return results;
    }

    //////////// DELETE

    // genesymbol, name
    // organism,
    public List searchGenes(SearchObject searchObject) {
        String term = "%" ;
        String q = "select a from Annotation a where (a.geneSymbol like :term or a.geneGnprod.name like :term)";
        if(!StringUtils.isEmpty(searchObject.getOrganism()) && !"0".equals(searchObject.getOrganism())) {
            q += " and a.organism=:organism ";
        }
        Query query =  entityManager.createQuery(q);
        query.setParameter("term", term);

        if(!StringUtils.isEmpty(searchObject.getOrganism()) && !"0".equals(searchObject.getOrganism())) {
            query.setParameter("organism", searchObject.getOrganism());
        }
        return query.getResultList();
    }

    // goclassaccession, definition,
    // ontology source
    public List searchGoClasses(SearchObject searchObject) {
        String term = "%" ;
        String q = "select a from Annotation a where (a.goClassAccession like :term or a.goClass.definition like :term) ";
        // build query according to the search parameters
        if(!StringUtils.isEmpty(searchObject.getOrganism()) && !"0".equals(searchObject.getOrganism())) {
            q += " and a.organism=:organism ";
        }
        if(!StringUtils.isEmpty(searchObject.getOntologySource()) && !"0".equals(searchObject.getOntologySource())) {
            q += " and a.goClass.ontologySource=:ontologySource ";
        }

        Query query =  entityManager.createQuery(q);
        query.setParameter("term", term);

        if(!StringUtils.isEmpty(searchObject.getOrganism()) && !"0".equals(searchObject.getOrganism())) {
            query.setParameter("organism", searchObject.getOrganism());
        }
        if(!StringUtils.isEmpty(searchObject.getOntologySource()) && !"0".equals(searchObject.getOntologySource())) {
            query.setParameter("ontologySource", searchObject.getOntologySource());
        }

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

    public List getSynonyms() {
        Query query = entityManager.createQuery("select distinct(a.geneGnprod.synonyms) from Annotation a");
        return query.getResultList();
    }


    ///

    //getAllAnnotations, findAllAnnotations
    //getOne, findone
    public List getAllAnnotation() {
        Query query = entityManager.createQuery("select a from Annotation a");
        return query.getResultList();
    }

    public List getAnnotationByGeneSymbol(String geneSymbol) {
        Query query =  entityManager.createQuery("select a from Annotation a where a.geneSymbol=:geneSymbol");
        query.setParameter("geneSymbol", geneSymbol);
        return query.getResultList();
    }

    public List getAnnotationByGoClassAccession(String goClassAccession) {
        Query query =  entityManager.createQuery("select a from Annotation a where a.goClassAccession=:goClassAccession");
        query.setParameter("goClassAccession", goClassAccession);
        return query.getResultList();
    }

    public List findByOrganism(String organism) {
        Query query =  entityManager.createQuery("select a from Annotation a where a.organism=:organism");
        query.setParameter("organism", organism);
        return query.getResultList();
    }
    // check this
    public List findByOrganismAndSymbol(String organism, String symbol) {
        Query query =  entityManager.createQuery("select a from Annotation a where " +
                "a.organism=:organism and a.geneSymbol=:symbol");
        query.setParameter("organism", organism);
        query.setParameter("symbol", symbol);
        return query.getResultList();
    }
    // check this
    public List findByOrganismAndAccession(String organism, String accession) {
        Query query =  entityManager.createQuery("select a from Annotation a where " +
                "a.organism=:organism and a.goClassAccession=:goClassAccession");
        query.setParameter("organism", organism);
        query.setParameter("accession", accession);
        return query.getResultList();
    }
    // tha einai typoy epilegw gene -> show annotation -> epilogh extension
    public List findByAnnotationExtension(String annotationExtension) {
        Query query =  entityManager.createQuery("select a from Annotation a where a.annotationExtension=:extension");
        return query.getResultList();
    }

    public List findByAnnotationQualifier(String annotationQualifier) {
        Query query =  entityManager.createQuery("select a from Annotation a where a.annotationQualifier=:annotationQualifier");
        query.setParameter("annotationQualifier", annotationQualifier);
        return query.getResultList();
    }

    public List findByEvidence(String evidence) {
        Query query =  entityManager.createQuery("select a from Annotation a where a.evidence=:evidence");
        query.setParameter("evidence", evidence);
        return query.getResultList();
    }

    public  List findByReference(String reference) {
        Query query =  entityManager.createQuery("select a from Annotation a where a.reference=:reference");
        query.setParameter("reference",reference);
        return query.getResultList();
    }

}
