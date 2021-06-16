package gr.uoa.di.pcomp.IncludingRESTAPI.controllers;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.hibernate.MappingNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import gr.uoa.di.pcomp.IncludingRESTAPI.controllers.requests.ExperimentExecutionRequest;
import gr.uoa.di.pcomp.IncludingRESTAPI.controllers.requests.ReservationItemRequest;
import gr.uoa.di.pcomp.IncludingRESTAPI.controllers.requests.ReservationRequest;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.DdlScript;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.Experiment;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.ExperimentExecution;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.ExperimentStatusLut;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.Reservation;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.ReservationItem;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.User;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.projection.ExperimentExecutionProjection;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.projection.ExperimentProjection;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.projection.ExperimentScript;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.projection.ExperimentStatusProjection;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.projection.ExperimentVersions;
import gr.uoa.di.pcomp.IncludingRESTAPI.repository.DdlScriptRepository;
import gr.uoa.di.pcomp.IncludingRESTAPI.repository.ExperimentExecutionRepository;
import gr.uoa.di.pcomp.IncludingRESTAPI.repository.ExperimentRepository;
import gr.uoa.di.pcomp.IncludingRESTAPI.repository.ExperimentStatusRepository;
import gr.uoa.di.pcomp.IncludingRESTAPI.repository.UserRepository;

@RestController
class ExperimentController {

	private final ExperimentRepository repository;
	private final ExperimentExecutionRepository executionRepository;
	private final ExperimentStatusRepository experimentStatusRepository;
	private final DdlScriptRepository ddlRepository;
	private final UserRepository userRepository;

	ExperimentController(ExperimentRepository repository,ExperimentExecutionRepository executionRepository,ExperimentStatusRepository experimentStatusRepository, DdlScriptRepository ddlRepository, UserRepository userRepository) {
		this.repository = repository;
		this.executionRepository = executionRepository;
		this.experimentStatusRepository = experimentStatusRepository;
		this.ddlRepository = ddlRepository;
		this.userRepository = userRepository;
	}

	// Aggregate root

	@GetMapping("/experiments")
	List<Experiment> all() {
		return repository.findAll();
	}

	@GetMapping("/experimentByUserId/{userId}")
	List<Experiment> allByUserId(@PathVariable Integer userId) {
		return repository.findAllByUserUserId(userId);
	}

	@GetMapping("/experimentVersionsByUserId/{userId}")
	List<ExperimentVersions> allVersionsByUserId(@PathVariable Integer userId) {
		return repository.findVersionsAllByUserUserId(userId);
	}

	@GetMapping("/experimentScriptByVersion/{version}")
	ExperimentScript scriptByVersion(@PathVariable String version) {
		return repository.getByExperimentVersion(version);
	}

	@PostMapping("/experiments")
	Experiment newExperiment(@RequestBody Experiment newExperiment) {
		return repository.save(newExperiment);
		// return experimentService.save(newExperiment);

	}
	
	@PutMapping("/saveScriptByVersionAndUserId/{experimentVersion}/{userId}")
	Experiment newDdlRealScript(@RequestBody DdlScript ddlScript, @PathVariable String experimentVersion, @PathVariable Integer userId) {
		//DdlScript script = repository.getExpByExperimentVersion(experimentVersion).getDdlScript();
		
		return repository.findByExperimentVersionAndUserUserId(experimentVersion, userId).map(experiment -> {
			experiment.getDdlScript().setRealScriptContent(ddlScript.getRealScriptContent());

			return repository.save(experiment);
		}).orElseGet(() -> {
			Experiment experiment = new Experiment();
			DdlScript ddlScript2 = new DdlScript();
			experiment.setExperimentVersion(experimentVersion);
			experiment.setDdlScript(ddlScript2);
			return repository.save(experiment);
		});
	}
	
	@PostMapping("/saveScriptContentByVersionAndUserName/{experimentVersion}/{userName}")
	Experiment newDdlScriptContent(@RequestBody String ddlScript, @PathVariable String experimentVersion, @PathVariable String userName) {
		//DdlScript script = repository.getExpByExperimentVersion(experimentVersion).getDdlScript();
		
		return repository.findByExperimentVersionAndUserUsername(experimentVersion, userName).map(experiment -> {
			experiment.getDdlScript().setScriptContent(ddlScript);
			return repository.save(experiment);
		}).orElseGet(() -> {
			Experiment newExperiment = new Experiment();
			DdlScript newScript = new DdlScript();
			User user = userRepository.getUserByUsername(userName);
			newScript.setScriptContent(ddlScript);
			newExperiment.setExperimentVersion(experimentVersion);
			newExperiment.setUser(user);
			newExperiment.setDdlScript(newScript);
			return repository.save(newExperiment);
		});
	}
	
	//@CrossOrigin
	@GetMapping("/experimentVersionByUserName/{userName}")
	List<ExperimentVersions> getVersionsByUsername(@PathVariable String userName) {
		return repository.findVersionsAllByUserUsername(userName)
		// .orElseThrow(() -> new MeetingDoesNotExistException(id));
		;
	}
	
    //@CrossOrigin
	@GetMapping("/getScriptByVersionAndUserName/{experimentVersion}/{userName}")
	ExperimentScript getScriptContentByVersionAndUserName( @PathVariable String experimentVersion, @PathVariable String userName) {
		return repository.getByExperimentVersionAndUserUsername(experimentVersion,userName)
		// .orElseThrow(() -> new MeetingDoesNotExistException(id));
		;
	}

	// Single item

	@GetMapping("/experiments/{id}")
	Optional<Experiment> one(@PathVariable Integer id) {

		return repository.findById(id)
		// .orElseThrow(() -> new MeetingDoesNotExistException(id));
		;
	}
	
	@GetMapping("/experiment/{experimentId}")
	ExperimentProjection getExperimentById(@PathVariable Integer experimentId) {
		return repository.getProjectedByExperimentId(experimentId);
	}
	
	@GetMapping("/experimentByExecutionId/{experimentExecutionId}")
	ExperimentProjection getExperimentByExecutionId(@PathVariable Integer experimentExecutionId) {
		return repository.getByExperimentExecutionsExperimentExecutionId(experimentExecutionId);
	}
	
	@GetMapping("/executionsByExperimentId/{experimentId}")
	List<ExperimentExecutionProjection> getExperimentExecutionByExperimentId(@PathVariable Integer experimentId) {
		return executionRepository.getAllByExperimentExperimentId(experimentId);
	}
	
	@GetMapping("/executionsByStatusId/{statusId}")
	List<ExperimentExecutionProjection> getExperimentExecutionByStatusId(@PathVariable Integer statusId) {
		return executionRepository.getAllByExperimentExperimentStatusLutExperimentStatusId(statusId);
	}
	
	@GetMapping("/executionById/{experimentId}")
	ExperimentExecutionProjection getExperimentExecutionById(@PathVariable Integer experimentId) {
		return executionRepository.findByExperimentExecutionId(experimentId);
	}
	
	@GetMapping("/experimentStatusById/{statusId}")
	ExperimentStatusProjection getExperimentStatusById(@PathVariable Integer statusId) {
		return  experimentStatusRepository.getByExperimentStatusId(statusId);
	}
	
	
	@GetMapping("/experimentStatusByName/{status}")
	ExperimentStatusProjection getExperimentStatusById(@PathVariable String status) {
		return  experimentStatusRepository.getByExperimentStatusDescr(status);
	}
	
	@PostMapping("/saveExperimentExecution")
	@ResponseBody
	ExperimentExecution newExperimentExecution(@RequestBody ExperimentExecutionRequest newExperimentExecution) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime startExecution = LocalDateTime.parse(newExperimentExecution.getStartExecution(), formatter);
		LocalDateTime endExecution = LocalDateTime.parse(newExperimentExecution.getEndExecution(), formatter);
		ExperimentExecution experimentExecution = new ExperimentExecution(startExecution, endExecution, newExperimentExecution.getExperimentStatus(), repository.getOne(newExperimentExecution.getExperimentId()));
	    return executionRepository.save(experimentExecution);
	}
	
	

	@PutMapping("/experiments/{name}")
	Experiment replaceExperiment(@RequestBody Experiment newExperiment, @PathVariable Integer id) {

		return repository.findById(id).map(experiment -> {
			experiment.setExperimentName(newExperiment.getExperimentName());
			experiment.setExperimentVersion(newExperiment.getExperimentVersion());
			return repository.save(experiment);
		}).orElseGet(() -> {
			newExperiment.setExperimentId(id);
			return repository.save(newExperiment);
		});
	}

	@DeleteMapping("/experiments/{id}")
	void deleteExperiment(@PathVariable Integer id) {
		repository.deleteById(id);
	}
}