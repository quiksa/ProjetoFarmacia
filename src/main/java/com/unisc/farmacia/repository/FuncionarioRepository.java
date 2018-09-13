package com.unisc.farmacia.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.unisc.farmacia.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
	
	@Query(value="select * from funcionario where login =?1 and senha=?2",nativeQuery = true)
	Optional<Funcionario>listaFuncionario(String login, String senha);

	
}
