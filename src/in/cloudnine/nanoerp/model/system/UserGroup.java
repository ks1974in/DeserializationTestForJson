package in.cloudnine.nanoerp.model.system;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import in.cloudnine.serverframework.data.interfaces.root.DataReferenceImpl;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the UserGroup database table.
 * 
 */
@JsonIdentityInfo(
		generator=ObjectIdGenerators.UUIDGenerator.class,
		property="_userGroupId",
		scope=UserGroup.class
		)

@Entity
@Table(name="UserGroup")
@NamedQuery(name="UserGroup.findAll", query="SELECT u FROM UserGroup u")
public class UserGroup extends DataReferenceImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="UserGroupId", unique=true, nullable=false, length=36)
	private String userGroupId;

	@Column(name="Code", nullable=false, length=36)
	private String code;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CreatedOn", nullable=false)
	private Date createdOn;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="Date")
	private Date date;

	@Column(name="Name", nullable=false, length=36)
	private String name;

	//bi-directional many-to-one association to AccessControlListMaster
	@OneToMany(mappedBy="userGroup", fetch=FetchType.EAGER)
	private List<AccessControlListMaster> accessControlListMasters;

	//bi-directional many-to-one association to SystemUser
	@OneToMany(mappedBy="userGroup", fetch=FetchType.EAGER)
	private List<SystemUser> systemUsers;

	//bi-directional many-to-one association to Company
	@ManyToOne
	@JoinColumn(name="CompanyId", nullable=false)
	private Company company;

	public UserGroup() {
	}

	public String getUserGroupId() {
		return this.userGroupId;
	}

	public void setUserGroupId(String userGroupId) {
		this.userGroupId = userGroupId;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<AccessControlListMaster> getAccessControlListMasters() {
		return this.accessControlListMasters;
	}

	public void setAccessControlListMasters(List<AccessControlListMaster> accessControlListMasters) {
		this.accessControlListMasters = accessControlListMasters;
	}

	public AccessControlListMaster addAccessControlListMaster(AccessControlListMaster accessControlListMaster) {
		getAccessControlListMasters().add(accessControlListMaster);
		accessControlListMaster.setUserGroup(this);

		return accessControlListMaster;
	}

	public AccessControlListMaster removeAccessControlListMaster(AccessControlListMaster accessControlListMaster) {
		getAccessControlListMasters().remove(accessControlListMaster);
		accessControlListMaster.setUserGroup(null);

		return accessControlListMaster;
	}

	public List<SystemUser> getSystemUsers() {
		return this.systemUsers;
	}

	public void setSystemUsers(List<SystemUser> systemUsers) {
		this.systemUsers = systemUsers;
	}

	public SystemUser addSystemUser(SystemUser systemUser) {
		getSystemUsers().add(systemUser);
		systemUser.setUserGroup(this);

		return systemUser;
	}

	public SystemUser removeSystemUser(SystemUser systemUser) {
		getSystemUsers().remove(systemUser);
		systemUser.setUserGroup(null);

		return systemUser;
	}

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}