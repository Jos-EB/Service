package com.sygbimmog.manager.partie;

import com.sygbimmog.manager.unitespatiale.Adresse;
import com.sygbimmog.manager.unitespatiale.AdresseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PartieService {

    private final PartieRepository partieRepository;
    private final PartieRoleRepository partieRoleRepository;
    private final PartieTypeRepository partieTypeRepository;
    private final AdresseRepository adresseRepository;

    @Autowired
    public PartieService(PartieRepository partieRepository, PartieRoleRepository partieRoleRepository, PartieTypeRepository partieTypeRepository, AdresseRepository adresseRepository){
        this.partieRepository = partieRepository;
        this.partieRoleRepository = partieRoleRepository;
        this.partieTypeRepository = partieTypeRepository;
        this.adresseRepository = adresseRepository;
    }

    public List<Partie> getPartie(){
        return partieRepository.findAll();
    }

    public Optional<Partie> getOnePartie(Long partieId){
        return partieRepository.findById(partieId);
    }

    public void addNewPartie(Partie partie){
        Optional<Partie> partieOptional = partieRepository.findPartieByNom(partie.getNom());
        if(partieOptional.isPresent()){
            throw new IllegalStateException("La partie existe déjà !!!");
        }
        partieRepository.save(partie);
    }

    public void deletePartie(Long partieId){
        boolean exists = partieRepository.existsById(partieId);
        if(!exists){
            throw new IllegalStateException("La partie avec l ID "+ partieId +" n'exixte pas !!!");
        }
        partieRepository.deleteById(partieId);
    }

    @Transactional
    public void updatePartie(Long partieId, String nom, String nationalite, String contact, String email, Long partieRoleId, Long partieTypeId, Long adresseId){
        Partie partie = partieRepository.findById(partieId).orElseThrow(()->new IllegalStateException("La partie avec l ID "+ partieId + " n existe pas"));

        if(nom != null && nom.length() > 0 && !Objects.equals(partie.getNom(), nom)){
            Optional<Partie> partieOptional = partieRepository.findPartieByNom(nom);
            if(partieOptional.isPresent()){
                throw new IllegalStateException("La  existe déjà !!!");
            }
            partie.setNom(nom);
        }

        if(nationalite != null && nationalite.length() > 0 && !Objects.equals(partie.getNationalite(), nationalite)){
            partie.setNationalite(nationalite);
        }

        if(contact != null && contact.length() > 0 && !Objects.equals(partie.getContact(), contact)){
            partie.setContact(contact);
        }

        if(email != null && email.length() > 0 && !Objects.equals(partie.getEmail(), email)){
            partie.setEmail(email);
        }

        if(partieRoleId != null){
            Optional<PartieRole> partieRole = partieRoleRepository.findById(partieRoleId);
            partie.setPartieRole(partieRole.get());
        }

        if(partieTypeId != null){
            Optional<PartieType> partieType = partieTypeRepository.findById(partieTypeId);
            partie.setPartieType(partieType.get());
        }

        if(adresseId != null){
            Optional<Adresse> adresse = adresseRepository.findById(partieRoleId);
            partie.setAdresse(adresse.get());
        }
    }
    
}
