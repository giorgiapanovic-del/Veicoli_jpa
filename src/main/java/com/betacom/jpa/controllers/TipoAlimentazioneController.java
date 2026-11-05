package com.betacom.jpa.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.betacom.jpa.dto.input.TipoAlimentazioneReq;
import com.betacom.jpa.dto.input.ValidationGroup;
import com.betacom.jpa.dto.output.ResponseRes;
import com.betacom.jpa.services.interfaces.ITipoAlimentazioneService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/rest/Alimentazione")
public class TipoAlimentazioneController {

	private final ITipoAlimentazioneService alimentazioneService;

	@GetMapping("/list")
	public ResponseEntity<Object> listAlimentazione(	) throws Exception {
		return ResponseEntity.ok(alimentazioneService.listAlimentazione());
	}
	
	@PostMapping("/create")
	public ResponseEntity<ResponseRes> createColore(
						@Validated(ValidationGroup.Create.class)
						@RequestBody TipoAlimentazioneReq tipoAlimentazioneReq) throws Exception {
		alimentazioneService.createAlimentazione(tipoAlimentazioneReq);
		return ResponseEntity.ok(ResponseRes.builder()
				.msg("create sucessfull")
				.build()
				);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseRes> deleteColore(@PathVariable Integer id) throws Exception {
		alimentazioneService.deleteAlimentazione(id);
		return ResponseEntity.ok(ResponseRes.builder()
				.msg("delete sucessfull")
				.build()
				);
	}
}
