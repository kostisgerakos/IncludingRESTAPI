
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
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "altitude",
    "latitude",
    "longitude",
    "speed",
    "timestep",
    "wayPoint"
})
public class DefinedWayPoint implements Serializable
{

    @JsonProperty("altitude")
    private Integer altitude;
    @JsonProperty("latitude")
    private Double latitude;
    @JsonProperty("longitude")
    private Double longitude;
    @JsonProperty("speed")
    private Integer speed;
    @JsonProperty("timestep")
    private Integer timestep;
    @JsonProperty("wayPoint")
    private Integer wayPoint;
    private final static long serialVersionUID = -7233365939854849256L;

    /**
     * 
     * @param altitude
     * @param timestep
     * @param latitude
     * @param speed
     * @param longitude
     * @param wayPoint
     */
    public DefinedWayPoint(Integer altitude, Double latitude, Double longitude, Integer speed, Integer timestep, Integer wayPoint) {
        super();
        this.altitude = altitude;
        this.latitude = latitude;
        this.longitude = longitude;
        this.speed = speed;
        this.timestep = timestep;
        this.wayPoint = wayPoint;
    }

    public DefinedWayPoint withAltitude(Integer altitude) {
        this.altitude = altitude;
        return this;
    }

    public DefinedWayPoint withLatitude(Double latitude) {
        this.latitude = latitude;
        return this;
    }

    public DefinedWayPoint withLongitude(Double longitude) {
        this.longitude = longitude;
        return this;
    }

    public DefinedWayPoint withSpeed(Integer speed) {
        this.speed = speed;
        return this;
    }

    public DefinedWayPoint withTimestep(Integer timestep) {
        this.timestep = timestep;
        return this;
    }

    public DefinedWayPoint withWayPoint(Integer wayPoint) {
        this.wayPoint = wayPoint;
        return this;
    }

}
