package gr.uoa.di.pcomp.IncludingRESTAPI.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gr.uoa.di.pcomp.IncludingRESTAPI.model.TestbedArea;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.projection.TestbedAreaProjection;

@Repository
public interface TestbedAreaRepository extends JpaRepository<TestbedArea, Integer>{ 
	List<TestbedAreaProjection> findAllProjectedBy();
	Optional<TestbedAreaProjection> findProjectedByTestbedAreaId(Integer TestbedAreaId);
	TestbedAreaProjection findTestbedAreaByName(String resourceName); 
	//TestbedAreaProjection findPolygonTestbedAreaByName(String resourceName);
	//TestbedAreaProjection findObstaclesTestbedAreaByName(String resourceName);

}
