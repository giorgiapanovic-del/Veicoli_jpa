package com.betacom.jpa.dto.output;

import java.util.List;

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
public class TipoSospensioneRes {

	private Integer id_tipo_sospensione;
    private String nome;
    private List<BiciRes> veicoli;
}
