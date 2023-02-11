package gr.uoa.bioinf.goDB.daos;

import gr.uoa.bioinf.goDB.models.GoClass;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GoClassDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List getAll() {
        Query query = entityManager.createQuery("select g from GoClass g");
        return query.getResultList();
    }

    public List getOneClass() {
        Query query =  entityManager.createQuery("select g from GoClass g where GoClass.accession=:accession");
        return query.getResultList();
    }

    /*
    public List<GoClass> updateGoClass() {
        // database....update where GoClass.accession == accession;
        return null;
    }*/

    public List findByOntologySource() {
        Query query = entityManager.createQuery("select g from GoClass g where GoClass.ontology_source=:ontology_source");
        return query.getResultList();
    }

    public List getDefinition() {
        Query query = entityManager.createQuery("select g from GoClass g where GoClass.definition like 'input_user'");
        return query.getResultList();
    }
}
