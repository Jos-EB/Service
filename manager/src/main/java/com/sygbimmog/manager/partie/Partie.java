package com.sygbimmog.manager.partie;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sygbimmog.manager.ladm.ObjetVersionne;
import com.sygbimmog.manager.unitespatiale.Adresse;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Partie extends ObjetVersionne {
    private String nom;
    @ManyToOne
    @JoinColumn(name="partie_role_id")
    @JsonIgnoreProperties("parties")
    private PartieRole partieRole;
    @ManyToOne
    @JoinColumn(name = "partie_type_id")
    @JsonIgnoreProperties("parties")
    private PartieType partieType;
    private String nationalite;
    @ManyToOne
    @JoinColumn(name = "adresse_id")
    @JsonIgnoreProperties("parties")
    private Adresse adresse;
    private String contact;
    private String email;

    public Partie() {
    }

    public Partie(LocalDate debutVersion, String qualite, Long utilisateurId, String nom, PartieRole partieRole, PartieType partieType, String nationalite, Adresse adresse, String contact, String email) {
        super(debutVersion, qualite, utilisateurId);
        this.nom = nom;
        this.partieRole = partieRole;
        this.partieType = partieType;
        this.nationalite = nationalite;
        this.adresse = adresse;
        this.contact = contact;
        this.email = email;
    }

    public Partie(Long id, LocalDate debutVersion, LocalDate finVersion, String qualite, Long utilisateurId, String nom, PartieRole partieRole, PartieType partieType, String nationalite, Adresse adresse, String contact, String email) {
        super(id, debutVersion, finVersion, qualite, utilisateurId);
        this.nom = nom;
        this.partieRole = partieRole;
        this.partieType = partieType;
        this.nationalite = nationalite;
        this.adresse = adresse;
        this.contact = contact;
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public PartieRole getPartieRole() {
        return partieRole;
    }

    public void setPartieRole(PartieRole partieRole) {
        this.partieRole = partieRole;
    }

    public PartieType getPartieType() {
        return partieType;
    }

    public void setPartieType(PartieType partieType) {
        this.partieType = partieType;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Partie{" +
                "nom='" + nom + '\'' +
                ", partieRole=" + partieRole +
                ", partieType=" + partieType +
                ", nationalite='" + nationalite + '\'' +
                ", adresse=" + adresse +
                ", contact='" + contact + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
