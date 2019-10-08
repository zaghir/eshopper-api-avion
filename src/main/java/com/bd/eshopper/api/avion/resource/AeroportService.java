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

import com.bd.eshopper.api.avion.entity.Aeroport;
import com.bd.eshopper.api.avion.service.AeroportMetier;

@RestController
@RequestMapping("/api/avion")
public class AeroportService {

	@Autowired
	private AeroportMetier aeroportService;

	private static Logger logger = LoggerFactory.getLogger(AeroportService.class);

	@RequestMapping(value = "/aeroport", method = RequestMethod.GET)
	@ResponseBody
	public List<Aeroport> getAll() {
		logger.info("AeroportService:getAll()");
		return aeroportService.getAll();
	}

	@RequestMapping(value = "/aeroport", method = RequestMethod.POST)
	// @Secured(value = { "ROLE_ADMIN" })
	public Aeroport save(@RequestBody Aeroport o) {
		logger.info("AeroportService:save()");
		return aeroportService.save(o);
	}

	@RequestMapping(value = "/aeroport", method = RequestMethod.PUT)
	// @Secured(value = { "ROLE_ADMIN" })
	public Aeroport update(@RequestBody Aeroport o) {
		logger.info("AeroportService:update()");
		return aeroportService.update(o);
	}

	@RequestMapping(value = "/aeroport", method = RequestMethod.DELETE)
	// @Secured(value = { "ROLE_ADMIN" })
	public Long delete(@RequestParam Long id) {
		logger.info("AeroportService:delete()");
		return aeroportService.delete(id);
	}

	@RequestMapping(value = "/aeroport/{id}", method = RequestMethod.GET)
	public Aeroport findOne(@PathVariable Long id) {
		logger.info("AeroportService:findOne()");
		return aeroportService.findOne(id);
	}

}
