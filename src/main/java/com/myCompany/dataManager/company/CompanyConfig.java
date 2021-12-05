package com.myCompany.dataManager.company;

import com.myCompany.dataManager.address.Address;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class CompanyConfig {

    @Bean
    CommandLineRunner commandLineRunner(CompanyRepository companyRepository){
        /*List<Address> msAddress = new ArrayList<>();
        msAddress.add(new Address(
                "First Av. 89",
                "484848",
                "New York",
                "USA",
                "main")
                );
        msAddress.add(new Address(
                "Second Av. 90",
                "67543",
                "Chicago",
                "USA",
                "post")
        );


        List<Address> tmAddress = new ArrayList<>();
        tmAddress.add(new Address(
                "Third Av. 44",
                "38475",
                "Los Angeles",
                "USA",
                "main"));*/
        return args -> {
            Company musicStore = new Company(
                    "Max",
                    "Mustermann",
                    "MusicStore GmbH",
                    "83742738",
                    "0123-456780",
                    "0123-456781",
                    "musicstore@gmail.com"
                    /*msAddress*/
            );

            Company thomann = new Company(
                    "John",
                    "Doe",
                    "Thomann GmbH & Co KG",
                    "47563223",
                    "0223-888999",
                    "0223-888998",
                    "thomann@posteo.de"

            );

            companyRepository.saveAll(List.of(musicStore,thomann));
        };
    }
}
