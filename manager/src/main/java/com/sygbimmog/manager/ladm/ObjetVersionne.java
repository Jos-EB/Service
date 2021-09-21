package com.sygbimmog.manager.ladm;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class ObjetVersionne {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private LocalDate debutVersion;
    private LocalDate finVersion;
    private String qualite;
    private Long UtilisateurId;

    public ObjetVersionne() {
    }

    public ObjetVersionne(LocalDate debutVersion, String qualite, Long utilisateurId) {
        this.debutVersion = debutVersion;
        this.qualite = qualite;
        UtilisateurId = utilisateurId;
    }

    public ObjetVersionne(Long id, LocalDate debutVersion, LocalDate finVersion, String qualite, Long utilisateurId) {
        this.id = id;
        this.debutVersion = debutVersion;
        this.finVersion = finVersion;
        this.qualite = qualite;
        UtilisateurId = utilisateurId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDebutVersion() {
        return debutVersion;
    }

    public void setDebutVersion(LocalDate debutVersion) {
        this.debutVersion = debutVersion;
    }

    public LocalDate getFinVersion() {
        return finVersion;
    }

    public void setFinVersion(LocalDate finVersion) {
        this.finVersion = finVersion;
    }

    public String getQualite() {
        return qualite;
    }

    public void setQualite(String qualite) {
        this.qualite = qualite;
    }

    public Long getUtilisateurId() {
        return UtilisateurId;
    }

    public void setUtilisateurId(Long utilisateurId) {
        UtilisateurId = utilisateurId;
    }
}
