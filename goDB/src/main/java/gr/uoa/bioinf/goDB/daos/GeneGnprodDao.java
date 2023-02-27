package gr.uoa.bioinf.goDB.daos;
import gr.uoa.bioinf.goDB.models.GeneGnprod;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
public class GeneGnprodDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void persist(GeneGnprod geneGnprod) {
        entityManager.persist(geneGnprod);
    }

    @Transactional
    public void update(GeneGnprod geneGnprod) {
        entityManager.merge(geneGnprod);
    }

}
