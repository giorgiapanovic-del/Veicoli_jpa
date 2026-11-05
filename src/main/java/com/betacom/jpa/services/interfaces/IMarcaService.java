package com.betacom.jpa.services.interfaces;

import java.util.List;
import com.betacom.jpa.dto.input.MarcaReq;
import com.betacom.jpa.dto.output.MarcaRes;

public interface IMarcaService {

	void createMarca(MarcaReq req) throws Exception;
	void deleteMarca(Integer id) throws Exception;
	
	List<MarcaRes> listMarca() throws Exception;
}
