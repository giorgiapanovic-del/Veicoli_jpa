package com.betacom.jpa.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.jpa.dto.input.TipoAlimentazioneReq;
import com.betacom.jpa.dto.output.TipoAlimentazioneRes;
import com.betacom.jpa.exception.VeicoloException;
import com.betacom.jpa.mapper.TipoAlimentazioneMap;
import com.betacom.jpa.models.TipoAlimentazione;
import com.betacom.jpa.repositories.ITipoAlimentazioneRepository;
import com.betacom.jpa.services.interfaces.INotificaService;
import com.betacom.jpa.services.interfaces.ITipoAlimentazioneService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class TipoAlimentazioneImpl implements ITipoAlimentazioneService{

	@Autowired
	private final ITipoAlimentazioneRepository alR;
	@Autowired
	private INotificaService notificaService;
	
	@Transactional
	public void createAlimentazione(TipoAlimentazioneReq req) throws Exception {
		log.debug("create {}", req);
		TipoAlimentazione alimentazione = new TipoAlimentazione();
		alimentazione.setId(req.getId());
		alimentazione.setNome(req.getNome());
		
		alR.save(alimentazione);
		
	}
	
	@Transactional
	public void deleteAlimentazione(Integer id) throws Exception {
		log.debug("delete {}", id);
		TipoAlimentazione alimentazione = alR.findById(id)
				.orElseThrow(() -> new VeicoloException(notificaService.get("alim-id-ntfnd")));
		if (!alimentazione.getVeicoli().isEmpty())
			new VeicoloException(notificaService.get("alim-id-inuse"));
		alR.delete(alimentazione);
	}

	
	public List<TipoAlimentazioneRes> listAlimentazione() throws Exception {
		log.debug("List: {}" );
		List<TipoAlimentazione> lC = alR.findAll();
		
		return TipoAlimentazioneMap.buildAlimentazioneResList(lC);
	}
}
