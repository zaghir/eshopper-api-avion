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

import com.bd.eshopper.api.avion.entity.Tarif;
import com.bd.eshopper.api.avion.service.TarifMetier;

@RestController
@RequestMapping("/api/avion")
public class TarifService {
	
	@Autowired
	private TarifMetier tarifMetier ;
	private static Logger logger = LoggerFactory.getLogger(TarifService.class);
	
	@RequestMapping(value="/tarif" , method=RequestMethod.GET )
	@ResponseBody
	public List<Tarif> getAll(){
		logger.info("TarifMetier:getAll()");		
		return tarifMetier.getAll();
	}
	
	@RequestMapping(value="/tarif" , method=RequestMethod.POST )
	//@Secured(value = { "ROLE_ADMIN" })
	public Tarif save(@RequestBody Tarif o){
		logger.info("TarifMetier:save()");
		return tarifMetier.save(o);
	}
	
	@RequestMapping(value="/tarif" , method=RequestMethod.PUT )
	//@Secured(value = { "ROLE_ADMIN" })
	public Tarif update(@RequestBody Tarif o){
		logger.info("TarifMetier:update()");
		return tarifMetier.update(o);		
	}

	@RequestMapping(value="/tarif" , method=RequestMethod.DELETE )
	//@Secured(value = { "ROLE_ADMIN" })
	public String delete(@RequestParam Long id){
		logger.info("TarifMetier:detele()");
		return tarifMetier.delete(id);
	}
	
	@RequestMapping(value="/tarif/{id}" , method=RequestMethod.GET )
	public Tarif findOne(@PathVariable Long id){
		logger.info("TarifMetier:findOne()");
		return tarifMetier.findOne(id);
	}
}
