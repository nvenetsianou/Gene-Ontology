package gr.uoa.bioinf.goDB.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class GoClass {
    @Id
    @Column(name="Accession")
    private String accession;
    @Column(name="Definition")
    private String definition;
    @Column(name="Ontology_source")
    private String ontology_source;

    public GoClass() {
    }

    public String getAccession() {
        return accession;
    }

    public void setAccession(String accession) {
        this.accession = accession;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getOntology_source() {
        return ontology_source;
    }

    public void setOntology_source(String ontology_source) {
        this.ontology_source = ontology_source;
    }
}



}

//public class main() { //TODO
//    go_class go_class = new go_class();
//    go_classDAO go_classDAO = new go_classDAO();
//    go_classDAO.save(go_class) //insert
//            go_classDAO.update(go_class) //update
//            go_classDAO.delete(go_class) //delete
//}

