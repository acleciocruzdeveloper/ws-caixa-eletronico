package com.bank.api.resources;

import com.bank.api.domain.Bank;
import com.bank.api.domain.Conta;
import com.bank.api.services.BankService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "bank")
@RequestMapping("/bank")
public class BankResource {

    @Autowired
    private BankService service;


    @GetMapping
    @ApiOperation(value = "Mostra lista de bancos")
    public ResponseEntity<List<Bank>> findAll() {
        List<Bank> contas = service.findAll();
        return ResponseEntity.ok().body(contas);

    }


}
