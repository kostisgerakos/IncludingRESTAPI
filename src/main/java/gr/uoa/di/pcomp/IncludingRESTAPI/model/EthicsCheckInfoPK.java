package gr.uoa.di.pcomp.IncludingRESTAPI.model;


import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The primary key class for the ethics_check_info database table.
 * 
 */
@Embeddable
@NoArgsConstructor
@Getter @Setter
public class EthicsCheckInfoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="script_id", insertable=false, updatable=false)
	private Integer scriptId;

	@Column(name="testbed_id", insertable=false, updatable=false)
	private Integer testbedId;

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof EthicsCheckInfoPK)) {
			return false;
		}
		EthicsCheckInfoPK castOther = (EthicsCheckInfoPK)other;
		return 
			this.scriptId.equals(castOther.scriptId)
			&& this.testbedId.equals(castOther.testbedId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.scriptId.hashCode();
		hash = hash * prime + this.testbedId.hashCode();
		
		return hash;
	}
}
