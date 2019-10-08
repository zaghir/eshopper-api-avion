package com.bd.eshopper.api.avion.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bd.eshopper.api.avion.dao.VolRepository;
import com.bd.eshopper.api.avion.entity.Vol;
import com.bd.eshopper.api.avion.service.VolMetier;

@Service
public class VolImpl implements VolMetier {

    @Autowired
    private VolRepository volRepository;

    @Override
    public Vol findOne(Long id) {
        return volRepository.getOne(id);
    }

    @Override
    public List<Vol> getAll() {
        return volRepository.findAll();
    }

    @Override
    public Vol save(Vol o) {
              return volRepository.save(o);
    }

    @Override
    public Vol update(Vol o) {
        return volRepository.save(o);
    }

    @Override
    public String delete(Long id) {
        if (volRepository.getOne(id) != null) {
            volRepository.deleteById(id);
            return "Vol suprimée de la base";
        } else {
            return "Erreur de suppression du vol";
        }
    }
}
