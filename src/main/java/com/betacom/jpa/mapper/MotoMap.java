package com.betacom.jpa.mapper;

import java.util.List;

import com.betacom.jpa.dto.output.BiciRes;
import com.betacom.jpa.dto.output.MotoRes;
import com.betacom.jpa.models.Bici;
import com.betacom.jpa.models.Moto;

public class MotoMap {

	 public static List<MotoRes> buildMotoResList(List<Moto> listMoto) {
	        return listMoto.stream()
	                .map(m -> buildMotoRes(m))
	                .toList();
	    }

	    public static MotoRes buildMotoRes(Moto moto) {
	        return MotoRes.builder()
	                .id(moto.getId())
	                .targa(moto.getTarga())
	                .cc(moto.getCc())
	                .idVeicolo(moto.getVeicoli() != null
			                ? moto.getVeicoli().getId()
			                : null)
	                .build();
	    }
}
