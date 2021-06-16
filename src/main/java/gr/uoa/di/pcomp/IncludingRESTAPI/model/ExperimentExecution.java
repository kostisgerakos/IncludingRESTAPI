package gr.uoa.di.pcomp.IncludingRESTAPI.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;


/**
 * The persistent class for the experiment_execution database table.
 * 
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="experiment_execution")
@NamedQuery(name="ExperimentExecution.findAll", query="SELECT e FROM ExperimentExecution e")
public class ExperimentExecution implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="experiment_execution_id")
	private Integer experimentExecutionId;

	@Column(name="end_execution", columnDefinition = "TIMESTAMP")
	private LocalDateTime endExecution;

	@Column(name="experiment_status")
	private Integer experimentStatus;

	@Column(name="start_execution", columnDefinition = "TIMESTAMP")
	private LocalDateTime startExecution;

	@OneToMany(mappedBy="experimentExecution")
	private List<ExperimentLog> experimentLogs;
	
	@ManyToOne
	@JoinColumn(name="experiment_id")
	private Experiment experiment;

	public ExperimentLog addExperimentLog(ExperimentLog experimentLog) {
		getExperimentLogs().add(experimentLog);
		experimentLog.setExperimentExecution(this);
		return experimentLog;
	}

	public ExperimentLog removeExperimentLog(ExperimentLog experimentLog) {
		getExperimentLogs().remove(experimentLog);
		experimentLog.setExperimentExecution(null);
		return experimentLog;
	}

	public ExperimentExecution(LocalDateTime startExecution,  LocalDateTime endExecution, Integer experimentStatus, 
			Experiment experiment) {
		super();
		this.endExecution = endExecution;
		this.experimentStatus = experimentStatus;
		this.startExecution = startExecution;
		this.experiment = experiment;
	}
	
	

}