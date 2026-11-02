package com.betacom.jpa.services.implementations;

import org.springframework.stereotype.Service;

import com.betacom.jpa.services.interfaces.INotificaService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class NotificaImpl implements INotificaService{@Override
	public String get(String code) {
		// TODO Auto-generated method stub
		return null;
	}

//	private final INotificaRepository notificaR;
//
//	@Value("${lang}")
//	private String lang;
//
//	public String get(String code) {
//		log.debug(" get {}", code);
//		String r = null;
//		Optional<Notifica> m =notificaR.findById(new NotificaID(lang,code));
//		if(m.isEmpty())
//			r=code;
//		else
//			r=m.get().getNotifica();		
//		return r;
//	}
}
