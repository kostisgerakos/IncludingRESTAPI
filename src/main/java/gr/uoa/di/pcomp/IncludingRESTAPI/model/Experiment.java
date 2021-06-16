package gr.uoa.di.pcomp.IncludingRESTAPI.model;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the experiment database table.
 * 
 */
@Entity
@NoArgsConstructor
@Getter @Setter
@NamedQuery(name="Experiment.findAll", query="SELECT e FROM Experiment e")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "experimentId")
public class Experiment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//@GeneratedValue(strategy=GenerationType.IDENTITY,generator="native")
	//@GenericGenerator(name = "native",strategy = "native")
	@Column(name="experiment_id")
	private Integer experimentId;

	private String descrition;

	@Column(name="ended_at")
	private Timestamp endedAt;

	@Column(name="experiment_name")
	private String experimentName;

	@Column(name="experiment_version")
	private String experimentVersion;

	@Column(name="launched_at")
	private Timestamp launchedAt;

	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="script_id")
	private DdlScript ddlScript;

	@ManyToOne
	@JoinColumn(name="experiment_status")
	private ExperimentStatusLut experimentStatusLut;

	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	@OneToMany(mappedBy="experiment")
	private List<ReservationItem> reservationItems;
	
	@OneToMany(mappedBy="experiment")
	private List<ExperimentExecution> experimentExecutions;

	public ReservationItem addReservationItem(ReservationItem reservationItem) {
		getReservationItems().add(reservationItem);
		reservationItem.setExperiment(this);
		return reservationItem;
	}

	public ReservationItem removeReservationItem(ReservationItem reservationItem) {
		getReservationItems().remove(reservationItem);
		reservationItem.setExperiment(null);
		return reservationItem;
	}
	
	public ExperimentExecution addExperimentExecution(ExperimentExecution experimentExecution) {
		getExperimentExecutions().add(experimentExecution);
		experimentExecution.setExperiment(this);
		return experimentExecution;
	}

	public ExperimentExecution removeExperimentExecution(ExperimentExecution experimentExecution) {
		getExperimentExecutions().remove(experimentExecution);
		experimentExecution.setExperiment(null);
		return experimentExecution;
	}

	public Experiment(Integer experimentId, String descrition, Timestamp endedAt, String experimentName,
			String experimentVersion, Timestamp launchedAt, DdlScript ddlScript,
			ExperimentStatusLut experimentStatusLut, User user) {
		super();
		this.experimentId = experimentId;
		this.descrition = descrition;
		this.endedAt = endedAt;
		this.experimentName = experimentName;
		this.experimentVersion = experimentVersion;
		this.launchedAt = launchedAt;
		this.ddlScript = ddlScript;
		this.experimentStatusLut = experimentStatusLut;
		this.user = user;
	}
	

}