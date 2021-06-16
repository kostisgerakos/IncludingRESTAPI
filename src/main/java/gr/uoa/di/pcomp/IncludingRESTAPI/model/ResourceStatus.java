package gr.uoa.di.pcomp.IncludingRESTAPI.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


/**
 * The persistent class for the resource_status_lut database table.
 * 
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Table(name="resource_status")
@NamedQuery(name="ResourceStatus.findAll", query="SELECT r FROM ResourceStatus r")
public class ResourceStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="resource_status_id")
	private Integer resourceStatusId;

	@Column(name="resource_status_descr")
	private String resourceStatusDescr;

	@OneToMany(mappedBy="resourceStatus")
	private List<Resource> resources;

	public Resource addResource(Resource resource) {
		getResources().add(resource);
		resource.setResourceStatus(this);
		return resource;
	}

	public Resource removeResource(Resource resource) {
		getResources().remove(resource);
		resource.setResourceStatus(null);
		return resource;
	}

}