package com.unisc.farmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unisc.farmacia.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

	
}
