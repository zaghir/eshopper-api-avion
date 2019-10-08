package com.bd.eshopper.api.avion.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bd.eshopper.api.avion.dao.TerminalAeroRepository;
import com.bd.eshopper.api.avion.entity.TerminalAero;
import com.bd.eshopper.api.avion.service.TerminalAeroMetier;

@Service
public class TerminalAeroImpl implements TerminalAeroMetier {

    @Autowired
    private TerminalAeroRepository terminalAeroRepository;

    @Override
    public TerminalAero findOne(Long id) {
        return terminalAeroRepository.getOne(id);
    }

    @Override
    public List<TerminalAero> getAll() {
        return terminalAeroRepository.findAll();
    }

    @Override
    public TerminalAero save(TerminalAero o) {
              return terminalAeroRepository.save(o);
    }

    @Override
    public TerminalAero update(TerminalAero o) {
        return terminalAeroRepository.save(o);
    }

    @Override
    public String delete(Long id) {
        if (terminalAeroRepository.getOne(id) != null) {
            terminalAeroRepository.deleteById(id);
            return "TerminalAero suprimée de la base";
        } else {
            return "Erreur de suppression du terminalAero";
        }
    }
}
