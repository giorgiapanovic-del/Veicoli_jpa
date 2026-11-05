package com.betacom.jpa.mapper;

import java.util.List;
import com.betacom.jpa.dto.output.TipoVeicoloRes;
import com.betacom.jpa.models.TipoVeicolo;

public class TipoVeicoloMap {

	public static List<TipoVeicoloRes> buildVeicoloResList(List<TipoVeicolo> listVeicolo) {
        return listVeicolo.stream()
                .map(b -> buildVeicoloRes(b))
                .toList();
    }

    public static TipoVeicoloRes buildVeicoloRes(TipoVeicolo veicolo) {
        return TipoVeicoloRes.builder()
                .id(veicolo.getId())
                .nome(veicolo.getNome())
                .build();
    }
}