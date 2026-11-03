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
public class TipoAlimentazioneRes {

	private Integer id_tipo_alimentazione;
    private String nome;
    private List<VeicoliRes> veicoli;
}
