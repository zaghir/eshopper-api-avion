package com.bd.eshopper.api.avion.service;

import java.util.List;

import com.bd.eshopper.api.avion.entity.Voyageur;


public interface VoyageurMetier {
	
	public Voyageur findOne(Long id) ;
	public List<Voyageur> getAll();
	public Voyageur save(Voyageur o) ;
	public Voyageur update(Voyageur o) ;
	public String delete(Long id) ;
}
