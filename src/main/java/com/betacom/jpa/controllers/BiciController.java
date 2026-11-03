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
import org.springframework.web.bind.annotation.RestController;

import com.betacom.jpa.dto.input.BiciReq;
import com.betacom.jpa.dto.input.MotoReq;
import com.betacom.jpa.dto.input.ValidationGroup;
import com.betacom.jpa.dto.output.ResponseRes;
import com.betacom.jpa.services.interfaces.IBiciService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/rest/Bici")
public class BiciController {

	private final IBiciService biciService;
	
	@GetMapping("/list")
	public ResponseEntity<Object> listMoto(	) throws Exception {
		return ResponseEntity.ok(biciService.listBici());
	}

	@PostMapping("/create")
	public ResponseEntity<ResponseRes> createMoto(
						@Validated(ValidationGroup.Create.class)
						@RequestBody BiciReq biciReq) throws Exception {
		biciService.createBici(biciReq);
		return ResponseEntity.ok(ResponseRes.builder()
				.msg("create sucessfull")
				.build()
				);
	}
	
	@PatchMapping("/update")
	public ResponseEntity<ResponseRes> updateMoto(
						@Validated(ValidationGroup.Update.class)
						@RequestBody BiciReq biciReq) throws Exception {
		biciService.updateBici(biciReq);
			return ResponseEntity.ok(ResponseRes.builder()
					.msg("update sucessfull")
					.build()
					);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseRes> deleteMoto(@PathVariable Integer id) throws Exception {
		biciService.deleteBici(id);
		return ResponseEntity.ok(ResponseRes.builder()
				.msg("delete sucessfull")
				.build()
				);
	}
}
