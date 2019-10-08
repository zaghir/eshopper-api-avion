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

import com.bd.eshopper.api.avion.entity.CompagnieAerienne;
import com.bd.eshopper.api.avion.service.CompagnieAerienneMetier;

@RestController
@RequestMapping("/api/avion")
public class CompagnieAerienneService {
	
	@Autowired
	private CompagnieAerienneMetier compagnieAerienneMetier ;
	
	private static Logger logger = LoggerFactory.getLogger(CompagnieAerienneService.class);
	
	@RequestMapping(value="/compagnieAerienne" , method=RequestMethod.GET )
	@ResponseBody
	public List<CompagnieAerienne> getAll(){
		logger.info("CompagnieAerienneMetier:getAll()");		
		return compagnieAerienneMetier.getAll();
	}
	
	@RequestMapping(value="/compagnieAerienne" , method=RequestMethod.POST )
	//@Secured(value = { "ROLE_ADMIN" })
	public CompagnieAerienne save(@RequestBody CompagnieAerienne o){
		logger.info("CompagnieAerienneMetier:save()");
		return compagnieAerienneMetier.save(o);
	}
	
	@RequestMapping(value="/compagnieAerienne" , method=RequestMethod.PUT )
	//@Secured(value = { "ROLE_ADMIN" })
	public CompagnieAerienne update(@RequestBody CompagnieAerienne o){
		logger.info("CompagnieAerienneMetier:update()");
		return compagnieAerienneMetier.update(o);		
	}

	@RequestMapping(value="/compagnieAerienne" , method=RequestMethod.DELETE )
	//@Secured(value = { "ROLE_ADMIN" })
	public String delete(@RequestParam Long id){
		logger.info("CompagnieAerienneMetier:delete()");
		return compagnieAerienneMetier.delete(id);
	}
	
	@RequestMapping(value="/compagnieAerienne/{id}" , method=RequestMethod.GET )
	public CompagnieAerienne findOne(@PathVariable Long id){
		logger.info("CompagnieAerienneMetier:findOne()");
		return compagnieAerienneMetier.findOne(id);
	}
}
