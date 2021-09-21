package com.sygbimmog.manager.partie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/partie")
public class PartieController {
    private final PartieService partieService;

    @Autowired
    public PartieController(PartieService partieService){
        this.partieService = partieService;
    }

    @GetMapping
    public List<Partie> getPartie(){
        return partieService.getPartie();
    }

    @GetMapping(path = "{partieId}")
    public Optional<Partie> getOnePartie(@PathVariable("partieId")Long partieId){
        return partieService.getOnePartie(partieId);
    }

    @PostMapping
    public void registerNewPartie(@RequestBody Partie partie){
        partieService.addNewPartie(partie);
    }

    @DeleteMapping(path = "{partieId}")
    public void deletePartie(@PathVariable("partieId")Long partieId){
        partieService.deletePartie(partieId);
    }

    @PutMapping(path = "{partieId}")
    public void updatePartie(@PathVariable("partieId") Long partieId,
                             @RequestParam(required = false)String nom,
                             @RequestParam(required = false)String contact,
                             @RequestParam(required = false)String email,
                             @RequestParam(required = false)Long partieRoleId,
                             @RequestParam(required = false)Long partieTypeId,
                             @RequestParam(required = false)Long adresseId,
                             @RequestParam(required = false)String nationalite){
        partieService.updatePartie(partieId, nom, nationalite, contact, email, partieRoleId, partieTypeId, adresseId);
    }
}
