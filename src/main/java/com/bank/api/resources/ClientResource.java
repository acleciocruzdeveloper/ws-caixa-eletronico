package com.bank.api.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bank.api.domain.Cliente;
import com.bank.api.services.ClientService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "clientes")
@RequestMapping("/clientes")
public class ClientResource {

	@Autowired
	private ClientService service;

	@GetMapping
	@ApiOperation(value = "Mostra lista de clientes cadastradas")
	public ResponseEntity<List<Cliente>> findAll() {
		List<Cliente> clientList = service.findAll();
		return ResponseEntity.ok().body(clientList);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Mostra clientes por ID")
	public ResponseEntity<Cliente> findById(@PathVariable Long id) {
		Cliente client = service.findById(id);
		return ResponseEntity.ok().body(client);
	}

	@PostMapping
	@ApiOperation(value = "Cadastra um novo cliente")
	public ResponseEntity<Cliente> insert(@RequestBody Cliente cliente) {
		Cliente umNovoCliente = service.umNovoCliente(cliente);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(umNovoCliente.getId())
				.toUri();
		return ResponseEntity.created(uri).body(umNovoCliente);

	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Deletar um cliente com ID")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.apagarUmCliente(id);
		return ResponseEntity.noContent().build();

	}
	@PutMapping
	@ApiOperation(value = "Atualizar dados de um cliente")
	public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente cliente){
		Cliente obj = service.atualizar(id, cliente);
		return ResponseEntity.ok().body(obj);
	}

}
