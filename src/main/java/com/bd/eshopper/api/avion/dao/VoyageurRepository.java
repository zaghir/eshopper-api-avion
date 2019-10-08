package com.bd.eshopper.api.avion.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bd.eshopper.api.avion.entity.Voyageur;

public interface VoyageurRepository extends JpaRepository<Voyageur, Long> {
}
