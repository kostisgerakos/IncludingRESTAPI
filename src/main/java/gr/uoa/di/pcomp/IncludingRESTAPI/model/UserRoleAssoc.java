package gr.uoa.di.pcomp.IncludingRESTAPI.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;


/**
 * The persistent class for the user_role_assoc database table.
 * 
 */
@Entity
@Getter @Setter
@Table(name="user_role_assoc")
@NamedQuery(name="UserRoleAssoc.findAll", query="SELECT u FROM UserRoleAssoc u")
public class UserRoleAssoc implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UserRoleAssocPK id;

	//bi-directional many-to-one association to Testbed
	@ManyToOne
	@JoinColumn(name="testbed_id")
	private Testbed testbed;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id", insertable=false, updatable=false)
	private User user;

	//bi-directional many-to-one association to UserRole
	@ManyToOne
	@JoinColumn(name="role_id", insertable=false, updatable=false)
	private UserRole userRole;

	public UserRoleAssoc() {
	}

	public UserRoleAssocPK getId() {
		return this.id;
	}

}