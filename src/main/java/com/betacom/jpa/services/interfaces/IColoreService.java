package com.betacom.jpa.services.interfaces;

import java.util.List;

import com.betacom.jpa.dto.input.ColoreReq;
import com.betacom.jpa.dto.output.ColoreRes;

public interface IColoreService {

	void createColore(ColoreReq req) throws Exception;
	void deleteColore(Integer id) throws Exception;
	
	List<ColoreRes> listColore() throws Exception;
}
