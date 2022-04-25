package com.bank.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.api.domain.Banco;
import com.bank.api.repositories.BancoRepository;

@Service
public class BankService {

    @Autowired
    private BancoRepository repository;

    public List<Banco> findAll() {
        return repository.findAll();
    }

    public Banco findById(Long id) {
        Optional<Banco> o = repository.findById(id);
        return o.get();
    }

}
