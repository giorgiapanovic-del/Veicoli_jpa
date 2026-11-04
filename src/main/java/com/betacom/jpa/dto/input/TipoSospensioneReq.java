package com.betacom.jpa.dto.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TipoSospensioneReq {

	@NotNull(groups = ValidationGroup.Update.class, message = "sos-id-ntfnd")
    private Integer id;

    @NotBlank(groups = ValidationGroup.Create.class, message = "sosp-ntfnd")
    private String nome;
}
