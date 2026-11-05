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
import com.betacom.jpa.dto.input.ColoreReq;
import com.betacom.jpa.dto.input.ValidationGroup;
import com.betacom.jpa.dto.output.ResponseRes;
import com.betacom.jpa.services.interfaces.IColoreService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/rest/Colore")
public class ColoreController {
	
	private final IColoreService coloreService;

	@GetMapping("/list")
	public ResponseEntity<Object> listColore(	) throws Exception {
		return ResponseEntity.ok(coloreService.listColore());
	}
	
	@PostMapping("/create")
	public ResponseEntity<ResponseRes> createColore(
						@Validated(ValidationGroup.Create.class)
						@RequestBody ColoreReq coloreReq) throws Exception {
		coloreService.createColore(coloreReq);
		return ResponseEntity.ok(ResponseRes.builder()
				.msg("create sucessfull")
				.build()
				);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseRes> deleteColore(@PathVariable Integer id) throws Exception {
		coloreService.deleteColore(id);
		return ResponseEntity.ok(ResponseRes.builder()
				.msg("delete sucessfull")
				.build()
				);
	}
}
