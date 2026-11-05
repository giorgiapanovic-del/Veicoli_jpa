package com.betacom.jpa.services.interfaces;

import java.util.List;
import com.betacom.jpa.dto.input.TipoAlimentazioneReq;
import com.betacom.jpa.dto.output.TipoAlimentazioneRes;

public interface ITipoAlimentazioneService {

	void createAlimentazione(TipoAlimentazioneReq req) throws Exception;
	void deleteAlimentazione(Integer id) throws Exception;
	
	List<TipoAlimentazioneRes> listAlimentazione() throws Exception;
}
