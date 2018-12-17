package com.unisc.farmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.unisc.farmacia.model.MovimentoMercadoria;

public interface MovimentoMercadoriaRepository extends JpaRepository<MovimentoMercadoria, Integer> {

	@Query(value = "select COALESCE ((select sum(me.qtmovimentoestoque) as quantidade from movimentomercadoria mm"
			+ " inner join movimentoestoque me ON me.idmovimentoestoque = mm.idmovimentoestoque"
			+ " where mm.idmercadoria = ?1 and me.tpmovimentoestoque = 'SA' and mm.idunidade = ?2 GROUP by mm.idmercadoria),0)", nativeQuery = true)
	int getQuantidadeSaida(int idmercadoria, int idunidade);
	
	@Query(value = "select sum(me.qtmovimentoestoque) as quantidade from movimentomercadoria mm"
			+ " inner join movimentoestoque me ON me.idmovimentoestoque = mm.idmovimentoestoque"
			+ " where mm.idmercadoria = ?1 and me.tpmovimentoestoque = 'EN' and mm.idunidade = ?2 GROUP by mm.idmercadoria", nativeQuery = true)
	int getQuantidadeEntrada(int idmercadoria, int idunidade);
	
	
	@Query(value = "select * from movimentomercadoria mm"
			+ " inner join movimentoestoque me ON me.idmovimentoestoque = mm.idmovimentoestoque"
			+ " where me.tpmovimentoestoque = 'EN' and mm.idunidade = ?1", nativeQuery = true)
	Iterable<MovimentoMercadoria> getEntradaEstoque(int idunidade);
	
	@Query(value = "select * from movimentomercadoria mm"
			+ " inner join movimentoestoque me ON me.idmovimentoestoque = mm.idmovimentoestoque"
			+ " where me.tpmovimentoestoque = 'SA' and mm.idunidade = ?1", nativeQuery = true)
	Iterable<MovimentoMercadoria> getSaidaEstoque(int idunidade);

}
