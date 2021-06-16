package gr.uoa.di.pcomp.IncludingRESTAPI.controllers;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import gr.uoa.di.pcomp.IncludingRESTAPI.model.projection.TestbedProjection;
import gr.uoa.di.pcomp.IncludingRESTAPI.repository.TestbedRepository;
import gr.uoa.di.pcomp.IncludingRESTAPI.views.View;

@RestController
public class TestbedController {
	private final TestbedRepository repository;

	TestbedController(TestbedRepository repository) {
		this.repository = repository;
	}
	@GetMapping("/testbeds")
	  List<TestbedProjection> allTestbeds() {
	    return repository.findAllProjectedBy();
	  }
	
	@GetMapping("/testbedByName/{name}")
	TestbedProjection getTestbedByName(@PathVariable String name) {
		return repository.findByName(name);
				  //.orElseThrow(() -> new MeetingDoesNotExistException(id));	
	}

	@GetMapping("/testbed/location/{name}")
	@JsonView(value = { View.TestbedView.TestbedLocation.class})
	TestbedProjection getTestbedLocationByName(@PathVariable String name) {
		return repository.findByName(name);
				  //.orElseThrow(() -> new MeetingDoesNotExistException(id));	
	}
	
	@GetMapping("/testbed/{testbedId}")
	Optional<TestbedProjection> getTestbedById(@PathVariable Integer testbedId) {
		return repository.findProjectionByTestbedId(testbedId);
				  //.orElseThrow(() -> new MeetingDoesNotExistException(id));
		
	}
	@GetMapping("/testbed/{operationStartTimeString}/{operationEndTimeString}")

	Optional<TestbedProjection> getTestbedByTime(@PathVariable String operationStartTimeString, @PathVariable String operationEndTimeString) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalTime operationStartTime = LocalTime.parse(operationStartTimeString, formatter);
		LocalTime operationEndTime = LocalTime.parse(operationEndTimeString, formatter);
		return repository.findByOperationStartTimeGreaterThanEqualAndOperationEndTimeLessThanEqual(operationStartTime,operationEndTime);
				  //.orElseThrow(() -> new MeetingDoesNotExistException(id));
		
	}
	@GetMapping("/testbed/{operationStartTimeString}/{operationEndTimeString}/{testbedId}")
	Optional<TestbedProjection> getTestbedByTimeAndId(@PathVariable String operationStartTimeString, @PathVariable String operationEndTimeString, @PathVariable Integer testbedId) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalTime operationStartTime = LocalTime.parse(operationStartTimeString, formatter);
		LocalTime operationEndTime = LocalTime.parse(operationEndTimeString, formatter);
		return repository.findByOperationStartTimeGreaterThanEqualAndOperationEndTimeLessThanEqualAndTestbedIdEquals(operationStartTime,operationEndTime,testbedId);
				  //.orElseThrow(() -> new MeetingDoesNotExistException(id));
		
	}

}
