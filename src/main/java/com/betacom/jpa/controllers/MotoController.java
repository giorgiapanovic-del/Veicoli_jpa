package com.betacom.jpa.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.jpa.dto.input.MotoReq;
import com.betacom.jpa.dto.input.ValidationGroup;
import com.betacom.jpa.dto.output.ResponseRes;
import com.betacom.jpa.services.interfaces.IMotoService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/rest/Moto")
public class MotoController {

private final IMotoService motoService;

	@GetMapping("/listFiltri")
	public ResponseEntity<Object> list(@RequestParam (required = false)  Integer id,
			@RequestParam (required = false)  String targa,
			@RequestParam (required = false)  Integer cc
			) throws Exception{
		return ResponseEntity.ok(motoService.listFiltri(id, targa, cc));
	}
	
	@GetMapping("/list")
	public ResponseEntity<Object> listMoto(	) throws Exception {
		return ResponseEntity.ok(motoService.listMoto());
	}

	@PostMapping("/create")
	public ResponseEntity<ResponseRes> createMoto(
						@Validated(ValidationGroup.Create.class)
						@RequestBody MotoReq motoReq) throws Exception {
		motoService.createMoto(motoReq);
		return ResponseEntity.ok(ResponseRes.builder()
				.msg("create sucessfull")
				.build()
				);
	}
	
	@PatchMapping("/update")
	public ResponseEntity<ResponseRes> updateMoto(
						@Validated(ValidationGroup.Update.class)
						@RequestBody MotoReq motoReq) throws Exception {
			motoService.updateMoto(motoReq);
			return ResponseEntity.ok(ResponseRes.builder()
					.msg("update sucessfull")
					.build()
					);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseRes> deleteMoto(@PathVariable Integer id) throws Exception {
		motoService.deleteMoto(id);
		return ResponseEntity.ok(ResponseRes.builder()
				.msg("delete sucessfull")
				.build()
				);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Object> findById(@PathVariable Integer id) throws Exception {
		return ResponseEntity.ok(motoService.findById(id));
	}
}
