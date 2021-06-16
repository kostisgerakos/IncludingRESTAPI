
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
    "date",
    "startTime",
    "endTime"
})
public class DateTime implements Serializable
{

    @JsonProperty("date")
    private String date;
    @JsonProperty("startTime")
    private String startTime;
    @JsonProperty("endTime")
    private String endTime;
    private final static long serialVersionUID = 3993832367433338624L;

    /**
     * 
     * @param date
     * @param startTime
     * @param endTime
     */
    public DateTime(String date, String startTime, String endTime) {
        super();
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public DateTime withDate(String date) {
        this.date = date;
        return this;
    }
    
    public DateTime withStartTime(String startTime) {
        this.startTime = startTime;
        return this;
    }

    public DateTime withEndTime(String endTime) {
        this.endTime = endTime;
        return this;
    }

}
