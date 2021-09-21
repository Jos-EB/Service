package com.sygbimmog.manager.partie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/partie_role")
public class PartieRoleController {

    private final PartieRoleService partieRoleService;

    @Autowired
    public PartieRoleController(PartieRoleService partieRoleService){
        this.partieRoleService = partieRoleService;
    }

    @GetMapping
    public List<PartieRole> getPartieRole(){
        return partieRoleService.getPartieRole();
    }

    @GetMapping(path = "{partieRoleId}")
    public Optional<PartieRole> getOnePartieRole(@PathVariable("partieRoleId")Long partieRoleId){
        return partieRoleService.getOnePartieRole(partieRoleId);
    }

    @PostMapping
    public void registerNewPartieRole(@RequestBody PartieRole partieRole){
        partieRoleService.addNewPartieRole(partieRole);
    }

    @DeleteMapping(path = "{partieRoleId}")
    public void deletePartieRole(@PathVariable("partieRoleId")Long partieRoleId){
        partieRoleService.deletePartieRole(partieRoleId);
    }

    @PutMapping(path = "{partieRoleId}")
    public void updatePartieRole(@PathVariable("partieRoleId") Long partieRoleId,
                                 @RequestParam(required = false)String label,
                                 @RequestParam(required = false)String description){
        partieRoleService.updatePartieRole(partieRoleId, label, description);
    }
}
