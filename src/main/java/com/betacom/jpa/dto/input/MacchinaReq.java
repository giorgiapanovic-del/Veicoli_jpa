package com.betacom.jpa.dto.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MacchinaReq extends VeicoliReq{
    
	@NotNull(groups = ValidationGroup.Update.class, message = "Manca id macchina")
    private Integer id;

    @NotNull(groups = ValidationGroup.Create.class, message = "Manca id veicolo")
    private Integer idVeicoli;

    @NotBlank(groups = ValidationGroup.Create.class, message = "La targa è obbligatoria")
    private String targa;

    @NotNull(groups = ValidationGroup.Create.class, message = "Manca la cilindrata")
    @Positive(message = "La cilindrata non è valida")
    private Integer cc;

    @NotNull(groups = ValidationGroup.Create.class, message = "Manca il numero di porte")
    @Positive(message = "Il numero di porte non è valido")
    private Integer numeroPorte;
}