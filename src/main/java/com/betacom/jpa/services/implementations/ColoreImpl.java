package com.betacom.jpa.services.implementations;

import java.util.List;

import org.springframework.stereotype.Service;

import com.betacom.jpa.dto.input.ColoreReq;
import com.betacom.jpa.dto.output.ColoreRes;
import com.betacom.jpa.exception.VeicoloException;
import com.betacom.jpa.mapper.ColoreMap;
import com.betacom.jpa.models.Colore;
import com.betacom.jpa.repositories.IColoreRepository;
import com.betacom.jpa.services.interfaces.IColoreService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RequiredArgsConstructor
@Service
public class ColoreImpl implements  IColoreService{

	private final IColoreRepository colR;
	
	@Transactional
	@Override
	public void createColore(ColoreReq req) throws Exception {
		log.debug("create {}", req);
		Colore cat = new Colore();
		cat.setId(req.getId());
		cat.setNome(req.getNome());
		
		colR.save(cat);
		
	}
	
	@Transactional
	@Override
	public void deleteColore(Integer id) throws Exception {
		log.debug("delete {}", id);
		Colore cat = colR.findById(id)
				.orElseThrow(() -> new VeicoloException("key_ntfnd"));
		if (!cat.getVeicoli().isEmpty())
			new VeicoloException("key_inuse");
		colR.delete(cat);
	}

	@Override
	public List<ColoreRes> listColore() throws Exception {
		log.debug("List: {}" );
		List<Colore> lC = colR.findAll();
		
		return ColoreMap.buildColoreResList(lC);
	}
}
