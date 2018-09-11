package com.unisc.farmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unisc.farmacia.model.Estoque;

public interface EstoqueRepository extends JpaRepository<Estoque, Integer> {

	
}
