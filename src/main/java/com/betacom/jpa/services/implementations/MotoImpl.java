package com.betacom.jpa.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.jpa.dto.input.MotoReq;
import com.betacom.jpa.dto.output.MotoRes;
import com.betacom.jpa.exception.VeicoloException;
import com.betacom.jpa.mapper.MotoMap;
import com.betacom.jpa.models.Moto;
import com.betacom.jpa.models.Veicoli;
import com.betacom.jpa.repositories.IMotoRepository;
import com.betacom.jpa.repositories.IVeicoliRepository;
import com.betacom.jpa.services.interfaces.IMotoService;
import com.betacom.jpa.services.interfaces.INotificaService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class MotoImpl implements IMotoService{
	
	@Autowired
	private final IMotoRepository motoRepository;
	@Autowired
	private final INotificaService notificaService;
	@Autowired
	private final IVeicoliRepository veicoliRepository;
	 
	@Transactional
	@Override
	public void createMoto(MotoReq motoReq) throws Exception {
		log.debug("create ()", motoReq);

		Veicoli veicolo = veicoliRepository.findById(motoReq.getIdVeicolo())
              .orElseThrow(() -> new VeicoloException(notificaService.get("moto-ntfnd")));
		Moto moto = new Moto();		
		moto.setCc(motoReq.getCc());
		moto.setTarga(motoReq.getTarga());
		moto.setVeicoli(veicolo);
		motoRepository.save(moto);
		
	}

	@Transactional
    @Override
    public void updateMoto(MotoReq motoReq) throws Exception {
        log.debug("update {}", motoReq);

        Moto moto = motoRepository.findById(motoReq.getId())
                .orElseThrow(() -> new VeicoloException(notificaService.get("moto-ntfnd")));

        if (motoReq.getCc() != null) moto.setCc(motoReq.getCc());
        if (motoReq.getTarga() != null) moto.setTarga(motoReq.getTarga());
        if (motoReq.getIdVeicolo() != null) {
            Veicoli veicolo = veicoliRepository.findById(motoReq.getIdVeicolo())
                    .orElseThrow(() -> new VeicoloException(notificaService.get("moto-ntfnd")));
            moto.setVeicoli(veicolo);
        }
        motoRepository.save(moto);
    }

	@Transactional
	@Override
	public void deleteMoto(Integer motoID) throws Exception {
		log.debug("delete {}", motoID);
		Moto moto = motoRepository.findById(motoID)
				.orElseThrow(() -> new VeicoloException(notificaService.get("moto-ntfnd")));
		
		motoRepository.delete(moto);
		
	}

	@Transactional
	@Override
	public List<MotoRes> listMoto() throws Exception {
		List<Moto> listMoto = motoRepository.findAll();
		return MotoMap.buildMotoResList(listMoto);
	}
	
	@Transactional
	@Override
	public MotoRes findById(Integer motoID) throws Exception {
		log.debug("findById () - id: {}", motoID);
		
		Moto moto = motoRepository.findById(motoID)
				.orElseThrow(() -> new VeicoloException("moto-ntfnd"));
		
		return MotoMap.buildMotoRes(moto);
	}

	@Override
	public List<MotoRes> listFiltri(Integer id, String targa, Integer cc) throws Exception {
		log.debug("list :{} / {} / {} / {}", id, targa, cc);
		List<Moto> lS = motoRepository.searchByFilter(id, targa, cc);
		return MotoMap.buildMotoResList(lS);

	}

}
