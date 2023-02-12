package gr.uoa.bioinf.goDB.daos;
import gr.uoa.bioinf.goDB.models.GeneGnprod;
import gr.uoa.bioinf.goDB.models.GoClass;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class GeneGnprodDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List getAllGeneGnprod() {
        Query query = entityManager.createQuery("select gnpr from GeneGnprod gnpr");
        return query.getResultList();
    }

    public List getOneGeneGnprod(String symbol) {
        Query query = entityManager.createQuery("select gnpr from GeneGnprod gnpr where gnpr.symbol=:symbol");
        query.setParameter("symbol", symbol);
        return query.getResultList();
    }

    /* not sure
    public List<GeneGnprod> updateGeneGnprod(String symbol) {
        // database....update where where GeneGnprod.symbol == symbol;
        return null;
    } */

    public List findByOrganism(String organism) {
        Query query = entityManager.createQuery("select gnpr from GeneGnprod gnpr where gnpr.organism=:organism");
        query.setParameter("organism", organism);
        return query.getResultList();
    }

    public  List findByName(String name) {
        Query query = entityManager.createQuery("select gnpr from GeneGnprod gnpr where gnpr.name=:name");
        query.setParameter("name", name);
        return query.getResultList();
    }

    // not sure -> mporei na gyrnaei apla ta synonyms
    public List getSynonyms(String synonyms) {
        Query query = entityManager.createQuery("select gnpr from GeneGnprod gnpr where gnpr.synonyms=:synonyms");
        query.setParameter("synonyms", synonyms);
        return query.getResultList();
    }

    public List findByGeneType(String gType) {
        Query query = entityManager.createQuery("select gnpr from GeneGnprod gnpr where gnpr.gType=:gtype");
        query.setParameter("gType", gType);
        return query.getResultList();
    }


}
