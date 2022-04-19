package com.bank.api.utils;

import com.bank.api.domain.Bank;
import com.bank.api.domain.Client;
import com.bank.api.domain.Conta;
import com.bank.api.enums.TipoConta;
import com.bank.api.repositories.BankRepository;
import com.bank.api.repositories.ClientRepository;
import com.bank.api.repositories.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class ClientUtils implements CommandLineRunner {


    @Autowired
    private ClientRepository repository;

    @Autowired
    private BankRepository bankRepository;

    @Autowired
    private ContaRepository contaRepository;

    @Override
    public void run(String... args) throws Exception {

        Client c1 = new Client(null, "Ghuilherme Santiago", "Rua Anhanguera", "(62) 5569-3625");
        Client c2 = new Client(null, "Raimundo Nonanto", "Avenida Lucena Roriz", "(61) 3623-2525");

        Bank b1 = new Bank(null, "Agencia Itamaraty", "Avenida das Nações", "(61) 1525-3333");
        Bank b2 = new Bank(null, "Agência Belo Horizonte", "Ouro Preto", "(61) 1525-3333");

        Conta ct1 = new Conta(null, Instant.parse("2011-12-03T10:15:30Z"), b2, c1,  TipoConta.CONTA_CORRENTE);
        Conta ct2 = new Conta(null, Instant.parse("2012-11-03T15:15:30Z"), b1, c2,  TipoConta.CONTA_POUPANCA);

        repository.saveAll(Arrays.asList(c1, c2));

        bankRepository.saveAll(Arrays.asList(b1, b2));

        contaRepository.saveAll(Arrays.asList(ct1, ct2));


    }
}
