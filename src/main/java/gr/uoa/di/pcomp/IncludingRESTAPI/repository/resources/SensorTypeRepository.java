package gr.uoa.di.pcomp.IncludingRESTAPI.repository.resources;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gr.uoa.di.pcomp.IncludingRESTAPI.model.SensorType;

@Repository
public interface SensorTypeRepository extends JpaRepository<SensorType, Integer>{

}
