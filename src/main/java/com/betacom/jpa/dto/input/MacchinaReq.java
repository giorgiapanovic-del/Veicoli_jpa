package com.betacom.jpa.dto.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MacchinaReq extends VeicoliReq{
    
	@NotNull(groups = ValidationGroup.Update.class, message = "macc-no-id")
    private Integer id;

    @NotNull(groups = ValidationGroup.Create.class, message = "veic-no-id")
    private Integer idVeicoli;

    @NotBlank(groups = ValidationGroup.Create.class, message = "tar-ntfnd")
    private String targa;

    @NotNull(groups = ValidationGroup.Create.class, message = "cil-ntfnd")
    @Positive(message = "cil-invalid")
    private Integer cc;

    @NotNull(groups = ValidationGroup.Create.class, message = "numpr-ntfnd")
    @Positive(message = "numpr-invalid")
    private Integer numeroPorte;
}