package com.betacom.jpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.betacom.jpa.models.Bici;

import jakarta.persistence.NamedQuery;

public interface IBiciRepository extends JpaRepository<Bici, Integer>{
	@Query (name ="bici.selectByFilter")
	List<Bici> searchByFilter(
			@Param("id") Integer id,
	        @Param("numeroCorone") Integer numeroCorone,
	        @Param("numeroMarce") Integer numeroMarce,
	        @Param("tipoFreno") String tipoFreno,
	        @Param("idTipoSospensione") Integer idTipoSospensione,
	        @Param("pieghevole") Boolean pieghevole
			);

}
