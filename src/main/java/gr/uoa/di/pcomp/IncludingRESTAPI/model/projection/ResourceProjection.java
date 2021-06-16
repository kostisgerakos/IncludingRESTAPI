package gr.uoa.di.pcomp.IncludingRESTAPI.model.projection;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonView;

import gr.uoa.di.pcomp.IncludingRESTAPI.model.EquipmentType;
import gr.uoa.di.pcomp.IncludingRESTAPI.model.OperatorCategory;
import gr.uoa.di.pcomp.IncludingRESTAPI.views.View;

@JsonPropertyOrder({"resourceId","resourceName","resourceDescription","resourceLocation","resourceStatus","healthStatus", "resourceType","transferable" , "partition", "testbedId","preferedSrid"})
public interface ResourceProjection {
	@JsonView(value = { View.ResourceView.Resource.class,View.ResourceView.ResourceId.class,View.ResourceView.ResourceIdTestbedId.class,View.ResourceView.Sensor.class,View.ResourceView.Operator.class,View.ResourceView.UxV.class,View.ResourceView.Equipment.class })
	Integer getResourceId();
	
	@JsonView(value = { View.ResourceView.Resource.class})
	String getResourceName();
	
	@JsonView(value = { View.ResourceView.Resource.class})
	String getResourceDescription();
	
	@JsonView(value = { View.ResourceView.Resource.class})
	String getResourceLocation();
	
	@JsonView(value = { View.ResourceView.Resource.class})
	Integer getPartition();
	
	@JsonView(value = { View.ResourceView.Resource.class})
	Integer getPreferedSrid();
	
	@JsonView(value = { View.ResourceView.Resource.class})
	Boolean getTransferable();
	
	@JsonView(value = { View.ResourceView.Resource.class})
	Boolean getMobile();
	
	@JsonView(value = { View.ResourceView.Resource.class})
	@Value("#{target.healthStatus?.healthStatusDescr}")
	String getHealthStatus();
	
	@JsonView(value = { View.ResourceView.Resource.class})
	@Value("#{target.resourceStatus?.resourceStatusDescr}")
	String getResourceStatus();
	
	@JsonView(value = { View.ResourceView.Resource.class})
	@Value("#{target.resourceType.resourceType}")
	String getResourceType();
	
	@JsonView(value = { View.ResourceView.Resource.class})
	@Value("#{target.testbedArea.testbedAreaId}")
	Integer getTestbedAreaId();
	
	@JsonView(value = { View.ResourceView.Resource.class})
	@Value("#{target.testbedArea.testbed.testbedId}")
	Integer getTestbedId();
	
	@JsonView(value = { View.ResourceView.ResourceIdTestbedId.class})
	@Value("#{target.testbedArea.testbed.name}")
	String getTestbedName();
	
	/*@JsonView(value = { View.ResourceView.Resource.class})
	Integer getMinSpeed();
	
	@JsonView(value = { View.ResourceView.Resource.class})
	Integer getMaxSpeed();
	
	@JsonView(value = { View.ResourceView.Resource.class})
	Integer getMinAltitude();
	
	@JsonView(value = { View.ResourceView.Resource.class})
	Integer getMaxAltitude();
	
	@JsonView(value = { View.ResourceView.Resource.class})
	String getAvailableSensors();*/
	
	@JsonView(value = { View.ResourceView.Sensor.class })
	@Value("#{target}")
	SensorProperties getSensor();
	
	@JsonView(value = { View.ResourceView.Sensor.class })
	interface SensorProperties {
		String getSensorName();
		String getUnit();
		@Value("#{target.sensorType.sensorType}")
		String getSensorType();
		String getCanonicalName();
	}
	
	@JsonView(value = { View.ResourceView.Operator.class })
	@Value("#{target}")
	OperatorProperties getOperator();
	
	@JsonView(value = { View.ResourceView.Operator.class })
	interface OperatorProperties {
		String getOperatorName();
		@Value("#{target.operatorCategory?.operatorCategory}")
		String  getOperatorCategory();
	}
	
	@JsonView(value = { View.ResourceView.UxV.class })
	@Value("#{target}")
	UxVProperties getUxV();
	
	@JsonView(value = { View.ResourceView.UxV.class })
	interface UxVProperties {
		@Value("#{target.UxVType.UxVType}")
		String getUxVType();
	}
	
	@JsonView(value = { View.ResourceView.Equipment.class })
	@Value("#{target}")
	EquipmentProperties getEquipment();
	
	@JsonView(value = { View.ResourceView.Equipment.class })
	interface EquipmentProperties {
		Integer getEquipmentAmount();
		@Value("#{target.equipmentType.equipmentType}")
		String getEquipmentType();
	}
	
}
