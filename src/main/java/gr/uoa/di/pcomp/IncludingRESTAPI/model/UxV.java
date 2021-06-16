package gr.uoa.di.pcomp.IncludingRESTAPI.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The persistent class for the uxv database table.
 * 
 */
@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "uxv")
//@PrimaryKeyJoinColumn(name = "uxv_id")
@NamedQuery(name = "UxV.findAll", query = "SELECT u FROM UxV u")
public class UxV extends Resource implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "uxv_type_id")
	private UxVType UxVType;
	
	//String availableSensors;
	
	@OneToMany(mappedBy="uxv")
	private List<UxVSensor> UxVSensors;
	
	@ManyToOne
	@JoinColumn(name = "resource_specification")
	private ResourceSpecification resourceSpecification;

	public UxV(Integer resourceId, String resourceName, String resourceDescription, String resourceLocation,
			Integer partition, Integer preferedSrid, Boolean transferable, Boolean mobile, List<ReservationItem> reservationItems,
			HealthStatus healthStatus, ResourceStatus resourceStatus, ResourceType resourceType, TestbedArea testbedArea, UxVType UxVType,
			//String availableSensors,
			ResourceSpecification resourceSpecification) {
		super(resourceId, resourceName, resourceDescription, resourceLocation, partition, preferedSrid, transferable, mobile,
				reservationItems, healthStatus, resourceStatus, resourceType, testbedArea);
		this.UxVType = UxVType;
		//this.availableSensors = availableSensors;
		this.resourceSpecification = resourceSpecification;

	}
	
	
	
	

}