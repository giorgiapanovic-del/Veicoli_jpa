package com.betacom.jpa.dto.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ColoreReq {

	@NotNull(groups = ValidationGroup.Update.class, message = "Manca l'id del colore")
    private Integer id;

	@NotBlank(groups = ValidationGroup.Create.class, message = "Manca il colore")
	private String nome;
}
