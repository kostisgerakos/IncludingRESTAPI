package gr.uoa.di.pcomp.IncludingRESTAPI.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


/**
 * The persistent class for the resource_type_lut database table.
 * 
 */
@Entity
@NoArgsConstructor
@Getter @Setter
@Table(name="resource_type")
@NamedQuery(name="ResourceType.findAll", query="SELECT r FROM ResourceType r")
public class ResourceType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="resource_type_id")
	private Integer resourceTypeId;

	@Column(name="resource_type")
	private String resourceType;

	@OneToMany(mappedBy="resourceType")
	private List<Resource> resources;

	public Resource addResource(Resource resource) {
		getResources().add(resource);
		resource.setResourceType(this);
		return resource;
	}

	public Resource removeResource(Resource resource) {
		getResources().remove(resource);
		resource.setResourceType(null);
		return resource;
	}

	public ResourceType(Integer resourceTypeId, String resourceType) {
		super();
		this.resourceTypeId = resourceTypeId;
		this.resourceType = resourceType;
	}

}