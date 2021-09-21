package com.sygbimmog.manager.unitespatiale;

import javax.persistence.*;

@Entity
public class Adresse {
    @Id
    @SequenceGenerator(name = "adresse_sequence", sequenceName = "AdresseSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "adresse_sequence")
    private Long id;
    private String label;
    private String pays;
    private String region;
    private String ville;
    private String quartier;
    private String rue;
    private String numeroBatiment;
    private String appartement;

    public Adresse() {
    }

    public Adresse(String label, String pays, String region, String ville, String quartier, String rue, String numeroBatiment, String appartement) {
        this.label = label;
        this.pays = pays;
        this.region = region;
        this.ville = ville;
        this.quartier = quartier;
        this.rue = rue;
        this.numeroBatiment = numeroBatiment;
        this.appartement = appartement;
    }

    public Adresse(Long id, String label, String pays, String region, String ville, String quartier, String rue, String numeroBatiment, String appartement) {
        this.id = id;
        this.label = label;
        this.pays = pays;
        this.region = region;
        this.ville = ville;
        this.quartier = quartier;
        this.rue = rue;
        this.numeroBatiment = numeroBatiment;
        this.appartement = appartement;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getQuartier() {
        return quartier;
    }

    public void setQuartier(String quartier) {
        this.quartier = quartier;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getNumeroBatiment() {
        return numeroBatiment;
    }

    public void setNumeroBatiment(String numeroBatiment) {
        this.numeroBatiment = numeroBatiment;
    }

    public String getAppartement() {
        return appartement;
    }

    public void setAppartement(String appartement) {
        this.appartement = appartement;
    }

    @Override
    public String toString() {
        return "Adresse{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", pays='" + pays + '\'' +
                ", region='" + region + '\'' +
                ", ville='" + ville + '\'' +
                ", quartier='" + quartier + '\'' +
                ", rue='" + rue + '\'' +
                ", numeroBatiment='" + numeroBatiment + '\'' +
                ", appartement='" + appartement + '\'' +
                '}';
    }
}
