package com.betacom.jpa.mapper;

import com.betacom.jpa.dto.output.MacchinaRes;
import com.betacom.jpa.models.Macchina;

public class MacchinaMap {

    // Converte l'Entity Macchina nel DTO di Response
    public static MacchinaRes toMacchinaRes(Macchina macchina) {
        if (macchina == null) {
            return null;
        }

        MacchinaRes res = new MacchinaRes();
        res.setId(macchina.getId());
        res.setTarga(macchina.getTarga());
        res.setCc(macchina.getCc());
        res.setNumeroPorte(macchina.getNumeroPorte());
        
        if (macchina.getVeicoli() != null) {
            res.setIdVeicoli(macchina.getVeicoli().getId());
        }

        return res;
    }
}