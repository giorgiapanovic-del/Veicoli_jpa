package com.betacom.jpa.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table (name="tipo_sospensione")
public class TipoSospensione {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id_tipo_sospensione")
	private Integer id;
	
	@Column(
			name="nome",
			nullable = false
			)
	private String nome;
	
	@OneToMany(mappedBy = "tipoSospensione", cascade = CascadeType.ALL)
    private List<Bici> veicoli;
}
