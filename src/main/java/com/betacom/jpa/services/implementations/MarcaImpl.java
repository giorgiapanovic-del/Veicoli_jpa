package com.betacom.jpa.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.jpa.dto.input.MarcaReq;
import com.betacom.jpa.dto.output.MarcaRes;
import com.betacom.jpa.exception.VeicoloException;
import com.betacom.jpa.mapper.MarcaMap;
import com.betacom.jpa.models.Marca;
import com.betacom.jpa.repositories.IMarcaRepository;
import com.betacom.jpa.services.interfaces.IMarcaService;
import com.betacom.jpa.services.interfaces.INotificaService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class MarcaImpl implements IMarcaService{

	@Autowired
	private final IMarcaRepository marcaR;
	@Autowired
	private INotificaService notificaService;
	
	@Transactional
	public void createMarca(MarcaReq req) throws Exception {
		log.debug("create {}", req);
		Marca marca = new Marca();
		marca.setId(req.getId());
		marca.setNome(req.getNome());
		
		marcaR.save(marca);
		
	}
	
	@Transactional
	public void deleteMarca(Integer id) throws Exception {
		log.debug("delete {}", id);
		Marca marca = marcaR.findById(id)
				.orElseThrow(() -> new VeicoloException(notificaService.get("marca-id-ntfnd")));
		if (!marca.getVeicoli().isEmpty())
			new VeicoloException(notificaService.get("marca-id-inuse"));
		marcaR.delete(marca);
	}

	public List<MarcaRes> listMarca() throws Exception {
		log.debug("List: {}" );
		List<Marca> marca = marcaR.findAll();
		
		return MarcaMap.buildMarcaResList(marca);
	}
}
