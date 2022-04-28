package com.bank.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.api.domain.Conta;
import com.bank.api.repositories.ContaRepository;

@Service
public class ContaService {

	@Autowired
	private ContaRepository contaRepository;

	public List<Conta> findAll() {
		return contaRepository.findAll();
	}

	public Conta findById(Long id) {
		Optional<Conta> obj = contaRepository.findById(id);
		return obj.get();
	}

}
