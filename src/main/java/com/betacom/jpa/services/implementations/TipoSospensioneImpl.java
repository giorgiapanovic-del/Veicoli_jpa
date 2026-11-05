package com.betacom.jpa.services.implementations;

import java.util.List;
import org.springframework.stereotype.Service;
import com.betacom.jpa.dto.input.TipoSospensioneReq;
import com.betacom.jpa.dto.output.TipoSospensioneRes;
import com.betacom.jpa.exception.VeicoloException;
import com.betacom.jpa.mapper.TipoSospensioneMap;
import com.betacom.jpa.models.TipoSospensione;
import com.betacom.jpa.repositories.ITipoSospensioneRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class TipoSospensioneImpl {

	private final ITipoSospensioneRepository sospR;
	
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
				.orElseThrow(() -> new VeicoloException("key_ntfnd"));
		if (!sospensione.getVeicoli().isEmpty())
			new VeicoloException("key_inuse");
		sospR.delete(sospensione);
	}

	
	public List<TipoSospensioneRes> listSospensione() throws Exception {
		log.debug("List: {}" );
		List<TipoSospensione> lC = sospR.findAll();
		
		return TipoSospensioneMap.buildSospensioneResList(lC);
	}
}
