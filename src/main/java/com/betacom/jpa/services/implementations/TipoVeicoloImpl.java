package com.betacom.jpa.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.jpa.dto.input.TipoVeicoloReq;
import com.betacom.jpa.dto.output.TipoVeicoloRes;
import com.betacom.jpa.exception.VeicoloException;
import com.betacom.jpa.mapper.TipoVeicoloMap;
import com.betacom.jpa.models.TipoVeicolo;
import com.betacom.jpa.repositories.ITipoVeicoloRepository;
import com.betacom.jpa.services.interfaces.INotificaService;
import com.betacom.jpa.services.interfaces.ITipoVeicoloService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class TipoVeicoloImpl implements ITipoVeicoloService{

	@Autowired
	private final ITipoVeicoloRepository tVeicoloR;
	@Autowired
	private INotificaService notificaService;
	
	@Transactional
	public void createVeicolo(TipoVeicoloReq req) throws Exception {
		log.debug("create {}", req);
		TipoVeicolo tveicolo = new TipoVeicolo();
		tveicolo.setId(req.getId());
		tveicolo.setNome(req.getNome());
		
		tVeicoloR.save(tveicolo);
		
	}
	
	@Transactional
	public void deleteVeicolo(Integer id) throws Exception {
		log.debug("delete {}", id);
		TipoVeicolo tveicolo = tVeicoloR.findById(id)
				.orElseThrow(() -> new VeicoloException(notificaService.get("tp-id-ntfnd")));
		if (!tveicolo.getVeicoli().isEmpty())
			new VeicoloException(notificaService.get("tp-id-inuse"));
		tVeicoloR.delete(tveicolo);
	}

	@Override
	public List<TipoVeicoloRes> listVeicolo() throws Exception {
		log.debug("List: {}" );
		List<TipoVeicolo> lC = tVeicoloR.findAll();
		
		return TipoVeicoloMap.buildVeicoloResList(lC);
	}

	
}
