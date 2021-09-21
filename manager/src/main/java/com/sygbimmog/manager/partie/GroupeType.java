package com.sygbimmog.manager.partie;

import javax.persistence.*;

@Entity
@Table
public class GroupeType {
    @Id
    @SequenceGenerator(name = "groupe_type_sequence", sequenceName = "GroupeTypeSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "groupe_type_sequence")
    private Long id;
    private String label;
    private String description;

    public GroupeType() {
    }

    public GroupeType(String label, String description) {
        this.label = label;
        this.description = description;
    }

    public GroupeType(Long id, String label, String description) {
        this.id = id;
        this.label = label;
        this.description = description;
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

    @Override
    public String toString() {
        return "GroupeType{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
