package in.cloudnine.nanoerp.model.system;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import in.cloudnine.serverframework.data.interfaces.root.DataReferenceImpl;

import java.util.Date;


/**
 * The persistent class for the AccessControlListMasters database table.
 * 
 */


@JsonIdentityInfo(
		generator=ObjectIdGenerators.UUIDGenerator.class,
		property="_accessControlListMastersId",
		scope=AccessControlListMaster.class
		)
@Entity
@Table(name="AccessControlListMasters")
@NamedQuery(name="AccessControlListMaster.findAll", query="SELECT a FROM AccessControlListMaster a")
public class AccessControlListMaster extends DataReferenceImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="AccessControlListMastersId", unique=true, nullable=false, length=36)
	private String accessControlListMastersId;

	@Column(name="`Create`", nullable=false)
	private Boolean create;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="Date")
	private Date date;

	@Column(name="`Delete`", nullable=false)
	private Boolean delete;

	@Column(name="Print", nullable=false)
	private Boolean print;

	@Column(name="`Update`", nullable=false)
	private Boolean update;

	@Column(name="`View`", nullable=false)
	private Boolean view;

	//bi-directional many-to-one association to Company
	@ManyToOne
	@JoinColumn(name="CompanyId", nullable=false)
	private Company company;

	//bi-directional many-to-one association to Master
	@ManyToOne
	@JoinColumn(name="MasterId", nullable=false)
	private Master master;

	//bi-directional many-to-one association to UserGroup
	@ManyToOne
	@JoinColumn(name="UserGroupId", nullable=false)
	private UserGroup userGroup;

	public AccessControlListMaster() {
	}

	public String getAccessControlListMastersId() {
		return this.accessControlListMastersId;
	}

	public void setAccessControlListMastersId(String accessControlListMastersId) {
		this.accessControlListMastersId = accessControlListMastersId;
	}

	public Boolean getCreate() {
		return this.create;
	}

	public void setCreate(Boolean create) {
		this.create = create;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Boolean getDelete() {
		return this.delete;
	}

	public void setDelete(Boolean delete) {
		this.delete = delete;
	}

	public Boolean getPrint() {
		return this.print;
	}

	public void setPrint(Boolean print) {
		this.print = print;
	}

	public Boolean getUpdate() {
		return this.update;
	}

	public void setUpdate(Boolean update) {
		this.update = update;
	}

	public Boolean getView() {
		return this.view;
	}

	public void setView(Boolean view) {
		this.view = view;
	}

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Master getMaster() {
		return this.master;
	}

	public void setMaster(Master master) {
		this.master = master;
	}

	public UserGroup getUserGroup() {
		return this.userGroup;
	}

	public void setUserGroup(UserGroup userGroup) {
		this.userGroup = userGroup;
	}

}