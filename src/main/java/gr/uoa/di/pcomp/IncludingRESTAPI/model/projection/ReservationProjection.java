package gr.uoa.di.pcomp.IncludingRESTAPI.model.projection;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonView;

import gr.uoa.di.pcomp.IncludingRESTAPI.model.ReservationItem;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.Resource;
import gr.uoa.di.pcomp.IncludingRESTAPI.views.View;


@JsonPropertyOrder({"reservationId", "reservationStatus","validFrom", "validUntil" , "user", "testbedAreaId","reservationItems"})
public interface ReservationProjection {
	@JsonView(value = { View.ReservationView.ReservedResources.class })
	Integer getReservationId();
	@Value("#{target.reservationStatus.reservationStatus}")
	String getReservationStatus();
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	LocalDateTime getValidFrom();
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	LocalDateTime getValidUntil();
	@Value("#{target.user.userId}")
	Integer getUser(); 
	@JsonView(value = { View.ReservationView.ReservedResources.class })
	List<Item> getReservationItems();
	@JsonView(value = { View.ReservationView.ReservedResources.class })
	interface Item {
		@Value("#{target.resource.resourceId}")
		Integer getResourceId();
		@Value("#{target.resource.resourceName}")
		String getResourceName();
		@Value("#{target.resource.testbedArea.testbed.testbedId}")
		Integer getTestbedId();
		@Value("#{target.resource.testbedArea.testbedAreaId}")
		Integer getTestbedAreaId();
		@Value("#{target.resource.resourceType.resourceType}")
		String getResourceType();
		@Value("#{target.resource.mobile}")
		Boolean getMobile();
	}
	@Value("#{target.testbedArea.testbedAreaId}")
	Integer getTestbedAreaId();
/*	@Value("${var.string:#{NULL}}")
	String getTest();*/
}
