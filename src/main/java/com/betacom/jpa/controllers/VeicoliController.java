package com.betacom.jpa.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.jpa.services.interfaces.IBiciService;
import com.betacom.jpa.services.interfaces.IMotoService;
import com.betacom.jpa.services.interfaces.IVeicoliService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/rest/Veicoli")
public class VeicoliController {

private final IVeicoliService veicoliService;
	
	//TODO
}
