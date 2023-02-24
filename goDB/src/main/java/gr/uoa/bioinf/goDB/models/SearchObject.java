package gr.uoa.bioinf.goDB.models;

public class SearchObject {

    private String geneTerm;
    private String goClassTerm;
    private String organism;
    private String goClass;
    private String ontologySource;

    public String getGeneTerm() {
        return geneTerm;
    }

    public void setGeneTerm(String geneTerm) {
        this.geneTerm = geneTerm;
    }

    public String getGoClassTerm() {
        return goClassTerm;
    }

    public void setGoClassTerm(String goClassTerm) {
        this.goClassTerm = goClassTerm;
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

    public void setOntologySource(String ontologySource) {
        this.ontologySource = ontologySource;
    }

    public String getOntologySource() {
        return ontologySource;
    }
}
