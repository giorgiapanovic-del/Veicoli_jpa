package com.betacom.jpa.services.implementations;

import java.util.List;
import org.springframework.stereotype.Service;
import com.betacom.jpa.dto.input.TipoVeicoloReq;
import com.betacom.jpa.dto.output.TipoVeicoloRes;
import com.betacom.jpa.exception.VeicoloException;
import com.betacom.jpa.mapper.TipoVeicoloMap;
import com.betacom.jpa.models.TipoVeicolo;
import com.betacom.jpa.repositories.ITipoVeicoloRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class TipoVeicoloImpl {

private final ITipoVeicoloRepository tVeicoloR;
	
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
				.orElseThrow(() -> new VeicoloException("key_ntfnd"));
		if (!tveicolo.getVeicoli().isEmpty())
			new VeicoloException("key_inuse");
		tVeicoloR.delete(tveicolo);
	}

	
	public List<TipoVeicoloRes> listSospensione() throws Exception {
		log.debug("List: {}" );
		List<TipoVeicolo> lC = tVeicoloR.findAll();
		
		return TipoVeicoloMap.buildVeicoloResList(lC);
	}
}
