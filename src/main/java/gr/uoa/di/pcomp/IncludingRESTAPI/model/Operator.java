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
 * The persistent class for the operators database table.
 * 
 */
@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "operator")
//@PrimaryKeyJoinColumn(name = "operators_id")
@NamedQuery(name = "Operator.findAll", query = "SELECT o FROM Operator o")
public class Operator extends Resource implements Serializable {
	private static final long serialVersionUID = 1L;

/*	@Column(name="team_size")
	private Integer teamSize;*/
	
	@Column(name="operator_name")
	private String operatorName;

	@ManyToOne
	@JoinColumn(name = "operator_category")
	@NotNull
	private OperatorCategory operatorCategory;

	public Operator(Integer resourceId, String resourceName, String resourceDescription, String resourceLocation,
			Integer partition, Integer preferedSrid, Boolean transferable, Boolean mobile, List<ReservationItem> reservationItems,
			HealthStatus healthStatus, ResourceStatus resourceStatus, ResourceType resourceType, TestbedArea testbedArea, String operatorName,OperatorCategory operatorCategory) {
		super(resourceId, resourceName, resourceDescription, resourceLocation, partition, preferedSrid, transferable, mobile,
				reservationItems, healthStatus, resourceStatus, resourceType, testbedArea);
		this.operatorName = operatorName;
		this.operatorCategory = operatorCategory;		}


	
}