package com.microservicios.models.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservicios.models.entity.Cliente;
import com.microservicios.models.service.ClienteService;

@RestController
public class ClienteController { 

	@Autowired
	private ClienteService clienteService;

	@GetMapping
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok().body(clienteService.findAllCliente());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> get(@PathVariable Long id) {
		Optional<Cliente> optional = clienteService.finByIdCliente(id);
		if (optional == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(optional.get());
	}

	@GetMapping("/getAllOrdered")
	public ResponseEntity<?> getAllOrderByNombre() {
		return ResponseEntity.ok().body(clienteService.findAllOrderByNombre());
	}

	@PostMapping
	public ResponseEntity<?> create(@RequestBody Cliente cliente1) {
		Cliente cliente = clienteService.saveCliente(cliente1);
		return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Cliente cliente1, @PathVariable Long id) {
		Optional<Cliente> optional = clienteService.finByIdCliente(id);
		if (optional == null) {
			return ResponseEntity.notFound().build();
		}
		Cliente cliente = optional.get();
		cliente.setNombre(cliente1.getNombre());
		cliente.setApellido(cliente1.getApellido());
		cliente.setNumero(cliente1.getNumero());
		cliente.setHora(cliente1.getHora());
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.saveCliente(cliente));

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		clienteService.deleteByIdCliente(id);
		return ResponseEntity.noContent().build();
	}

}
