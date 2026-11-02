package com.betacom.jpa.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="bici")
public class Bici {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id_bici")
	private Integer id;
	
	@OneToOne
    @JoinColumn(name = "id_veicoli", nullable = false) 
    private Veicoli veicoli;
	
	@Column(
			name="numero_corone",
			nullable = false
			)
	private Integer numeroCorone;
	
	@Column(
			name="numero_marce",
			nullable = false
			)
	private Integer numeroMarce;

	@Column(
			name="tipo_freno",
			nullable = false
			)
	private String tipoFreno;
	
	@ManyToOne
	@JoinColumn(
			name = "id_tipo_sospensione"
			)
	private TipoSospensione tipoSospensione;
	
	@Column(
			name="pieghevole",
			nullable = false
			)
	private Boolean pieghevole;
	
	
}
