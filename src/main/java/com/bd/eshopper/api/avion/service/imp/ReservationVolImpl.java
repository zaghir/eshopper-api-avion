package com.bd.eshopper.api.avion.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bd.eshopper.api.avion.dao.ReservationVolRepository;
import com.bd.eshopper.api.avion.entity.ReservationVol;
import com.bd.eshopper.api.avion.service.ReservationVolMetier;

@Service
public class ReservationVolImpl implements ReservationVolMetier {

    @Autowired
    private ReservationVolRepository ReservationVolRepository;

    @Override
    public ReservationVol findOne(Long id) {
        return ReservationVolRepository.getOne(id);
    }

    @Override
    public List<ReservationVol> getAll() {
        return ReservationVolRepository.findAll();
    }

    @Override
    public ReservationVol save(ReservationVol o) {
              return ReservationVolRepository.save(o);
    }

    @Override
    public ReservationVol update(ReservationVol o) {
        return ReservationVolRepository.save(o);
    }

    @Override
    public String delete(Long id) {
        if (ReservationVolRepository.getOne(id) != null) {
            ReservationVolRepository.deleteById(id);
            return "reservation suprimée de la base";
        } else {
            return "Erreur de suppression de la réservation";
        }
    }
}
