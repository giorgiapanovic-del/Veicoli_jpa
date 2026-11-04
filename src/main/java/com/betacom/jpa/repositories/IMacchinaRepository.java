package com.betacom.jpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.betacom.jpa.models.Macchina;

@Repository
public interface IMacchinaRepository extends JpaRepository<Macchina, Integer> {
	
	@Query (name ="macchina.selectByFilter")
	List<Macchina> searchByFilter(
			@Param("id") Integer id,
	        @Param("targa") String targa,
	        @Param("cc") Integer cc,
	        @Param("numeroPorte") Integer numeroPorte
			);

	

}
