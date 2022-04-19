package com.bank.api.services;

import com.bank.api.domain.Conta;
import com.bank.api.repositories.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaService {

    @Autowired
    private ContaRepository repository;


    public List<Conta> findAll() {
        return repository.findAll();
    }
}
