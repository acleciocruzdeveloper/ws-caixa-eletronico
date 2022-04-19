package com.bank.api.services;


import com.bank.api.domain.Client;
import com.bank.api.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public List<Client> findAll() {
        return repository.findAll();
    }

    public Client findById(Long id) {
        Optional<Client> o = repository.findById(id);
        return o.get();
    }

    public void save(Client client){
        Client obj  = new Client();
        repository.save(obj);
    }

    public void removerClient(){
        Client obj = new Client();
        repository.delete(obj);
    }
}