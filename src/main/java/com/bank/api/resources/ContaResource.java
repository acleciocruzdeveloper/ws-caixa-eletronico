package com.bank.api.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.api.domain.Conta;
import com.bank.api.services.ContaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "contas")
@RequestMapping("/contas")
public class ContaResource {
	
	@Autowired
	private ContaService contaService;
	
	 @GetMapping
	    @ApiOperation(value = "Mostra lista de contas cadastradas")
	    public ResponseEntity<List<Conta>> findAll(){
	        List<Conta> contaList = contaService.findAll();
	        return ResponseEntity.ok().body(contaList);
	    }
	    @GetMapping("/{id}")
	    @ApiOperation(value = "Mostra clientes por ID")
	    public ResponseEntity<Conta> findById(@PathVariable Long id){
	        Conta conta = contaService.findById(id);
	        return ResponseEntity.ok().body(conta);
	    }



}
