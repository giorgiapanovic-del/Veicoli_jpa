package com.betacom.jpa.services.interfaces;

import java.util.List;

import com.betacom.jpa.dto.input.MotoReq;
import com.betacom.jpa.dto.output.MotoRes;

public interface IMotoService {

	void createMoto(MotoReq motoReq) throws Exception;
	void updateMoto(MotoReq motoReq) throws Exception;
	void deleteMoto(Integer motoID) throws Exception;
	
	List<MotoRes> listMoto() throws Exception;
}
