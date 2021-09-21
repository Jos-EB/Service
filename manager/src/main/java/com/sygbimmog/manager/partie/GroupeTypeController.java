package com.sygbimmog.manager.partie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "api/groupe_type")
public class GroupeTypeController {
    private final GroupeTypeService groupeTypeService;

    @Autowired
    public GroupeTypeController(GroupeTypeService groupeTypeService){
        this.groupeTypeService = groupeTypeService;
    }

    @GetMapping
    public List<GroupeType> getGroupeType(){
        return groupeTypeService.getGroupeType();
    }

    @PostMapping
    public void registerNewGroupeType(@RequestBody GroupeType groupeType){
        groupeTypeService.addNewGroupeType(groupeType);
    }

    @DeleteMapping(path = "{groupeTypeId}")
    public void deleteGroupeType(@PathVariable("groupeTypeId")Long groupeTypeId){
        groupeTypeService.deleteGroupeType(groupeTypeId);
    }

    @PutMapping(path = "{groupeTypeId}")
    public void updateGroupeType(@PathVariable("groupeTypeId") Long groupeTypeId,
                                 @RequestParam(required = false)String label,
                                 @RequestParam(required = false)String description){
        groupeTypeService.updateGroupeType(groupeTypeId, label, description);
    }
}
