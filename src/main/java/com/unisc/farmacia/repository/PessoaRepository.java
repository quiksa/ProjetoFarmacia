package com.unisc.farmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.unisc.farmacia.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

	
	@Query(value="select * from pessoa p where p.nrcpf=?1",nativeQuery = true)
	Pessoa findPessoaPorCpf(String nrCpf);
	
}
