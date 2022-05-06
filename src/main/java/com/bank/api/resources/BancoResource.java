package com.bank.api.resources;

import com.bank.api.domain.AgenciaBancaria;
import com.bank.api.services.BankService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
@Api(value = "banco")
public class BancoResource {

    @Autowired
    private BankService service;

    @RequestMapping(value = "/bancos", method = RequestMethod.GET)
    @ApiOperation(value = "Mostra lista de bancos")
    public ModelAndView findAll() {
        ModelAndView mav = new ModelAndView("bancos");
        List<AgenciaBancaria> bancos = service.findAll();
        mav.addObject("bancos", bancos);
        return mav;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Busca banco por Id")
    public ResponseEntity<AgenciaBancaria> findById(@PathVariable Long id) {
        AgenciaBancaria banco = service.findById(id);
        return ResponseEntity.ok().body(banco);
    }

    @PostMapping
    @ApiOperation(value = "Cadastrar novo banco")
    public ResponseEntity<AgenciaBancaria> insert(@RequestBody AgenciaBancaria banco) {
        AgenciaBancaria bancoNovo = service.novoBanco(banco);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(bancoNovo.getAgencia())
                .toUri();
        return ResponseEntity.created(uri).body(bancoNovo);
    }

    @PutMapping
    @ApiOperation(value = "Atualização dos dados da agência")
    public ResponseEntity<AgenciaBancaria> atualizarBanco(@PathVariable Long id, @RequestBody AgenciaBancaria banco) {
        AgenciaBancaria objBanco = service.atualizarDados(id, banco);
        return ResponseEntity.ok().body(objBanco);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deletar um banco bancaria")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.removerBanco(id);
        return ResponseEntity.noContent().build();
    }

}
