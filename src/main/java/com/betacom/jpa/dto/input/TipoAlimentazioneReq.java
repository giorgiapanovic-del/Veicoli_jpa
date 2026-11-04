package com.betacom.jpa.dto.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TipoAlimentazioneReq {

	@NotNull(groups = ValidationGroup.Update.class, message = "alim-id-ntfnd")
    private Integer id;

    @NotBlank(groups = ValidationGroup.Create.class, message = "alim-name-ntfnd")
    private String nome;
}
