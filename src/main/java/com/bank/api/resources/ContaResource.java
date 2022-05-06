package com.bank.api.resources;

import com.bank.api.domain.Conta;
import com.bank.api.services.ContaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@Api(value = "contas")
@RequestMapping("/contas")
public class ContaResource {

    @Autowired
    private ContaService contaService;

    @GetMapping
    @ApiOperation(value = "Mostra lista de contas cadastradas")
    public ResponseEntity<List<Conta>> findAll() {
        List<Conta> contaList = contaService.findAll();
        return ResponseEntity.ok().body(contaList);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Mostra clientes por id")
    public ResponseEntity<Conta> findById(@PathVariable Long id) {
        Conta conta = contaService.findById(id);
        return ResponseEntity.ok().body(conta);
    }

    @PostMapping
    @ApiOperation(value = "Cadastro de conta")
    public ResponseEntity<Conta> insert(@RequestBody Conta conta) {
        Conta novaConta = contaService.insert(conta);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(novaConta.getNumeroConta())
                .toUri();
        return ResponseEntity.created(uri).body(novaConta);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deve fechar uma conta")
    public ResponseEntity<Void> fecharConta(@PathVariable Long id) {
        contaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
