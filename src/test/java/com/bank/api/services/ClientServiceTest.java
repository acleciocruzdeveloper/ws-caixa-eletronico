package com.bank.api.services;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.bank.api.domain.Cliente;
import com.bank.api.repositories.ClienteRepository;

@ExtendWith(SpringExtension.class)
public class ClientServiceTest {


    @Mock
    private ClienteRepository repository;
    @Mock
    private ClientService service;

    @Test
    public void deveBuscarTodosClientes() {

        List<Cliente> clientList = new ArrayList<>();

        when(service.findAll()).thenReturn(clientList);

    }
   
}
