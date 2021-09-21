package com.sygbimmog.manager.partie;

import com.sygbimmog.manager.unitespatiale.Adresse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MembreService {

    private final MembreRepository membreRepository;
    private final PartieRepository partieRepository;
    private final GroupeRepository groupeRepository;

    @Autowired

    public MembreService(MembreRepository membreRepository, PartieRepository partieRepository, GroupeRepository groupeRepository) {
        this.membreRepository = membreRepository;
        this.partieRepository = partieRepository;
        this.groupeRepository = groupeRepository;
    }

    public List<Membre> getMembre(){
        return membreRepository.findAll();
    }

    public Optional<Membre> getOneMembre(Long membreId){
        return membreRepository.findById(membreId);
    }

    public void addNewMembre(Membre membre){
        membreRepository.save(membre);
    }

    public void deleteMembre(Long membreId){
        boolean exists = membreRepository.existsById(membreId);
        if(!exists){
            throw new IllegalStateException("Le membre avec l ID "+ membreId +" n'exixte pas !!!");
        }
        membreRepository.deleteById(membreId);
    }

    @Transactional
    public void updateMembre(Long membreId, Double part,Long partieId,Long groupeId){
        Membre membre = membreRepository.findById(membreId).orElseThrow(()->new IllegalStateException("Le membre avec l'ID "+ membreId + " n existe pas"));

        if(part != null && !Objects.equals(membre.getPart(), part)){
            membre.setPart(part);
        }

        if(partieId != null){
            Optional<Partie> partie = partieRepository.findById(partieId);
            membre.setPartie(partie.get());
        }

        if(groupeId != null){
            Optional<Groupe> groupe = groupeRepository.findById(groupeId);
            membre.setGroupe(groupe.get());
        }
    }

}
