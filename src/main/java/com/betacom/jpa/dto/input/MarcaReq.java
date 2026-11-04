package com.betacom.jpa.dto.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MarcaReq {

	@NotNull(groups = ValidationGroup.Update.class, message = "marca-id-ntfnd")
    private Integer id;

    @NotBlank(groups = ValidationGroup.Create.class, message = "marca-ntfnd")
    private String nome;

}
