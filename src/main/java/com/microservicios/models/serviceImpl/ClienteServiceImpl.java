package com.microservicios.models.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microservicios.models.entity.Cliente;
import com.microservicios.models.repository.ClienteRepository;
import com.microservicios.models.service.ClienteService;
@Service
public class ClienteServiceImpl implements ClienteService{
    
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Cliente> findAllCliente() {
		return clienteRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Cliente> finByIdCliente(Long id) {
		return clienteRepository.findById(id);
	}

	@Override
	@Transactional
	public Cliente saveCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@Override
	@Transactional
	public void deleteByIdCliente(Long id) {
		clienteRepository.deleteById(id);
	}

	@Override
	public List<Cliente> findAllOrderByNombre() {
		return clienteRepository.findAllOrderByNombre();
	}

}
