package com.microservicios.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.microservicios.models.entity.Empresa;

public interface EmpresaRepository extends CrudRepository<Empresa, Long> {

}
