package gr.uoa.di.pcomp.IncludingRESTAPI.views.custom;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "reservationId", "validFromDate", "validFromTime", "validUntilDate", "validUntilTime" })
public class ReservationTimestamps implements Serializable {

	@JsonProperty("reservationId")
	public int reservationId;
	@JsonProperty("validFromDate")
	public String validFromDate;
	@JsonProperty("validFromTime")
	public String validFromTime;
	@JsonProperty("validUntilDate")
	public String validUntilDate;
	@JsonProperty("validUntilTime")
	public String validUntilTime;
	private final static long serialVersionUID = -259218983559017660L;

}