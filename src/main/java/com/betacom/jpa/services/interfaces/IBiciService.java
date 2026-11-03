package com.betacom.jpa.services.interfaces;

import java.util.List;

import com.betacom.jpa.dto.input.BiciReq;
import com.betacom.jpa.dto.output.BiciRes;


public interface IBiciService {

	void createBici(BiciReq biciReq) throws Exception;
	void updateBici(BiciReq biciReq) throws Exception;
	void deleteBici(Integer biciID) throws Exception;
	
	List<BiciRes> listBici() throws Exception;
}
