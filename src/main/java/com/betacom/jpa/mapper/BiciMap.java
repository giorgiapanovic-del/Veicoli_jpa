package com.betacom.jpa.mapper;

import java.util.List;


import com.betacom.jpa.dto.output.BiciRes;
import com.betacom.jpa.models.Bici;


public class BiciMap {

	 public static List<BiciRes> buildBiciResList(List<Bici> listBici) {
	        return listBici.stream()
	                .map(b -> buildBiciRes(b))
	                .toList();
	    }

	    public static BiciRes buildBiciRes(Bici bici) {
	        return BiciRes.builder()
	                .id(bici.getId())
	                .numeroCorone(bici.getNumeroCorone())
	                .numeroMarce(bici.getNumeroMarce())
	                .tipoFreno(bici.getTipoFreno())
	                .tipoSospensione(bici.getTipoSospensione() != null
			                ? bici.getTipoSospensione().toString()
			                : null)
	                .pieghevole(bici.getPieghevole())
	                .idVeicolo(bici.getVeicoli() != null
			                ? bici.getVeicoli().getId()
			                : null)
	                .build();
	    }
}
