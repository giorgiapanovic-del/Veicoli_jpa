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
public class VeicoliRes {

	private Integer id;
    private String tipoVeicolo;        
    private Integer numeroRuote;
    private String tipoAlimentazione;  
    private String categoria;          
    private String colore;             
    private String marca;              
    private Integer annoProduzione;
    private String modello;
}
