package com.bank.api.utils;

import com.bank.api.domain.Client;
import com.bank.api.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class ClientUtils implements CommandLineRunner {


    @Autowired
    private ClientRepository repository;


    @Override
    public void run(String... args) throws Exception {

        Client c1 = new Client(null, "Ghuilherme Santiago", "Rua Anhanguera", "(62) 5569-3625", "1234", "Santander", "25632-1");
        Client c2 = new Client(null, "Raimundo Nonanto", "Avenida Lucena Roriz", "(61) 3623-2525", "4321", "Bradesco", "54789-3");
        repository.saveAll(Arrays.asList(c1, c2));





    }
}
