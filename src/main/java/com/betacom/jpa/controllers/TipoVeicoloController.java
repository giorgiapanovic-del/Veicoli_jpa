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
import com.betacom.jpa.dto.input.TipoVeicoloReq;
import com.betacom.jpa.dto.input.ValidationGroup;
import com.betacom.jpa.dto.output.ResponseRes;
import com.betacom.jpa.services.interfaces.ITipoVeicoloService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/rest/TipoVeicolo")
public class TipoVeicoloController {

	private final ITipoVeicoloService veicoloService;

	@GetMapping("/list")
	public ResponseEntity<Object> listAlimentazione(	) throws Exception {
		return ResponseEntity.ok(veicoloService.listVeicolo());
	}
	
	@PostMapping("/create")
	public ResponseEntity<ResponseRes> createSospensione(
						@Validated(ValidationGroup.Create.class)
						@RequestBody TipoVeicoloReq tipoVeicoloReq) throws Exception {
		veicoloService.createVeicolo(tipoVeicoloReq);
		return ResponseEntity.ok(ResponseRes.builder()
				.msg("create sucessfull")
				.build()
				);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseRes> deleteVeicolo(@PathVariable Integer id) throws Exception {
		veicoloService.deleteVeicolo(id);
		return ResponseEntity.ok(ResponseRes.builder()
				.msg("delete sucessfull")
				.build()
				);
	}
}
