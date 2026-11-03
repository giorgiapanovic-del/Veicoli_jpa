package com.betacom.jpa.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.jpa.dto.input.MacchinaReq;
import com.betacom.jpa.dto.output.MacchinaRes;
import com.betacom.jpa.dto.output.ResponseRes;
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
    
    @GetMapping("/get-all")
    public ResponseEntity<List<MacchinaRes>> getAll() {
        log.info("Richiesta ricezione di tutte le macchine");
        List<MacchinaRes> list = macchinaService.getAllMacchine();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<MacchinaRes> getById(@PathVariable Integer id) {
        log.info("Richiesta ricezione macchina con ID: {}", id);
        try {
            MacchinaRes res = macchinaService.getMacchinaById(id);
            return ResponseEntity.ok(res);
        } catch (Exception e) {
            log.error("Errore durante la ricerca della macchina con ID {}: {}", id, e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseRes> create(@Valid @RequestBody MacchinaReq request) {
        log.info("Richiesta creazione nuova macchina con targa: {}", request.getTarga());
        ResponseRes response = new ResponseRes();
        try {
            macchinaService.createMacchina(request);
            response.setResult(true);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            log.error("Errore durante la creazione della macchina: {}", e.getMessage());
            response.setResult(false);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseRes> update(@Valid @RequestBody MacchinaReq request) {
        log.info("Richiesta aggiornamento macchina con ID: {}", request.getId());
        ResponseRes response = new ResponseRes();
        try {
            macchinaService.updateMacchina(request);
            response.setResult(true);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error("Errore durante l'aggiornamento della macchina: {}", e.getMessage());
            response.setResult(false);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseRes> delete(@PathVariable Integer id) {
        log.info("Richiesta eliminazione macchina con ID: {}", id);
        ResponseRes response = new ResponseRes();
        try {
            macchinaService.deleteMacchina(id);
            response.setResult(true);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error("Errore durante l'eliminazione della macchina con ID {}: {}", id, e.getMessage());
            response.setResult(false);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
}