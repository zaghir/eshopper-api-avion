package com.bd.eshopper.api.avion.resource;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bd.eshopper.api.avion.entity.ReservationVol;
import com.bd.eshopper.api.avion.entity.Voyageur;
import com.bd.eshopper.api.avion.service.ReservationVolMetier;

@RestController
@RequestMapping("/api/avion")
public class ReservationVolService {
	
	private static Logger logger = LoggerFactory.getLogger(ReservationVolService.class);
	
	@Autowired
	private ReservationVolMetier reservationVolMetier ;
	
	@RequestMapping(value="/reservation" , method=RequestMethod.GET )
	@ResponseBody
	public List<ReservationVol> getAll(){
		logger.info("ReservationVolService:getAll()");
		return reservationVolMetier.getAll();
	}
	
	@RequestMapping(value="/reservation" , method=RequestMethod.POST )
	//@Secured(value = { "ROLE_ADMIN" })
	public ReservationVol save(@RequestBody ReservationVol o){
		logger.info("ReservationVolService:service()");
            for( Voyageur v : o.getVoyageurs()){
                logger.debug("nom--- {}",v.getNom());
            } 
		return reservationVolMetier.save(o);
	}
	
	@RequestMapping(value="/reservation" , method=RequestMethod.PUT )
	//@Secured(value = { "ROLE_ADMIN" })
	public ReservationVol update(@RequestBody ReservationVol o){
		logger.info("ReservationVolService:update()");
		return reservationVolMetier.update(o);		
	}

	@RequestMapping(value="/reservation" , method=RequestMethod.DELETE )
	//@Secured(value = { "ROLE_ADMIN" })
	public String delete(@RequestParam Long id){
		logger.info("ReservationVolService:delete()");
		return reservationVolMetier.delete(id);
	}
	
	@RequestMapping(value="/reservation/{id}" , method=RequestMethod.GET )
	public ReservationVol findOne(@PathVariable Long id){
		logger.info("ReservationVolService:findOne()");
		return reservationVolMetier.findOne(id);
	}
}
