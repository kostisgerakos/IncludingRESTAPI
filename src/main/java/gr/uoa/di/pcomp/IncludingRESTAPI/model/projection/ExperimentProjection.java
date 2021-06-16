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
import gr.uoa.di.pcomp.IncludingRESTAPI.model.ExperimentExecution;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.ExperimentStatusLut;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.ReservationItem;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.Resource;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.User;
import gr.uoa.di.pcomp.IncludingRESTAPI.views.View;


@JsonPropertyOrder({"experimentId", "experimentVersion","experimentName", "launchedAt" , "endedAt"})
public interface ExperimentProjection {
	Integer getExperimentId();
	String getDescrition();
	Timestamp getEndedAt();
	String getExperimentName();
	String getExperimentVersion();
	Timestamp getLaunchedAt();	
	Script getDdlScript();
	//@JsonView(value = { View.ReservationView.ReservedResources.class })
	interface Script {
		@Value("#{target.scriptId}")
		Integer getScriptId();
		@Value("#{target.filename}")
		String getFilename();
		@Value("#{target.genScriptContent}")
		String getGenScriptContent();
		@Value("#{target.realScriptContent}")
		String getRealScriptContent();
		@Value("#{target.scriptContent}")
		String getScriptContent();
	}
	@Value("#{target.experimentStatusLut.experimentStatusDescr}")
	String getExperimentStatusLut();
	@Value("#{target.user.userId}")
	Integer getUser(); 

	/*@OneToMany(mappedBy="experiment")
	private List<ReservationItem> reservationItems;
	
	@OneToMany(mappedBy="experiment")
	private List<ExperimentExecution> experimentExecutions;
*/
	

}
