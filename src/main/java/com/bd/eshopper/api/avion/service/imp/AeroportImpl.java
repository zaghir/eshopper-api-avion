package com.bd.eshopper.api.avion.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bd.eshopper.api.avion.dao.AeroportRepository;
import com.bd.eshopper.api.avion.entity.Aeroport;
import com.bd.eshopper.api.avion.service.AeroportMetier;

@Service
public class AeroportImpl implements AeroportMetier{

	@Autowired
	private AeroportRepository aeroportRepository;

	@Override
	public Aeroport save(Aeroport o) {
		Aeroport a = new Aeroport() ;
		if(aeroportRepository.findByCode(o.getCode()) == null){
			return aeroportRepository.save(o);
		}else{
			a.setCode("existe deja");
			 a.setAdresse("existe deja");
			 a.setPays("existe deja");
			 return a;
		}

	}

	@Override
	public List<Aeroport> getAll() {
		return aeroportRepository.findAll();
	}

	@Override
	public Long delete(Long id) {
		if(aeroportRepository.getOne(id) != null){
			aeroportRepository.deleteById(id);
			return id;
		}else{
			return 0L ;
		}
		
	}

	@Override
	public Aeroport update(Aeroport o) {
		return aeroportRepository.save(o);
	}

	@Override
	public Aeroport findOne(Long id) {
		return aeroportRepository.getOne(id);
	}
	
}
