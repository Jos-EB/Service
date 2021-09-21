package com.sygbimmog.manager.partie;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table
public class PartieRole {
    @Id
    @SequenceGenerator(name = "partie_role_sequence", sequenceName = "PartieRoleSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "partie_role_sequence")
    private Long id;
    private String label;
    private String description;
    @OneToMany(mappedBy = "partieRole",targetEntity = Partie.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("partieRole")
    private Collection<Partie> parties;

    public PartieRole() {
    }

    public PartieRole(String label, String description) {
        this.label = label;
        this.description = description;
    }

    public PartieRole(Long id, String label, String description) {
        this.id = id;
        this.label = label;
        this.description = description;
    }

    public PartieRole(Long id, String label, String description, Collection<Partie> parties) {
        this.id = id;
        this.label = label;
        this.description = description;
        this.parties = parties;
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
        return "PartieRole{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", description='" + description + '\'' +
                ", partieCollection=" + parties +
                '}';
    }
}
