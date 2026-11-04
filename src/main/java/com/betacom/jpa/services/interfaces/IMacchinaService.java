package com.betacom.jpa.services.interfaces;

import java.util.List;
import com.betacom.jpa.dto.input.MacchinaReq;
import com.betacom.jpa.dto.output.BiciRes;
import com.betacom.jpa.dto.output.MacchinaRes;
import com.betacom.jpa.exception.VeicoloException;

public interface IMacchinaService {
	
    List<MacchinaRes> listMacchina() throws Exception;
    MacchinaRes getMacchinaById(Integer id) throws Exception;
    void createMacchina(MacchinaReq request) throws Exception;
    void updateMacchina(MacchinaReq request) throws Exception;
    void deleteMacchina(Integer id) throws Exception;
	List<MacchinaRes> listFiltri(Integer id, String targa, Integer cc, Integer numeroPorte) throws Exception;
	
}