package com.betacom.jpa.services.implementations;

import java.util.List;

import org.springframework.stereotype.Service;

import com.betacom.jpa.dto.input.MacchinaReq;
import com.betacom.jpa.dto.output.MacchinaRes;
import com.betacom.jpa.exception.VeicoloException;
import com.betacom.jpa.mapper.MacchinaMap;
import com.betacom.jpa.models.Macchina;
import com.betacom.jpa.models.Veicoli;
import com.betacom.jpa.repositories.IMacchinaRepository;
import com.betacom.jpa.repositories.IVeicoliRepository;
import com.betacom.jpa.services.interfaces.IMacchinaService;
import com.betacom.jpa.services.interfaces.INotificaService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class MacchinaImpl implements IMacchinaService {

    private final IMacchinaRepository macchinaRepository;
    private final IVeicoliRepository veicoliRepository;
    private final INotificaService notificaService;

    @Transactional
    @Override
    public void createMacchina(MacchinaReq macchinaReq) throws Exception {

        log.debug("create {}", macchinaReq);

        Veicoli veicolo = veicoliRepository.findById(macchinaReq.getIdVeicoli())
                .orElseThrow(() -> new VeicoloException(notificaService.get("macchina-fnd")));

        Macchina macchina = new Macchina();

        macchina.setTarga(macchinaReq.getTarga());
        macchina.setCc(macchinaReq.getCc());
        macchina.setNumeroPorte(macchinaReq.getNumeroPorte());
        macchina.setVeicoli(veicolo);

        macchinaRepository.save(macchina);
    }

    @Transactional
    @Override
    public void updateMacchina(MacchinaReq macchinaReq) throws Exception {

        log.debug("update {}", macchinaReq);

        Macchina macchina = macchinaRepository.findById(macchinaReq.getId())
                .orElseThrow(() -> new VeicoloException(notificaService.get("macchina-ntfnd")));

        if (macchinaReq.getTarga() != null) macchina.setTarga(macchinaReq.getTarga());
        if (macchinaReq.getCc() != null) macchina.setCc(macchinaReq.getCc());
        if (macchinaReq.getNumeroPorte() != null) macchina.setNumeroPorte(macchinaReq.getNumeroPorte());

        if (macchinaReq.getIdVeicoli() != null) {
            Veicoli veicolo = veicoliRepository.findById(macchinaReq.getIdVeicoli())
                    .orElseThrow(() -> new VeicoloException(notificaService.get("macchina-fnd")));

            macchina.setVeicoli(veicolo);
        }

        macchinaRepository.save(macchina);
    }

    @Transactional
    @Override
    public void deleteMacchina(Integer macchinaID) throws Exception {

        log.debug("delete {}", macchinaID);

        Macchina macchina = macchinaRepository.findById(macchinaID)
                .orElseThrow(() -> new VeicoloException(notificaService.get("macchina-ntfnd")));

        macchinaRepository.delete(macchina);
    }

    @Override
    public List<MacchinaRes> listMacchina() throws Exception {

        List<Macchina> listMacchina = macchinaRepository.findAll();
        return MacchinaMap.buildMacchinaResList(listMacchina);
    }


	@Override
	public MacchinaRes getMacchinaById(Integer id) throws VeicoloException {
		log.debug("getMacchinaById () - id: {}", id);

	    Macchina macchina = macchinaRepository.findById(id)
	            .orElseThrow(() -> new VeicoloException(notificaService.get("macchina-ntfnd")));

	    return MacchinaMap.buildMacchinaRes(macchina);
	}
}