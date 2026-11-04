package com.betacom.jpa.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.jpa.dto.input.MacchinaReq;
import com.betacom.jpa.dto.output.MacchinaRes;
import com.betacom.jpa.dto.output.ResponseRes; // <-- Import corretto
import com.betacom.jpa.services.interfaces.IMacchinaService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/rest/Macchina")
public class MacchinaController {

    private final IMacchinaService macchinaService;
    
    @GetMapping("/listFiltri")
	public ResponseEntity<Object> list(@RequestParam (required = false)  Integer id,
			@RequestParam (required = false)  String targa,
			@RequestParam (required = false)  Integer cc,
			@RequestParam (required = false)  Integer numeroPorte 
			) throws Exception{
		return ResponseEntity.ok(macchinaService.listFiltri(id, targa, cc, numeroPorte));
	}
    
    @GetMapping("/list")
    public ResponseEntity<List<MacchinaRes>> getAll() throws Exception {
        log.info("Richiesta ricezione di tutte le macchine");
        List<MacchinaRes> list = macchinaService.listMacchina();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<MacchinaRes> getById(@PathVariable Integer id) throws Exception {
        log.info("Richiesta ricezione macchina con ID: {}", id);
        MacchinaRes res = macchinaService.getMacchinaById(id);
        return ResponseEntity.ok(res);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseRes> create(
            @Valid @RequestBody MacchinaReq request) throws Exception {

        log.info("Creazione macchina con targa: {}", request.getTarga());

        macchinaService.createMacchina(request);

        ResponseRes response = ResponseRes.builder()
                .msg("Macchina creata correttamente")
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PatchMapping("/update")
    public ResponseEntity<ResponseRes> update(
            @Valid @RequestBody MacchinaReq request) throws Exception {

        log.info("Aggiornamento macchina con ID: {}", request.getId());

        macchinaService.updateMacchina(request);

        ResponseRes response = ResponseRes.builder()
                .msg("Macchina aggiornata correttamente")
                .build();

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseRes> delete(
            @PathVariable Integer id) throws Exception {

        log.info("Eliminazione macchina con ID: {}", id);

        macchinaService.deleteMacchina(id);

        ResponseRes response = ResponseRes.builder()
                .msg("Macchina eliminata correttamente")
                .build();

        return ResponseEntity.ok(response);
    }
}