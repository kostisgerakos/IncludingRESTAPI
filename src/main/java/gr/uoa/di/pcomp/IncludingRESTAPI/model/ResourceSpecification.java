package gr.uoa.di.pcomp.IncludingRESTAPI.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


/**
 * The persistent class for the operators_category database table.
 * 
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Table(name="resource_specification")
@NamedQuery(name="ResourceSpecification.findAll", query="SELECT o FROM ResourceSpecification o")
public class ResourceSpecification implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="resource_specification_id")
	private Integer resourceSpecificationId;
	
	private Integer minSpeed;

	private Integer maxSpeed;

	private Integer minAltitude;

	private Integer maxAltitude;

	@OneToMany(mappedBy="resourceSpecification")
	private List<UxV> UxVs;
	
	@OneToMany(mappedBy="resourceSpecification")
	private List<Sensor> Sensors;

	public UxV addUxV(UxV uxv) {
		getUxVs().add(uxv);
		uxv.setResourceSpecification(this);
		return uxv;
	}

	public UxV removeUxV(UxV uxv) {
		getUxVs().remove(uxv);
		uxv.setResourceSpecification(null);
		return uxv;
	}
	
	public Sensor addSensor(Sensor sensor) {
		getSensors().add(sensor);
		sensor.setResourceSpecification(this);
		return sensor;
	}

	public Sensor removeSensor(Sensor sensor) {
		getSensors().remove(sensor);
		sensor.setResourceSpecification(null);
		return sensor;
	}

	public ResourceSpecification(Integer resourceSpecificationId, Integer minSpeed, Integer maxSpeed,
			Integer minAltitude, Integer maxAltitude) {
		super();
		this.resourceSpecificationId = resourceSpecificationId;
		this.minSpeed = minSpeed;
		this.maxSpeed = maxSpeed;
		this.minAltitude = minAltitude;
		this.maxAltitude = maxAltitude;
	}
	

}