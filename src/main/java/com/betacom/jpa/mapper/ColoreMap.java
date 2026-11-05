package com.betacom.jpa.mapper;

import java.util.List;
import com.betacom.jpa.dto.output.ColoreRes;
import com.betacom.jpa.models.Colore;

public class ColoreMap {

	public static List<ColoreRes> buildColoreResList(List<Colore> listColore) {
        return listColore.stream()
                .map(b -> buildColoreRes(b))
                .toList();
    }

    public static ColoreRes buildColoreRes(Colore colore) {
        return ColoreRes.builder()
                .id(colore.getId())
                .nome(colore.getNome())
                .build();
    }
}
