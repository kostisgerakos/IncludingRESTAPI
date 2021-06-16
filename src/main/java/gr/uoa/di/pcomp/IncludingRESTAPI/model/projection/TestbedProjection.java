package gr.uoa.di.pcomp.IncludingRESTAPI.model.projection;

import java.time.LocalTime;
import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonView;

import gr.uoa.di.pcomp.IncludingRESTAPI.model.SensorType;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.projection.ReservationProjection.Item;
import gr.uoa.di.pcomp.IncludingRESTAPI.views.View;

@JsonPropertyOrder({""})
public interface TestbedProjection {
	//@Value("#{target.resourceStatus?.resourceStatusDescr}")
	
	Integer getTestbedId();
	
	Double getAccuracy();
	
	String getArea();
	
	@JsonView(value = { View.TestbedView.TestbedLocation.class})
	String getLocation();
	
	String getName();
	
	String getDescription();
	
    @JsonFormat(pattern="HH:mm:ss")
	LocalTime getOperationEndTime();
    
    @JsonFormat(pattern="HH:mm:ss")
	LocalTime getOperationStartTime();
	
	Boolean getSimulator();
	
	String getTestbedStatusMessage();
	
	Boolean getAuvSupport();
	
	Boolean getUavSupport();
	
	Boolean getUgvSupport();
	
	Boolean getUsvSupport();
	
	Boolean getVrEnabled();
	

	
}
