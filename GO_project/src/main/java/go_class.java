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

public class go_classDAO {
    public List<go_class> getAllGOclasses {
        database....select * from go_class;
    }

    public go_class getGOclass(accession) {
        database....select * where go_class.accession==accession;
    }

    public go_class updateGO_class(GO_class) {
        database....update where go_class.accession==accession;
    }

}

public class main() {
    go_class go_class = new go_class();
    go_classDAO go_classDAO = new go_classDAO();
    go_classDAO.save(go_class) //insert
            go_classDAO.update(go_class) //update
            go_classDAO.delete(go_class) //delete
}

public class go_classController() {
    @GetMapping("/getAllGOclasses")
    public List<go_class> getAllGOclasses() {
        return go_classDAO.getAllGOclasses;
    }

    @GetMapping("/getGOclass?id=")
    public go_class go_classDAO(accession) {
        return go_classDAO.getGOclass(accession);

    }

}