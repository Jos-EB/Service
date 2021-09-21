package com.sygbimmog.manager.partie;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PartieRoleConfig {

    @Bean
    CommandLineRunner commandLineRunnerPartieRole (PartieRoleRepository partieRoleRepository){
        return args -> {
            PartieRole principal = new PartieRole("Pincipal", "Personne initiant l'acquisirion");
            PartieRole majoritaire = new PartieRole("Majotitaire", "Personne ayant le plus grosse part dans le transaction");
            PartieRole minoritaire = new PartieRole("Minoritaire", "Personne ayant la plus petite part dans la transaction");
            partieRoleRepository.saveAll(List.of(majoritaire, minoritaire, principal));
        };
    }
}
