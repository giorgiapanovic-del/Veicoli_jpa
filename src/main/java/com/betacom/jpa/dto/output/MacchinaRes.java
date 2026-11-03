package com.betacom.jpa.dto.output;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MacchinaRes {
    
    private Integer id;
    private String targa;
    private Integer cc;
    private Integer numeroPorte;
    private Integer idVeicoli; // O eventuali dettagli del veicolo associato
}