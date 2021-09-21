package com.sygbimmog.manager.partie;

import com.sygbimmog.manager.unitespatiale.Adresse;
import com.sygbimmog.manager.unitespatiale.AdresseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class PartieConfig {
    @Bean
    CommandLineRunner commandLineRunnerPartie(PartieRepository partieRepository){
        return args -> {
            Partie Ebale = new Partie(LocalDate.now(), "Permanant", 1L, "EBALE Joseph", null, null, "Camerounais", null, "00237694830999", "jos@eb.com");
            Partie Mbida = new Partie(LocalDate.now(), "Permanant", 1L, "Mbida Raymend", null, null, "Camerounais", null, "00237694830999", "jos@eb.com");
            Partie Nnemete = new Partie(LocalDate.now(), "Permanant", 1L, "Nnemete Alphonse", null, null, "Camerounais", null, "00237694830999", "jos@eb.com");
            partieRepository.saveAll(List.of(Ebale, Mbida, Nnemete));
        };
    }
}
