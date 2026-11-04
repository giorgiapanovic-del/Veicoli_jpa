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

	@NotNull(groups = ValidationGroup.Update.class, message = "color-no-id")
    private Integer id;

	@NotBlank(groups = ValidationGroup.Create.class, message = "color-no-name")
	private String nome;
}
