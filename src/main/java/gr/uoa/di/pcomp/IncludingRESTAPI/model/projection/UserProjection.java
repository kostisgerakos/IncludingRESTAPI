package gr.uoa.di.pcomp.IncludingRESTAPI.model.projection;

import java.sql.Timestamp;
import java.time.LocalTime;
import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonView;

import gr.uoa.di.pcomp.IncludingRESTAPI.model.SensorType;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.projection.ReservationProjection.Item;
import gr.uoa.di.pcomp.IncludingRESTAPI.views.View;

@JsonPropertyOrder({""})
public interface UserProjection {
	//@Value("#{target.resourceStatus?.resourceStatusDescr}")
	
	Integer getUserId();
	
	String getEmail();
	
	String getFirstname();
	
	String getLastname();
	
	@JsonView(value = { View.UserView.Username.class})
	String getUsername();
	
	Boolean getIsSuperuser();
	
	Timestamp getLastLogin();
	
	//String getPassword();
	
	String getDn();
	
}
