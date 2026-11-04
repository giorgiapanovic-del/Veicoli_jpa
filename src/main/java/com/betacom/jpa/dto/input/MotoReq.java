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
public class MotoReq extends VeicoliReq{

	@NotNull(groups = ValidationGroup.Update.class, message = "moto-id-ntfnd")
    private Integer id;

    @NotNull(groups = ValidationGroup.Create.class, message = "moto-idveic-ntfnd")
    private Integer idVeicolo;

    @NotBlank(groups = ValidationGroup.Create.class, message = "moto-trg-ntfnd")
    private String targa;

    @NotNull(groups = ValidationGroup.Create.class, message = "cc-ntfnd")
    @Positive(message = "cc-invalid")
    private Integer cc;
}
