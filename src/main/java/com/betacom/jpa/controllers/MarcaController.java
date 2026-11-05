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
import com.betacom.jpa.dto.input.MarcaReq;
import com.betacom.jpa.dto.input.ValidationGroup;
import com.betacom.jpa.dto.output.ResponseRes;
import com.betacom.jpa.services.interfaces.IMarcaService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/rest/Marca")
public class MarcaController {

	private final IMarcaService marcaService;

	@GetMapping("/list")
	public ResponseEntity<Object> listMarca() throws Exception {
		return ResponseEntity.ok(marcaService.listMarca());
	}
	
	@PostMapping("/create")
	public ResponseEntity<ResponseRes> createMarca(
						@Validated(ValidationGroup.Create.class)
						@RequestBody MarcaReq marcaReq) throws Exception {
		marcaService.createMarca(marcaReq);
		return ResponseEntity.ok(ResponseRes.builder()
				.msg("create sucessfull")
				.build()
				);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseRes> deleteMarca(@PathVariable Integer id) throws Exception {
		marcaService.deleteMarca(id);
		return ResponseEntity.ok(ResponseRes.builder()
				.msg("delete sucessfull")
				.build()
				);
	}
}
