package com.betacom.jpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.betacom.jpa.models.Veicoli;

@Repository
public interface IVeicoliRepository extends JpaRepository<Veicoli, Integer>{
	@Query (name ="veicoli.selectByFilter")
	List<Veicoli> searchByFilter(
	        @Param("id") Integer id,
	        @Param("idTipoVeicolo") Integer idTipoVeicolo,
	        @Param("numeroRuote") Integer numeroRuote,
	        @Param("idTipoAlimentazione") String idTipoAlimentazione, // String perché in base al DDL l'id è un varchar
	        @Param("idCategoria") String idCategoria,                 // String perché in base al DDL l'id è un varchar
	        @Param("idColore") Integer idColore,
	        @Param("idMarca") Integer idMarca,
	        @Param("annoProduzione") Integer annoProduzione,
	        @Param("modello") String modello
	    );
}
