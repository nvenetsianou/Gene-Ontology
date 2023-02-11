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

    public List getAnnotationByGeneSymbol() {
        Query query =  entityManager.createQuery("select a from Annotation a where Annotation.gene_symbol=:gene_symbol");
        return query.getResultList();
    }

    public List getAnnotationByGoClassAccession() {
        Query query =  entityManager.createQuery("select a from Annotation a where Annotation.go_class_accession=:go_class_accession");
        return query.getResultList();
    }

    public List findByOrganism() {
        Query query =  entityManager.createQuery("select a from Annotation a where Annotation.organism=:organism");
        return query.getResultList();
    }

    public List findByOrganismAndSymbol() {
        Query query =  entityManager.createQuery("select a from Annotation a where " +
                "Annotation.organism=:organism and Annotation.gene_symbol=:gene_symbol");
        return query.getResultList();
    }

    public List findByOrganismAndAccession() {
        Query query =  entityManager.createQuery("select a from Annotation a where " +
                "Annotation.organism=:organism and Annotation.go_class_accession=:go_class_accession");
        return query.getResultList();
    }
    // tha einai typoy epilegw gene -> show annotation -> epilogh extension
    public List findByAnnotationExtension() {
        Query query =  entityManager.createQuery("select a from Annotation a where Annotation.annotation_extension=:extension");
        return query.getResultList();
    }

    public List findByAnnotationQualifier() {
        Query query =  entityManager.createQuery("select a from Annotation a where Annotation.annotation_qualifier=:annotation_qualifier");
        return query.getResultList();
    }

    public List findByEvidence() {
        Query query =  entityManager.createQuery("select a from Annotation a where Annotation.evidence=:evidence");
        return query.getResultList();
    }

    public  List findByReference() {
        Query query =  entityManager.createQuery("select a from Annotation a where Annotation.evidence=:evidence");
        return query.getResultList();
    }

}
