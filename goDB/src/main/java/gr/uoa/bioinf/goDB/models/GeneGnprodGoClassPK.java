package gr.uoa.bioinf.goDB.models;

import java.io.Serializable;

public class GeneGnprodGoClassPK implements Serializable {

    private String gene_symbol;
    private String go_class_accession;

    public GeneGnprodGoClassPK(String gene_symbol, String go_class_accession) {
        this.gene_symbol = gene_symbol;
        this.go_class_accession = go_class_accession;
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
}
