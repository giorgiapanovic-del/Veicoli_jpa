package com.betacom.jpa.mapper;

import java.util.List;

import com.betacom.jpa.dto.output.VeicoliRes;
import com.betacom.jpa.models.Veicoli;

public class VeicoliMap {

	public static List<VeicoliRes> buildVeicoliResList(List<Veicoli> listV) {
		if (listV == null) {
			return null;
		}
		return listV.stream()
				.map(s -> buildVeicoliRes(s)
				).toList();
	}

	public static VeicoliRes buildVeicoliRes(Veicoli v) {
		if (v == null) {
			return null;
		}
		
		return VeicoliRes.builder()
				.id(v.getId())
				.tipoVeicolo(v.getTipoVeicolo() != null ? v.getTipoVeicolo().getNome() : null) 
				.numeroRuote(v.getNumeroRuote())
				.tipoAlimentazione(v.getTipoAlimentazione() != null ? v.getTipoAlimentazione().getNome() : null) 
				.categoria(v.getCategoria() != null ? v.getCategoria().getNome() : null) 
				.colore(v.getColore() != null ? v.getColore().getNome() : null) 
				.marca(v.getMarca() != null ? v.getMarca().getNome() : null)
				.annoProduzione(v.getAnnoProduzione())
				.modello(v.getModello())
				.build();
	}
}
