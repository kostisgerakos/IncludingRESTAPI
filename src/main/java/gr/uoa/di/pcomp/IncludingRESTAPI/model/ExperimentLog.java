package gr.uoa.di.pcomp.IncludingRESTAPI.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * The persistent class for the experiment_log database table.
 * 
 */
@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name="experiment_log")
@NamedQuery(name="ExperimentLog.findAll", query="SELECT e FROM ExperimentLog e")
public class ExperimentLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="experiment_log_id")
	private Integer experimentLogId;

	@Column(name="experiment_status")
	private String experimentStatus;

	@Column(name="experiment_status_message")
	private String experimentStatusMessage;

	@ManyToOne
	@JoinColumn(name="experiment_execution_id")
	private ExperimentExecution experimentExecution;

	@ManyToOne
	@JoinColumn(name="testbed_id")
	private Testbed testbed;

}