package gr.uoa.bioinf.goDB.daos;


import gr.uoa.bioinf.goDB.models.Annotation;

import java.util.List;

// afti i klasi sindeetai me ti vasi
public class AnnotationDao {

    //getAllAnnotations, findAllAnnotations
    //getOne, findone


    //findByOrganism
    public List<Annotation> findByOrganism(String organism) {
        // select * from annotation where annotation.organism = organism
    }

    public List<Annotation> findBySymbol(String symbol) {
        // select * from annotation where annotation.symbol == symbol;
    }

    public List<Annotation> findByOrganismAndSymbol(String Organism, String symbol) {
        // select * from annotation where annotation.organism == organism and annotation.symbol == symbol;
    }

    public List<Annotation> findByGoClassAccession(String go_class_accession) {
        // select * from annotation where annotation.go_class_accession == go_class_accession;
    }

    public List<Annotation> findByAnnotationExtension(String annotation_extension) {
        // select * from annotation where annotation.annotation_extension == annotation_extension;
    }

    public List<Annotation> findByAnnotationQualifier(String annotation_qualifier) {
        // select * from annotation where annotation.annotation_qualifier == annotation_qualifier;
    }

    public List<Annotation> findByEvidence(String evidence) {
        // select * from annotation where annotation.evidence == evidence;
    }

    public  List<Annotation> findByReference(String reference) {
        // select * from annotation where annotation.reference == reference;
    }

}
