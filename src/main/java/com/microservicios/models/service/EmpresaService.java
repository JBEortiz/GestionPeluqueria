package com.microservicios.models.service;

import java.util.Optional;

import com.microservicios.models.entity.Empresa;

public interface EmpresaService {
	
	public Iterable<Empresa> findAll();

	public Optional<Empresa> finById(Long id);

	public Empresa save(Empresa empresa);

	public void deleteById(Long id);

}
