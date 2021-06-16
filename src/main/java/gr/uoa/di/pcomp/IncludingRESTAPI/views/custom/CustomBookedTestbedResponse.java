
package gr.uoa.di.pcomp.IncludingRESTAPI.views.custom;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
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
    "User",
    "boockedTestBeds"
})
public class CustomBookedTestbedResponse implements Serializable
{

    @JsonProperty("User")
    private String user;
    @JsonProperty("boockedTestBeds")
    private List<BoockedTestBed> boockedTestBeds = null;
    private final static long serialVersionUID = -3283453661090621026L;


    /**
     * 
     * @param boockedTestBeds
     * @param user
     */
    public CustomBookedTestbedResponse(String user, List<BoockedTestBed> boockedTestBeds) {
        super();
        this.user = user;
        
        this.boockedTestBeds = boockedTestBeds;
    }

	public CustomBookedTestbedResponse(List<ReservationProjectionCustom> findAllByUserUsername) {
		// TODO Auto-generated constructor stub
		if (!findAllByUserUsername.isEmpty()) {
			this.user = findAllByUserUsername.get(1).getUser();
			List<BoockedTestBed> boockedTestBeds = new ArrayList<BoockedTestBed>();
			List<String> testbedIndex  = new ArrayList<String>();		
			DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			DateTimeFormatter timeformatter = DateTimeFormatter.ofPattern("HH:mm");
			for(ReservationProjectionCustom projection:findAllByUserUsername) {
				if(!testbedIndex.contains(projection.getTestbedAreaName())) {
					testbedIndex.add(projection.getTestbedAreaName());
					boockedTestBeds.add(new BoockedTestBed(projection.getTestbedAreaName(),projection.getTestbedAreaIndoor(), projection.getTestbedAreaLocation(),projection.getValidFrom().format(dateformatter),projection.getValidFrom().format(timeformatter),projection.getValidUntil().format(timeformatter)));
				}
				else {
					boockedTestBeds.get(testbedIndex.indexOf(projection.getTestbedAreaName())).getDateTime().add(new DateTime(projection.getValidFrom().format(dateformatter),projection.getValidFrom().format(timeformatter),projection.getValidUntil().format(timeformatter)));
				}
			}
			this.boockedTestBeds = boockedTestBeds;
		}
	}

    public CustomBookedTestbedResponse withUser(String user) {
        this.user = user;
        return this;
    }

    public CustomBookedTestbedResponse withBoockedTestBeds(List<BoockedTestBed> boockedTestBeds) {
        this.boockedTestBeds = boockedTestBeds;
        return this;
    }

}
