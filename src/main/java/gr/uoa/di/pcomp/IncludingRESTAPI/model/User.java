package gr.uoa.di.pcomp.IncludingRESTAPI.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Table(name = "user", uniqueConstraints={@UniqueConstraint(columnNames={"username"}), @UniqueConstraint(columnNames={"dn"})}, schema = "including_db") //schema should specified cause user is a reserved word for postgres
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "userId")
public class User implements Serializable 
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private Integer userId;

	private String email;

	private String firstname;
	
	@Column(name="surname")
	private String lastname;

	private String username;

	@Column(name="is_superuser")
	private Boolean isSuperuser;

	@Column(name="last_login")
	private Timestamp lastLogin;
	
	@JsonIgnore
	private String password;
	
	@Column(name="dn",length=256)//, unique=true)
	private String dn;

	//bi-directional many-to-one association to Experiment
	@OneToMany(mappedBy="user")
	private List<Experiment> experiments;

	//bi-directional many-to-one association to Reservation
	@OneToMany(mappedBy="user")
	private List<Reservation> reservations;

	//bi-directional many-to-one association to UserRoleAssoc
	@OneToMany(mappedBy="user")
	private List<UserRoleAssoc> userRoleAssocs;
	
	//bi-directional many-to-one association to EthicsCheckInfo
	@OneToMany(mappedBy="testbedOper")
	private List<EthicsCheckInfo> ethicsCheckInfos1;

	//bi-directional many-to-one association to EthicsCheckInfo
	@OneToMany(mappedBy="ethicUser")
	private List<EthicsCheckInfo> ethicsCheckInfos2;

	public Experiment addExperiment(Experiment experiment) {
		getExperiments().add(experiment);
		experiment.setUser(this);

		return experiment;
	}

	public Experiment removeExperiment(Experiment experiment) {
		getExperiments().remove(experiment);
		experiment.setUser(null);

		return experiment;
	}
	
	public Reservation addReservation(Reservation reservation) {
		getReservations().add(reservation);
		reservation.setUser(this);

		return reservation;
	}

	public Reservation removeReservation(Reservation reservation) {
		getReservations().remove(reservation);
		reservation.setUser(null);
		return reservation;
	}


	public UserRoleAssoc addUserRoleAssoc(UserRoleAssoc userRoleAssoc) {
		getUserRoleAssocs().add(userRoleAssoc);
		userRoleAssoc.setUser(this);
		return userRoleAssoc;
	}

	public UserRoleAssoc removeUserRoleAssoc(UserRoleAssoc userRoleAssoc) {
		getUserRoleAssocs().remove(userRoleAssoc);
		userRoleAssoc.setUser(null);
		return userRoleAssoc;
	}

	public User(Integer userId, String email, String firstname, String lastname, String username, Boolean isSuperuser,
			Timestamp lastLogin, String password, String dn) {
		super();
		this.userId = userId;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.isSuperuser = isSuperuser;
		this.lastLogin = lastLogin;
		this.password = password;
		this.dn = dn;
	}
	

}
