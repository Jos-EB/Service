package com.sygbimmog.manager.partie;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sygbimmog.manager.unitespatiale.Adresse;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Groupe extends Partie {

    @ManyToOne
    @JoinColumn(name = "groupe_type_id")
    @JsonIgnoreProperties("groupes")
    private GroupeType groupeType;
    @OneToMany(mappedBy = "groupe",targetEntity = Membre.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("Groupe")
    private Collection<Membre> membres;

    public Groupe() {
    }

    public Groupe(LocalDate debutVersion, String qualite, Long utilisateurId, String nom, PartieRole partieRole, PartieType partieType, String nationalite, Adresse adresse, String contact, String email, GroupeType groupeType, Collection<Membre> membre) {
        super(debutVersion, qualite, utilisateurId, nom, partieRole, partieType, nationalite, adresse, contact, email);
        this.groupeType = groupeType;
        this.membres = membre;
    }

    public Groupe(Long id, LocalDate debutVersion, LocalDate finVersion, String qualite, Long utilisateurId, String nom, PartieRole partieRole, PartieType partieType, String nationalite, Adresse adresse, String contact, String email, GroupeType groupeType) {
        super(id, debutVersion, finVersion, qualite, utilisateurId, nom, partieRole, partieType, nationalite, adresse, contact, email);
        this.groupeType = groupeType;
    }

    public Groupe(Long id, LocalDate debutVersion, LocalDate finVersion, String qualite, Long utilisateurId, String nom, PartieRole partieRole, PartieType partieType, String nationalite, Adresse adresse, String contact, String email, GroupeType groupeType, Collection<Membre> membre) {
        super(id, debutVersion, finVersion, qualite, utilisateurId, nom, partieRole, partieType, nationalite, adresse, contact, email);
        this.groupeType = groupeType;
        this.membres = membre;
    }

    public GroupeType getGroupeType() {
        return groupeType;
    }

    public void setGroupeType(GroupeType groupeType) {
        this.groupeType = groupeType;
    }

    public Collection<Membre> getMembres() {
        return membres;
    }

    public void setMembres(Collection<Membre> membres) {
        this.membres = membres;
    }

    @Override
    public String toString() {
        return "Groupe{" +
                "groupeType=" + groupeType +
                ", membre=" + membres +
                '}';
    }
}
