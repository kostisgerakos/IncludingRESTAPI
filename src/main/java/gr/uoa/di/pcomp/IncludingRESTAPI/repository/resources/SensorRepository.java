package gr.uoa.di.pcomp.IncludingRESTAPI.repository.resources;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gr.uoa.di.pcomp.IncludingRESTAPI.model.Sensor;

@Repository
@Transactional
public interface SensorRepository extends ResourceBaseRepository<Sensor>{

	Sensor getByResourceId(Integer resourceId);

}
