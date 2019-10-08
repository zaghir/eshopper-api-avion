package com.bd.eshopper.api.avion.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class ReservationVol {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String codeReservation;
	private Date dateCreation;
	private String idPaiement;

//	@ManyToMany
//	@JoinTable(name = "reservationvol_vol")
	//private List<Vol> vols;

	@ManyToOne()
	@JoinColumn(name = "tarif_id")
	private Tarif tarif;

	@ManyToMany
	@JoinTable(name = "reservationvol_voyageur")
	private List<Voyageur> voyageurs;

	@ManyToOne
	@JoinColumn(name = "assurance_id")
	private Assurance assurance;

	@OneToOne(mappedBy = "reservation")
	private Facture facture;

	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;

}
