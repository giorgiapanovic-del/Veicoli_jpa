package com.betacom.jpa.mapper;

import java.util.List;
import com.betacom.jpa.dto.output.TipoSospensioneRes;
import com.betacom.jpa.models.TipoSospensione;

public class TipoSospensioneMap {

	public static List<TipoSospensioneRes> buildSospensioneResList(List<TipoSospensione> listSospensione) {
        return listSospensione.stream()
                .map(b -> buildSospensioneRes(b))
                .toList();
    }

    public static TipoSospensioneRes buildSospensioneRes(TipoSospensione sospensione) {
        return TipoSospensioneRes.builder()
                .id(sospensione.getId())
                .nome(sospensione.getNome())
                .build();
    }
}
