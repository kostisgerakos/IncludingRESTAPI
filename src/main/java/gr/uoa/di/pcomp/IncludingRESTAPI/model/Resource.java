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
 * The persistent class for the resource database table.
 * 
 */
@Entity
@NoArgsConstructor
@Getter @Setter
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name = "resource_type")
@NamedQuery(name="Resource.findAll", query="SELECT r FROM Resource r")
public class Resource implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="resource_id")
	//@JsonView(value = { View.ResourceView.SimpleResource.class })
	private Integer resourceId;

	@Column(name="resource_name")
	@NotNull
	private String resourceName;
	
	@Column(name="resource_description")
	private String resourceDescription;

	@Column(name="resource_location")
	private String resourceLocation;
	
	private Integer partition;

	@Column(name="prefered_srid")
	private Integer preferedSrid;

	@NotNull
	private Boolean transferable;
	
	@NotNull
	private Boolean mobile;

	@OneToMany(mappedBy="resource")
	private List<ReservationItem> reservationItems;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="health")
	private HealthStatus healthStatus;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="resource_status")
	private ResourceStatus resourceStatus;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="resource_type")
	@NotNull
	private ResourceType resourceType;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="testbed_area_id")
	@NotNull
	private TestbedArea testbedArea;
	

	
	public ReservationItem addReservationItem(ReservationItem reservationItem) {
		getReservationItems().add(reservationItem);
		reservationItem.setResource(this);
		return reservationItem;
	}

	public ReservationItem removeReservationItem(ReservationItem reservationItem) {
		getReservationItems().remove(reservationItem);
		reservationItem.setResource(null);
		return reservationItem;
	}

}