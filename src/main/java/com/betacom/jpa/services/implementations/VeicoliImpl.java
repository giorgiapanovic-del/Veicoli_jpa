package com.betacom.jpa.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.jpa.dto.input.VeicoliReq;
import com.betacom.jpa.dto.output.VeicoliRes;
import com.betacom.jpa.exception.VeicoloException;
import com.betacom.jpa.mapper.VeicoliMap;
import com.betacom.jpa.models.Veicoli;
import com.betacom.jpa.repositories.ICategoriaRepository;
import com.betacom.jpa.repositories.IColoreRepository;
import com.betacom.jpa.repositories.IMarcaRepository;
import com.betacom.jpa.repositories.ITipoAlimentazioneRepository;
import com.betacom.jpa.repositories.ITipoVeicoloRepository;
import com.betacom.jpa.repositories.IVeicoliRepository;
import com.betacom.jpa.services.interfaces.INotificaService;
import com.betacom.jpa.services.interfaces.IVeicoliService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class VeicoliImpl implements IVeicoliService {

	@Autowired
	private IVeicoliRepository veicoliRepository;
	
	@Autowired
	private  ITipoVeicoloRepository tipoVeicoloRepository;
	
	@Autowired
	private ITipoAlimentazioneRepository tipoAlimentazioneRepository;
	
	@Autowired
	private ICategoriaRepository categoriaRepository;
	
	@Autowired
	private IColoreRepository coloreRepository;
	
	@Autowired
	private IMarcaRepository marcaRepository;
	
	@Autowired
	private INotificaService notificaService;
	
	@Transactional
	@Override
	public void createVeicoli(VeicoliReq veicoliReq) throws Exception {
		log.debug("createVeicoli () - {}", veicoliReq);
		
		Veicoli veicolo = new Veicoli();
		veicolo.setNumeroRuote(veicoliReq.getNumeroRuote());
		veicolo.setAnnoProduzione(veicoliReq.getAnnoProduzione());
		veicolo.setModello(veicoliReq.getModello());
		
		if (veicoliReq.getIdTipoVeicolo() != null) {
			veicolo.setTipoVeicolo(tipoVeicoloRepository.findById(veicoliReq.getIdTipoVeicolo())
					.orElseThrow(() -> new VeicoloException(notificaService.get("veic-ntfnd"))));
		}
		if (veicoliReq.getIdTipoAlimentazione() != null) {
			veicolo.setTipoAlimentazione(tipoAlimentazioneRepository.findById(veicoliReq.getIdTipoAlimentazione())
					.orElseThrow(() -> new VeicoloException(notificaService.get("alim-ntfnd"))));
		}
		if (veicoliReq.getIdCategoria() != null) {
			veicolo.setCategoria(categoriaRepository.findById(veicoliReq.getIdCategoria())
					.orElseThrow(() -> new VeicoloException(notificaService.get("cat-ntfnd"))));
		}
		if (veicoliReq.getIdColore() != null) {
			veicolo.setColore(coloreRepository.findById(veicoliReq.getIdColore())
					.orElseThrow(() -> new VeicoloException(notificaService.get("col-ntfnd"))));
		}
		if (veicoliReq.getIdMarca() != null) {
			veicolo.setMarca(marcaRepository.findById(veicoliReq.getIdMarca())
					.orElseThrow(() -> new VeicoloException(notificaService.get("marca-ntfnd"))));
		}
		
		veicoliRepository.save(veicolo);
	}

	@Transactional
	@Override
	public void updateVeicoli(VeicoliReq veicoliReq) throws Exception {
		log.debug("updateVeicoli () - {}", veicoliReq);
		
		Veicoli veicolo = veicoliRepository.findById(veicoliReq.getId())
				.orElseThrow(() -> new VeicoloException(notificaService.get("veic-ntfnd")));			
		
		if (veicoliReq.getNumeroRuote() != null) veicolo.setNumeroRuote(veicoliReq.getNumeroRuote());
		if (veicoliReq.getAnnoProduzione() != null) veicolo.setAnnoProduzione(veicoliReq.getAnnoProduzione());
		if (veicoliReq.getModello() != null) veicolo.setModello(veicoliReq.getModello());
		
		if (veicoliReq.getIdTipoVeicolo() != null) {
			veicolo.setTipoVeicolo(tipoVeicoloRepository.findById(veicoliReq.getIdTipoVeicolo())
					.orElseThrow(() -> new VeicoloException(notificaService.get("tp-id-ntfnd"))));
		}
		if (veicoliReq.getIdTipoAlimentazione() != null) {
			veicolo.setTipoAlimentazione(tipoAlimentazioneRepository.findById(veicoliReq.getIdTipoAlimentazione())
					.orElseThrow(() -> new VeicoloException(notificaService.get("alim-ntfnd"))));
		}
		if (veicoliReq.getIdCategoria() != null) {
			veicolo.setCategoria(categoriaRepository.findById(veicoliReq.getIdCategoria())
					.orElseThrow(() -> new VeicoloException(notificaService.get("cat-ntfnd"))));
		}
		if (veicoliReq.getIdColore() != null) {
			veicolo.setColore(coloreRepository.findById(veicoliReq.getIdColore())
					.orElseThrow(() -> new VeicoloException(notificaService.get("col-ntfnd"))));
		}
		if (veicoliReq.getIdMarca() != null) {
			veicolo.setMarca(marcaRepository.findById(veicoliReq.getIdMarca())
					.orElseThrow(() -> new VeicoloException(notificaService.get("marca-ntfnd"))));
		}
		
		veicoliRepository.save(veicolo);
	}

	@Transactional
	@Override
	public void deleteVeicoli(Integer veicoloID) throws Exception {
		log.debug("deleteVeicoli () - id: {}", veicoloID);
		
		Veicoli veicolo = veicoliRepository.findById(veicoloID)
				.orElseThrow(() -> new VeicoloException(notificaService.get("veic-ntfnd")));
		
		veicoliRepository.delete(veicolo);
	}

	@Transactional
	@Override
	public List<VeicoliRes> listVeicoli() throws Exception {
		log.debug("listVeicoli ()");
		
		List<Veicoli> listVeicoli = veicoliRepository.findAll();
		return VeicoliMap.buildVeicoliResList(listVeicoli);
	}

	@Transactional
	@Override
	public VeicoliRes findById(Integer id) throws Exception {
		log.debug("findById () - id: {}", id);
		
		Veicoli veicolo = veicoliRepository.findById(id)
				.orElseThrow(() -> new VeicoloException(notificaService.get("veic-ntfnd")));
		
		return VeicoliMap.buildVeicoliRes(veicolo);
	}

	@Override
	public List<VeicoliRes> listFiltri(Integer id, Integer idTipoVeicolo, Integer numeroRuote,
			String idTipoAlimentazione, String idCategoria, Integer idColore, Integer idMarca, Integer annoProduzione,
			String modello) throws Exception {
		log.debug("list :{} / {} / {} / {}",  id,  idTipoVeicolo,  numeroRuote,  idTipoAlimentazione,  idCategoria,  idColore,  idMarca,  annoProduzione,  modello);
		List<Veicoli> lS = veicoliRepository.searchByFilter(id,  idTipoVeicolo,  numeroRuote,  idTipoAlimentazione,  idCategoria,  idColore,  idMarca,  annoProduzione,  modello);
		return VeicoliMap.buildVeicoliResList(lS);
	}
}