package com.bd.eshopper.api.avion.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vol implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String numeroVol;
	private Date dateHeureDepart;
	private Date dateHeureArrivee;
	private String modelAvion;
	private String Classe;
	@ManyToOne(cascade = CascadeType.ALL)
	private CompagnieAerienne compagnieaerienne;
	@ManyToOne(cascade = CascadeType.ALL)
	private Aeroport aeroportDepart;
	@ManyToOne(cascade = CascadeType.ALL)
	private Aeroport aeroportArrivee;

//    @ManyToMany(mappedBy="vols")
//    List<ReservationVol> reservationVols;

}
