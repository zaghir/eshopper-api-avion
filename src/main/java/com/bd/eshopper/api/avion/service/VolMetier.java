package com.bd.eshopper.api.avion.service;

import java.util.List;

import com.bd.eshopper.api.avion.entity.Vol;


public interface VolMetier {
	
	public Vol findOne(Long id) ;
	public List<Vol> getAll();
	public Vol save(Vol o) ;
	public Vol update(Vol o) ;
	public String delete(Long id) ;
	

}
