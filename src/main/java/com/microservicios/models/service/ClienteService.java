package com.microservicios.models.service;

import java.util.List;
import java.util.Optional;

import com.microservicios.models.entity.Cliente;


public interface ClienteService {
     public Iterable<Cliente> findAllCliente();
	
	public Optional<Cliente> finByIdCliente(Long id);
	
	public Cliente saveCliente(Cliente cliente);
	
	public void deleteByIdCliente(Long id);

	List<Cliente> findAllOrderByNombre();
	

}
