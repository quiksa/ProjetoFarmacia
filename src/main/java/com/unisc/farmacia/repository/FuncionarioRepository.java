package com.unisc.farmacia.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.unisc.farmacia.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

	@Query(value = "select * from funcionario where login =?1 and senha=?2", nativeQuery = true)
	List<Funcionario> listaFuncionario(String login, String senha);

	// seleciona o id,cargo e nome do funcionario pelo nome
	@Query(value = "SELECT f.idfuncionario, c.dscargo, p.nmpessoa from funcionario f, cargo c, pessoa p where"
			+ " p.idpessoa = f.idpessoa and f.idcargo = c.idcargo and p.nmpessoa = '?1';",nativeQuery = true)
	Optional<Object> buscaCargoFuncionario (String nome);
 
}
