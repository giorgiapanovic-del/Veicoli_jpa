package com.betacom.jpa.services.implementations;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.betacom.jpa.dto.input.BiciReq;
import com.betacom.jpa.dto.output.BiciRes;
import com.betacom.jpa.exception.VeicoloException;
import com.betacom.jpa.mapper.BiciMap;
import com.betacom.jpa.models.Bici;
import com.betacom.jpa.repositories.IBiciRepository;
import com.betacom.jpa.services.interfaces.IBiciService;
import com.betacom.jpa.services.interfaces.INotificaService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class BiciImpl implements IBiciService{
	
	private final IBiciRepository biciRepository;
	private final INotificaService notificaService;
	
	@Transactional
	@Override
	public void createBici(BiciReq biciReq) throws Exception {
		
		log.debug("create ()", biciReq);
//		if (biciRepository.existsByCodiceFiscale(biciReq.getCodiceFiscale()))
//			throw new VeicoloException(notificaService.get("cffisc-fnd"));
		
		Bici bici = new Bici();
		bici.setNumeroCorone(biciReq.getNumeroCorone());
		bici.setNumeroMarce(biciReq.getNumeroMarce());
		bici.setPieghevole(biciReq.getPieghevole());
		bici.setTipoFreno(biciReq.getTipoFreno());
//		bici.setTipoSospensione(biciReq.getTipoSospensione());
//		bici.setVeicoli(biciReq.getVeicoli());
		biciRepository.save(bici);
		
	}

	@Transactional
	@Override
	public void updateBici(BiciReq biciReq) throws Exception {
		
		log.debug("update {}", biciReq);
//		Bici bici = biciRepository.findById(biciReq.getId());
//				.orElseThrow(() -> new VeicoloException(msgS.get("bici-ntfnd")));			
//		
//		if (bici.getPieghevole() != null) bici.setPieghevole(biciReq.getPieghevole());
//		if (bici.getNumeroCorone() != null) bici.setNumeroCorone(biciReq.getNumeroCorone());		
//		if (bici.getNumeroMarce() != null) bici.setNumeroMarce(biciReq.getNumeroMarce());
//		if (bici.getTipoFreno() != null) bici.setTipoFreno(biciReq.getTipoFreno());
//		if (bici.getTipoSospensione() != null) bici.setTipoSospensione(biciReq.getTipoSospensione());
//		if (bici.getVeicoli() != null) bici.setVeicoli(biciReq.getVeicoli());
//		biciRepository.save(bici);
		
	}

	@Transactional
	@Override
	public void deleteBici(Integer biciID) throws Exception {
		log.debug("delete {}", biciID);
		Bici bici = biciRepository.findById(biciID)
				.orElseThrow(() -> new VeicoloException("bici-ntfnd"));
		
		biciRepository.delete(bici);
		
	}

	@Override
	public List<BiciRes> listBici() throws Exception {
		List<Bici> listBici = biciRepository.findAll();
		return BiciMap.buildBiciResList(listBici);		
	}

}
