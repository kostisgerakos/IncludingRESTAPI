package gr.uoa.di.pcomp.IncludingRESTAPI.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


/**
 * The persistent class for the health_status_lut database table.
 * 
 */
@Entity
@Getter @Setter
@Table(name="health_status")
@NamedQuery(name="HealthStatus.findAll", query="SELECT h FROM HealthStatus h")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "healthStatusId")
public class HealthStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="health_status_id")
	private Integer healthStatusId;

	@Column(name="health_status_descr")
	private String healthStatusDescr;

	//bi-directional many-to-one association to Resource
	//@Transient
	//@JsonIgnore
	//@OneToMany(mappedBy="healthStatusLut")
	//private List<Resource> resources;

	public HealthStatus() {
	}

	/*public Resource addResource(Resource resource) {
		getResources().add(resource);
		resource.setHealthStatusLut(this);

		return resource;
	}

	public Resource removeResource(Resource resource) {
		getResources().remove(resource);
		resource.setHealthStatusLut(null);

		return resource;
	}*/

}