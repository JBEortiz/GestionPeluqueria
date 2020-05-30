package com.microservicios.models.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microservicios.models.entity.Empresa;
import com.microservicios.models.repository.EmpresaRepository;
import com.microservicios.models.service.EmpresaService;
@Service
public class EmpresaServiceImpl implements EmpresaService {

	@Autowired
	private  EmpresaRepository empresaRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Empresa> findAll() {
		return empresaRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Empresa> finById(Long id) {
		return empresaRepository.findById(id);
	}

	@Override
	@Transactional
	public Empresa save(Empresa empresa) {
		return empresaRepository.save(empresa);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
       empresaRepository.deleteById(id);		
	}

}
