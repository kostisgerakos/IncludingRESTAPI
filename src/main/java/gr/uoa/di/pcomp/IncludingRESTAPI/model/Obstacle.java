package gr.uoa.di.pcomp.IncludingRESTAPI.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


/**
 * The persistent class for the operators_category database table.
 * 
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Table(name="obstacle")
@NamedQuery(name="Obstacle.findAll", query="SELECT o FROM Obstacle o")
public class Obstacle implements Serializable {
	

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="obstacle_id")
	private Integer obstacleId;

	@Column(name="obstacle_area")
	@NotNull
	private String obstacle;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="testbedArea")
	private TestbedArea testbedArea;

}