package com.bank.api.services;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.bank.api.domain.Client;
import com.bank.api.repositories.ClientRepository;

@ExtendWith(SpringExtension.class)
public class ClientServiceTest {


    @Mock
    private ClientRepository repository;
    @Mock
    private ClientService service;

    @Test
    public void deveBuscarTodosClientes() {

        List<Client> clientList = new ArrayList<>();

        when(service.findAll()).thenReturn(clientList);

    }

    @Test
    public void deveBuscarUmCliente() {
        Client c1 = new Client();

        //when(repository.findById(c1.getId())).thenReturn(Optional.of(c1));

    }
}
