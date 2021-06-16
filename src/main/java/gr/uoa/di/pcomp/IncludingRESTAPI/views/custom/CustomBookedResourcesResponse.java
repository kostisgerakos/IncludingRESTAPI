package gr.uoa.di.pcomp.IncludingRESTAPI.views.custom;

import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
//@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"Image",
"Name",
"Type",
"Status",
"Selected",
"MinSpeed",
"MaxSpeed",
"Speed",
"MinAltitude",
"MaxAltitude",
"Altitude",
"availableSensors",
"availableAlgorithms",
"availableCommunications",
"definedSensorsList",
"definedAlgorithmsList",
"definedCommunicationsList",
"definedEventsList",
"definedWayPoints",
"WPs",
"borrowed"
})
public class CustomBookedResourcesResponse implements Serializable
{

@JsonProperty("Image")
private String image;
@JsonProperty("Name")
private String name;
@JsonProperty("Type")
private String type;
@JsonProperty("Status")
private Object status;
@JsonProperty("Selected")
private Object selected;
@JsonProperty("MinSpeed")
private Integer minSpeed;
@JsonProperty("MaxSpeed")
private Integer maxSpeed;
@JsonProperty("Speed")
private Integer speed;
@JsonProperty("MinAltitude")
private Integer minAltitude;
@JsonProperty("MaxAltitude")
private Integer maxAltitude;
@JsonProperty("Altitude")
private Integer altitude;
@JsonProperty("availableSensors")
private List<String> availableSensors = null;
@JsonProperty("availableAlgorithms")
private Object availableAlgorithms;
@JsonProperty("availableCommunications")
private Object availableCommunications;
@JsonProperty("definedSensorsList")
private List<String> definedSensorsList;
@JsonProperty("definedAlgorithmsList")
private Object definedAlgorithmsList;
@JsonProperty("definedCommunicationsList")
private Object definedCommunicationsList;
@JsonProperty("definedEventsList")
private Object definedEventsList;
@JsonProperty("definedWayPoints")
private List<DefinedWayPoint> definedWayPoints;
@JsonProperty("WPs")
private Object wPs;
@JsonProperty("borrowed")
private Boolean borrowed;
@JsonProperty("location")
private List<DefinedWayPoint> location;
private final static long serialVersionUID = -2988531204288754248L;


/**
*
* @param image
* @param altitude
* @param availableCommunications
* @param maxAltitude
* @param definedCommunicationsList
* @param availableAlgorithms
* @param definedEventsList
* @param maxSpeed
* @param type
* @param definedSensorsList
* @param speed
* @param availableSensors
* @param minAltitude
* @param definedAlgorithmsList
* @param definedWayPoints
* @param name
* @param wPs
* @param minSpeed
* @param selected
* @param borrowed
* @param status
*/
public CustomBookedResourcesResponse(String image, String name, String type, Object status, Object selected, Integer minSpeed, Integer maxSpeed, Integer speed, Integer minAltitude, Integer maxAltitude, Integer altitude, List<String> availableSensors, Object availableAlgorithms, Object availableCommunications, List<String> definedSensorsList, Object definedAlgorithmsList, Object definedCommunicationsList, Object definedEventsList, List<DefinedWayPoint> definedWayPoints, Object wPs, Boolean borrowed , List<DefinedWayPoint> location) {
super();
this.image = image;
this.name = name;
this.type = type;
this.status = status;
this.selected = selected;
this.minSpeed = minSpeed;
this.maxSpeed = maxSpeed;
this.speed = speed;
this.minAltitude = minAltitude;
this.maxAltitude = maxAltitude;
this.altitude = altitude;
this.availableSensors = availableSensors;
this.availableAlgorithms = availableAlgorithms;
this.availableCommunications = availableCommunications;
this.definedSensorsList = definedSensorsList;
this.definedAlgorithmsList = definedAlgorithmsList;
this.definedCommunicationsList = definedCommunicationsList;
this.definedEventsList = definedEventsList;
this.definedWayPoints = definedWayPoints;
this.wPs = wPs;
this.borrowed = borrowed;
this.location = location;
}


public CustomBookedResourcesResponse withImage(String image) {
this.image = image;
return this;
}

public CustomBookedResourcesResponse withName(String name) {
this.name = name;
return this;
}

public CustomBookedResourcesResponse withType(String type) {
this.type = type;
return this;
}

public CustomBookedResourcesResponse withStatus(Object status) {
this.status = status;
return this;
}

public CustomBookedResourcesResponse withSelected(Object selected) {
this.selected = selected;
return this;
}

public CustomBookedResourcesResponse withMinSpeed(Integer minSpeed) {
this.minSpeed = minSpeed;
return this;
}

public CustomBookedResourcesResponse withMaxSpeed(Integer maxSpeed) {
this.maxSpeed = maxSpeed;
return this;
}

public CustomBookedResourcesResponse withSpeed(Integer speed) {
this.speed = speed;
return this;
}

public CustomBookedResourcesResponse withMinAltitude(Integer minAltitude) {
this.minAltitude = minAltitude;
return this;
}

public CustomBookedResourcesResponse withMaxAltitude(Integer maxAltitude) {
this.maxAltitude = maxAltitude;
return this;
}

public CustomBookedResourcesResponse withAltitude(Integer altitude) {
this.altitude = altitude;
return this;
}

public CustomBookedResourcesResponse withAvailableSensors(List<String> availableSensors) {
this.availableSensors = availableSensors;
return this;
}

public CustomBookedResourcesResponse withAvailableAlgorithms(Object availableAlgorithms) {
this.availableAlgorithms = availableAlgorithms;
return this;
}

public CustomBookedResourcesResponse withAvailableCommunications(Object availableCommunications) {
this.availableCommunications = availableCommunications;
return this;
}

public CustomBookedResourcesResponse withDefinedSensorsList(List<String> definedSensorsList) {
this.definedSensorsList = definedSensorsList;
return this;
}

public CustomBookedResourcesResponse withDefinedAlgorithmsList(Object definedAlgorithmsList) {
this.definedAlgorithmsList = definedAlgorithmsList;
return this;
}

public CustomBookedResourcesResponse withDefinedCommunicationsList(Object definedCommunicationsList) {
this.definedCommunicationsList = definedCommunicationsList;
return this;
}

public CustomBookedResourcesResponse withDefinedEventsList(Object definedEventsList) {
this.definedEventsList = definedEventsList;
return this;
}

public CustomBookedResourcesResponse withDefinedWayPoints(List<DefinedWayPoint> definedWayPoints) {
this.definedWayPoints = definedWayPoints;
return this;
}

public CustomBookedResourcesResponse withWPs(Object wPs) {
this.wPs = wPs;
return this;
}

public CustomBookedResourcesResponse withBorrowed(Boolean borrowed) {
this.borrowed = borrowed;
return this;
}

}