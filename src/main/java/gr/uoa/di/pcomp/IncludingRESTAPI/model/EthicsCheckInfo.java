package gr.uoa.di.pcomp.IncludingRESTAPI.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;


/**
 * The persistent class for the ethics_check_info database table.
 * 
 */
@Entity
@NoArgsConstructor
@Getter @Setter
@Table(name="ethics_check_info")
@NamedQuery(name="EthicsCheckInfo.findAll", query="SELECT e FROM EthicsCheckInfo e")
public class EthicsCheckInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EthicsCheckInfoPK id;

	@Column(name="email_check")
	private Boolean emailCheck;

	@Column(name="ethic_approval_time")
	private Timestamp ethicApprovalTime;

	@Column(name="ethic_comment")
	private String ethicComment;

	@Column(name="testbed_approval_time")
	private Timestamp testbedApprovalTime;

	@Column(name="testbed_comment")
	private String testbedComment;

	@ManyToOne
	@JoinColumn(name="ethic_approval_status")
	private ApprovalLut approvalLut1;

	@ManyToOne
	@JoinColumn(name="testbed_approval_status")
	private ApprovalLut approvalLut2;

	
/*	@ManyToOne(optional=false)
	@JoinColumn(name="scriptId",referencedColumnName="script_id", insertable=false, updatable=false)
	private DdlScript ddlScript;*/
/*
	@ManyToOne
	@JoinColumn(name="testbed_id")
	private Testbed testbed;*/

	@ManyToOne
	@JoinColumn(name="testbed_oper_id")
	private User testbedOper;

	@ManyToOne
	@JoinColumn(name="ethic_user_id")
	private User ethicUser;

	

}