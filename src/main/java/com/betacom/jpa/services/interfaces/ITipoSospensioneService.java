package com.betacom.jpa.services.interfaces;

import java.util.List;
import com.betacom.jpa.dto.input.TipoSospensioneReq;
import com.betacom.jpa.dto.output.TipoSospensioneRes;

public interface ITipoSospensioneService {

	void createSospensione(TipoSospensioneReq req) throws Exception;
	void deleteSospensione(Integer id) throws Exception;
	
	List<TipoSospensioneRes> listSospensione() throws Exception;
}
