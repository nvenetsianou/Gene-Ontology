package gr.uoa.bioinf.goDB.daos;


import gr.uoa.bioinf.goDB.models.Annotation;

import java.util.List;

// afti i klasi sindeetai me ti vasi
public class AnnotationDao {

    //getAllAnnotations, findAllAnnotations
    //getOne, findone


    //findByOrganism
    public List<Annotation> findByOrganism(String organism) {
        // select * from annotation where organism = :organism
    }
}
