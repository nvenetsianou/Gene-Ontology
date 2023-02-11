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

    public List getOneGeneGnprod() {
        Query query = entityManager.createQuery("select gnpr from GeneGnprod gnpr where GeneGnprod.symbol=:symbol");
        return query.getResultList();
    }

    /* not sure
    public List<GeneGnprod> updateGeneGnprod(String symbol) {
        // database....update where where GeneGnprod.symbol == symbol;
        return null;
    } */

    public List findByOrganism() {
        Query query = entityManager.createQuery("select gnpr from GeneGnprod gnpr where GeneGnprod.organism=:organism");
        return query.getResultList();
    }

    public  List findByName() {
        Query query = entityManager.createQuery("select gnpr from GeneGnprod gnpr where GeneGnprod.name=:name");
        return query.getResultList();
    }

    // not sure -> mporei na gyrnaei apla ta synonyms
    public List getSynonyms() {
        Query query = entityManager.createQuery("select gnpr from GeneGnprod gnpr where GeneGnprod.synonyms=:synonyms");
        return query.getResultList();
    }

    public List findByGeneType(){
        Query query = entityManager.createQuery("select gnpr from GeneGnprod gnpr where GeneGnprod.gtype=:gtype");
        return query.getResultList();
    }


}
