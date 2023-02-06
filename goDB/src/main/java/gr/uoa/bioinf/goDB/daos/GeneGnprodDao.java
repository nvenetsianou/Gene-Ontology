package gr.uoa.bioinf.goDB.daos;
import gr.uoa.bioinf.goDB.models.GeneGnprod;
import gr.uoa.bioinf.goDB.models.GoClass;

import java.util.List;

public class GeneGnprodDao {
    public List<GeneGnprod> getAllGeneGnprod {
        // database....select * from gene_gnprod;
    }

    public List<GeneGnprod> getOneGeneGnprod {
        // database...select * where GeneGnprod.symbol == symbol;
    }

    public List<GeneGnprod> updateGeneGnprod() {
        // database....update where where GeneGnprod.symbol == symbol;
    }
}
