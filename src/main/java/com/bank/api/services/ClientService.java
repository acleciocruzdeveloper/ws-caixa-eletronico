package com.bank.api.services;


import com.bank.api.domain.Cliente;
import com.bank.api.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClienteRepository repository;

    public List<Cliente> findAll() {
        return repository.findAll();
    }

    public Cliente findById(Long id) {
        Optional<Cliente> o = repository.findById(id);
        return o.get();
    }
    
    public Cliente umNovoCliente(Cliente cliente) {
    	return repository.save(cliente);
    }

}