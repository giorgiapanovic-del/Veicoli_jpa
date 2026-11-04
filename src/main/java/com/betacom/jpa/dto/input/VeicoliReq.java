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

	@NotNull(groups = ValidationGroup.Update.class, message = "veic-no-id")
    private Integer id;

    @NotNull(groups = ValidationGroup.Create.class, message = "tpveic-no-id")
    private Integer idTipoVeicolo;

    @NotNull(groups = ValidationGroup.Create.class, message = "numrt-ntfnd")
    @Positive(message = "Il numero di ruote non è valido")
    private Integer numeroRuote;

    @NotNull(groups = ValidationGroup.Create.class, message = "alim-name-ntfnd")
    private Integer idTipoAlimentazione;

    @NotNull(groups = ValidationGroup.Create.class, message = "cat-no-name")
    private Integer idCategoria;

    @NotNull(groups = ValidationGroup.Create.class, message = "color-no-name")
    private Integer idColore;

    @NotNull(groups = ValidationGroup.Create.class, message = "marca-id-ntfnd")
    private Integer idMarca;

    @NotNull(groups = ValidationGroup.Create.class, message = "annprd-ntfnd")
    @Positive(message = "annprd-invalid")
    private Integer annoProduzione;

    @NotNull (groups = ValidationGroup.Create.class , message ="model-ntfnd")
	@NotBlank (groups = ValidationGroup.Create.class , message ="model-invalid")
    private String modello;
}
