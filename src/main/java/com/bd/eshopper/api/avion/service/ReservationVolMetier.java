package com.bd.eshopper.api.avion.service;

import java.util.List;

import com.bd.eshopper.api.avion.entity.ReservationVol;


public interface ReservationVolMetier {
	
	public ReservationVol findOne(Long id) ;
	public List<ReservationVol> getAll();
	public ReservationVol save(ReservationVol o) ;
	public ReservationVol update(ReservationVol o) ;
	public String delete(Long id) ;
	

}
