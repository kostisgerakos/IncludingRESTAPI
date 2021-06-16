package gr.uoa.di.pcomp.IncludingRESTAPI.controllers;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.hibernate.MappingNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import gr.uoa.di.pcomp.IncludingRESTAPI.controllers.requests.ReservationItemRequest;
import gr.uoa.di.pcomp.IncludingRESTAPI.controllers.requests.ReservationRequest;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.DdlScript;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.Reservation;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.ReservationItem;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.projection.ObstacleProjection;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.projection.ReservationItemProjection;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.projection.ReservationProjection;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.projection.ReservationProjectionCustom;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.projection.ReservationStatusProjection;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.projection.UxVSensorProjection;
import gr.uoa.di.pcomp.IncludingRESTAPI.repository.ReservationItemRepository;
import gr.uoa.di.pcomp.IncludingRESTAPI.repository.ReservationRepository;
import gr.uoa.di.pcomp.IncludingRESTAPI.repository.ReservationStatusRepository;
import gr.uoa.di.pcomp.IncludingRESTAPI.repository.TestbedAreaRepository;
import gr.uoa.di.pcomp.IncludingRESTAPI.repository.UserRepository;
import gr.uoa.di.pcomp.IncludingRESTAPI.repository.resources.ResourceRepository;
import gr.uoa.di.pcomp.IncludingRESTAPI.repository.resources.SensorRepository;
import gr.uoa.di.pcomp.IncludingRESTAPI.repository.resources.UxVRepository;
import gr.uoa.di.pcomp.IncludingRESTAPI.repository.resources.UxVSensorRepository;
import gr.uoa.di.pcomp.IncludingRESTAPI.views.View;
import gr.uoa.di.pcomp.IncludingRESTAPI.views.custom.CustomBookedTestbedResponse;
import gr.uoa.di.pcomp.IncludingRESTAPI.views.custom.CustomTestbedAreasResponse;
import gr.uoa.di.pcomp.IncludingRESTAPI.views.custom.DefinedWayPoint;
import gr.uoa.di.pcomp.IncludingRESTAPI.views.custom.ReservationTimestamps;
import gr.uoa.di.pcomp.IncludingRESTAPI.views.custom.CustomBookedResourcesResponse;

@RestController
class ReservationController {

	private final ReservationRepository repository;
	private final ReservationStatusRepository statusRepository;
	private final TestbedAreaRepository testbedAreaRepository;
	private final SensorRepository sensorRepository;
	private final UxVRepository uxvRepository;
	private final UxVSensorRepository uxvSensorRepository;
	private final UserRepository userRepository;
	private final ResourceRepository resourceRepository;
	private final ReservationItemRepository reservationItemRepository;

	/*
	 * @GetMapping("/reservations") List<ReservationProjection> all() { 
	 * return repository.findAllProjectedBy(); }
	 */


	public ReservationController(ReservationRepository repository, ReservationStatusRepository statusRepository,
			TestbedAreaRepository testbedAreaRepository, SensorRepository sensorRepository, UxVRepository uxvRepository, UxVSensorRepository uxvSensorRepository,
			UserRepository userRepository, ResourceRepository resourceRepository, ReservationItemRepository reservationItemRepository) {
		super();
		this.repository = repository;
		this.statusRepository = statusRepository;
		this.testbedAreaRepository = testbedAreaRepository;
		this.sensorRepository = sensorRepository;
		this.uxvRepository = uxvRepository;
		this.uxvSensorRepository = uxvSensorRepository;
		this.userRepository = userRepository;
		this.resourceRepository = resourceRepository;
		this.reservationItemRepository = reservationItemRepository;
	}

	@GetMapping("/reservations/{validFromString}/{validUntilString}")
	List<ReservationProjection> findBetween(@PathVariable String validFromString,
			@PathVariable String validUntilString) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime validFrom = LocalDateTime.parse(validFromString, formatter);
		LocalDateTime validUntil = LocalDateTime.parse(validUntilString, formatter);
		return repository.findAllByValidFromGreaterThanEqualAndValidUntilLessThanEqual(validFrom, validUntil);
	}
	
	/*@GetMapping("/reservations")
	List<ReservationProjection> findBetween(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime validFrom,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime  validUntil) {
		return repository.findAllByValidFromGreaterThanEqualAndValidUntilLessThanEqual(validFrom, validUntil);
	}*/
	
	@GetMapping("/reservations/{validFromString}/{validUntilString}/{reservationStatus}/{username}/{testbedAreaId}")
	List<ReservationProjection> findBetweenDatesUserArea(@PathVariable String validFromString,  @PathVariable String validUntilString, @PathVariable String reservationStatus,@PathVariable String username,@PathVariable Integer testbedAreaId) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime validFrom = LocalDateTime.parse(validFromString, formatter);
		LocalDateTime validUntil = LocalDateTime.parse(validUntilString, formatter);
		return repository.findAllDistinctByValidFromGreaterThanEqualAndValidUntilLessThanEqualAndReservationStatusReservationStatusEqualsAndUserUsernameIsAndTestbedAreaTestbedAreaIdEquals(validFrom, validUntil, reservationStatus, username, testbedAreaId);
	}
	
	@GetMapping("/reservations/{validFromString}/{validUntilString}/{reservationStatus}/{username}")
	List<ReservationProjection> findBetweenDatesUserArea(@PathVariable String validFromString,  @PathVariable String validUntilString, @PathVariable String reservationStatus,@PathVariable String username) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime validFrom = LocalDateTime.parse(validFromString, formatter);
		LocalDateTime validUntil = LocalDateTime.parse(validUntilString, formatter);
		return repository.findAllDistinctByValidFromGreaterThanEqualAndValidUntilLessThanEqualAndReservationStatusReservationStatusEqualsAndUserUsernameIs(validFrom, validUntil, reservationStatus, username);
	}
	
	@GetMapping("/reservationsByStatusArea/{validFromString}/{validUntilString}/{reservationStatus}/{testbedAreaId}")
	List<ReservationProjection> findBetweenDatesUserArea(@PathVariable String validFromString,  @PathVariable String validUntilString, @PathVariable String reservationStatus,@PathVariable Integer testbedAreaId) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime validFrom = LocalDateTime.parse(validFromString, formatter);
		LocalDateTime validUntil = LocalDateTime.parse(validUntilString, formatter);
		return repository.findAllDistinctByValidFromGreaterThanEqualAndValidUntilLessThanEqualAndReservationStatusReservationStatusEqualsAndTestbedAreaTestbedAreaIdEquals(validFrom, validUntil, reservationStatus, testbedAreaId);
	}

	// Single item
	@GetMapping("/reservation/{reservationId}")
	ReservationProjection one(@PathVariable Integer reservationId) {
		return repository.findByReservationId(reservationId);
	}
	
	@GetMapping("/reservationsByStatus/{reservationStatus}")
	List<ReservationProjection> findByStatus(@PathVariable String reservationStatus) {
		return repository.findAllByReservationStatusReservationStatus(reservationStatus);
	}
	
	@GetMapping("/reservationsByUser/{username}")
	List<ReservationProjection> findReservationsByUsername(@PathVariable String username) {
		return repository.findAllByUserUsername(username);
	}
	
	@GetMapping("/reservationByTimestamp/{username}/{testbedAreaName}/{validFromDateString}/{validFromTimeString}")
	ReservationTimestamps findReservationsByUsernameAndTestbedArea(@PathVariable String username,
			@PathVariable String testbedAreaName, @PathVariable String validFromDateString,
			@PathVariable String validFromTimeString) {
		DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		DateTimeFormatter timeformatter = DateTimeFormatter.ofPattern("HH:mm");

		LocalDate validFromDate = LocalDate.parse(validFromDateString, dateformatter);
		LocalTime validFromTime = LocalTime.parse(validFromTimeString, timeformatter);

		LocalDateTime validFrom = LocalDateTime.of(validFromDate.getYear(), validFromDate.getMonth(),
				validFromDate.getDayOfMonth(), validFromTime.getHour(), validFromTime.getMinute(), 0);
		ReservationProjection reservation = repository
				.findCustomByUserUsernameIsAndTestbedAreaNameIsAndValidFromLessThanEqualAndValidUntilGreaterThanEqual(
						username, testbedAreaName, validFrom, validFrom);
		ReservationTimestamps response = null;
		if (reservation != null) {
			response = new ReservationTimestamps(reservation.getReservationId(),
					reservation.getValidFrom().format(dateformatter),reservation.getValidFrom().format(timeformatter),
					reservation.getValidUntil().format(dateformatter),reservation.getValidUntil().format(timeformatter));
		}
		return response;
	}
	///////////////////////////////////////////////////////CUSTOM RESPONSES FOR THOSE THAT ARE UNABLE//////////////////////////////////////////////////////////////////////
	@GetMapping("/reservationsCustom")
	//@JsonView(value = View.ResourceView.Resource.class)
	List<ReservationProjectionCustom> findReservationsByUserUser() {
		return repository.findAllCustomProjectedBy();
	}
	
/*	@GetMapping("/reservationsCustomByTest/{username}/{testbedAreaName}/{validFromDateString}/{validFromTimeString}")
	List<ReservationProjectionCustom> findReservationsByUserUser(@PathVariable String username,
			@PathVariable String testbedAreaName, @PathVariable String validFromDateString,
			@PathVariable String validFromTimeString) {
		
		DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		DateTimeFormatter timeformatter = DateTimeFormatter.ofPattern("HH:mm");

		LocalDate validFromDate = LocalDate.parse(validFromDateString, dateformatter);
		LocalTime validFromTime = LocalTime.parse(validFromTimeString, timeformatter);
		LocalDateTime validFrom = LocalDateTime.of(validFromDate.getYear(), validFromDate.getMonth(),
				validFromDate.getDayOfMonth(), validFromTime.getHour(), validFromTime.getMinute(), 0);
		
		System.out.println("User is" + username);
		System.out.println("User is" + testbedAreaName);

		System.out.println("User is" + validFrom);
		
		  String now = "2021-06-20 15:00:00";
		System.out.println("User is" + validFrom);

	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	        validFrom = LocalDateTime.parse(now, formatter);
			System.out.println("User is" + validFrom);


		List<ReservationProjectionCustom> findAllByUserUsername = repository.findAllCustomByUserUsernameIsAndTestbedAreaNameIs(username,testbedAreaName);
				//.findCustomByUserUsernameIsAndTestbedAreaNameIsAndValidFromEquals(username, testbedAreaName, validFrom);
		return findAllByUserUsername;
	}*/
	@GetMapping("/INCLUDINGREST/rest/testbeds/{username}")
	List<CustomBookedTestbedResponse> findReservationsByUserUser(@PathVariable String username) {
		return Arrays.asList(new CustomBookedTestbedResponse(repository.findAllCustomByUserUsername(username)));
	}

	@GetMapping("/INCLUDINGREST/rest/testbedarea/{username}")
	List<CustomTestbedAreasResponse> findReservationsByUserTestbeds(@PathVariable String username) {
		List<ReservationProjectionCustom> findAllByUserUsername = repository.findAllCustomByUserUsername(username);
		List<CustomTestbedAreasResponse> responses = new ArrayList<CustomTestbedAreasResponse>();
		if (!findAllByUserUsername.isEmpty()) {
			for (ReservationProjectionCustom projection : findAllByUserUsername) {
				if (projection.getObstacles().isEmpty()) {
					responses.add(new CustomTestbedAreasResponse(projection.getTestbedAreaName(),
							projection.getTestbedAreaPolygon(), null));// Arrays.asList(projection.getTestbedAreaObstacles())));
				} else {
					List<String> obstacles = new ArrayList<String>();
					for (ObstacleProjection obstacle : projection.getObstacles()) {
						System.out.println("obstacle: " + obstacle.getObstacle());
						obstacles.add(obstacle.getObstacle());
					}
					responses.add(new CustomTestbedAreasResponse(projection.getTestbedAreaName(),
							projection.getTestbedAreaPolygon(), obstacles));// Arrays.asList(projection.getTestbedAreaObstacles())));
				}
			}
		}
		return responses;
	}
	
	@GetMapping("/INCLUDINGREST/rest/resources/{username}/{testbedAreaName}/{validFromDateString}/{validFromTimeString}")
	List<CustomBookedResourcesResponse> findResourcesCustom(@PathVariable String username,
			@PathVariable String testbedAreaName, @PathVariable String validFromDateString,
			@PathVariable String validFromTimeString) {
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		DateTimeFormatter timeformatter = DateTimeFormatter.ofPattern("HH:mm");

		LocalDate validFromDate = LocalDate.parse(validFromDateString, dateformatter);
		LocalTime validFromTime = LocalTime.parse(validFromTimeString, timeformatter);

		LocalDateTime validFrom = LocalDateTime.of(validFromDate.getYear(), validFromDate.getMonth(),
				validFromDate.getDayOfMonth(), validFromTime.getHour(), validFromTime.getMinute(), 0);

		ReservationProjectionCustom findAllByUserUsername = repository
				.findCustomByUserUsernameIsAndTestbedAreaNameIsAndValidFromEquals(username, testbedAreaName, validFrom);

		List<CustomBookedResourcesResponse> responses = new ArrayList<CustomBookedResourcesResponse>();
		for (ReservationItemProjection projection : findAllByUserUsername.getreservationItems()) {

			responses.add(new CustomBookedResourcesResponse(
					"image for " + projection.getResource().getResourceName(),
					projection.getResource().getResourceName(), 
					projection.getResource().getResourceType().equals("Sensor") ? sensorRepository.getByResourceId(projection.getResource().getResourceId()).getSensorType().getSensorType().concat("Sensor"): 
						projection.getResource().getResourceType().equals("UxV") ? uxvRepository.getByResourceId(projection.getResource().getResourceId()).getUxVType().getUxVType() : 
						projection.getResource().getResourceType(), //for resource type...had to because some responses cannot be changed...sorry
					projection.getResource().getResourceStatus(), 
					null,
					projection.getResource().getResourceType().equals("UxV") ? 
							uxvRepository.getByResourceId(projection.getResource().getResourceId()).getResourceSpecification() != null ? 
							uxvRepository.getByResourceId(projection.getResource().getResourceId()).getResourceSpecification().getMinSpeed() : null :
						projection.getResource().getResourceType().equals("Sensor") ? sensorRepository.getByResourceId(projection.getResource().getResourceId()).getResourceSpecification() != null ?
								sensorRepository.getByResourceId(projection.getResource().getResourceId()).getResourceSpecification().getMinSpeed() : null :
									projection.getResource().getResourceType().equals("Operator") ? Integer.valueOf(0) :
									projection.getResource().getResourceType().equals("Equipment") ? Integer.valueOf(0) : null,//projection.getResource().getMinSpeed(),
					projection.getResource().getResourceType().equals("UxV") ? 
							uxvRepository.getByResourceId(projection.getResource().getResourceId()).getResourceSpecification() != null ?
							uxvRepository.getByResourceId(projection.getResource().getResourceId()).getResourceSpecification().getMaxSpeed() : null :
						projection.getResource().getResourceType().equals("Sensor") ? sensorRepository.getByResourceId(projection.getResource().getResourceId()).getResourceSpecification() != null ?
								sensorRepository.getByResourceId(projection.getResource().getResourceId()).getResourceSpecification().getMaxSpeed() : null :
									projection.getResource().getResourceType().equals("Operator") ? Integer.valueOf(1) : 
									projection.getResource().getResourceType().equals("Equipment") ? Integer.valueOf(1) : null,//projection.getResource().getMaxSpeed(),
					projection.getResource().getResourceType().equals("Operator") ?
							Integer.valueOf(0) : 
								(projection.getResource().getResourceType().equals("Equipment") ?
										Integer.valueOf(0) : null),// : projection.getResource().resourceType().equals("Equipment") ? 0 : null,//null,
					projection.getResource().getResourceType().equals("UxV") ? 
							uxvRepository.getByResourceId(projection.getResource().getResourceId()).getResourceSpecification() != null ? 
									uxvRepository.getByResourceId(projection.getResource().getResourceId()).getResourceSpecification().getMinAltitude() : null :
						projection.getResource().getResourceType().equals("Sensor") ? 
								sensorRepository.getByResourceId(projection.getResource().getResourceId()).getResourceSpecification() != null ?
						sensorRepository.getByResourceId(projection.getResource().getResourceId()).getResourceSpecification().getMinAltitude() :null :
							projection.getResource().getResourceType().equals("Operator") ? Integer.valueOf(0) : 
							projection.getResource().getResourceType().equals("Equipment") ? Integer.valueOf(0) : null, // projection.getResource().getMinAltitude(),					
					projection.getResource().getResourceType().equals("UxV") ? 
							uxvRepository.getByResourceId(projection.getResource().getResourceId()).getResourceSpecification() != null ? 
							uxvRepository.getByResourceId(projection.getResource().getResourceId()).getResourceSpecification().getMaxAltitude() : null :
						projection.getResource().getResourceType().equals("Sensor") ? sensorRepository.getByResourceId(projection.getResource().getResourceId()).getResourceSpecification() != null ?
								sensorRepository.getByResourceId(projection.getResource().getResourceId()).getResourceSpecification().getMaxAltitude() : null : 
									projection.getResource().getResourceType().equals("Operator") ? Integer.valueOf(1) : 
									projection.getResource().getResourceType().equals("Equipment") ? Integer.valueOf(1) : null,//projection.getResource().getMaxAltitude(), 
					projection.getResource().getResourceType().equals("Operator") ?
							Integer.valueOf(0) : projection.getResource().getResourceType().equals("Equipment") ? Integer.valueOf(0) : null,//null,
									//GET AVAILABLE UXV SENSORS
					//projection.getResource().getResourceType().equals("UxV") ? uxvRepository.getByResourceId(projection.getResource().getResourceId()).getAvailableSensors() != null ?
					//		Arrays.asList(uxvRepository.getByResourceId(projection.getResource().getResourceId()).getAvailableSensors().split(",")) : 
					projection.getResource().getResourceType().equals("UxV") ? uxvRepository.getByResourceId(projection.getResource().getResourceId()).getUxVSensors() != null ?
							sensorsOfUxV(uxvSensorRepository.findAllByUxvResourceId(projection.getResource().getResourceId())) : 
						null : null,//projection.getResource().getAvailableSensors() != null ? Arrays.asList(projection.getResource().getAvailableSensors().split(",")) : null,
					null, null, null, null, null, null,
					projection.getResource().getResourceLocation() != null ? Arrays.asList(new DefinedWayPoint(0,Double.parseDouble(
							Arrays.asList(projection.getResource().getResourceLocation().split(",")).get(0)),
							Double.parseDouble(Arrays.asList(projection.getResource().getResourceLocation().split(",")).get(1)),0, 0, 0)) : null,
					null, projection.getResource().getTransferable(),
					projection.getResource().getResourceLocation() != null ? Arrays.asList(new DefinedWayPoint(0,Double.parseDouble(
							Arrays.asList(projection.getResource().getResourceLocation().split(",")).get(0)),
							Double.parseDouble(Arrays.asList(projection.getResource().getResourceLocation().split(",")).get(1)),0, 0, 0)) : null));
		}
		return responses;
	}
	
	List<String> sensorsOfUxV(List<UxVSensorProjection> sensorsProjection) {
		List<String> sensorList = new ArrayList<String>();
		for (UxVSensorProjection sensor : sensorsProjection) {
			sensorList.add(sensor.getSensorName());
		}
		return sensorList;
		// UxV uxv = uxvrepository.findByResourceId(id);
		// return uxv.getAvailableSensors() != null ?
		// Arrays.asList(uxv.getAvailableSensors().split(",")) : null;
	}
	///////////////////////////////////////////////////////END CUSTOM//////////////////////////////////////////////////////////////////////

	@GetMapping("/resourcesReservedByUser/{username}")
	@JsonView(value = { View.ReservationView.ReservedResources.class })
	List<ReservationProjection> findresourcesReservedByUser(@PathVariable String username) {
		return repository.findAllByUserUsername(username);
	}
	
	@GetMapping("/resourcesReservedByUserAndDateTime/{username}/{testbedAreaName}/{validFromDateString}/{validFromTimeString}")
	@JsonView(value = { View.ReservationView.ReservedResources.class })
	ReservationProjection findresourcesReservedByUserAndTimestamp(@PathVariable String username,  @PathVariable String testbedAreaName, @PathVariable String validFromDateString,@PathVariable String validFromTimeString) {
		DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		DateTimeFormatter timeformatter = DateTimeFormatter.ofPattern("HH:mm");	
		LocalDate validFromDate = LocalDate.parse(validFromDateString, dateformatter);
		LocalTime validFromTime = LocalTime.parse(validFromTimeString, timeformatter);		
		LocalDateTime validFrom = LocalDateTime.of(validFromDate.getYear(),validFromDate.getMonth(),validFromDate.getDayOfMonth(),validFromTime.getHour(),validFromTime.getMinute(),0);		
		return repository.findByUserUsernameIsAndTestbedAreaNameIsAndValidFromEquals(username, testbedAreaName, validFrom);
	}

	
	@PutMapping("/setReservationStatus/{id}/{reservation_status_id}")
	ResponseEntity<String> replaceReservation(@PathVariable Integer id, @PathVariable Integer reservation_status_id) {
		return repository.findById(id).map(reservation -> {
			reservation.setReservationStatus(statusRepository.getOne(reservation_status_id));
		    repository.save(reservation);
		    return  new ResponseEntity<>("Reservation Status Changed", HttpStatus.OK);
		}).orElseGet(() -> {
			//newReservation.setReservationId(id);
		    return  new ResponseEntity<>("Reservation Not Found", HttpStatus.NOT_FOUND);//repository.save(newReservation);
		});
	}
	
	@GetMapping("/reservationStatus")
	List<ReservationStatusProjection> findReservationsStatus() {
		return statusRepository.findAllProjectedBy();
	}
	
	@GetMapping("/reservationStatus/{reservation_status_id}")
	ReservationStatusProjection findReservationsStatusById(@PathVariable Integer reservation_status_id) {
		return statusRepository.findByReservationStatusId(reservation_status_id);
	}
	
	@GetMapping("/reservationStatusByName/{reservation_status}")
	ReservationStatusProjection findReservationsStatusById(@PathVariable String reservation_status) {
		return statusRepository.findByReservationStatus(reservation_status);
	}
	
	@PostMapping("/saveReservation")
	@ResponseBody
	Reservation newReservation(@RequestBody ReservationRequest newReservation) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime validFrom = LocalDateTime.parse(newReservation.getValidFrom(), formatter);
		LocalDateTime validUntil = LocalDateTime.parse(newReservation.getValidUntil(), formatter);
		Reservation res = new Reservation(null, statusRepository.getOne(4), validFrom, validUntil, testbedAreaRepository.getOne(newReservation.getTestbedAreaId()), userRepository.getUserByUsername(newReservation.getUsername()));
	    for(ReservationItemRequest reservationItem : newReservation.getReservationItems()) {
	    	res.addReservationItem(new ReservationItem(null, null, res, resourceRepository.findByResourceId(reservationItem.getResourceId())));
	    }
	    return repository.save(res);
	}
	

	@PutMapping("/editReservation")
	ResponseEntity<String> editReservation(@RequestBody ReservationRequest newReservation) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime validFrom = LocalDateTime.parse(newReservation.getValidFrom(), formatter);
		LocalDateTime validUntil = LocalDateTime.parse(newReservation.getValidUntil(), formatter);
		Reservation persisted = repository.getOne(newReservation.getReservationId());
		if (persisted != null) {
			persisted.setReservationStatus(statusRepository.getOne(4));
			persisted.setTestbedArea(testbedAreaRepository.getOne(newReservation.getTestbedAreaId()));
			persisted.setValidFrom(validFrom);
			persisted.setValidUntil(validUntil);

			//List<ReservationItem> delList = persisted.getReservationItems();
	       // Iterator<ReservationItem> iterator = delList.iterator();
	       /* while (iterator.hasNext()) {
	        	persisted.removeReservationItem(iterator.next());
			}*/
			for (ReservationItem reservationItem : persisted.getReservationItems()) {
				reservationItem.setReservation(null);
				//reservationItemRepository.deleteById(reservationItem.getReservationItemId()); ;
			}
			persisted.getReservationItems().clear();
			for (ReservationItemRequest reservationItem : newReservation.getReservationItems()) {
				persisted.addReservationItem(new ReservationItem(null, null, persisted,
						resourceRepository.findByResourceId(reservationItem.getResourceId())));
			}
			repository.save(persisted);
			return new ResponseEntity<>("Reservation Changed", HttpStatus.OK);

		} else {
			return new ResponseEntity<>("Reservation Not Found", HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/deleteReservation/{id}")
	void deleteReservation(@PathVariable Integer id) {
		repository.deleteById(id);
	}
}