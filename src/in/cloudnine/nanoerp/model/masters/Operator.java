package in.cloudnine.nanoerp.model.masters;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import in.cloudnine.minerva.serverframework.data.impl.DataObjectImpl;

import java.util.Date;


/**
 * The persistent class for the Operator database table.
 * 
 */
@JsonIdentityInfo(
		generator=ObjectIdGenerators.UUIDGenerator.class,
		property="_operatorId",
		scope=Operator.class
		)
@Table(name="Operator")
@Entity
@NamedQuery(name="Operator.findAll", query="SELECT o FROM Operator o")
public class Operator extends DataObjectImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="OperatorId")
	private String operatorId;

	@Column(name="Code")
	private String code;

	
	@Column(name="Name")
	private String name;

	@Lob
	@Column(name="Remarks")
	private String remarks;

	public Operator() {
	}

	public String getOperatorId() {
		return this.operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}