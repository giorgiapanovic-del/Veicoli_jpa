package com.betacom.jpa.mapper;

import java.util.List;
import com.betacom.jpa.dto.output.TipoAlimentazioneRes;
import com.betacom.jpa.models.TipoAlimentazione;

public class TipoAlimentazioneMap {

	public static List<TipoAlimentazioneRes> buildAlimentazioneResList(List<TipoAlimentazione> listAlimentazione) {
        return listAlimentazione.stream()
                .map(b -> buildAlimentazioneRes(b))
                .toList();
    }

    public static TipoAlimentazioneRes buildAlimentazioneRes(TipoAlimentazione alimentazione) {
        return TipoAlimentazioneRes.builder()
                .id(alimentazione.getId())
                .nome(alimentazione.getNome())
                .build();
    }
}
