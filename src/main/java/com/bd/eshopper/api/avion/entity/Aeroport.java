package com.bd.eshopper.api.avion.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Aeroport implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Size(min = 2, max = 100, message = "indiquez le code de l'airport")
	private String code;
	@NotNull
	@Size(min = 2, message = "indiquez l'adresse")
	private String adresse;
	@NotNull
	@Size(min = 2, max = 100, message = "indiquez la ville")
	private String ville;
	@NotNull
	@Size(min = 2, max = 100, message = "indiquez le pays")
	private String pays;

	@OneToMany
	@JoinColumn(name = "airport_id")
	private List<TerminalAero> terminalAero;

}
