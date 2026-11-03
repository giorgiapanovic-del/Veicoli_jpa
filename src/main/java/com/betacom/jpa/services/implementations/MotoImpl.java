package com.betacom.jpa.services.implementations;

import java.util.List;

import org.springframework.stereotype.Service;

import com.betacom.jpa.dto.input.MotoReq;
import com.betacom.jpa.dto.output.MotoRes;
import com.betacom.jpa.exception.VeicoloException;
import com.betacom.jpa.models.Bici;
import com.betacom.jpa.models.Moto;
import com.betacom.jpa.repositories.IBiciRepository;
import com.betacom.jpa.repositories.IMotoRepository;
import com.betacom.jpa.services.interfaces.IMotoService;
import com.betacom.jpa.services.interfaces.INotificaService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class MotoImpl implements IMotoService{
	
	private final IMotoRepository motoRepository;
	private final INotificaService notificaService;
	
	@Transactional
	@Override
	public void createMoto(MotoReq motoReq) throws Exception {
		log.debug("create ()", motoReq);
//		if (biciRepository.existsByCodiceFiscale(req.getCodiceFiscale()))
//			throw new VeicoloException(msgS.get("cffisc-fnd"));
		
//		Moto moto = new Moto();
//		moto.setNumeroCorone(motoReq.getNumeroCorone());
//		moto.setNumeroMarce(motoReq.getNumeroMarce());
//		moto.setPieghevole(motoReq.getPieghevole());
//		moto.setTipoFreno(motoReq.getTipoFreno());
//		moto.setTipoSospensione(motoReq.getTipoSospensione());
//		moto.setVeicoli(motoReq.getVeicoli());
//		motoRepository.save(moto);
		
	}

	@Transactional
	@Override
	public void updateMoto(MotoReq motoReq) throws Exception {
//		log.debug("update {}", motoReq);
//		Moto moto = motoRepository.findById(motoReq.getId());
////				.orElseThrow(() -> new VeicoloException(msgS.get("moto-ntfnd")));			
//		
//		if (moto.getCc() != null) moto.setCc(motoReq.getPieghevole());
//		if (moto.getTarga() != null) moto.setTarga(motoReq.getTarga());		
//		if (moto.getVeicoli() != null) moto.setVeicoli(motoReq.getVeicoli());
//		motoRepository.save(moto);
		
		
	}

	@Transactional
	@Override
	public void deleteMoto(Integer motoID) throws Exception {
//		log.debug("delete {}", motoID);
//		Moto moto = motoRepository.findById(motoID)
//				.orElseThrow(() -> new VeicoloException("moto-ntfnd"));
//		
//		motoRepository.delete(moto);
		
	}

	@Transactional
	@Override
	public List<MotoRes> listMoto() throws Exception {
//		List<Moto> listMoto = motoRepository.findAll();
//		return MotoMap.buildMotoDTO(listMoto);
		return null;
	}

}
