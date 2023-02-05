public class Annotations {
    private String gene_symbol;
    private String go_class_accession;
    private String organism;
    private String annotation_qualifier;
    private String annotation_extension;
    private String evidence;
    private String reference;

    public String getGene_symbol() {
        return gene_symbol;
    }

    public void setGene_symbol(String gene_symbol) {
        this.gene_symbol = gene_symbol;
    }

    public String getGo_class_accession() {
        return go_class_accession;
    }

    public void setGo_class_accession(String go_class_accession) {
        this.go_class_accession = go_class_accession;
    }

    public String getOrganism() {
        return organism;
    }

    public void setOrganism(String organism) {
        this.organism = organism;
    }

    public String getAnnotation_qualifier() {
        return annotation_qualifier;
    }

    public void setAnnotation_qualifier(String annotation_qualifier) {
        this.annotation_qualifier = annotation_qualifier;
    }

    public String getAnnotation_extension() {
        return annotation_extension;
    }

    public void setAnnotation_extension(String annotation_extension) {
        this.annotation_extension = annotation_extension;
    }

    public String getEvidence() {
        return evidence;
    }

    public void setEvidence(String evidence) {
        this.evidence = evidence;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    @ManytoMany
    private List<GO_class> goClassList
}