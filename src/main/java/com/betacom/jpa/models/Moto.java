package com.betacom.jpa.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table (name="moto")
public class Moto {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id_moto")
	private Integer id;
	
	@OneToOne
    @JoinColumn(
    		name = "id_veicoli", 
    		nullable = false)
    private Veicoli veicoli;
	
	@Column(
			name="targa",
			nullable = false
			)
	private String targa;
	
	@Column(
			name="cc",
			nullable = false
			)
	private Integer cc;

}
