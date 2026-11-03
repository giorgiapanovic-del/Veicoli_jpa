package com.betacom.jpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betacom.jpa.dto.input.MacchinaReq;
import com.betacom.jpa.dto.output.MacchinaRes;
import com.betacom.jpa.models.Macchina;

@Repository
public interface IMacchinaRepository extends JpaRepository<Macchina, Integer> {

	void createMacchina(MacchinaReq macchinaReq) throws Exception;
	void updateMacchina(MacchinaReq macchinaReq) throws Exception;
	void deleteMacchina(Integer macchinaID) throws Exception;
	
	List<MacchinaRes> listMoto() throws Exception;
}
