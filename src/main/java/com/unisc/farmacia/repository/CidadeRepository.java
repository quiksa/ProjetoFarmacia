package com.unisc.farmacia.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.unisc.farmacia.model.Cidade;
import com.unisc.farmacia.model.Estado;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

	@Query(value="select * from cidade e where e.idcidade =?1",nativeQuery = true)
	Optional<Estado> findEstadoById(int idEstado);

	@Query(value="select * from cidade c, estado e where e.idestado=c.idestado and e.nmestado=?1",nativeQuery=true)
	List<Cidade> findAllByIdEstado(String nmEstado);
	
}
