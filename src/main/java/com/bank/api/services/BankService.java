package com.bank.api.services;

import com.bank.api.domain.Bank;
import com.bank.api.domain.Client;
import com.bank.api.repositories.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankService {

    @Autowired
    private BankRepository repository;

    public List<Bank> findAll() {
        return repository.findAll();
    }

    public Bank findById(Long id) {
        Optional<Bank> o = repository.findById(id);
        return o.get();
    }

    public void save(Bank bank){
        Bank obj  = new Bank();
        repository.save(obj);
    }

    public void removerClient(){
        Bank obj = new Bank();
        repository.delete(obj);
    }

}
