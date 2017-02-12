package in.cloudnine.nanoerp.model.system;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import in.cloudnine.serverframework.data.interfaces.root.DataReferenceImpl;

import java.util.Date;


/**
 * The persistent class for the SystemUser database table.
 * 
 */
@JsonIdentityInfo(
		generator=ObjectIdGenerators.UUIDGenerator.class,
		property="_systemUserId",
		scope=SystemUser.class
		)

@Entity
@Table(name="SystemUser")
@NamedQuery(name="SystemUser.findAll", query="SELECT s FROM SystemUser s")
public class SystemUser extends DataReferenceImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SystemUserId", unique=true, nullable=false, length=36)
	private String systemUserId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="Date")
	private Date date;

	@Column(name="Enabled", nullable=false)
	private Boolean enabled;

	@Column(name="FirstName", nullable=false, length=36)
	private String firstName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LastLogin", nullable=false)
	private Date lastLogin;

	@Column(name="LastName", nullable=false, length=36)
	private String lastName;

	@Column(name="Password", nullable=false, length=36)
	private String password;

	@Column(name="UserName", nullable=false, length=36)
	private String userName;

	//bi-directional many-to-one association to Company
	@ManyToOne
	@JoinColumn(name="CompanyId", nullable=false)
	private Company company;

	//bi-directional many-to-one association to UserGroup
	@ManyToOne
	@JoinColumn(name="UserGroupId", nullable=false)
	private UserGroup userGroup;

	public SystemUser() {
	}

	public String getSystemUserId() {
		return this.systemUserId;
	}

	public void setSystemUserId(String systemUserId) {
		this.systemUserId = systemUserId;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Boolean getEnabled() {
		return this.enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Date getLastLogin() {
		return this.lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public UserGroup getUserGroup() {
		return this.userGroup;
	}

	public void setUserGroup(UserGroup userGroup) {
		this.userGroup = userGroup;
	}

}