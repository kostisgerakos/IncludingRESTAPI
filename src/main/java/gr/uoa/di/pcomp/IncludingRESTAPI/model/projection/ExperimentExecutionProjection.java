package gr.uoa.di.pcomp.IncludingRESTAPI.model.projection;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonView;

import gr.uoa.di.pcomp.IncludingRESTAPI.model.DdlScript;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.Experiment;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.ExperimentExecution;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.ExperimentLog;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.ExperimentStatusLut;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.ReservationItem;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.Resource;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.User;
import gr.uoa.di.pcomp.IncludingRESTAPI.views.View;


@JsonPropertyOrder({"experimentExecutionId", "startExecution","endExecution", "experimentStatus"})
public interface ExperimentExecutionProjection {
	Integer getExperimentExecutionId();
	Timestamp getEndExecution();
	Integer getExperimentStatus();
	Timestamp getStartExecution();
	@Value("#{target.experiment.experimentId}")
	Integer getExperiment(); 
}
