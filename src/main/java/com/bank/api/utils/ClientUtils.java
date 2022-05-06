package com.bank.api.utils;

import com.bank.api.domain.AgenciaBancaria;
import com.bank.api.domain.Cliente;
import com.bank.api.domain.Conta;
import com.bank.api.enums.Banco;
import com.bank.api.enums.TipoConta;
import com.bank.api.repositories.BancoRepository;
import com.bank.api.repositories.ClienteRepository;
import com.bank.api.repositories.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Arrays;

@Component
@Profile("test")
public class ClientUtils implements CommandLineRunner {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private BancoRepository bancoRepository;

    @Autowired
    private ContaRepository contaRepository;

    @Override
    public void run(String... args) throws Exception {

        Cliente c1 = Cliente.builder().id(null).nome("Ghuilherme Santiago").endereco("Rua Anhanguera")
                .telefone("(62) 5569-3322").build();
        Cliente c2 = Cliente.builder().id(null).nome("Raimundo Nonanto").endereco("Avenida Lucena Roriz")
                .telefone("(58) 5544-3355").build();

        AgenciaBancaria bancoUm = AgenciaBancaria.builder().agencia(null).nomeAgencia("Agência Brasília")
                .banco(Banco.BRADESCO)
                .endereco("SQSW 05, Bloco A, Loja 25 - Suoeste /DF").telefone("(61) 5555-3322").build();

        AgenciaBancaria bancoDois = AgenciaBancaria.builder().agencia(null).nomeAgencia("Agência São Paulo")
                .banco(Banco.BANCO_DO_BRASIL)
                .endereco("São Paulo - São Paulo /SP").telefone("(11) 2222-3322").build();

        Conta contaUm = Conta.builder().numeroConta(null).dataAbertura(Instant.parse("2019-04-08T14:32:24Z"))
                .cliente(c1).agenciaBancaria(bancoUm).tipoConta(TipoConta.CONTA_CORRENTE).depositoInicial(new BigDecimal(1500.00)).build();

        Conta contaDois = Conta.builder().numeroConta(null).dataAbertura(Instant.parse("2019-04-09T11:52:27Z"))
                .cliente(c2).agenciaBancaria(bancoDois).tipoConta(TipoConta.CONTA_POUPANCA)
                .depositoInicial(new BigDecimal(500.58)).build();

        clienteRepository.saveAll(Arrays.asList(c1, c2));

        bancoRepository.saveAll(Arrays.asList(bancoUm, bancoDois));

        contaRepository.saveAll(Arrays.asList(contaUm, contaDois));

    }
}
