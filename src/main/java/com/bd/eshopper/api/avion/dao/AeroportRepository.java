package com.bd.eshopper.api.avion.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bd.eshopper.api.avion.entity.Aeroport;


public interface AeroportRepository extends JpaRepository<Aeroport, Long>{
	
	@Query("select a from Aeroport a where a.code = :code")
	public Aeroport findByCode(@Param(value = "code") String code) ;

}
