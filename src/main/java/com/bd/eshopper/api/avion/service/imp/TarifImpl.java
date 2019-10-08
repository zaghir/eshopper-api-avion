package com.bd.eshopper.api.avion.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bd.eshopper.api.avion.dao.TarifRepository;
import com.bd.eshopper.api.avion.entity.Tarif;
import com.bd.eshopper.api.avion.service.TarifMetier;

@Service
public class TarifImpl implements TarifMetier {

    @Autowired
    private TarifRepository tarifRepository;

    @Override
    public Tarif findOne(Long id) {
        return tarifRepository.getOne(id);
    }

    @Override
    public List<Tarif> getAll() {
        return tarifRepository.findAll();
    }

    @Override
    public Tarif save(Tarif o) {
              return tarifRepository.save(o);
    }

    @Override
    public Tarif update(Tarif o) {
        return tarifRepository.save(o);
    }

    @Override
    public String delete(Long id) {
        if (tarifRepository.getOne(id) != null) {
            tarifRepository.deleteById(id);
            return "Tarif suprimée de la base";
        } else {
            return "Erreur de suppression du tarif";
        }
    }
}
