package com.bank.api.utils;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.bank.api.domain.Banco;
import com.bank.api.domain.Cliente;
import com.bank.api.domain.Conta;
import com.bank.api.enums.TipoConta;
import com.bank.api.repositories.BancoRepository;
import com.bank.api.repositories.ClienteRepository;
import com.bank.api.repositories.ContaRepository;

@Configuration
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

		Banco bancoUm = Banco.builder().agencia(null).nomeAgencia("Agência Brasília")
				.endereco("SQSW 05, Bloco A, Loja 25 - Suoeste /DF").telefone("(61) 5555-3322").build();

		Banco bancoDois = Banco.builder().agencia(null).nomeAgencia("Agência São Paulo")
				.endereco("São Paulo - São Paulo /SP").telefone("(11) 2222-3322").build();

		Conta contaUm = Conta.builder().numeroConta(null).dataAbertura(Instant.parse("2019-04-08T14:32:24Z"))
				.cliente(c1).banco(bancoUm).tipoConta(TipoConta.CONTA_CORRENTE).build();

		Conta contaDois = Conta.builder().numeroConta(null).dataAbertura(Instant.parse("2019-04-09T11:52:27Z"))
				.cliente(c2).banco(bancoDois).tipoConta(TipoConta.CONTA_POUPANCA).build();

		clienteRepository.saveAll(Arrays.asList(c1, c2));

		bancoRepository.saveAll(Arrays.asList(bancoUm, bancoDois));

		contaRepository.saveAll(Arrays.asList(contaUm, contaDois));

	}
}
