package gr.uoa.di.pcomp.IncludingRESTAPI.model.projection;


import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonView;

import gr.uoa.di.pcomp.IncludingRESTAPI.model.Obstacle;
import gr.uoa.di.pcomp.IncludingRESTAPI.views.View;

@JsonPropertyOrder({"testbedAreaId","name","testbed","description","area","areaValidation", "indoor","transferable" , "mapImageName", "maxAltitude","obstacles","obstaclesValidation","srid"})
public interface TestbedAreaProjection {
	
	@JsonView(value = {View.TestbedAreaView.TestbedAreaPolygonAndId.class})
	Integer getTestbedAreaId();
	
	String getName();
	
	@Value("#{target.testbed.name}")
	String getTestbed();
	
	@Value("#{target.testbed.testbedId}")
	Integer getTestbedId();
	
	String getDescription();
	
	@JsonView(value = {View.TestbedAreaView.TestbedAreaPolygonAndId.class })
	String getArea();
	
	String getAreaValidation();
	
	@JsonView(value = {View.TestbedAreaView.TestbedAreaIsIndoor.class })
	Boolean getIndoor();
	
	String getMapImageName();
	
	Double getMaxAltitude();
	
	@JsonView(value = {View.TestbedAreaView.TestbedAreaObstacles.class })
	List<ObstacleProjection> getObstacles();
	
	String getObstaclesValidation();
	
	Integer getSrid();	
	
	@JsonView(value = {View.TestbedAreaView.TestbedAreaLocation.class})
	//@Value("#{target.testbed.location}")
	String getLocation();
}
