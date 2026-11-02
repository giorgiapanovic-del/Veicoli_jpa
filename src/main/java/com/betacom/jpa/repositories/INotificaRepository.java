package com.betacom.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.jpa.models.Notifica;
import com.betacom.jpa.models.NotificaID;



public interface INotificaRepository extends JpaRepository<Notifica,NotificaID> {

}
