package gr.uoa.di.pcomp.IncludingRESTAPI.model.projection;

import com.fasterxml.jackson.annotation.JsonView;

import gr.uoa.di.pcomp.IncludingRESTAPI.model.DdlScript;
import gr.uoa.di.pcomp.IncludingRESTAPI.views.View;

public interface ObstacleProjection {
	@JsonView(value = {View.TestbedAreaView.TestbedAreaObstacles.class })
	String getObstacle();
}
