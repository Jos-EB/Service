package com.sygbimmog.manager.unitespatiale;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class AdresseCongig {
    @Bean
    CommandLineRunner commandLineRunnerAdresse (AdresseRepository repository){
        return args -> {
            Adresse mainHome = new Adresse ("Maison au centre ville", "Cameroun", "Centre", "Yaoundé", "Elig-Essono", "", "", "");
            Adresse secondaryHome = new Adresse("Maison au bord du Nyong", "Cameroun", "Centre", "Akonolinga", "Administratif", "105", "0001", "");
            Adresse office = new Adresse("Immeuble noName", "Cameroun", "Littoral", "Douala", "Akwa", "D*****", "450", "2");
            repository.saveAll(List.of(mainHome, secondaryHome, office));
        };
    }
}
