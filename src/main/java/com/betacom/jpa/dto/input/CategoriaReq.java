package com.betacom.jpa.dto.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CategoriaReq {

	@NotNull(groups = ValidationGroup.Update.class, message = "no-id-cat")
    private Integer id;

	@NotBlank(groups = ValidationGroup.Create.class, message = "cat-no-name")
    private String nome;
}
