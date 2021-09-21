package com.sygbimmog.manager.partie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/membre")
public class MembreController {
    private final MembreService membreService;
    
    @Autowired
    public MembreController(MembreService membreService) {
        this.membreService = membreService;
    }

    @GetMapping
    public List<Membre> getMembre(){
        return membreService.getMembre();
    }

    @GetMapping(path = "{membreId}")
    public Optional<Membre> getOneMembre(@PathVariable("membreId")Long membreId){
        return membreService.getOneMembre(membreId);
    }

    @PostMapping
    public void registerNewMembre(@RequestBody Membre membre){
        membreService.addNewMembre(membre);
    }

    @DeleteMapping(path = "{membreId}")
    public void deleteMembre(@PathVariable("membreId")Long membreId){
        membreService.deleteMembre(membreId);
    }

    @PutMapping(path = "{membreId}")
    public void updateMembre(@PathVariable("membreId") Long membreId,
                             @RequestParam(required = false)Double part,
                             @RequestParam(required = false)Long groupeId,
                             @RequestParam(required = false)Long partieId){
        membreService.updateMembre(membreId, part, partieId, groupeId);
    }
    
}
