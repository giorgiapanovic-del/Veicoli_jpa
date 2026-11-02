package com.betacom.jpa.services.implementations;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.betacom.jpa.models.Notifica;
import com.betacom.jpa.models.NotificaID;
import com.betacom.jpa.repositories.INotificaRepository;

import com.betacom.jpa.services.interfaces.INotificaService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class NotificaImpl implements INotificaService{

	private final INotificaRepository notificaR;

	@Value("${lang}")
	private String lang;

	public String get(String code) {
		log.debug(" get {}", code);
		String r = null;
		Optional<Notifica> m =notificaR.findById(new NotificaID(lang,code));
		if(m.isEmpty())
			r=code;
		else
			r=m.get().getNotifica();		
		return r;
	}
}
