package gr.uoa.bioinf.goDB.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Gene_gnprod")
public class GeneGnprod {
    @Id
    @Column(name="Symbol")
    private String symbol;
    @Column(name="Name")
    private String name;
    @Column(name="Organism")
    private String organism;
    @Column(name="gType")
    private String gType;
    @Column(name="Source")
    private String source;
    @Column(name="Synonyms")
    private String synonyms;

    public GeneGnprod() {
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrganism() {
        return organism;
    }

    public void setOrganism(String organism) {
        this.organism = organism;
    }

    public String getgType() {
        return gType;
    }

    public void setgType(String gType) {
        this.gType = gType;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(String synonyms) {
        this.synonyms = synonyms;
    }

}
