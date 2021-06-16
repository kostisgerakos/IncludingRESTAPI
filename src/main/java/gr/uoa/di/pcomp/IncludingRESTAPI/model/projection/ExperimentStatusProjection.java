package gr.uoa.di.pcomp.IncludingRESTAPI.model.projection;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"experimentStatusId", "getExperimentStatusDescr"})
public interface ExperimentStatusProjection {
	Integer getExperimentStatusId();
	String getExperimentStatusDescr();
}
