package com.myCompany.dataManager.company;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CompanyConfig {

    /*@Bean
    CommandLineRunner commandLineRunner(CompanyRepository companyRepository){
        return args -> {
            Company musicStore = new Company(
                    "Max",
                    "Mustermann",
                    "MusicStore GmbH",
                    "83742738",
                    "0123-456780",
                    "0123-456781",
                    "musicstore@gmail.com",
                    false
            );

            Company thomann = new Company(
                    "John",
                    "Doe",
                    "Thomann GmbH & Co KG",
                    "47563223",
                    "0223-888999",
                    "0223-888998",
                    "thomann@posteo.de",
                    false
            );

            companyRepository.saveAll(List.of(musicStore,thomann));
        };
    }*/
}
