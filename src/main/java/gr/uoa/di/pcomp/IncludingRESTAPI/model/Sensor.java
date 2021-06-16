package gr.uoa.di.pcomp.IncludingRESTAPI.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


/**
 * The persistent class for the sensor database table.
 * 
 */
@Entity
@NoArgsConstructor
@Getter @Setter
@Table(name="sensor")
//@PrimaryKeyJoinColumn(name = "sensor_id")
@NamedQuery(name="Sensor.findAll", query="SELECT s FROM Sensor s")
public class Sensor extends Resource implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="sensor_name")
	@NotNull
	private String sensorName;
	
	@Column(name="canonical_name")
	private String canonicalName;

	private String unit;

	@ManyToOne
	@JoinColumn(name="sensor_type_id")
	@NotNull
	private SensorType sensorType;

	//for mobile sensors
	@ManyToOne
	@JoinColumn(name = "resource_specification")
	private ResourceSpecification resourceSpecification;

	public Sensor(Integer resourceId, String resourceName, String resourceDescription, String resourceLocation,
			Integer partition, Integer preferedSrid, Boolean transferable, Boolean mobile, List<ReservationItem> reservationItems,
			HealthStatus healthStatus, ResourceStatus resourceStatus, ResourceType resourceType, TestbedArea testbedArea, String sensorName ,String canonicalName, String unit, SensorType sensorType, ResourceSpecification resourceSpecification) {
		super(resourceId, resourceName, resourceDescription, resourceLocation, partition, preferedSrid, transferable, mobile,
				reservationItems, healthStatus, resourceStatus, resourceType, testbedArea);
		this.sensorName = sensorName;
		this.canonicalName = canonicalName;
		this.unit = unit;
		this.sensorType = sensorType;
		this.resourceSpecification = resourceSpecification;
		}
	
	
	

}