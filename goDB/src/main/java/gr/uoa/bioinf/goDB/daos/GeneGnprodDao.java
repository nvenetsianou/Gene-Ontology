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

    public List<GeneGnprod> updateGeneGnprod(String symbol) {
        // database....update where where GeneGnprod.symbol == symbol;
    }

    public List<GeneGnprod> findByOrganism(String organism) {
        // database ... select * where GeneGnprod.organism == organism;
    }

    public  List<GeneGnprod> findByName(String name) {
        // database ... select * from where GeneGnprod.name == (or LIKE) name;
    }

    public List<GeneGnprod> getSynonyms(String synonyms) {
        // database... select * from where GeneGnprod.synonyms == synonyms;
    }

    public List<GeneGnprod> finfByGeneType(String gene_type){
        // database... select * from where GeneGnprod.gene_type == gene_type;
    }

    
}
