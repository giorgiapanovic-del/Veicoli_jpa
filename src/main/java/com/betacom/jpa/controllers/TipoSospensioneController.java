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
import com.betacom.jpa.dto.input.TipoSospensioneReq;
import com.betacom.jpa.dto.input.ValidationGroup;
import com.betacom.jpa.dto.output.ResponseRes;
import com.betacom.jpa.services.interfaces.ITipoSospensioneService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/rest/Sospensione")
public class TipoSospensioneController {

	private final ITipoSospensioneService sospensioneService;

	@GetMapping("/list")
	public ResponseEntity<Object> listAlimentazione(	) throws Exception {
		return ResponseEntity.ok(sospensioneService.listSospensione());
	}
	
	@PostMapping("/create")
	public ResponseEntity<ResponseRes> createSospensione(
						@Validated(ValidationGroup.Create.class)
						@RequestBody TipoSospensioneReq tipoSospensioneReq) throws Exception {
		sospensioneService.createSospensione(tipoSospensioneReq);
		return ResponseEntity.ok(ResponseRes.builder()
				.msg("create sucessfull")
				.build()
				);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseRes> deleteSospensione(@PathVariable Integer id) throws Exception {
		sospensioneService.deleteSospensione(id);
		return ResponseEntity.ok(ResponseRes.builder()
				.msg("delete sucessfull")
				.build()
				);
	}
}
