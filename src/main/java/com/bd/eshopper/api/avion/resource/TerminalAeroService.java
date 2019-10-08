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

import com.bd.eshopper.api.avion.entity.TerminalAero;
import com.bd.eshopper.api.avion.service.TerminalAeroMetier;

@RestController
@RequestMapping("/api/avion")
public class TerminalAeroService {

	@Autowired
	private TerminalAeroMetier terminalAeroMetier;

	private static Logger logger = LoggerFactory.getLogger(TerminalAeroService.class);

	@RequestMapping(value = "/terminalAero", method = RequestMethod.GET)
	@ResponseBody
	public List<TerminalAero> getAll() {
		logger.info("TerminalAeroService:getAll()");
		return terminalAeroMetier.getAll();
	}

	@RequestMapping(value = "/terminalAero", method = RequestMethod.POST)
	// @Secured(value = { "ROLE_ADMIN" })
	public TerminalAero save(@RequestBody TerminalAero o) {
		logger.info("TerminalAeroService:save()");
		return terminalAeroMetier.save(o);
	}

	@RequestMapping(value = "/terminalAero", method = RequestMethod.PUT)
	// @Secured(value = { "ROLE_ADMIN" })
	public TerminalAero update(@RequestBody TerminalAero o) {
		logger.info("TerminalAeroService:update()");
		return terminalAeroMetier.update(o);
	}

	@RequestMapping(value = "/terminalAero", method = RequestMethod.DELETE)
	// @Secured(value = { "ROLE_ADMIN" })
	public String delete(@RequestParam Long id) {
		logger.info("TerminalAeroService:detele()");
		return terminalAeroMetier.delete(id);
	}

	@RequestMapping(value = "/terminalAero/{id}", method = RequestMethod.GET)
	public TerminalAero findOne(@PathVariable Long id) {
		logger.info("TerminalAeroService:findOne()");
		return terminalAeroMetier.findOne(id);
	}
}
