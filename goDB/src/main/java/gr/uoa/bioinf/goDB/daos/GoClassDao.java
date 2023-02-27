package gr.uoa.bioinf.goDB.daos;

import gr.uoa.bioinf.goDB.models.GoClass;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
public class GoClassDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void persist(GoClass goClass) {
        entityManager.persist(goClass);
    }

    @Transactional
    public void update(GoClass goClass) {
        entityManager.merge(goClass);
    }

    public List getAll() {
        Query query = entityManager.createQuery("select g from GoClass g");
        return query.getResultList();
    }
}
