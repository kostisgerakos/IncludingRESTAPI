
package gr.uoa.di.pcomp.IncludingRESTAPI.views.custom;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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
    "testBed",
    "type",
    "location",
    "dateTime"
})
public class BoockedTestBed implements Serializable
{

    @JsonProperty("testBed")
    private String testBed;
    @JsonProperty("type")
    private String type;
    @JsonProperty("location")
    private List<String> location = null;
    @JsonProperty("dateTime")
    private List<DateTime> dateTime = null;
    private final static long serialVersionUID = -6881714492416273815L;

    /**
     * 
     * @param dateTime
     * @param testBed
     * @param location
     * @param type
     */
    public BoockedTestBed(String testBed, String type, List<String> location, List<DateTime> dateTime) {
        super();
        this.testBed = testBed;
        this.type = type;
        this.location = location;
        this.dateTime = dateTime;
    }

	public BoockedTestBed(String testBed, Boolean type, String location, String validFromDate, String ValidFromTime,
			String validUntilTime) {
		super();
		this.testBed = testBed;
		this.type = type ? "indoor" : "outdoor";
		this.location = new ArrayList<String>();
		this.location.add(location.split(",")[1]);
		this.location.add(location.split(",")[0]);
		this.dateTime = new ArrayList<DateTime>(
				Arrays.asList(new DateTime(validFromDate, ValidFromTime, validUntilTime)));
	}


    public BoockedTestBed withTestBed(String testBed) {
        this.testBed = testBed;
        return this;
    }

    public BoockedTestBed withType(String type) {
        this.type = type;
        return this;
    }

    public BoockedTestBed withLocation(List<String> location) {
        this.location = location;
        return this;
    }

    public BoockedTestBed withDateTime(List<DateTime> dateTime) {
        this.dateTime = dateTime;
        return this;
    }

}
