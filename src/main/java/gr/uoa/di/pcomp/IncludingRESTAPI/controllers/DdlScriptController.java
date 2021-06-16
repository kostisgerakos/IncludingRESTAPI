package gr.uoa.di.pcomp.IncludingRESTAPI.controllers;


import java.util.List;
import java.util.Optional;

import org.hibernate.MappingNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import gr.uoa.di.pcomp.IncludingRESTAPI.model.DdlScript;
import gr.uoa.di.pcomp.IncludingRESTAPI.repository.DdlScriptRepository;


@RestController
class DdlScriptController {
	/*
	 * @Autowired private IDdlScriptService ddlScriptService;
	 */

	private final DdlScriptRepository repository;

	DdlScriptController(DdlScriptRepository repository) {
		this.repository = repository;
	}

	// Aggregate root

	@GetMapping("/ddlScripts")
	List<DdlScript> all() {
		return repository.findAll();
	}

	@PostMapping("/ddlScripts")
	DdlScript newDdlScript(@RequestBody DdlScript newDdlScript) {
		return repository.save(newDdlScript);
	}

	// Single item

	@GetMapping("/ddlScripts/{id}")
	Optional<DdlScript> one(@PathVariable Integer id) {

		return repository.findById(id)
				  //.orElseThrow(() -> new MeetingDoesNotExistException(id));
		;
	}

	
	/*
	 * @PutMapping("/ddlScripts/{id}") DdlScript replaceDdlScript(@RequestBody
	 * DdlScript newDdlScript, @PathVariable Integer id) {
	 * 
	 * return repository.findById(id).map(ddlScript -> {
	 * ddlScript.setScriptContent(newDdlScript.getScriptContent());
	 * ddlScript.setDdlScriptDescription(newDdlScript.getDdlScriptDescription());
	 * return repository.save(ddlScript); }).orElseGet(() -> {
	 * newDdlScript.setDdlScriptId(id); return repository.save(newDdlScript); }); }
	 */

	@DeleteMapping("/ddlScripts/{id}")
	void deleteDdlScript(@PathVariable Integer id) {
		repository.deleteById(id);
	}
}
