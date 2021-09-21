package com.sygbimmog.manager.partie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/partie_type")
public class PartieTypeController {

    private final PartieTypeService partieTypeService;

    @Autowired
    public PartieTypeController(PartieTypeService partieTypeService){
        this.partieTypeService = partieTypeService;
    }

    @GetMapping
    public List<PartieType> getPartieType(){
        return partieTypeService.getPartieType();
    }

    @GetMapping(path = "{partieTypeId}")
    public Optional<PartieType> getOnePartieType(@PathVariable("partieTypeId")Long partieTypeId){
        return partieTypeService.getOnePartieType(partieTypeId);
    }

    @PostMapping
    public void registerNewPartieType(@RequestBody PartieType partieType){
        partieTypeService.addNewPartieType(partieType);
    }

    @DeleteMapping(path = "{partieTypeId}")
    public void deletePartieType(@PathVariable("partieTypeId")Long partieTypeId){
        partieTypeService.deletePartieType(partieTypeId);
    }

    @PutMapping(path = "{partieTypeId}")
    public void updatePartieType(@PathVariable("partieTypeId") Long partieTypeId,
                                 @RequestParam(required = false)String label,
                                 @RequestParam(required = false)String description){
        partieTypeService.updatePartieType(partieTypeId, label, description);
    }

}
