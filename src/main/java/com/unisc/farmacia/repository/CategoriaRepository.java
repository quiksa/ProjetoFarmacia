package com.unisc.farmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unisc.farmacia.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

	
}
