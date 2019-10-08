package com.bd.eshopper.api.avion.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bd.eshopper.api.avion.entity.Tarif;

public interface TarifRepository extends JpaRepository<Tarif, Long> {
}
