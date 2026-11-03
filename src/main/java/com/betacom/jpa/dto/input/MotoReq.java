package com.betacom.jpa.dto.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MotoReq {

	@NotNull(groups = ValidationGroup.Update.class, message = "Manca l'id della moto")
    private Integer id;

    @NotNull(groups = ValidationGroup.Create.class, message = "Manca l'id veicolo")
    private Integer idVeicolo;

    @NotBlank(groups = ValidationGroup.Create.class, message = "Manca la targa")
    private String targa;

    @NotNull(groups = ValidationGroup.Create.class, message = "Manca il valore dei cc")
    @Positive(message = "Valore non valido di cc")
    private Integer cc;
}
