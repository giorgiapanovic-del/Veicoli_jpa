package com.betacom.jpa.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.jpa.dto.input.CategoriaReq;
import com.betacom.jpa.dto.output.CategoriaRes;
import com.betacom.jpa.exception.VeicoloException;
import com.betacom.jpa.mapper.CategoriaMap;
import com.betacom.jpa.models.Categoria;
import com.betacom.jpa.repositories.ICategoriaRepository;
import com.betacom.jpa.services.interfaces.ICategoriaService;
import com.betacom.jpa.services.interfaces.INotificaService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class CategoriaImpl implements ICategoriaService{
	@Autowired
	private final ICategoriaRepository catR;
	@Autowired
	private INotificaService notificaService;
	
	@Transactional
	@Override
	public void createCatgoria(CategoriaReq req) throws Exception {
		log.debug("create {}", req);
		Categoria cat = new Categoria();
		cat.setId(req.getId());
		cat.setNome(req.getNome());
		
		catR.save(cat);
		
	}
	
	@Transactional
	@Override
	public void deleteCategoria(Integer id) throws Exception {
		log.debug("delete {}", id);
		Categoria cat = catR.findById(id)
				.orElseThrow(() -> new VeicoloException(notificaService.get("cat-id-ntfnd")));
		if (!cat.getVeicoli().isEmpty())
			new VeicoloException(notificaService.get("cat-id-inuse"));
		catR.delete(cat);
	}

	@Override
	public List<CategoriaRes> listCategoria() throws Exception {
		log.debug("List: {}" );
		List<Categoria> lC = catR.findAll();
		
		return CategoriaMap.buildCategoriaResList(lC);
	}


}
