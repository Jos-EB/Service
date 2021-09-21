package com.sygbimmog.manager.partie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PartieTypeService {
    private final PartieTypeRepository partieTypeRepository;

    @Autowired
    public PartieTypeService(PartieTypeRepository partieTypeRepository){
        this.partieTypeRepository = partieTypeRepository;
    }

    public List<PartieType> getPartieType(){
        return partieTypeRepository.findAll();
    }

    public Optional<PartieType> getOnePartieType(Long partieTypeId){
        return partieTypeRepository.findById(partieTypeId);
    }

    public void addNewPartieType(PartieType partieType){
        Optional<PartieType> partieTypeOptional = partieTypeRepository.findPartieTypeByLabel(partieType.getLabel());
        if(partieTypeOptional.isPresent()){
            throw new IllegalStateException("Le rôle existe déjà !!!");
        }
        partieTypeRepository.save(partieType);
    }

    public void deletePartieType(Long partieTypeId){
        boolean exists = partieTypeRepository.existsById(partieTypeId);
        if(!exists){
            throw new IllegalStateException("Le rôle avec l ID "+ partieTypeId +" n'exixte pas !!!");
        }
        partieTypeRepository.deleteById(partieTypeId);
    }

    @Transactional
    public void updatePartieType(Long partieTypeId, String label, String description){
        PartieType partieType = partieTypeRepository.findById(partieTypeId).orElseThrow(()->new IllegalStateException("Le rôle avec l ID "+ partieTypeId + " n existe pas"));

        if(label != null && label.length() > 0 && !Objects.equals(partieType.getLabel(), label)){
            Optional<PartieType> partieTypeOptional = partieTypeRepository.findPartieTypeByLabel(label);
            if(partieTypeOptional.isPresent()){
                throw new IllegalStateException("Le type existe déjà !!!");
            }
            partieType.setLabel(label);
        }

        if(description != null && description.length() > 0 && !Objects.equals(partieType.getDescription(), description)){
            partieType.setDescription(description);
        }
    }
}
