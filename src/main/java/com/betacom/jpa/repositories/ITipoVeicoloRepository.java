package com.betacom.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betacom.jpa.models.TipoVeicolo;

@Repository
public interface ITipoVeicoloRepository extends JpaRepository<TipoVeicolo, Integer>{

}
