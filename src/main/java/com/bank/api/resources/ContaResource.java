package com.bank.api.resources;

import com.bank.api.domain.Conta;
import com.bank.api.services.ContaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "conta")
@RequestMapping(value = "/contas")
public class ContaResource {

    @Autowired
    private ContaService service;


    @GetMapping
    @ApiOperation(value = "Mostra lista de contas")
    public ResponseEntity<List<Conta>> findAll(){
        List<Conta> contas = service.findAll();
        return ResponseEntity.ok().body(contas);

    }

}
