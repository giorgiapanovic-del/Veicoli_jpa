package com.betacom.jpa.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.jpa.dto.input.TipoSospensioneReq;
import com.betacom.jpa.dto.output.TipoSospensioneRes;
import com.betacom.jpa.exception.VeicoloException;
import com.betacom.jpa.mapper.TipoSospensioneMap;
import com.betacom.jpa.models.TipoSospensione;
import com.betacom.jpa.repositories.ITipoSospensioneRepository;
import com.betacom.jpa.services.interfaces.INotificaService;
import com.betacom.jpa.services.interfaces.ITipoSospensioneService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class TipoSospensioneImpl implements ITipoSospensioneService{

	@Autowired
	private final ITipoSospensioneRepository sospR;
	@Autowired
	private INotificaService notificaService;
	
	@Transactional
	public void createSospensione(TipoSospensioneReq req) throws Exception {
		log.debug("create {}", req);
		TipoSospensione sospensione = new TipoSospensione();
		sospensione.setId(req.getId());
		sospensione.setNome(req.getNome());
		
		sospR.save(sospensione);
		
	}
	
	@Transactional
	public void deleteSospensione(Integer id) throws Exception {
		log.debug("delete {}", id);
		TipoSospensione sospensione = sospR.findById(id)
				.orElseThrow(() -> new VeicoloException(notificaService.get("sos-id-ntfnd")));
		if (!sospensione.getVeicoli().isEmpty())
			new VeicoloException(notificaService.get("sos-id-inuse"));
		sospR.delete(sospensione);
	}

	
	public List<TipoSospensioneRes> listSospensione() throws Exception {
		log.debug("List: {}" );
		List<TipoSospensione> lC = sospR.findAll();
		
		return TipoSospensioneMap.buildSospensioneResList(lC);
	}
}
