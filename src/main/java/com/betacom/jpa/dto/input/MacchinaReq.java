package com.betacom.jpa.dto.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MacchinaReq {
    
    private Integer id;

    @NotNull(message = "L'ID del veicolo è obbligatorio")
    private Integer idVeicoli;

    @NotBlank(message = "La targa non può essere vuota o null")
    private String targa;

    @NotNull(message = "La cilindrata (cc) è obbligatoria")
    private Integer cc;

    @NotNull(message = "Il numero di porte è obbligatorio")
    private Integer numeroPorte;
}