package com.bd.eshopper.api.avion.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bd.eshopper.api.avion.entity.CompagnieAerienne;

public interface CompagnieAerienneRepository extends JpaRepository<CompagnieAerienne, Long> {

    //methode personalisée pour récupéré l'entité par nom
    @Query("select c from CompagnieAerienne c where c.airlineName like :nom")
    public CompagnieAerienne findByNom(@Param(value = "nom") String nom);
}
