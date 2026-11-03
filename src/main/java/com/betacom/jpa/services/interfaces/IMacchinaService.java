package com.betacom.jpa.services.interfaces;

import java.util.List;
import com.betacom.jpa.dto.input.MacchinaReq;
import com.betacom.jpa.dto.output.MacchinaRes;
import com.betacom.jpa.exception.VeicoloException;

public interface IMacchinaService {
	
    List<MacchinaRes> getAllMacchine();
    MacchinaRes getMacchinaById(Integer id) throws VeicoloException;
    void createMacchina(MacchinaReq request) throws VeicoloException;
    void updateMacchina(MacchinaReq request) throws VeicoloException;
    void deleteMacchina(Integer id) throws VeicoloException;
}