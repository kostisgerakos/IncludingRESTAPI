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
 * The persistent class for the uxv_sensor database table.
 * 
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Table(name="uxv_sensor")
@NamedQuery(name="UxVSensor.findAll", query="SELECT s FROM UxVSensor s")
public class UxVSensor implements Serializable {
	

	public UxVSensor(Integer sensorId, @NotNull String sensorName, String canonicalName, String unit) {
		super();
		this.sensorId = sensorId;
		this.sensorName = sensorName;
		this.canonicalName = canonicalName;
		this.unit = unit;
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sensor_id")
	private Integer sensorId;

	@Column(name="sensor_name")
	@NotNull
	private String sensorName;
	
	@Column(name="canonical_name")
	private String canonicalName;

	private String unit;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="uxv")
	private UxV uxv;

}