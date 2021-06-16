package gr.uoa.di.pcomp.IncludingRESTAPI.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The persistent class for the equipment database table.
 * 
 */
@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "equipment")
//@PrimaryKeyJoinColumn(name = "equipment_id")
@NamedQuery(name = "Equipment.findAll", query = "SELECT e FROM Equipment e")
public class Equipment extends Resource implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "equipment_amount")
	private Integer equipmentAmount;

	@ManyToOne
	@JoinColumn(name = "equipment_type")
	private EquipmentType equipmentType;


	public Equipment(Integer resourceId, String resourceName, String resourceDescription, String resourceLocation,
			Integer partition, Integer preferedSrid, Boolean transferable, Boolean mobile, List<ReservationItem> reservationItems,
			HealthStatus healthStatus, ResourceStatus resourceStatus, ResourceType resourceType, TestbedArea testbedArea, Integer equipmentAmount, EquipmentType equipmentType) {
		super(resourceId, resourceName, resourceDescription, resourceLocation, partition, preferedSrid, transferable, mobile,
				reservationItems, healthStatus, resourceStatus, resourceType, testbedArea);
		this.equipmentAmount = equipmentAmount;
		this.equipmentType = equipmentType;	}
}