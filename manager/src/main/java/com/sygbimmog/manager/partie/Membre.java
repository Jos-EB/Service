package com.sygbimmog.manager.partie;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sygbimmog.manager.ladm.ObjetVersionne;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Membre extends ObjetVersionne {
    private Double part;
    @ManyToOne
    @JoinColumn(name = "groupe_id")
    @JsonIgnoreProperties("membres")
    private Groupe groupe;
    @ManyToOne
    @JoinColumn(name = "partie_id")
    @JsonIgnoreProperties("membres")
    private Partie partie;

    public Membre() {
    }

    public Membre(Double part) {
        this.part = part;
    }

    public Membre(LocalDate debutVersion, String qualite, Long utilisateurId, Double part, Groupe groupe, Partie partie) {
        super(debutVersion, qualite, utilisateurId);
        this.part = part;
        this.groupe = groupe;
        this.partie = partie;
    }

    public Membre(Long id, LocalDate debutVersion, LocalDate finVersion, String qualite, Long utilisateurId, Double part, Groupe groupe, Partie partie) {
        super(id, debutVersion, finVersion, qualite, utilisateurId);
        this.part = part;
        this.groupe = groupe;
        this.partie = partie;
    }

    public Double getPart() {
        return part;
    }

    public void setPart(Double part) {
        this.part = part;
    }

    public Groupe getGroupe() {
        return groupe;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }

    public Partie getPartie() {
        return partie;
    }

    public void setPartie(Partie partie) {
        this.partie = partie;
    }

    @Override
    public String toString() {
        return "Membre{" +
                "part=" + part +
                ", groupe=" + groupe +
                ", partie=" + partie +
                '}';
    }
}
