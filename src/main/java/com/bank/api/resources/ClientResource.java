package com.bank.api.resources;


import com.bank.api.domain.Client;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClientResource {

    @GetMapping
    public ResponseEntity<Client> findAll(){
        Client c1 = new Client(1L, "Maria", "Rua botucatu");
        return ResponseEntity.ok().body(c1);
    }

}
