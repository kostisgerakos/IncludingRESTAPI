package gr.uoa.di.pcomp.IncludingRESTAPI.repository;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gr.uoa.di.pcomp.IncludingRESTAPI.model.Testbed;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.projection.TestbedProjection;


@Repository
public interface TestbedRepository extends JpaRepository<Testbed, Integer>{
	List<TestbedProjection> findAllProjectedBy();
	TestbedProjection findByName(String name);
	Optional<TestbedProjection> findProjectionByTestbedId(Integer testbedId); 
	Optional<TestbedProjection> findByOperationStartTimeGreaterThanEqualAndOperationEndTimeLessThanEqual(LocalTime operationStartTime,  LocalTime operationEndTime);
	Optional<TestbedProjection> findByOperationStartTimeGreaterThanEqualAndOperationEndTimeLessThanEqualAndTestbedIdEquals(LocalTime operationStartTime,  LocalTime operationEndTime, Integer testbedId );
}
