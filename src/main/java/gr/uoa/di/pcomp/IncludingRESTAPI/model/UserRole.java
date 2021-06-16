package gr.uoa.di.pcomp.IncludingRESTAPI.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


/**
 * The persistent class for the user_role database table.
 * 
 */
@Entity
@Getter @Setter
@Table(name="user_role")
@NamedQuery(name="UserRole.findAll", query="SELECT u FROM UserRole u")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "roleId")
public class UserRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="role_id")
	private Integer roleId;

	private String description;

	//bi-directional many-to-one association to UserRoleAssoc
	@OneToMany(mappedBy="userRole")
	private List<UserRoleAssoc> userRoleAssocs;

	public UserRole() {
	}

	public UserRoleAssoc addUserRoleAssoc(UserRoleAssoc userRoleAssoc) {
		getUserRoleAssocs().add(userRoleAssoc);
		userRoleAssoc.setUserRole(this);
		return userRoleAssoc;
	}

	public UserRoleAssoc removeUserRoleAssoc(UserRoleAssoc userRoleAssoc) {
		getUserRoleAssocs().remove(userRoleAssoc);
		userRoleAssoc.setUserRole(null);
		return userRoleAssoc;
	}

}