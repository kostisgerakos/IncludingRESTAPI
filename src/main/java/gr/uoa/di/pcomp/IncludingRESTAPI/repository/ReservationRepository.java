package gr.uoa.di.pcomp.IncludingRESTAPI.repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gr.uoa.di.pcomp.IncludingRESTAPI.model.Reservation;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.projection.ReservationProjection;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.projection.ReservationProjectionCustom;


@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer>{
	ReservationProjection findByReservationId(Integer reservationId);
	List<ReservationProjection> findAllProjectedBy();
	List<ReservationProjection> findAllByUserUsername(String username);
	List<ReservationProjection> findAllByValidFromGreaterThanEqualAndValidUntilLessThanEqual(LocalDateTime validFrom,  LocalDateTime validUntil);
	List<ReservationProjection> findAllDistinctByValidFromGreaterThanEqualAndValidUntilLessThanEqualAndReservationStatusReservationStatusEqualsAndUserUsernameIs(LocalDateTime validFrom,  LocalDateTime validUntil, String reservationStatus, String username);
	List<ReservationProjection> findAllDistinctByValidFromGreaterThanEqualAndValidUntilLessThanEqualAndReservationStatusReservationStatusEqualsAndTestbedAreaTestbedAreaIdEquals(LocalDateTime validFrom,  LocalDateTime validUntil, String reservationStatus, Integer testbedAreaId);
	List<ReservationProjection> findAllDistinctByValidFromGreaterThanEqualAndValidUntilLessThanEqualAndReservationStatusReservationStatusEqualsAndUserUsernameIsAndTestbedAreaTestbedAreaIdEquals(LocalDateTime validFrom,  LocalDateTime validUntil, String reservationStatus, String username, Integer testbedAreaId);
	List<ReservationProjectionCustom> findAllCustomByUserUsername(String username);
	List<ReservationProjectionCustom> findAllCustomByUserUsernameIsAndTestbedAreaNameIs(String username, String testbedAreaName);
	List<ReservationProjectionCustom> findAllCustomProjectedBy();
	ReservationProjectionCustom findCustomByUserUsernameIsAndTestbedAreaNameIsAndValidFromEquals(String username, String testbedAreaName, LocalDateTime validFrom);
	ReservationProjection findCustomByUserUsernameIsAndTestbedAreaNameIsAndValidFromLessThanEqualAndValidUntilGreaterThanEqual(String username, String testbedAreaName, LocalDateTime validFrom, LocalDateTime validUntil);
	ReservationProjection findByUserUsernameIsAndTestbedAreaNameIsAndValidFromEquals(String username, String testbedAreaName, LocalDateTime validFrom);
	List<ReservationProjection> findAllByReservationStatusReservationStatus(String reservationStatus);
}