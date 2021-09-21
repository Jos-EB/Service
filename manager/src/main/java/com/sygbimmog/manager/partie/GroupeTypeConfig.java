package com.sygbimmog.manager.partie;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class GroupeTypeConfig {

    @Bean
    CommandLineRunner commandLineRunnerGroupeType (GroupeTypeRepository groupeTypeRepository){
        return args -> {
            GroupeType famille = new GroupeType("Famille", "Ensemble formé d'un père et/ou d'une mère et de(s) enfant(s)");
            GroupeType clan = new GroupeType("clan", "Ensemble de personnes descendant d'un même encètre");
            GroupeType communaute = new GroupeType("Communauté", "Ensemble de personnes partageant le même espace géographique généralement restraint ainsi que leurs activités");
            groupeTypeRepository.saveAll(List.of(clan, communaute, famille));
        };
    }
}
