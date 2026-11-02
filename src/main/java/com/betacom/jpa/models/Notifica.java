package com.betacom.jpa.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="notifica_systema")
public class Notifica {

	@EmbeddedId
	private NotificaID notificaID;
	
	private String notifica;
}
