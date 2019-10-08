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

import com.bd.eshopper.api.avion.entity.Vol;
import com.bd.eshopper.api.avion.service.VolMetier;

@RestController
@RequestMapping("/api/avion")
public class VolService {
	
	@Autowired
	private VolMetier volMetier ;
	private static Logger logger = LoggerFactory.getLogger(VolService.class);
	
	@RequestMapping(value="/vol" , method=RequestMethod.GET )
	@ResponseBody
	public List<Vol> getAll(){
		logger.info("VolService:getAll()");		
		return volMetier.getAll();
	}
	
	@RequestMapping(value="/vol" , method=RequestMethod.POST )
	//@Secured(value = { "ROLE_ADMIN" })
	public Vol save(@RequestBody Vol o){
		logger.info("VolService:save()");
		return volMetier.save(o);
	}
	
	@RequestMapping(value="/vol" , method=RequestMethod.PUT )
	//@Secured(value = { "ROLE_ADMIN" })
	public Vol update(@RequestBody Vol o){
		logger.info("VolService:update()");
		return volMetier.update(o);		
	}

	@RequestMapping(value="/vol" , method=RequestMethod.DELETE )
	//@Secured(value = { "ROLE_ADMIN" })
	public String delete(@RequestParam Long id){
		logger.info("VolService:delete()");
		return volMetier.delete(id);
	}
	
	@RequestMapping(value="/vol/{id}" , method=RequestMethod.GET )
	public Vol findOne(@PathVariable Long id){
		logger.info("VolService:findOne()");
		return volMetier.findOne(id);
	}
}
