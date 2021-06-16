package gr.uoa.di.pcomp.IncludingRESTAPI.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


/**
 * The persistent class for the approval_lut database table.
 * 
 */
@Entity
@NoArgsConstructor
@Getter @Setter
@Table(name="approval_lut")
@NamedQuery(name="ApprovalLut.findAll", query="SELECT a FROM ApprovalLut a")
public class ApprovalLut implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String name;

	//bi-directional many-to-one association to EthicsCheckInfo
	@OneToMany(mappedBy="approvalLut1")
	private List<EthicsCheckInfo> ethicsCheckInfos1;

	//bi-directional many-to-one association to EthicsCheckInfo
	@OneToMany(mappedBy="approvalLut2")
	private List<EthicsCheckInfo> ethicsCheckInfos2;


	public EthicsCheckInfo addEthicsCheckInfos1(EthicsCheckInfo ethicsCheckInfos1) {
		getEthicsCheckInfos1().add(ethicsCheckInfos1);
		ethicsCheckInfos1.setApprovalLut1(this);

		return ethicsCheckInfos1;
	}

	public EthicsCheckInfo removeEthicsCheckInfos1(EthicsCheckInfo ethicsCheckInfos1) {
		getEthicsCheckInfos1().remove(ethicsCheckInfos1);
		ethicsCheckInfos1.setApprovalLut1(null);

		return ethicsCheckInfos1;
	}


	public EthicsCheckInfo addEthicsCheckInfos2(EthicsCheckInfo ethicsCheckInfos2) {
		getEthicsCheckInfos2().add(ethicsCheckInfos2);
		ethicsCheckInfos2.setApprovalLut2(this);

		return ethicsCheckInfos2;
	}

	public EthicsCheckInfo removeEthicsCheckInfos2(EthicsCheckInfo ethicsCheckInfos2) {
		getEthicsCheckInfos2().remove(ethicsCheckInfos2);
		ethicsCheckInfos2.setApprovalLut2(null);

		return ethicsCheckInfos2;
	}

}