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
public class VeicoliReq {

	@NotNull(groups = ValidationGroup.Update.class, message = "Manca l'id del veicolo")
    private Integer id;

    @NotNull(groups = ValidationGroup.Create.class, message = "Manca il tipo veicolo")
    private Integer idTipoVeicolo;

    @NotNull(groups = ValidationGroup.Create.class, message = "Manca il numero di ruote")
    @Positive(message = "Il numero di ruote non è valido")
    private Integer numeroRuote;

    @NotNull(groups = ValidationGroup.Create.class, message = "Manca il tipo alimentazione")
    private Integer idTipoAlimentazione;

    @NotNull(groups = ValidationGroup.Create.class, message = "Manca la categoria")
    private Integer idCategoria;

    @NotNull(groups = ValidationGroup.Create.class, message = "Manca il colore")
    private Integer idColore;

    @NotNull(groups = ValidationGroup.Create.class, message = "Manca la marca")
    private Integer idMarca;

    @NotNull(groups = ValidationGroup.Create.class, message = "Manca l'anno di produzione")
    @Positive(message = "L'anno di produzione non è valido")
    private Integer annoProduzione;

    @NotBlank(groups = ValidationGroup.Create.class, message = "Manca il modello")
    private String modello;
}
