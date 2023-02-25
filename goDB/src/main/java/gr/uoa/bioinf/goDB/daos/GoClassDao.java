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

    //////////////

    public List getAll() {
        Query query = entityManager.createQuery("select g from GoClass g");
        return query.getResultList();
    }

    public List getOneClass(String accession) {
        Query query =  entityManager.createQuery("select g from GoClass g where g.accession=:accession");
        query.setParameter("accession", accession);
        return query.getResultList();
    }

    /*
    public List<GoClass> updateGoClass() {
        // database....update where GoClass.accession == accession;
        return null;
    }*/

    public List findByOntologySource(String ontologySource) {
        Query query = entityManager.createQuery("select g from GoClass g where g.ontologySource=:ontologySource");
        query.setParameter("ontologySource", ontologySource);
        return query.getResultList();
    }

    public List getDefinition(String definition) {
        Query query = entityManager.createQuery("select g from GoClass g where g.definition like 'input_user'");
        return query.getResultList();
    }
}
