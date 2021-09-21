package com.sygbimmog.manager.unitespatiale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/adresse")
public class AdresseController {
    private final AdresseService adresseService;

    @Autowired
    public AdresseController(AdresseService adresseService) {
        this.adresseService = adresseService;
    }

    @GetMapping(path = "{adresseId}")
    public Optional<Adresse> getOneAdresse(@PathVariable("adresseId") Long adresseId){
        return adresseService.getOneAdresse(adresseId);
    }

    @GetMapping
    public List<Adresse> getAdresse(){
        return adresseService.getAdresse();
    }

    @PostMapping
    public void registerNewAdresse(@RequestBody Adresse adresse){
        adresseService.addNewAdresse(adresse);
    }

    @DeleteMapping(path = "{adresseId}")
    public void deleteAdresse(@PathVariable("adresseId") Long adresseId){
        adresseService.deleteAdresse(adresseId);
    }

    @PutMapping(path = "{adresseId}")
    public void updateAdresse(@PathVariable("adresseId") Long id,
                              @RequestParam(required = false) String label,
                              @RequestParam(required = false) String pays,
                              @RequestParam(required = false) String region,
                              @RequestParam(required = false) String ville,
                              @RequestParam(required = false) String quartier,
                              @RequestParam(required = false) String rue,
                              @RequestParam(required = false) String numeroBatiment,
                              @RequestParam(required = false) String appartement)
    {
        adresseService.updateAdresse(id, label, pays, region, ville, quartier, rue, numeroBatiment, appartement);
    }
}
