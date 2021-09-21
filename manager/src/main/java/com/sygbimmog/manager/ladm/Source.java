package com.sygbimmog.manager.ladm;

import java.time.Duration;
import java.time.LocalDate;

public class Source {
    private LocalDate dateDecret;
    private Long TypeDisponibiliteId;
    private Duration dureeVie;
    private LocalDate dateEnregistrement;
    private LocalDate dateSoumission;

    public Source() {
    }

    public Source(LocalDate dateDecret, Long typeDisponibiliteId, Duration dureeVie, LocalDate dateEnregistrement, LocalDate dateSoumission) {
        this.dateDecret = dateDecret;
        TypeDisponibiliteId = typeDisponibiliteId;
        this.dureeVie = dureeVie;
        this.dateEnregistrement = dateEnregistrement;
        this.dateSoumission = dateSoumission;
    }

    public LocalDate getDateDecret() {
        return dateDecret;
    }

    public void setDateDecret(LocalDate dateDecret) {
        this.dateDecret = dateDecret;
    }

    public Long getTypeDisponibiliteId() {
        return TypeDisponibiliteId;
    }

    public void setTypeDisponibiliteId(Long typeDisponibiliteId) {
        TypeDisponibiliteId = typeDisponibiliteId;
    }

    public Duration getDureeVie() {
        return dureeVie;
    }

    public void setDureeVie(Duration dureeVie) {
        this.dureeVie = dureeVie;
    }

    public LocalDate getDateEnregistrement() {
        return dateEnregistrement;
    }

    public void setDateEnregistrement(LocalDate dateEnregistrement) {
        this.dateEnregistrement = dateEnregistrement;
    }

    public LocalDate getDateSoumission() {
        return dateSoumission;
    }

    public void setDateSoumission(LocalDate dateSoumission) {
        this.dateSoumission = dateSoumission;
    }
}
