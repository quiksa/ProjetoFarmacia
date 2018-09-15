package com.unisc.farmacia.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.unisc.farmacia.model.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Integer> {
	
	@Query(value="select * from estado e where e.idestado =?1",nativeQuery = true)
	Optional<Estado> findEstadoById(int idEstado);

}
