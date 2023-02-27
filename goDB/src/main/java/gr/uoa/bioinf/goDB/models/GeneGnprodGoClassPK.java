package gr.uoa.bioinf.goDB.models;

import java.io.Serializable;

public class GeneGnprodGoClassPK implements Serializable {

    private String geneSymbol;
    private String goClassAccession;

    public GeneGnprodGoClassPK() {
    }

    public GeneGnprodGoClassPK(String geneSymbol, String goClassAccession) {
        this.geneSymbol = geneSymbol;
        this.goClassAccession = goClassAccession;
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
}

