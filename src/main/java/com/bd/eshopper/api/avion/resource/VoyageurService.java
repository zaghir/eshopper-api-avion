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

import com.bd.eshopper.api.avion.entity.Voyageur;
import com.bd.eshopper.api.avion.service.VoyageurMetier;

@RestController
@RequestMapping("/api/avion")
public class VoyageurService {

	@Autowired
	private VoyageurMetier voyageurMetier;

	private static Logger logger = LoggerFactory.getLogger(VoyageurService.class);

	@RequestMapping(value = "/voyageur", method = RequestMethod.GET)
	@ResponseBody
	public List<Voyageur> getAll() {
		logger.info("VoyageurService:getAll()");
		return voyageurMetier.getAll();
	}

	@RequestMapping(value = "/voyageur", method = RequestMethod.POST)
	// @Secured(value = { "ROLE_ADMIN" })
	public Voyageur save(@RequestBody Voyageur o) {
		logger.info("VoyageurService:save()");
		return voyageurMetier.save(o);
	}

	@RequestMapping(value = "/voyageur", method = RequestMethod.PUT)
	// @Secured(value = { "ROLE_ADMIN" })
	public Voyageur update(@RequestBody Voyageur o) {
		logger.info("VoyageurService:update()");
		return voyageurMetier.update(o);
	}

	@RequestMapping(value = "/voyageur", method = RequestMethod.DELETE)
	// @Secured(value = { "ROLE_ADMIN" })
	public String delete(@RequestParam Long id) {
		logger.info("VoyageurService:delete()");
		return voyageurMetier.delete(id);
	}

	@RequestMapping(value = "/voyageur/{id}", method = RequestMethod.GET)
	public Voyageur findOne(@PathVariable Long id) {
		logger.info("VoyageurService:findOne()");
		return voyageurMetier.findOne(id);
	}
}
