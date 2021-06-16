package gr.uoa.di.pcomp.IncludingRESTAPI.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/*import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;*/


import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The persistent class for the testbed database table.
 * 
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@NamedQuery(name="Testbed.findAll", query="SELECT t FROM Testbed t")
@Table(name = "testbed", uniqueConstraints={@UniqueConstraint(columnNames={"name"})}) 
public class Testbed implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="testbed_id")
	private Integer testbedId;

	private Double accuracy;
	
	@NotNull
	private String area;

	@Column(name="location")//,columnDefinition = "Point")
	@NotNull
	private String location;
	
	@NotNull
	private String name;
	
	private String description;

	@Column(name="operation_end_time", columnDefinition = "TIME")
	@NotNull
	private LocalTime operationEndTime;

	@Column(name="operation_start_time", columnDefinition = "TIME")
	@NotNull
	private LocalTime operationStartTime;

	@NotNull
	private Boolean simulator;
	
	@Column(name="testbedStatusMessage")
	private String testbedStatusMessage;
	
	@Column(name="auv_support")
	private Boolean auvSupport;

	@Column(name="uav_support")
	private Boolean uavSupport;

	@Column(name="ugv_support")
	private Boolean ugvSupport;

	@Column(name="usv_support")
	private Boolean usvSupport;

	@Column(name="vr_enabled")
	private Boolean vrEnabled;

	@OneToMany(mappedBy="testbed")
	private List<ExperimentLog> experimentLogs;

	@OneToMany(mappedBy="testbed")
	private List<TestbedArea> testbedAreas;

	@OneToMany(mappedBy="testbed")
	private List<UserRoleAssoc> userRoleAssocs;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="health")
	private HealthStatus healthStatus;
	
/*	@OneToMany(mappedBy="testbed")
	private List<EthicsCheckInfo> ethicsCheckInfos;

*/
	public ExperimentLog addExperimentLog(ExperimentLog experimentLog) {
		getExperimentLogs().add(experimentLog);
		experimentLog.setTestbed(this);

		return experimentLog;
	}

	public ExperimentLog removeExperimentLog(ExperimentLog experimentLog) {
		getExperimentLogs().remove(experimentLog);
		experimentLog.setTestbed(null);

		return experimentLog;
	}

	public TestbedArea addTestbedArea(TestbedArea testbedArea) {
		getTestbedAreas().add(testbedArea);
		testbedArea.setTestbed(this);

		return testbedArea;
	}

	public TestbedArea removeTestbedArea(TestbedArea testbedArea) {
		getTestbedAreas().remove(testbedArea);
		testbedArea.setTestbed(null);

		return testbedArea;
	}

	public UserRoleAssoc addUserRoleAssoc(UserRoleAssoc userRoleAssoc) {
		getUserRoleAssocs().add(userRoleAssoc);
		userRoleAssoc.setTestbed(this);

		return userRoleAssoc;
	}

	public UserRoleAssoc removeUserRoleAssoc(UserRoleAssoc userRoleAssoc) {
		getUserRoleAssocs().remove(userRoleAssoc);
		userRoleAssoc.setTestbed(null);

		return userRoleAssoc;
	}

	public Testbed(Integer testbedId, Double accuracy, @NotNull String area, @NotNull String location,
			@NotNull String name, String description, @NotNull LocalTime operationEndTime,
			@NotNull LocalTime operationStartTime, @NotNull Boolean simulator, String testbedStatusMessage,
			Boolean auvSupport, Boolean uavSupport, Boolean ugvSupport, Boolean usvSupport, Boolean vrEnabled) {
		super();
		this.testbedId = testbedId;
		this.accuracy = accuracy;
		this.area = area;
		this.location = location;
		this.name = name;
		this.description = description;
		this.operationEndTime = operationEndTime;
		this.operationStartTime = operationStartTime;
		this.simulator = simulator;
		this.testbedStatusMessage = testbedStatusMessage;
		this.auvSupport = auvSupport;
		this.uavSupport = uavSupport;
		this.ugvSupport = ugvSupport;
		this.usvSupport = usvSupport;
		this.vrEnabled = vrEnabled;
	}
}
