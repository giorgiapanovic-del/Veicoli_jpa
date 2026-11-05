package com.betacom.jpa.services.implementations;

import java.util.List;
import org.springframework.stereotype.Service;
import com.betacom.jpa.dto.input.TipoAlimentazioneReq;
import com.betacom.jpa.dto.output.TipoAlimentazioneRes;
import com.betacom.jpa.exception.VeicoloException;
import com.betacom.jpa.mapper.TipoAlimentazioneMap;
import com.betacom.jpa.models.TipoAlimentazione;
import com.betacom.jpa.repositories.ITipoAlimentazioneRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class TipoAlimentazioneImpl {

	private final ITipoAlimentazioneRepository alR;
	
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
				.orElseThrow(() -> new VeicoloException("key_ntfnd"));
		if (!alimentazione.getVeicoli().isEmpty())
			new VeicoloException("key_inuse");
		alR.delete(alimentazione);
	}

	
	public List<TipoAlimentazioneRes> listAlimentazione() throws Exception {
		log.debug("List: {}" );
		List<TipoAlimentazione> lC = alR.findAll();
		
		return TipoAlimentazioneMap.buildAlimentazioneResList(lC);
	}
}
