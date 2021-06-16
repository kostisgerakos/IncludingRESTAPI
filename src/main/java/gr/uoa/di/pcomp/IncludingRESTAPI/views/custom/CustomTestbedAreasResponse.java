
package gr.uoa.di.pcomp.IncludingRESTAPI.views.custom;

import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import gr.uoa.di.pcomp.IncludingRESTAPI.model.projection.ReservationProjectionCustom;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter @Setter
//@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "TestBedArea",
    "Polygon",
    "Obstacles"
})
public class CustomTestbedAreasResponse implements Serializable
{

    @JsonProperty("TestBedArea")
    private String testBedArea;
    @JsonProperty("Polygon")
    private String polygon;
    @JsonProperty("Obstacles")
    private List<String> obstacles;// = null;
    private final static long serialVersionUID = 99803092640999646L;


    public CustomTestbedAreasResponse(String testBedArea, String polygon, List<String> obstacles) {
        super();
        this.testBedArea = testBedArea;
        this.polygon = polygon;
        this.obstacles = obstacles;
    }
	
    public CustomTestbedAreasResponse withTestBedArea(String testBedArea) {
        this.testBedArea = testBedArea;
        return this;
    }

    public CustomTestbedAreasResponse withPolygon(String polygon) {
        this.polygon = polygon;
        return this;
    }

    public CustomTestbedAreasResponse withObstacles(List<String> obstacles) {
        this.obstacles = obstacles;
        return this;
    }

}
