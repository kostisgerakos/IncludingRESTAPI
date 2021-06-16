package gr.uoa.di.pcomp.IncludingRESTAPI.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


/**
 * The persistent class for the ddl_script database table.
 * 
 */
@Entity
@Getter @Setter
@NoArgsConstructor
@Table(name="ddl_script")
@NamedQuery(name="DdlScript.findAll", query="SELECT d FROM DdlScript d")
public class DdlScript implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="script_id")
	private Integer scriptId;

	private String filename;

	@Column(name="gen_script_content",length=67108)
	private String genScriptContent;

	private String generatedfilename;

	@Column(name="real_script_content",length=67108)
	private String realScriptContent;

	@Column(name="script_content",length=67108)
	private String scriptContent;

	//bi-directional many-to-one association to Experiment
	//@JsonBackReference
	@JsonIgnore
	@OneToOne(cascade = {CascadeType.ALL},mappedBy = "ddlScript")
	private Experiment experiment;

	public DdlScript(Integer scriptId, String filename, String genScriptContent, String generatedfilename,
			String realScriptContent, String scriptContent) {
		super();
		this.scriptId = scriptId;
		this.filename = filename;
		this.genScriptContent = genScriptContent;
		this.generatedfilename = generatedfilename;
		this.realScriptContent = realScriptContent;
		this.scriptContent = scriptContent;
	}
	

	/*//bi-directional many-to-one association to EthicsCheckInfo
	@OneToMany(mappedBy="ddlScript")
	private List<EthicsCheckInfo> ethicsCheckInfos;
*/


}