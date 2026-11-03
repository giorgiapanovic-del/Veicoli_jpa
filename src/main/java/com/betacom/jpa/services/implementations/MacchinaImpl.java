package com.betacom.jpa.services.implementations;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
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

@Service
public class MacchinaImpl implements IMacchinaService {

    @Autowired
    private IMacchinaRepository macchinaRepository;

    @Autowired
    private IVeicoliRepository veicoliRepository;

    
    public List<MacchinaRes> getAllMacchine() {
        List<Macchina> macchine = macchinaRepository.findAll();
        // Sfruttiamo il mapper pulito fuori dall'implementazione
        return macchine.stream()
                .map(MacchinaMap::toMacchinaRes)
                .collect(Collectors.toList());
    }

    
    public MacchinaRes getMacchinaById(Integer id) throws VeicoloException {
//        Macchina macchina = macchinaRepository.findById(id)
//                .orElseThrow(() -> new VeicoloException("Macchina non trovata con ID: " + id));
//        
//        return MacchinaMap.toMacchinaRes(macchina);
    	return null;
    }

    public void createMacchina(MacchinaReq request) throws VeicoloException {
//        Veicoli veicolo = veicoliRepository.findById(request.getIdVeicoli())
//                .orElseThrow(() -> new VeicoloException("Veicolo padre non trovato con ID: " + request.getIdVeicoli()));

        Macchina macchina = new Macchina();
        macchina.setTarga(request.getTarga());
        macchina.setCc(request.getCc());
        macchina.setNumeroPorte(request.getNumeroPorte());
//        macchina.setVeicoli(veicolo);

        macchinaRepository.save(macchina);
    }

    
    public void updateMacchina(MacchinaReq request) throws VeicoloException {
        if (request.getId() == null) {
            throw new VeicoloException("L'ID della macchina è obbligatorio per l'aggiornamento");
        }
        
        Macchina macchina = macchinaRepository.findById(request.getId())
                .orElseThrow(() -> new VeicoloException("Macchina non trovata per l'aggiornamento"));

//        Veicoli veicolo = veicoliRepository.findById(request.getIdVeicoli())
//                .orElseThrow(() -> new VeicoloException("Veicolo padre non trovato con ID: " + request.getIdVeicoli()));

        macchina.setTarga(request.getTarga());
        macchina.setCc(request.getCc());
        macchina.setNumeroPorte(request.getNumeroPorte());
//        macchina.setVeicoli(veicolo);

        macchinaRepository.save(macchina);
    }

    
    public void deleteMacchina(Integer id) throws VeicoloException {
        if (!macchinaRepository.existsById(id)) {
            throw new VeicoloException("Impossibile eliminare: Macchina non trovata con ID: " + id);
        }
        macchinaRepository.deleteById(id);
    }
}