package gr.uoa.di.pcomp.IncludingRESTAPI.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * The persistent class for the sensor_type database table.
 * 
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Table(name="sensor_type")
@NamedQuery(name="SensorType.findAll", query="SELECT s FROM SensorType s")
public class SensorType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sensor_type_id")
	private Integer sensorTypeId;
	
	@Column(name="sensor_type")
	@NotNull
	private String sensorType;

	@OneToMany(mappedBy="sensorType")
	private List<Sensor> sensors;

	public Sensor addSensor(Sensor sensor) {
		getSensors().add(sensor);
		sensor.setSensorType(this);
		return sensor;
	}

	public Sensor removeSensor(Sensor sensor) {
		getSensors().remove(sensor);
		sensor.setSensorType(null);
		return sensor;
	}

	public SensorType(Integer sensorTypeId, String sensorType) {
		super();
		this.sensorTypeId = sensorTypeId;
		this.sensorType = sensorType;
	}	

}