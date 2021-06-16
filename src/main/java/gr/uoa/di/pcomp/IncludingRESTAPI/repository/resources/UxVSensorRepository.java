package gr.uoa.di.pcomp.IncludingRESTAPI.repository.resources;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gr.uoa.di.pcomp.IncludingRESTAPI.model.UxVSensor;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.projection.UxVSensorProjection;



@Repository
public interface UxVSensorRepository extends JpaRepository<UxVSensor, Integer>{
		List<UxVSensorProjection> findAllByUxvResourceId(Integer resourceId);
}
