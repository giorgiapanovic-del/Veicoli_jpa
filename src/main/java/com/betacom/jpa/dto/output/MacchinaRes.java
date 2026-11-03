package com.betacom.jpa.dto.output;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MacchinaRes {
    
    private Integer id;
    private String targa;
    private Integer cc;
    private Integer numeroPorte;
    private Integer idVeicoli; // O eventuali dettagli del veicolo associato
}