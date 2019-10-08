/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bd.eshopper.api.avion.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tarif {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Float prixParAdulte;
	private Float TaxeaPrAdulte;
	private Float prixParEnfant;
	private Float TaxeParEnfant;
	private Float prixParBebe;
	private Float TaxeParBebe;
	private String monaie;
	private Boolean remboursement;
	private Boolean echange;
	@OneToMany(mappedBy = "tarif")
	private List<ReservationVol> reservationVols;

}
