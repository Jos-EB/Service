package com.sygbimmog.manager.partie;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table
public class PartieType {
    @Id
    @SequenceGenerator(name = "partie_type_sequence", sequenceName = "PartieTypeSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "partie_type_sequence")
    private Long id;
    private String label;
    private String description;
    @OneToMany(mappedBy = "partieType",targetEntity = Partie.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("partieType")
    Collection<Partie> parties;

    public PartieType() {
    }

    public PartieType(String label, String description) {
        this.label = label;
        this.description = description;
    }

    public PartieType(Long id, String label, String description) {
        this.id = id;
        this.label = label;
        this.description = description;
    }

    public PartieType(Long id, String label, String description, Collection<Partie> partie) {
        this.id = id;
        this.label = label;
        this.description = description;
        this.parties = partie;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<Partie> getParties() {
        return parties;
    }

    public void setParties(Collection<Partie> parties) {
        this.parties = parties;
    }

    @Override
    public String toString() {
        return "PartieType{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", description='" + description + '\'' +
                ", partie=" + parties +
                '}';
    }
}
