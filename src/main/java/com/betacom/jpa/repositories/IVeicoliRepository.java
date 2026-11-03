package com.betacom.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betacom.jpa.models.Veicoli;

@Repository
public interface IVeicoliRepository extends JpaRepository<Veicoli, Integer>{

}
