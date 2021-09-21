package com.sygbimmog.manager.unitespatiale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AdresseService {
    private final AdresseRepository adresseRepository;

    @Autowired
    public AdresseService(AdresseRepository adresseRepository){
        this.adresseRepository = adresseRepository;
    }

    public List<Adresse> getAdresse(){
        return adresseRepository.findAll();
    }

    public Optional<Adresse> getOneAdresse(Long adresseId){
        return adresseRepository.findById(adresseId);
    }

    public void addNewAdresse(Adresse adresse){
        Optional<Adresse> adresseOptional = adresseRepository.findAdresseByLabel(adresse.getLabel());
        if(adresseOptional.isPresent()){
            throw new IllegalStateException("L'adresse existe déjà !!!");
        }
        adresseRepository.save(adresse);
    }

    public void deleteAdresse(Long adresseId){
        boolean exists = adresseRepository.existsById(adresseId);
        if(!exists){
            throw new IllegalStateException("L'adresse avec l ID "+ adresseId +" n'exixte pas !!!");
        }
        adresseRepository.deleteById(adresseId);
    }

    @Transactional
    public void updateAdresse(Long adresseId, String label, String pays, String region, String ville, String quartier, String rue, String numeroBatiment, String appartemement){
        Adresse adresse = adresseRepository.findById(adresseId).orElseThrow(()->new IllegalStateException("L'adresse avec l'ID "+ adresseId + " n'existe pas"));

        if(label != null && label.length() > 0 && !Objects.equals(adresse.getLabel(), label)){
            Optional<Adresse> adresseOptional = adresseRepository.findAdresseByLabel(label);
            if(adresseOptional.isPresent()){
                throw new IllegalStateException("L'adresse existe déjà !!!");
            }
            adresse.setLabel(label);
        }

        if(pays != null && pays.length() > 0 && !Objects.equals(adresse.getPays(), pays)){
            adresse.setPays(pays);
        }

        if(region != null && region.length() > 0 && !Objects.equals(adresse.getRegion(), region)){
            adresse.setRegion(region);
        }

        if(ville != null && ville.length() > 0 && !Objects.equals(adresse.getVille(), ville)){
            adresse.setVille(ville);
        }

        if(quartier != null && quartier.length() > 0 && !Objects.equals(adresse.getQuartier(), quartier)){
            adresse.setQuartier(quartier);
        }

        if(rue != null && rue.length() > 0 && !Objects.equals(adresse.getRue(), rue)){
            adresse.setRue(rue);
        }

        if(numeroBatiment != null && numeroBatiment.length() > 0 && !Objects.equals(adresse.getNumeroBatiment(), numeroBatiment)){
            adresse.setNumeroBatiment(numeroBatiment);
        }

        if(appartemement != null && appartemement.length() > 0 && !Objects.equals(adresse.getAppartement(), appartemement)){
            adresse.setAppartement(appartemement);
        }
    }
}
