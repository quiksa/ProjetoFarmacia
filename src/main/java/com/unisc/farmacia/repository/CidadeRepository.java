package com.unisc.farmacia.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.unisc.farmacia.model.Cidade;
import com.unisc.farmacia.model.Estado;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

	@Query(value="select * from ciddade e where e.idcidade =?1",nativeQuery = true)
	Optional<Estado> findEstadoById(int idEstado);
	
}
