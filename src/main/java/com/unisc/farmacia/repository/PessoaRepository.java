package com.unisc.farmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unisc.farmacia.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

	
}
