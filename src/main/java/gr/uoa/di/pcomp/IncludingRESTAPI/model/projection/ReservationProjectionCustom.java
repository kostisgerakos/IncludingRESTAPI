package gr.uoa.di.pcomp.IncludingRESTAPI.model.projection;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonView;

import gr.uoa.di.pcomp.IncludingRESTAPI.model.Obstacle;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.ReservationItem;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.Resource;
import gr.uoa.di.pcomp.IncludingRESTAPI.views.View;

public interface ReservationProjectionCustom {
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	LocalDateTime getValidFrom();
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	LocalDateTime getValidUntil();
	@Value("#{target.user.username}")
	String getUser(); 
	@Value("#{target.testbedArea.name}")
	String getTestbedAreaName();
	@Value("#{target.testbedArea.indoor}")
	Boolean getTestbedAreaIndoor();
	@Value("#{target.testbedArea.testbed.location}")
	String getTestbedAreaLocation();
	@Value("#{target.testbedArea.area}")
	String getTestbedAreaPolygon();
	@Value("#{target.testbedArea.obstacles}")
	List<ObstacleProjection> getObstacles();
	//@Value("#{target.reservationItems")
	List<ReservationItemProjection> getreservationItems();
	//@Value("#{target.testbedArea.obstacles}")
	//List<Obstacle>  getTestbedAreaObstacles();
}
