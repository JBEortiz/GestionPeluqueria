package com.microservicios.models.controller;

import java.util.List;
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
import com.microservicios.models.entity.Empresa;
import com.microservicios.models.service.EmpresaService;
@RestController

public class EmpresaController {
	
	@Autowired
	private EmpresaService empresaService;
	@GetMapping("/peluqueria")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok().body(empresaService.findAll());
	}

	@GetMapping("/peluqueria/{id}")
	public ResponseEntity<?> get(@PathVariable Long id) {
		Optional<Empresa> optional = empresaService.finById(id);
		if (optional == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(optional.get());
	}

	@PostMapping("/peluqueria")
	public ResponseEntity<?> create(@RequestBody Empresa empresaPelu) {
		Empresa empresa = empresaService.save(empresaPelu);
		return ResponseEntity.status(HttpStatus.CREATED).body(empresa);
	}

	@PutMapping("/peluqueria/{id}")
	public ResponseEntity<?> update(@RequestBody Empresa empresaPelu, @PathVariable Long id) {
		Optional<Empresa> optional = empresaService.finById(id);
		if (optional == null) {
			return ResponseEntity.notFound().build();
		}
		Empresa empresa = optional.get();
		empresa.setNombre(empresaPelu.getNombre());
        empresa.setDireccion(empresaPelu.getDireccion());
		return ResponseEntity.status(HttpStatus.CREATED).body(empresaService.save(empresa));

	}
	@PutMapping("/peluqueria/{id}/ayadirClientes")
	public ResponseEntity<?> addCliente(@RequestBody List<Cliente> clientes, @PathVariable Long id){
		Optional<Empresa> optional= this.empresaService.finById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Empresa empresa= optional.get();
		clientes.forEach(e->{ empresa.setClientes(clientes);});
		return ResponseEntity.status(HttpStatus.CREATED).body(empresaService.save(empresa));
		
	}
	
	@DeleteMapping("/peluqueria/{id}/eliminarCliente")
	public ResponseEntity<?> deleteCliente(@RequestBody Cliente cliente, @PathVariable Long id){
		Optional<Empresa> optional= this.empresaService.finById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Empresa empresa= optional.get();
		empresa.getClientes().remove(cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(empresaService.save(empresa));
		
	}
	

	@DeleteMapping("/peluqueria/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		empresaService.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
