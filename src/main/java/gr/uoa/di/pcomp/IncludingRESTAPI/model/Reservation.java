package gr.uoa.di.pcomp.IncludingRESTAPI.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the reservation database table.
 * 
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@NamedQuery(name="Reservation.findAll", query="SELECT r FROM Reservation r")
public class Reservation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="reservation_id")
	private Integer reservationId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="reservation_status")
	@NotNull
	private ReservationStatus reservationStatus;
	
	@Column(name="valid_from", columnDefinition = "TIMESTAMP") 
	@NotNull
	private LocalDateTime validFrom;

	@Column(name="valid_until",columnDefinition = "TIMESTAMP")
	@NotNull
	private LocalDateTime validUntil;

	@ManyToOne
	@JoinColumn(name="testbed_area_id")
	@NotNull
	private TestbedArea testbedArea;

	@ManyToOne
	@JoinColumn(name="user_id")
	@NotNull
	private User user;

	@OneToMany(mappedBy="reservation",cascade = CascadeType.ALL)
	@NotNull
	private List<ReservationItem> reservationItems;

	public ReservationItem addReservationItem(ReservationItem reservationItem) {
		getReservationItems().add(reservationItem);
		reservationItem.setReservation(this);

		return reservationItem;
	}

	public ReservationItem removeReservationItem(ReservationItem reservationItem) {
		getReservationItems().remove(reservationItem);
		reservationItem.setReservation(null);

		return reservationItem;
	}

	public Reservation(Integer reservationId, ReservationStatus reservationStatus,
			LocalDateTime validFrom, LocalDateTime validUntil, TestbedArea testbedArea, User user) {
		this.reservationId = reservationId;
		this.reservationStatus = reservationStatus;
		this.validFrom = validFrom;
		this.validUntil = validUntil;
		this.testbedArea = testbedArea;
		this.user = user;
		this.reservationItems = new ArrayList<ReservationItem>();
	}	
	
	
	//bi-directional many-to-many association to Resource
    /*@ManyToMany
	@JoinTable(
			name="resource_reservations"
			, joinColumns={
				@JoinColumn(name="resource_id")
				}
			, inverseJoinColumns={
				@JoinColumn(name="reservation_id")
				}
			)
	private List<Resource> resources;*/


}