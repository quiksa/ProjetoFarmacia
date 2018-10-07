package com.unisc.farmacia.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.unisc.farmacia.model.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Integer> {
	
	@Query(value="select * from cargo c where c.idcargo =?1",nativeQuery = true)
	Optional<Cargo> findCargoById(int idCargo);
	
	@Query(value="select * from cargo c where c.dscargo=?1",nativeQuery = true)
	Optional<Cargo> findCargoByDs(String ds);
	
	
}
