package com.unisc.farmacia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.unisc.farmacia.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

	@Query(value="select * from cidade e where e.idcidade =?1",nativeQuery = true)
	Cidade findCidadeById(int idCidade);

	@Query(value="select * from cidade c "
			+ "inner join estado e on e.idestado = c.idestado "
			+ "where c.idestado=?1 order by c.nmcidade",nativeQuery=true)
	List<Cidade> findAllByIdEstado(int idEstado);
	
}
