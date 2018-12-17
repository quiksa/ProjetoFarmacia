package com.unisc.farmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.unisc.farmacia.model.DocFiscal;

public interface DocFiscalRepository extends JpaRepository<DocFiscal, Integer> {
	
	
	@Query(value = "select * from docfiscal df"
			+ " where df.tpoperacao = 'SA' and df.idunidade = ?1", nativeQuery = true)
	Iterable<DocFiscal> getDocfiscalSaida(int idunidade);

	
}
