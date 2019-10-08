package com.bd.eshopper.api.avion.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bd.eshopper.api.avion.dao.VoyageurRepository;
import com.bd.eshopper.api.avion.entity.Voyageur;
import com.bd.eshopper.api.avion.service.VoyageurMetier;

@Service
public class VoyageurImpl implements VoyageurMetier {

    @Autowired
    private VoyageurRepository voyageurRepository;

    @Override
    public Voyageur findOne(Long id) {
        return voyageurRepository.getOne(id);
    }

    @Override
    public List<Voyageur> getAll() {
        return voyageurRepository.findAll();
    }

    @Override
    public Voyageur save(Voyageur o) {
              return voyageurRepository.save(o);
    }

    @Override
    public Voyageur update(Voyageur o) {
        return voyageurRepository.save(o);
    }

    @Override
    public String delete(Long id) {
        if (voyageurRepository.getOne(id) != null) {
            voyageurRepository.deleteById(id);
            return "Voyageur suprimée de la base";
        } else {
            return "Erreur de suppression du voyageur";
        }
    }
}
