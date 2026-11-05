package com.betacom.jpa.mapper;

import java.util.List;
import com.betacom.jpa.dto.output.CategoriaRes;
import com.betacom.jpa.models.Categoria;

public class CategoriaMap {

	public static List<CategoriaRes> buildCategoriaResList(List<Categoria> listCategoria) {
        return listCategoria.stream()
                .map(b -> buildCategoriaRes(b))
                .toList();
    }

    public static CategoriaRes buildCategoriaRes(Categoria categoria) {
        return CategoriaRes.builder()
                .id(categoria.getId())
                .nome(categoria.getNome())
                .build();
    }
}
