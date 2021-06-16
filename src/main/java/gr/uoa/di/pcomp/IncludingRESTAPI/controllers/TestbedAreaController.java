package gr.uoa.di.pcomp.IncludingRESTAPI.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import gr.uoa.di.pcomp.IncludingRESTAPI.model.projection.ObstacleProjection;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.projection.TestbedAreaProjection;
import gr.uoa.di.pcomp.IncludingRESTAPI.repository.TestbedAreaRepository;
import gr.uoa.di.pcomp.IncludingRESTAPI.utils.Runner;
import gr.uoa.di.pcomp.IncludingRESTAPI.views.View;

@RestController
public class TestbedAreaController {
	private final TestbedAreaRepository repository;
	private Runner validator;

	TestbedAreaController(TestbedAreaRepository repository) {
		this.repository = repository;
		 validator =  new Runner();
	}

	@GetMapping("/testbedAreas")
	List<TestbedAreaProjection> allTestbedAreas() {
		return repository.findAllProjectedBy();
	}

	@GetMapping("/testbedArea/{id}")
	Optional<TestbedAreaProjection> getTestbedAreaById(@PathVariable Integer id) {
		return repository.findProjectedByTestbedAreaId(id);
		// .orElseThrow(() -> new MeetingDoesNotExistException(id));
	}

	@GetMapping("/testbedAreaIndoorByName/{name}")
	@JsonView(value = {View.TestbedAreaView.TestbedAreaIsIndoor.class })
	TestbedAreaProjection getIndoorByTestbedName(@PathVariable String name) {
		return repository.findTestbedAreaByName(name);
		// .orElseThrow(() -> new MeetingDoesNotExistException(id));
	}
	
	@GetMapping("/testbedAreaPolygonAndid/{name}")
	@JsonView(value = {View.TestbedAreaView.TestbedAreaPolygonAndId.class})
	TestbedAreaProjection getPolygonByTestbedName(@PathVariable String name) {
		return repository.findTestbedAreaByName(name);//findPolygonTestbedAreaByName(name);
		// .orElseThrow(() -> new MeetingDoesNotExistException(id));
	}

	@GetMapping("/testbedAreaObstacles/{name}")
	@JsonView(value = {View.TestbedAreaView.TestbedAreaObstacles.class })
	TestbedAreaProjection getObstaclesByName(@PathVariable String name) {
		return repository.findTestbedAreaByName(name);
		// .orElseThrow(() -> new MeetingDoesNotExistException(id));
	}
	
	@GetMapping("/testbedAreaLocation/{name}")
	@JsonView(value = {View.TestbedAreaView.TestbedAreaLocation.class })
	TestbedAreaProjection getLocationByName(@PathVariable String name) {
		return repository.findTestbedAreaByName(name);
		// .orElseThrow(() -> new MeetingDoesNotExistException(id));
	}
	
	@GetMapping("/isPointInsideTestbedArea/{location}/{name}")
	@JsonView(value = { View.TestbedAreaView.TestbedAreaPolygonAndId.class })
	Boolean getPointInsideArea(@PathVariable String name, @PathVariable String location) {
		//////////Oi axrhstoi den exoyn apofasisei ti einai long/lat h lat/long opote edw allazei kata peristasi//////////////
		Double longitude = Double.parseDouble(location.split(",")[0]);
		Double latitude = Double.parseDouble(location.split(",")[1]);
		Boolean decision = false;
		if (!repository.findTestbedAreaByName(name).getArea().isEmpty()) {
			decision = validator.coordinate_is_inside_polygon(Arrays.asList(repository.findTestbedAreaByName(name).getArea().replaceAll("[()]", "").split(",")),latitude, longitude);
		}
		return decision;
	}
	
	@GetMapping("/isPointInsideObstacle/{location}/{name}")
	@JsonView(value = { View.TestbedAreaView.TestbedAreaPolygonAndId.class })
	Boolean getPointInsideObstacle(@PathVariable String name, @PathVariable String location) {
		////////// Oi axrhstoi den exoyn apofasisei ti einai long/lat h lat/long opote
		////////// edw allazei kata peristasi//////////////
		Double longitude = Double.parseDouble(location.split(",")[0]);
		Double latitude = Double.parseDouble(location.split(",")[1]);
		Boolean decision = false;
		if (!repository.findTestbedAreaByName(name).getObstacles().isEmpty()) {
			for (ObstacleProjection obstacle : repository.findTestbedAreaByName(name).getObstacles()) {
				if(validator.coordinate_is_inside_polygon(Arrays.asList(obstacle.getObstacle().replaceAll("[()]", "").split(",")), latitude, longitude) || decision)
					decision = true;
			}
		}
		return decision;
	}

}
