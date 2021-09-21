package com.sygbimmog.manager.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student ebale = new Student ("EBALE", "ebale@jos.com", LocalDate.of(1991, Month.JULY,24));
            Student mbida = new Student("Mbida", "mbida@jos.com", LocalDate.of(1996, Month.FEBRUARY, 29));
            repository.saveAll(List.of(ebale, mbida));
        };
    }
}
