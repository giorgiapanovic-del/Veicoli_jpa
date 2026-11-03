package com.betacom.jpa.services.interfaces;

import java.util.List;

import com.betacom.jpa.dto.input.VeicoliReq;
import com.betacom.jpa.dto.output.VeicoliRes;

public interface IVeicoliService {

	void createVeicoli(VeicoliReq veicoliReq) throws Exception;
	void updateVeicoli(VeicoliReq veicoliReq) throws Exception;
	void deleteVeicoli(Integer veicoliID) throws Exception;
	
	VeicoliRes findById(Integer id) throws Exception;
	
	List<VeicoliRes> listVeicoli() throws Exception;
}
