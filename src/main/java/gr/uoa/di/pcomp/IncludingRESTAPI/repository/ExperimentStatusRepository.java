package gr.uoa.di.pcomp.IncludingRESTAPI.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gr.uoa.di.pcomp.IncludingRESTAPI.model.ExperimentStatusLut;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.projection.ExperimentStatusProjection;


@Repository
public interface ExperimentStatusRepository extends JpaRepository<ExperimentStatusLut, Integer> {
	ExperimentStatusProjection getByExperimentStatusId(Integer experimentStatusId);
	ExperimentStatusProjection getByExperimentStatusDescr(String experimentStatusDescr);

}