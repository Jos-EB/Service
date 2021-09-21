package com.sygbimmog.manager.partie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/groupe")
public class GroupeContoller {
    private final GroupeService groupeService;

    @Autowired
    public GroupeContoller(GroupeService groupeService) {
        this.groupeService = groupeService;
    }

    @GetMapping
    public List<Groupe> getGroupe(){
        return groupeService.getGroupe();
    }

    @GetMapping(path = "{groupeId}")
    public Optional<Groupe> getOneGroupe(@PathVariable("groupeId")Long groupeId){
        return groupeService.getOneGroupe(groupeId);
    }

    @PostMapping
    public void registerNewGroupe(@RequestBody Groupe groupe){
        groupeService.addNewGroupe(groupe);
    }

    @DeleteMapping(path = "{groupeId}")
    public void deleteGroupe(@PathVariable("groupeId")Long groupeId){
        groupeService.deleteGroupe(groupeId);
    }

    @PutMapping(path = "{groupeId}")
    public void updateGroupe(@PathVariable("groupeId") Long groupeId,
                             @RequestParam(required = false)String nom,
                             @RequestParam(required = false)String contact,
                             @RequestParam(required = false)String email,
                             @RequestParam(required = false)Long partieRoleId,
                             @RequestParam(required = false)Long partieTypeId,
                             @RequestParam(required = false)Long adresseId,
                             @RequestParam(required = false)Long groupeTypeId,
                             @RequestParam(required = false)String nationalite){
        groupeService.updateGroupe(groupeId, nom, nationalite, contact, email, partieRoleId, partieTypeId, adresseId, groupeTypeId);
    }
}
