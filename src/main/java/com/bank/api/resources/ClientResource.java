package com.bank.api.resources;


import com.bank.api.domain.Client;
import com.bank.api.services.ClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "clientes")
@RequestMapping("/clientes")
public class ClientResource {

    @Autowired
    private ClientService service;

    @GetMapping
    @ApiOperation(value = "Mostra lista de clientes cadastradas")
    public ResponseEntity<List<Client>> findAll(){
        List<Client> clientList = service.findAll();
        return ResponseEntity.ok().body(clientList);
    }
    @GetMapping("/{id}")
    @ApiOperation(value = "Mostra clientes por ID")
    public ResponseEntity<Client> findById(@PathVariable Long id){
        Client client = service.findById(id);
        return ResponseEntity.ok().body(client);
    }

}
