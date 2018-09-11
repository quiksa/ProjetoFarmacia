package com.unisc.farmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unisc.farmacia.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	
}
