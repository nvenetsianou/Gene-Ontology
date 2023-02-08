package gr.uoa.bioinf.goDB.daos;

import gr.uoa.bioinf.goDB.models.GoClass;
import java.util.List;


public class GoClassDao {
    public List<GoClass> getAllGOclasses {
           // database....select * from go_class;
    }

    public List<GoClass> getOneClass {
        // database...select * where GoClass.accession == accession;
    }

    public List<GoClass> updateGoClass {
        // database....update where GoClass.accession == accession;
    }

    public List<GoClass> findByOntologySource(String ontology_source) {
        // database... select * where GoClass.ontology_source == ontology_source;
    }

    public List<GoClass> getDefinition(String definition) {
        // database... select * where GoClass.definition LIKE "..";
    }
}
