package com.bd.eshopper.api.avion.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Client implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Size(min = 2, max = 100, message = "indiquez le nom")
	private String nom;
	@NotNull
	@Size(min = 2, max = 100, message = "indiquez le prenom")
	private String prenom;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateNaissance;
	@NotNull
	@Size(min = 2, message = "indiquez l'adresse")
	private String adresse;
	@NotNull
	@Size(min = 2, max = 100, message = "indiquez la ville")
	private String ville;
	@NotNull
	@Size(min = 2, max = 6, message = "indiquez le code postal")
	private String codePostal;
	@NotNull
	@Size(min = 2, max = 100, message = "indiquez le pays")
	private String pays;
	@Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\." + "[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@"
			+ "(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message = "{invalid.email}")
	private String email;
	private String telephone;
	private Date createdAt;
	private Date updatedAt;
	private String numeroCb;
	private String moisCb;
	private String anneeCb;
	private String cryptogrameCb;

	@OneToMany(mappedBy = "client")
	private List<ReservationVol> reservations;

}
