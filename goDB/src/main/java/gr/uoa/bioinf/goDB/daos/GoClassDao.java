package gr.uoa.bioinf.goDB.daos;

import gr.uoa.bioinf.goDB.models.GoClass;
import java.util.List;


public class GoClassDao {
    public List<GoClass> getAllGOclasses {
           // database....select * from go_class;
    }

    public List<GoClass> getOneClass {
        // database...select * where go_class.accession==accession;
    }

    public List<GoClass> updateGoClass() {
        // database....update where go_class.accession==accession;
    }
}
