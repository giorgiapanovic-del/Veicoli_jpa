
package com.betacom.jpa.mapper;

import java.util.List;

import com.betacom.jpa.dto.output.MacchinaRes;
import com.betacom.jpa.models.Macchina;

public class MacchinaMap {

    public static List<MacchinaRes> buildMacchinaResList(List<Macchina> listMacchina) {
        return listMacchina.stream()
                .map(m -> buildMacchinaRes(m))
                .toList();
    }

    public static MacchinaRes buildMacchinaRes(Macchina macchina) {
        return MacchinaRes.builder()
                .id(macchina.getId())
                .targa(macchina.getTarga())
                .cc(macchina.getCc())
                .numeroPorte(macchina.getNumeroPorte())
                .idVeicoli(macchina.getVeicoli() != null
                        ? macchina.getVeicoli().getId()
                        : null)
                .build();
    }
}
