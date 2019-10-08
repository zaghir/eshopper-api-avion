package com.bd.eshopper.api.avion.service;

import java.util.List;

import com.bd.eshopper.api.avion.entity.Tarif;


public interface TarifMetier {
	
	public Tarif findOne(Long id) ;
	public List<Tarif> getAll();
	public Tarif save(Tarif o) ;
	public Tarif update(Tarif o) ;
	public String delete(Long id) ;
}
