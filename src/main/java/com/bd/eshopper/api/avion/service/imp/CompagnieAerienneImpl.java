package com.bd.eshopper.api.avion.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bd.eshopper.api.avion.dao.CompagnieAerienneRepository;
import com.bd.eshopper.api.avion.entity.CompagnieAerienne;
import com.bd.eshopper.api.avion.service.CompagnieAerienneMetier;

@Service
public class CompagnieAerienneImpl implements CompagnieAerienneMetier {

    @Autowired
    private CompagnieAerienneRepository compagnieAerienneRepository;

    @Override
    public CompagnieAerienne findOne(Long id) {
        return compagnieAerienneRepository.getOne(id);
    }

    @Override
    public List<CompagnieAerienne> getAll() {
        return compagnieAerienneRepository.findAll();
    }

    @Override
    public CompagnieAerienne save(CompagnieAerienne o) {
        CompagnieAerienne a = new CompagnieAerienne();
        if (o.getId() == null) {
            if (o.getAirlineName() != null) {
                if (compagnieAerienneRepository.findByNom(o.getAirlineName()) == null) {
                    a = compagnieAerienneRepository.save(o);
                } else {
                    a.setAirlineName("exite deja");
                }
            }
        }
        return a;
    }

    @Override
    public CompagnieAerienne update(CompagnieAerienne o) {
        return compagnieAerienneRepository.save(o);
    }

    @Override
    public String delete(Long id) {
        if (compagnieAerienneRepository.getOne(id) != null) {
            compagnieAerienneRepository.deleteById(id);
            return "Compagnie suprimée de la base";
        } else {
            return "Erreur de suppression de la compagnie aérienne";
        }
    }
}
