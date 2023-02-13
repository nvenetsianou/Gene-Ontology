package gr.uoa.bioinf.goDB.models;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name="Annotations")
@IdClass(GeneGnprodGoClassPK.class)
public class Annotation {

    @Id
    @Column(name="Gene_Symbol")
    private String geneSymbol;
    @Id
    @Column(name="GO_class_Accession")
    private String goClassAccession;
    @Column(name="Organism")
    private String organism;
    @Column(name="Annotation_qualifier")
    private String annotationQualifier;
    @Column(name="Annotation_extension")
    private String annotationExtension;
    @Column(name="Evidence")
    private String evidence;
    @Column(name="Reference")
    private String reference;

    @OneToMany
    private List<GoClass> goClassList;

    @OneToMany
    private List<GeneGnprod> geneGnLrodList;

    public Annotation() {
    }

    public String getGeneSymbol() {
        return geneSymbol;
    }

    public void setGeneSymbol(String geneSymbol) {
        this.geneSymbol = geneSymbol;
    }

    public String getGoClassAccession() {
        return goClassAccession;
    }

    public void setGoClassAccession(String goClassAccession) {
        this.goClassAccession = goClassAccession;
    }

    public String getOrganism() {
        return organism;
    }

    public void setOrganism(String organism) {
        this.organism = organism;
    }

    public String getAnnotationQualifier() {
        return annotationQualifier;
    }

    public void setAnnotationQualifier(String annotationQualifier) {
        this.annotationQualifier = annotationQualifier;
    }

    public String getAnnotationExtension() {
        return annotationExtension;
    }

    public void setAnnotationExtension(String annotationExtension) {
        this.annotationExtension = annotationExtension;
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
