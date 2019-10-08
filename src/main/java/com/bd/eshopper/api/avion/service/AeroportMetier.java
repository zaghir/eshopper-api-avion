package com.bd.eshopper.api.avion.service;

import java.util.List;

import com.bd.eshopper.api.avion.entity.Aeroport;

public interface AeroportMetier {
	
	public Aeroport save(Aeroport o) ;
	public List<Aeroport> getAll();
	public Long delete(Long id) ;
	public Aeroport update(Aeroport o ) ;
	public Aeroport findOne(Long id);

}
