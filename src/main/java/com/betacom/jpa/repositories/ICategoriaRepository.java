package com.betacom.jpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.betacom.jpa.models.Categoria;

@Repository
public interface ICategoriaRepository extends JpaRepository<Categoria, Integer>{

//	List<Categoria> findById (@Param("id") String filter);
}
