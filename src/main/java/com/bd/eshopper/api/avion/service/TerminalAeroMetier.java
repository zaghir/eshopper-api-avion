package com.bd.eshopper.api.avion.service;

import java.util.List;

import com.bd.eshopper.api.avion.entity.TerminalAero;


public interface TerminalAeroMetier {
	
	public TerminalAero findOne(Long id) ;
	public List<TerminalAero> getAll();
	public TerminalAero save(TerminalAero o) ;
	public TerminalAero update(TerminalAero o) ;
	public String delete(Long id) ;
}
