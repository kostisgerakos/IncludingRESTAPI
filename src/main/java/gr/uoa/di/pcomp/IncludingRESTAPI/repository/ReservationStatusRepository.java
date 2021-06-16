package gr.uoa.di.pcomp.IncludingRESTAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gr.uoa.di.pcomp.IncludingRESTAPI.model.ReservationStatus;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.projection.ReservationStatusProjection;


@Repository
public interface ReservationStatusRepository extends JpaRepository<ReservationStatus, Integer>{
	List<ReservationStatusProjection> findAllProjectedBy();
	ReservationStatusProjection findByReservationStatusId(Integer ReservationStatusId);
	ReservationStatusProjection findByReservationStatus(String ReservationStatus);


}
