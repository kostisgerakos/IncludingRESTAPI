package gr.uoa.di.pcomp.IncludingRESTAPI.model;

import java.io.Serializable;

import javax.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The persistent class for the reservation_item database table.
 * 
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "reservation_item")
@NamedQuery(name = "ReservationItem.findAll", query = "SELECT r FROM ReservationItem r")
public class ReservationItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reservation_item_id")
	private Integer reservationItemId;

	/*
	 * @Column(name="in_use") 
	 * private Boolean inUse;
	 */
	
	// bi-directional many-to-one association to Experiment
	@ManyToOne
	@JoinColumn(name = "experiment_id")
	private Experiment experiment;

	// bi-directional many-to-one association to Reservation
	@ManyToOne
	@JoinColumn(name = "reservation_id", referencedColumnName = "reservation_id")
	private Reservation reservation;

	// bi-directional many-to-one association to Resource
	@ManyToOne
	@JoinColumn(name = "resource_id")
	private Resource resource;

}