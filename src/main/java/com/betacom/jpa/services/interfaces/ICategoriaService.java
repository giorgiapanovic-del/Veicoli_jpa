package com.betacom.jpa.services.interfaces;

import java.util.List;

import com.betacom.jpa.dto.input.CategoriaReq;
import com.betacom.jpa.dto.output.CategoriaRes;

public interface ICategoriaService {

	void createCatgoria(CategoriaReq req) throws Exception;
	void deleteCategoria(Integer id) throws Exception;
	
	List<CategoriaRes> listCategoria() throws Exception;
}
