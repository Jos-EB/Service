package com.sygbimmog.manager.partie;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PartieTypeConfg {
    @Bean
    CommandLineRunner commandLineRunnerPartieType (PartieTypeRepository partieTypeRepository){
        return args -> {
            PartieType principal = new PartieType("PincipalT", "Personne initiant l'acquisirion");
            PartieType majoritaire = new PartieType("MajotitaireT", "Personne ayant le plus grosse part dans le transaction");
            PartieType minoritaire = new PartieType("MinoritaireT", "Personne ayant la plus petite part dans la transaction");
            partieTypeRepository.saveAll(List.of(majoritaire, minoritaire, principal));
        };
    }
}
