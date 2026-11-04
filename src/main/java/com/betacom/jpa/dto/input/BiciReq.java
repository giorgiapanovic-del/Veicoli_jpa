package com.betacom.jpa.dto.input;

import com.betacom.jpa.models.TipoSospensione;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BiciReq extends VeicoliReq{

	@NotNull(groups = ValidationGroup.Update.class, message = "bici-no-id")
    private Integer id;

	@NotNull(groups = ValidationGroup.Create.class, message = "veicolo-no-id")
    private Integer idVeicolo;

	@NotNull(groups = ValidationGroup.Create.class, message = "numc-ntfnd")
    @Positive(message = "numc-invalid")
    private Integer numeroCorone;

	@NotNull(groups = ValidationGroup.Create.class, message = "marce-no-num")
    @Positive(message = "marcenum-invalid")
    private Integer numeroMarce;

	@NotBlank(groups = ValidationGroup.Create.class, message = "frenot-ntfnd")
    private String tipoFreno;

	@NotBlank(groups = ValidationGroup.Create.class, message = "sosp-ntfnd")
    private TipoSospensione tipoSospensione;

	@NotNull(groups = ValidationGroup.Create.class, message = "Manca il campo pieghevole")
    private Boolean pieghevole;
}
