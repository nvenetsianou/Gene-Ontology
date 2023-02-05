public class go_class {
    private String accession;
    private String definition;
    private String ontology_source;

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

public class GO_classDAO {
    public List<GO_class> getAllGOclasses {
        database....select * from GO_class;
    }

    public GO_class getGOclass(accession) {
        database....select * where GO_class.accession==accession;
    }

    public GO_class updateGO_class(GO_class) {
        database....update where GO_class.accession==accession;
    }

}

public class main() {
    GO_class go_class = new GO_class();
    GO_classDAO go_classDAO = new GO_classDAO();
    GO_classDAO.save(go_class) //insert
            GO_classDAO.update(go_class) //update
            GO_classDAO.delete(go_class) //delete
}

public class GO_classController() {
    @GetMapping("/getAllGOclasses")
    public List<GO_class> getAllGOclasses() {
        return GO_classDAO.getAllGOclasses;
    }

    @GetMapping("/getGOclass?id=")
    public GO_class GO_classDAO(accession) {
        return GO_classDAO.GO_classDAO(accession);
    }

}