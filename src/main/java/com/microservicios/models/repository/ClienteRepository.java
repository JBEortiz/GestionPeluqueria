package com.microservicios.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.microservicios.models.entity.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
	@Query("SELECT c FROM Cliente c ORDER BY c.nombre")
 	List<Cliente> findAllOrderByNombre();
}
