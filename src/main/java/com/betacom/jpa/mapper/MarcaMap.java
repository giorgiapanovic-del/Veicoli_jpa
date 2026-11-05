package com.betacom.jpa.mapper;

import java.util.List;
import com.betacom.jpa.dto.output.MarcaRes;
import com.betacom.jpa.models.Marca;

public class MarcaMap {

	public static List<MarcaRes> buildMarcaResList(List<Marca> listMarca) {
        return listMarca.stream()
                .map(b -> buildMarcaRes(b))
                .toList();
    }

    public static MarcaRes buildMarcaRes(Marca marca) {
        return MarcaRes.builder()
                .id(marca.getId())
                .nome(marca.getNome())
                .build();
    }
}
