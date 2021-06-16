package gr.uoa.di.pcomp.IncludingRESTAPI.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import gr.uoa.di.pcomp.IncludingRESTAPI.model.UxV;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.projection.ResourceProjection;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.projection.UxVSensorProjection;
import gr.uoa.di.pcomp.IncludingRESTAPI.repository.resources.EquipmentRepository;
import gr.uoa.di.pcomp.IncludingRESTAPI.repository.resources.OperatorRepository;
import gr.uoa.di.pcomp.IncludingRESTAPI.repository.resources.ResourceRepository;
import gr.uoa.di.pcomp.IncludingRESTAPI.repository.resources.SensorRepository;
import gr.uoa.di.pcomp.IncludingRESTAPI.repository.resources.UxVRepository;
import gr.uoa.di.pcomp.IncludingRESTAPI.repository.resources.UxVSensorRepository;
import gr.uoa.di.pcomp.IncludingRESTAPI.views.View;

@RestController
public class ResourceController {
	private final ResourceRepository repository;
	private final SensorRepository sensorRepository;
	private final OperatorRepository operatorRepository;
	private final UxVRepository uxvrepository;
	private final UxVSensorRepository uxvSensorRepository;
	private final EquipmentRepository equipmentRepository;


	public ResourceController(ResourceRepository repository, SensorRepository sensorRepository,
			OperatorRepository operatorRepository, UxVRepository uxvrepository, UxVSensorRepository uxvSensorRepository,
			EquipmentRepository equipmentRepository) {
		super();
		this.repository = repository;
		this.sensorRepository = sensorRepository;
		this.operatorRepository = operatorRepository;
		this.uxvrepository = uxvrepository;
		this.uxvSensorRepository = uxvSensorRepository;
		this.equipmentRepository = equipmentRepository;
	}

	@GetMapping("/resources")
	@JsonView(value = View.ResourceView.Resource.class)
	List<ResourceProjection> allResources() {
		return repository.findAllProjectedBy();
	}

	@GetMapping("/resource/{id}")
	@JsonView(value = View.ResourceView.Resource.class)
	ResourceProjection resourceById(@PathVariable Integer id) {
		return repository.findProjectedByResourceId(id);
	}
	
	@GetMapping("/resourcesByTestbedId/{testbedId}")
	@JsonView(value = View.ResourceView.Resource.class)
	List<ResourceProjection> resourceByTestbedId(@PathVariable Integer testbedId) {
		return repository.findAllByTestbedAreaTestbedTestbedId(testbedId);
	}
	
	@GetMapping("/resourcesByTestbedAreaId/{testbedAreaId}")
	@JsonView(value = View.ResourceView.Resource.class)
	List<ResourceProjection> resourceByTestbedAreaId(@PathVariable Integer testbedId) {
		return repository.findAllByTestbedAreaTestbedAreaId(testbedId);
	}

	@GetMapping("/resourceByName/{name}")
	@JsonView(value = View.ResourceView.Resource.class)
	Optional<ResourceProjection> resourceByName(@PathVariable String name) {
		return repository.findResourceByResourceName(name);
	}

	@GetMapping("/resourceIdByName/{name}")
	@JsonView(value = View.ResourceView.ResourceId.class)
	List<ResourceProjection> getResourceIdByName(@PathVariable String name) {

		return repository.findByResourceName(name);
		// .orElseThrow(() -> new MeetingDoesNotExistException(id));
	}
	
	@GetMapping("/sensorsOfUxV/{id}")
	List<String> sensorsOfUxV(@PathVariable Integer id) {
		List<String> sensorList = new ArrayList<String>();
		for (UxVSensorProjection sensor : uxvSensorRepository.findAllByUxvResourceId(id)) {
			sensorList.add(sensor.getSensorName());
		}
		return sensorList;
		// UxV uxv = uxvrepository.findByResourceId(id);
		// return uxv.getAvailableSensors() != null ?
		// Arrays.asList(uxv.getAvailableSensors().split(",")) : null;
	}
	
	//////////////////////////////////SubTypes
	@GetMapping("/sensors")
	@JsonView(value = View.ResourceView.Sensor.class)
	List<ResourceProjection> allSensors() {
		return sensorRepository.findAllProjectedBy();
	}

	@GetMapping("/sensor/{id}")
	@JsonView(value = View.ResourceView.Sensor.class)
	ResourceProjection sensorById(@PathVariable Integer id) {
		return sensorRepository.findProjectedByResourceId(id);
	}
	@GetMapping("/operators")
	@JsonView(value = View.ResourceView.Operator.class)
	List<ResourceProjection> allOperators() {
		return operatorRepository.findAllProjectedBy();
	}

	@GetMapping("/operator/{id}")
	@JsonView(value = View.ResourceView.Operator.class)
	ResourceProjection operatorById(@PathVariable Integer id) {
		return operatorRepository.findProjectedByResourceId(id);
	}
	@GetMapping("/uxv")
	@JsonView(value = View.ResourceView.UxV.class)
	List<ResourceProjection> allUxVs() {
		return uxvrepository.findAllProjectedBy();
	}

	@GetMapping("/uxv/{id}")
	@JsonView(value = View.ResourceView.UxV.class)
	ResourceProjection uxvById(@PathVariable Integer id) {
		return uxvrepository.findProjectedByResourceId(id);
	}
	@GetMapping("/equipment")
	@JsonView(value = View.ResourceView.Equipment.class)
	List<ResourceProjection> allEquipment() {
		return equipmentRepository.findAllProjectedBy();
	}
	@GetMapping("/equipment/{id}")
	@JsonView(value = View.ResourceView.Equipment.class)
	ResourceProjection equipmentById(@PathVariable Integer id) {
		return equipmentRepository.findProjectedByResourceId(id);
	}	

}
