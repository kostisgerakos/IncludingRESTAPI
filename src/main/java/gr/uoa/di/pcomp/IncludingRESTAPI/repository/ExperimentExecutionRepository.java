package gr.uoa.di.pcomp.IncludingRESTAPI.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gr.uoa.di.pcomp.IncludingRESTAPI.model.ExperimentExecution;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.projection.ExperimentExecutionProjection;


@Repository
public interface ExperimentExecutionRepository extends JpaRepository<ExperimentExecution, Integer> {
	List<ExperimentExecutionProjection> getAllByExperimentExperimentId(Integer experimentId);
	List<ExperimentExecutionProjection> getAllByExperimentExperimentStatusLutExperimentStatusId(Integer experimentStatusId);
	ExperimentExecutionProjection findByExperimentExecutionId(Integer experimentExecutionId);

}