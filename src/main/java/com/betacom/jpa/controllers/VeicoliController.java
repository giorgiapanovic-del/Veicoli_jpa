package com.betacom.jpa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.betacom.jpa.dto.input.ValidationGroup;
import com.betacom.jpa.dto.input.VeicoliReq;
import com.betacom.jpa.dto.output.ResponseRes;
import com.betacom.jpa.services.interfaces.IVeicoliService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/rest/Veicoli")
public class VeicoliController {
	
	@Autowired
	private IVeicoliService veicoliService;
	
	@GetMapping("/list")
	public ResponseEntity<Object> listVeicoli() throws Exception {
		return ResponseEntity.ok(veicoliService.listVeicoli());
	}
	
	@PostMapping("/create")
	public ResponseEntity<ResponseRes> createVeicolo(
			@Validated(ValidationGroup.Create.class)
			@RequestBody VeicoliReq veicoliReq) throws Exception {
		veicoliService.createVeicoli(veicoliReq);
		return ResponseEntity.ok(ResponseRes.builder()
				.msg("create sucessfull")
				.build()
				);
	}
	
	@PatchMapping("/update")
	public ResponseEntity<ResponseRes> updateVeicoli(
						@Validated(ValidationGroup.Update.class)
						@RequestBody VeicoliReq veicoliReq) throws Exception {
		veicoliService.updateVeicoli(veicoliReq);
			return ResponseEntity.ok(ResponseRes.builder()
					.msg("update sucessfull")
					.build()
					);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseRes> deleteVeicoli(@PathVariable Integer id) throws Exception {
		veicoliService.deleteVeicoli(id);
		return ResponseEntity.ok(ResponseRes.builder()
				.msg("delete sucessfull")
				.build()
				);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Object> findById(@PathVariable Integer id) throws Exception {
		return ResponseEntity.ok(veicoliService.findById(id));
	}
}
