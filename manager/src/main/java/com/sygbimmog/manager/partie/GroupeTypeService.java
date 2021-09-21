package com.sygbimmog.manager.partie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class GroupeTypeService {
    private final GroupeTypeRepository groupeTypeRepository;

    @Autowired
    public GroupeTypeService(GroupeTypeRepository groupeTypeRepository){
        this.groupeTypeRepository = groupeTypeRepository;
    }

    public List<GroupeType> getGroupeType(){
        return groupeTypeRepository.findAll();
    }

    public void addNewGroupeType(GroupeType groupeType){
        Optional<GroupeType> groupeTypeOptional = groupeTypeRepository.findGroupeTypeByLabel(groupeType.getLabel());
        if(groupeTypeOptional.isPresent()){
            throw new IllegalStateException("Le type de groupe existe déjà !!!");
        }
        groupeTypeRepository.save(groupeType);
    }

    public void deleteGroupeType(Long groupeTypeId) {
        boolean exists = groupeTypeRepository.existsById(groupeTypeId);
        if(!exists){
            throw new IllegalStateException("Le type de groupe avec l id " + groupeTypeId + " n existe pas !!!");
        }
        groupeTypeRepository.deleteById(groupeTypeId);
    }

    @Transactional
    public void updateGroupeType(Long groupeTypeId, String label, String description) {
        GroupeType groupeType = groupeTypeRepository.findById(groupeTypeId).orElseThrow(()->new IllegalStateException("Le type de groupe avec l id " + groupeTypeId + " n existe pas !!!"));

        if(label != null && label.length() > 0 && !Objects.equals(groupeType.getLabel(), label)){
            Optional<GroupeType> groupeTypeOptional = groupeTypeRepository.findGroupeTypeByLabel(label);
            if(groupeTypeOptional.isPresent()){
                throw new IllegalStateException("Le type de groupe existe déjà !!!");
            }
            groupeType.setLabel(label);
        }

        if(description != null && description.length() > 0 && !Objects.equals(groupeType.getDescription(), description)){
            groupeType.setDescription(description);
        }
    }
}