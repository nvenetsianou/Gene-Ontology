package gr.uoa.bioinf.goDB.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="GO_class")
public class GoClass {
    @Id
    @Column(name="Accession")
    private String accession;
    @Column(name="Definition")
    private String definition;
    @Column(name="Ontology_source")
    private String ontologySource;

    public GoClass() {
    }

    public GoClass(String accession, String definition, String ontologySource) {
        this.accession = accession;
        this.definition = definition;
        this.ontologySource = ontologySource;
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

    public String getOntologySource() {
        return ontologySource;
    }

    public void setOntologySource(String ontologySource) {
        this.ontologySource = ontologySource;
    }
}

//public class main() { //TODO
//    go_class go_class = new go_class();
//    go_classDAO go_classDAO = new go_classDAO();
//    go_classDAO.save(go_class) //insert
//            go_classDAO.update(go_class) //update
//            go_classDAO.delete(go_class) //delete
//}

