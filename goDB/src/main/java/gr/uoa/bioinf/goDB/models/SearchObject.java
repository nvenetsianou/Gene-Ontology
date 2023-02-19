package gr.uoa.bioinf.goDB.models;

public class SearchObject {

    private String term;
    private String organism;
    private String goClass;
    private String ontologySource;

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getOrganism() {
        return organism;
    }

    public void setOrganism(String organism) {
        this.organism = organism;
    }

    public String getGoClass() {
        return goClass;
    }

    public void setGoClass(String goClass) {
        this.goClass = goClass;
    }

    public String getOntologySource() {
        return ontologySource;
    }

    public void setOntologySource(String ontologySource) {
        this.ontologySource = ontologySource;
    }
}
