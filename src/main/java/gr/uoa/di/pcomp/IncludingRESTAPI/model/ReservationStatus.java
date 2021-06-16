package gr.uoa.di.pcomp.IncludingRESTAPI.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Table(name="reservation_status",uniqueConstraints={@UniqueConstraint(columnNames={"reservation_status"})})
@NamedQuery(name="ReservationStatus.findAll", query="SELECT r FROM ReservationStatus r")
public class ReservationStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="reservation_status_id")
	private Integer reservationStatusId;

	@Column(name="reservation_status")
	@NotNull
	private String reservationStatus;

	@OneToMany(mappedBy="reservationStatus")
	private List<Reservation> reservations;

	public Reservation addReservation(Reservation reservation) {
		getReservations().add(reservation);
		reservation.setReservationStatus(this);
		return reservation;
	}

	public Reservation removeReservation(Reservation reservation) {
		getReservations().remove(reservation);
		reservation.setReservationStatus(null);
		return reservation;
	}

	public ReservationStatus(Integer reservationStatusId, @NotNull String reservationStatus) {
		super();
		this.reservationStatusId = reservationStatusId;
		this.reservationStatus = reservationStatus;
	}
	

}
