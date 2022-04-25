package com.bank.api.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.api.domain.Banco;
import com.bank.api.services.BankService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "banco")
@RequestMapping("/bancos")
public class BancoResource {

    @Autowired
    private BankService service;


    @GetMapping
    @ApiOperation(value = "Mostra lista de bancos")
    public ResponseEntity<List<Banco>> findAll() {
        List<Banco> bancos = service.findAll();
        return ResponseEntity.ok().body(bancos);

    }


}
