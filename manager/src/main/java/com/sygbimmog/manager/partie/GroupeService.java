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
public class GroupeService {
    private final GroupeRepository groupeRepository;
    private final GroupeTypeRepository groupeTypeRepository;
    private final MembreRepository membreRepository;
    private final PartieRoleRepository partieRoleRepository;
    private final PartieTypeRepository partieTypeRepository;
    private final AdresseRepository adresseRepository;

    @Autowired
    public GroupeService(GroupeRepository groupeRepository, GroupeTypeRepository groupeTypeRepository, MembreRepository membreRepository, PartieRoleRepository partieRoleRepository, PartieTypeRepository partieTypeRepository, AdresseRepository adresseRepository) {
        this.groupeRepository = groupeRepository;
        this.groupeTypeRepository = groupeTypeRepository;
        this.membreRepository = membreRepository;

        this.partieRoleRepository = partieRoleRepository;
        this.partieTypeRepository = partieTypeRepository;
        this.adresseRepository = adresseRepository;
    }

    public List<Groupe> getGroupe(){
        return groupeRepository.findAll();
    }

    public Optional<Groupe> getOneGroupe(Long groupeId){
        return groupeRepository.findById(groupeId);
    }

    public void addNewGroupe(Groupe groupe){
        Optional<Groupe> groupeOptional = groupeRepository.findGroupeByNom(groupe.getNom());
        if (groupeOptional.isPresent()){
            throw new IllegalStateException("Le groupe exixte déjà");
        }
        groupeRepository.save(groupe);
    }

    public void deleteGroupe(Long groupeId){
        boolean exists = groupeRepository.existsById(groupeId);
        if(!exists){
            throw new IllegalStateException("La groupe avec l ID "+ groupeId +" n'exixte pas !!!");
        }
        groupeRepository.deleteById(groupeId);
    }

    @Transactional
    public void updateGroupe(Long groupeId, String nom, String nationalite, String contact, String email, Long partieRoleId, Long partieTypeId, Long adresseId, Long groupeTypeId){
        Groupe groupe = groupeRepository.findById(groupeId).orElseThrow(()->new IllegalStateException("La partie avec l ID "+ groupeId + " n existe pas"));

        if(nom != null && nom.length() > 0 && !Objects.equals(groupe.getNom(), nom)){
            Optional<Groupe> groupeOptional = groupeRepository.findGroupeByNom(nom);
            if(groupeOptional.isPresent()){
                throw new IllegalStateException("La  existe déjà !!!");
            }
            groupe.setNom(nom);
        }

        if(nationalite != null && nationalite.length() > 0 && !Objects.equals(groupe.getNationalite(), nationalite)){
            groupe.setNationalite(nationalite);
        }

        if(contact != null && contact.length() > 0 && !Objects.equals(groupe.getContact(), contact)){
            groupe.setContact(contact);
        }

        if(email != null && email.length() > 0 && !Objects.equals(groupe.getEmail(), email)){
            groupe.setEmail(email);
        }

        if(partieRoleId != null){
            Optional<PartieRole> partieRole = partieRoleRepository.findById(partieRoleId);
            groupe.setPartieRole(partieRole.get());
        }

        if(partieTypeId != null){
            Optional<PartieType> partieType = partieTypeRepository.findById(partieTypeId);
            groupe.setPartieType(partieType.get());
        }

        if(adresseId != null){
            Optional<Adresse> adresse = adresseRepository.findById(adresseId);
            groupe.setAdresse(adresse.get());
        }

        if(groupeTypeId != null){
            Optional<GroupeType> groupeType = groupeTypeRepository.findById(groupeTypeId);
            groupe.setGroupeType(groupeType.get());
        }
    }


}
