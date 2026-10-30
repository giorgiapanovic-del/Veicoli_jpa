package com.betacom.jpa.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@Table(name="veicoli")
public class Veicoli {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(
				name="tipo_veicolo"
			)
	private TipoVeicolo tipoVeicolo;
	
	
	@Column(
			name="numero_ruote",
			nullable=false
		)
	private Integer numeroRuote;
	
	
	@ManyToOne
	@JoinColumn(
			name="tipo_alimentazione"
			)
	private TipoAlimentazione tipoAlimentazione;
	
	@ManyToOne
	@JoinColumn(
			name="categoria"
			)
	private Categoria categoria;
	
	@ManyToOne
	@JoinColumn(
			name="colore"
			)
	private Colore colore;
	
	@ManyToOne
	@JoinColumn(
			name="marca"
			)
	private Marca marca;
	
	@Column(
			name="anno_produzione",
			nullable = false
			)
	private Integer annoProduzione;
	
	@Column(
			name="modello",
			nullable = false
			)
	private String modello;
}
