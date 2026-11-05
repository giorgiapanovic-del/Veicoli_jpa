package com.betacom.jpa.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.betacom.jpa.dto.input.BiciReq;
import com.betacom.jpa.dto.output.BiciRes;
import com.betacom.jpa.exception.VeicoloException;
import com.betacom.jpa.mapper.BiciMap;
import com.betacom.jpa.models.Bici;
import com.betacom.jpa.models.Veicoli;
import com.betacom.jpa.repositories.IBiciRepository;
import com.betacom.jpa.repositories.IVeicoliRepository;
import com.betacom.jpa.services.interfaces.IBiciService;
import com.betacom.jpa.services.interfaces.INotificaService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class BiciImpl implements IBiciService{
	
	@Autowired
	private final IBiciRepository biciRepository;
	@Autowired
	private final INotificaService notificaService;
	@Autowired
	private final IVeicoliRepository veicoliRepository;
	
	@Transactional
    @Override
    public void createBici(BiciReq biciReq) throws Exception {

        log.debug("create {}", biciReq);

        Veicoli veicolo = veicoliRepository.findById(biciReq.getIdVeicolo())
                .orElseThrow(() -> new VeicoloException(notificaService.get("bici-ntfnd")));

        Bici bici = new Bici();

        bici.setNumeroCorone(biciReq.getNumeroCorone());
        bici.setNumeroMarce(biciReq.getNumeroMarce());
        bici.setPieghevole(biciReq.getPieghevole());
        bici.setTipoFreno(biciReq.getTipoFreno());
        bici.setTipoSospensione(biciReq.getTipoSospensione());
        bici.setVeicoli(veicolo);

        biciRepository.save(bici);
    }

	@Transactional
    @Override
    public void updateBici(BiciReq biciReq) throws Exception {

        log.debug("update {}", biciReq);

        Bici bici = biciRepository.findById(biciReq.getId())
                .orElseThrow(() -> new VeicoloException(notificaService.get("bici-ntfnd")));

        if (biciReq.getPieghevole() != null) bici.setPieghevole(biciReq.getPieghevole());
        if (biciReq.getNumeroCorone() != null) bici.setNumeroCorone(biciReq.getNumeroCorone());
        if (biciReq.getNumeroMarce() != null) bici.setNumeroMarce(biciReq.getNumeroMarce());
        if (biciReq.getTipoFreno() != null) bici.setTipoFreno(biciReq.getTipoFreno());
        if (biciReq.getTipoSospensione() != null) bici.setTipoSospensione(biciReq.getTipoSospensione());
        if (biciReq.getIdVeicolo() != null) {
            Veicoli veicolo = veicoliRepository.findById(biciReq.getIdVeicolo())
                    .orElseThrow(() -> new VeicoloException(notificaService.get("bici-ntfnd")));
            bici.setVeicoli(veicolo);
        }
        biciRepository.save(bici);
    }

	@Transactional
	@Override
	public void deleteBici(Integer biciID) throws Exception {
		log.debug("delete {}", biciID);
		Bici bici = biciRepository.findById(biciID)
				.orElseThrow(() -> new VeicoloException(notificaService.get("bici-ntfnd")));
		
		biciRepository.delete(bici);
		
	}

	@Override
	public List<BiciRes> listBici() throws Exception {
		List<Bici> listBici = biciRepository.findAll();
		return BiciMap.buildBiciResList(listBici);		
	}
	
	@Transactional
	@Override
	public BiciRes findById(Integer biciID) throws Exception {
		log.debug("findById () - id: {}", biciID);
		
		Bici bici = biciRepository.findById(biciID)
				.orElseThrow(() -> new VeicoloException(notificaService.get("bici-ntfnd")));
		
		return BiciMap.buildBiciRes(bici);
	}

	@Override
	public List<BiciRes> listFiltri(Integer id, Integer numeroCorone, Integer numeroMarce, String tipoFreno,
			Integer idTipoSospensione, Boolean pieghevole) throws Exception {
		log.debug("list :{} / {} / {} / {}", id, numeroCorone, numeroMarce, tipoFreno, idTipoSospensione, pieghevole);
		List<Bici> lS = biciRepository.searchByFilter(id, numeroCorone, numeroMarce, tipoFreno, idTipoSospensione, pieghevole);
		return BiciMap.buildBiciResList(lS);
	}

}
