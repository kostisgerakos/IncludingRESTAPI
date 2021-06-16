package gr.uoa.di.pcomp.IncludingRESTAPI.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The persistent class for the Uxv_type database table.
 * 
 */
@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "uxv_type")
@NamedQuery(name = "UxVType.findAll", query = "SELECT s FROM UxVType s")
public class UxVType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "uxv_type_id")
	private Integer UxVTypeId;

	@Column(name = "uxv_type")
	private String UxVType;

	@OneToMany(mappedBy = "UxVType")
	private List<UxV> UxVs;

	public UxV addOperator(UxV UxV) {
		getUxVs().add(UxV);
		UxV.setUxVType(this);
		return UxV;
	}

	public UxV removeUxv(UxV UxV) {
		getUxVs().remove(UxV);
		UxV.setUxVType(null);
		return UxV;
	}

	public UxVType(Integer uxvTypeId, String uxvType) {
		super();
		UxVTypeId = uxvTypeId;
		UxVType = uxvType;
	}
}