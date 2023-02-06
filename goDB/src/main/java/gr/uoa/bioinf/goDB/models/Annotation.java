package gr.uoa.bioinf.goDB.models;
import jakarta.persistence.*;
import java.util.List;

@Entity
@IdClass(GeneGnprodGoClassPK.class)
public class Annotation {

    @Id
    @Column(name="Gene_Symbol")
    private String gene_symbol;
    @Id
    @Column(name="GO_class_Accession")
    private String go_class_accession;
    @Column(name="Organism")
    private String organism;
    @Column(name="Annotation_qualifier")
    private String annotation_qualifier;
    @Column(name="Annotation_extension")
    private String annotation_extension;
    @Column(name="Evidence")
    private String evidence;
    @Column(name="Reference")
    private String reference;

    @ManyToMany
    private List<GoClass> goClassList;

    @ManyToMany
    private List<GeneGnprod> geneGnLrodList;

    public Annotation() {
    }

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

}
