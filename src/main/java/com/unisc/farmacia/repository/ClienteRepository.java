package com.unisc.farmacia.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.unisc.farmacia.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	
	@Query(value="select * from cliente inner join pessoa on (cliente.idpessoa = pessoa.idpessoa and pessoa.nmpessoa like %?1% );",nativeQuery = true)
	List<Cliente> findListaClientePorNome(String nome);
}
