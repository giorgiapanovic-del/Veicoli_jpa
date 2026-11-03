package com.betacom.jpa.mapper;

import java.util.List;


import com.betacom.jpa.dto.output.BiciRes;
import com.betacom.jpa.models.Bici;


public class BiciMap {

	public static List<BiciRes> buildBiciResList(List<Bici> lA){
		
		return lA.stream()
				.map(s -> buildBiciRes(s)
						).toList();						
		
	}
	
	public static BiciRes buildBiciRes(Bici a) {
		return BiciRes.builder()
				.id(a.getId())
				.build();
	}
}
