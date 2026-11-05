package com.betacom.jpa.services.interfaces;

import java.util.List;
import com.betacom.jpa.dto.input.TipoVeicoloReq;
import com.betacom.jpa.dto.output.TipoVeicoloRes;

public interface ITipoVeicoloService {

	void createVeicolo(TipoVeicoloReq req) throws Exception;
	void deleteVeicolo(Integer id) throws Exception;
	
	List<TipoVeicoloRes> listVeicolo() throws Exception;
}
