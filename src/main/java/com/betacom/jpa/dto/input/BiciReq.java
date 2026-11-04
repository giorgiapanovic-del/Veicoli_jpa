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
public class BiciReq {

	@NotNull(groups = ValidationGroup.Update.class, message = "Manca id bici")
    private Integer id;

	@NotNull(groups = ValidationGroup.Create.class, message = "Manca id veicolo")
    private Integer idVeicolo;

	@NotNull(groups = ValidationGroup.Create.class, message = "Manca il numero corone")
    @Positive(message = "numero di corone non valido")
    private Integer numeroCorone;

	@NotNull(groups = ValidationGroup.Create.class, message = "Manca il numero di marce")
    @Positive(message = "numero di marce non valido")
    private Integer numeroMarce;

	@NotBlank(groups = ValidationGroup.Create.class, message = "Il tipo di freno è obbligatorio")
    private String tipoFreno;

	@NotBlank(groups = ValidationGroup.Create.class, message = "Il tipo di sospensione è obbligatorio")
    private TipoSospensione tipoSospensione;

	@NotNull(groups = ValidationGroup.Create.class, message = "Il campo 'pieghevole' è obbligatorio")
    private Boolean pieghevole;
}
