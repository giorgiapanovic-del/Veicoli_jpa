package com.betacom.jpa.dto.output;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BiciRes {
	
	private Integer id;
	private Integer idVeicolo;
	private Integer numeroCorone;
	private Integer numeroMarce;
	private String tipoFreno; 
	private String tipoSospensione; 
	private Boolean pieghevole;
}
