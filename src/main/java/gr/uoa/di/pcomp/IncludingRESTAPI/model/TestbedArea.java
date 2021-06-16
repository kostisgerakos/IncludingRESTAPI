package gr.uoa.di.pcomp.IncludingRESTAPI.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


/**
 * The persistent class for the testbed_area database table.
 * 
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Table(name="testbed_area", uniqueConstraints={@UniqueConstraint(columnNames={"name"})})
@NamedQuery(name="TestbedArea.findAll", query="SELECT t FROM TestbedArea t")
public class TestbedArea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="testbed_area_id")
	private Integer testbedAreaId;
	
	@NotNull
	private String name;
	
	@ManyToOne
	@JoinColumn(name="testbed_id")
	@NotNull
	private Testbed testbed;
	
	private String description;
	
	@Column(name="location")//,columnDefinition = "Point")
	@NotNull
	private String location;

	@Column(length=8096)
	private String area;

	@Column(name="area_validation")
	private String areaValidation;
	
	@NotNull
	private Boolean indoor;

	@Column(name="map_image_name")
	private String mapImageName;

	@Column(name="max_altitude")
	private Double maxAltitude;

	@Column(name="obstacles_validation")
	private String obstaclesValidation;

	private Integer srid;

	@OneToMany(mappedBy="testbedArea")
	private List<Reservation> reservations;
	
	public Reservation addReservation(Reservation reservation) {
		getReservations().add(reservation);
		reservation.setTestbedArea(this);
		return reservation;
	}

	public Reservation removeReservation(Reservation reservation) {
		getReservations().remove(reservation);
		reservation.setTestbedArea(null);
		return reservation;
	}
	
	@OneToMany(mappedBy="testbedArea")
	private List<Resource> resources;
	
	public Resource addResource(Resource resource) {
		getResources().add(resource);
		resource.setTestbedArea(this);
		return resource;
	}

	public Resource removeResource(Resource resource) {
		getResources().remove(resource);
		resource.setTestbedArea(null);
		return resource;
	}
	
	@OneToMany(mappedBy="testbedArea")
	private List<Obstacle> obstacles;
	
	public Obstacle addObstacle(Obstacle obstacle) {
		getObstacles().add(obstacle);
		obstacle.setTestbedArea(this);
		return obstacle;
	}

	public Obstacle removeObstacle(Obstacle obstacle) {
		getObstacles().remove(obstacle);
		obstacle.setObstacle(null);
		return obstacle;
	}

	public TestbedArea(Integer testbedAreaId, @NotNull String name, @NotNull Testbed testbed, String description,
			@NotNull String location, String area, String areaValidation, @NotNull Boolean indoor, String mapImageName,
			Double maxAltitude, String obstaclesValidation, Integer srid) {
		super();
		this.testbedAreaId = testbedAreaId;
		this.name = name;
		this.testbed = testbed;
		this.description = description;
		this.location = location;
		this.area = area;
		this.areaValidation = areaValidation;
		this.indoor = indoor;
		this.mapImageName = mapImageName;
		this.maxAltitude = maxAltitude;
		this.obstaclesValidation = obstaclesValidation;
		this.srid = srid;
	}
	
}