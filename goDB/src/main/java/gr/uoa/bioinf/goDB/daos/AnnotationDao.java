package gr.uoa.bioinf.goDB.daos;


import gr.uoa.bioinf.goDB.models.Annotation;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
// afti i klasi sindeetai me ti vasi
public class AnnotationDao {
    @PersistenceContext
    private EntityManager entityManager;

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
