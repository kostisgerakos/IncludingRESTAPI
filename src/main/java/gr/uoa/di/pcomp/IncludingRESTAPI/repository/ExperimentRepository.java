package gr.uoa.di.pcomp.IncludingRESTAPI.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gr.uoa.di.pcomp.IncludingRESTAPI.model.Experiment;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.projection.ExperimentProjection;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.projection.ExperimentScript;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.projection.ExperimentVersions;


@Repository
public interface ExperimentRepository extends JpaRepository<Experiment, Integer> {
	List<Experiment> findAllByUserUserId(Integer userId);
	List<ExperimentVersions>  findVersionsAllByUserUserId(Integer userId);
	List<ExperimentVersions>  findVersionsAllByUserUsername(String userName);
	Experiment getExpByExperimentVersion(String experimentVersion);
	ExperimentScript getByExperimentVersion(String experimentVersion);
	Optional<Experiment>  findByExperimentVersionAndUserUserId(String experimentVersion,Integer userId);
	Optional<Experiment>  findByExperimentVersionAndUserUsername(String experimentVersion,String userName);
	ExperimentScript getByExperimentVersionAndUserUsername(String experimentVersion,String userName);

	ExperimentProjection getProjectedByExperimentId(Integer experimentId);
	ExperimentProjection getByExperimentExecutionsExperimentExecutionId(Integer experimentExecutionId);
	//Optional<Experiment> findByVersion(String version);
}