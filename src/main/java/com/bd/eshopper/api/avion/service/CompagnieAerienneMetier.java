package com.bd.eshopper.api.avion.service;

import java.util.List;

import com.bd.eshopper.api.avion.entity.CompagnieAerienne;


public interface CompagnieAerienneMetier {
	
	public CompagnieAerienne findOne(Long id) ;
	public List<CompagnieAerienne> getAll();
	public CompagnieAerienne save(CompagnieAerienne o) ;
	public CompagnieAerienne update(CompagnieAerienne o) ;
	public String delete(Long id) ;
	

}
