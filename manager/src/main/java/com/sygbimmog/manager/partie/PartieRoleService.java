package com.sygbimmog.manager.partie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PartieRoleService {
    private final PartieRoleRepository partieRoleRepository;

    @Autowired
    public PartieRoleService(PartieRoleRepository partieRoleRepository){
        this.partieRoleRepository = partieRoleRepository;
    }

    public List<PartieRole> getPartieRole(){
        return partieRoleRepository.findAll();
    }

    public Optional<PartieRole> getOnePartieRole(Long partieRoleId){
        return partieRoleRepository.findById(partieRoleId);
    }

    public void addNewPartieRole(PartieRole partieRole){
        Optional<PartieRole> partieRoleOptional = partieRoleRepository.findPartieRoleByLabel(partieRole.getLabel());
        if(partieRoleOptional.isPresent()){
            throw new IllegalStateException("Le rôle existe déjà !!!");
        }
        partieRoleRepository.save(partieRole);
    }

    public void deletePartieRole(Long partieRoleId){
        boolean exists = partieRoleRepository.existsById(partieRoleId);
        if(!exists){
            throw new IllegalStateException("Le rôle avec l ID "+ partieRoleId +" n'exixte pas !!!");
        }
        partieRoleRepository.deleteById(partieRoleId);
    }

    @Transactional
    public void updatePartieRole(Long partieRoleId, String label, String description){
        PartieRole partieRole = partieRoleRepository.findById(partieRoleId).orElseThrow(()->new IllegalStateException("Le rôle avec l ID "+ partieRoleId + " n existe pas"));

        if(label != null && label.length() > 0 && !Objects.equals(partieRole.getLabel(), label)){
            Optional<PartieRole> partieRoleOptional = partieRoleRepository.findPartieRoleByLabel(label);
            if(partieRoleOptional.isPresent()){
                throw new IllegalStateException("Le role existe déjà !!!");
            }
            partieRole.setLabel(label);
        }

        if(description != null && description.length() > 0 && !Objects.equals(partieRole.getDescription(), description)){
            partieRole.setDescription(description);
        }
    }
}
