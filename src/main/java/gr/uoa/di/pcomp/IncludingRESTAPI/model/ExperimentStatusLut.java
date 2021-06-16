package gr.uoa.di.pcomp.IncludingRESTAPI.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


/**
 * The persistent class for the experiment_status_lut database table.
 * 
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Table(name="experiment_status_lut")
@NamedQuery(name="ExperimentStatusLut.findAll", query="SELECT e FROM ExperimentStatusLut e")
public class ExperimentStatusLut implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="experiment_status_id")
	private Integer experimentStatusId;

	@Column(name="experiment_status_descr")
	private String experimentStatusDescr;

	//bi-directional many-to-one association to Experiment
	@OneToMany(mappedBy="experimentStatusLut")
	private List<Experiment> experiments;

	public Experiment addExperiment(Experiment experiment) {
		getExperiments().add(experiment);
		experiment.setExperimentStatusLut(this);

		return experiment;
	}

	public Experiment removeExperiment(Experiment experiment) {
		getExperiments().remove(experiment);
		experiment.setExperimentStatusLut(null);

		return experiment;
	}

	public ExperimentStatusLut(Integer experimentStatusId, String experimentStatusDescr) {
		super();
		this.experimentStatusId = experimentStatusId;
		this.experimentStatusDescr = experimentStatusDescr;
	}
	
	

}