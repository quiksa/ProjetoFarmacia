package com.unisc.farmacia.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.unisc.farmacia.model.Estado;
import com.unisc.farmacia.model.Unidade;

public interface UnidadeRepository extends JpaRepository<Unidade, Integer> {
	
	@Query(value="select * from estado e where e.idestado =?1",nativeQuery = true)
	Optional<Estado> findEstadoById(int idEstado);

	
}
