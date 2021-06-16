package gr.uoa.di.pcomp.IncludingRESTAPI.repository.resources;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gr.uoa.di.pcomp.IncludingRESTAPI.model.Sensor;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.UxV;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.projection.UxVSensorProjection;

@Repository
@Transactional
public interface UxVRepository extends ResourceBaseRepository<UxV>{

	UxV getByResourceId(Integer resourceId);

}
