package com.betacom.jpa.services.interfaces;

import java.util.List;

import com.betacom.jpa.dto.input.BiciReq;
import com.betacom.jpa.dto.output.BiciRes;
import com.betacom.jpa.dto.output.VeicoliRes;


public interface IBiciService {

	void createBici(BiciReq biciReq) throws Exception;
	void updateBici(BiciReq biciReq) throws Exception;
	void deleteBici(Integer biciID) throws Exception;
	
	BiciRes findById(Integer id) throws Exception;
	
	List<BiciRes> listBici() throws Exception;
	
	List<BiciRes> listFiltri(Integer id, Integer numeroCorone, Integer numeroMarce, String tipoFreno, Integer idTipoSospensione, Boolean pieghevole) throws Exception;

}
