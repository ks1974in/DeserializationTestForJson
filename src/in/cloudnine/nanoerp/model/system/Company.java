package in.cloudnine.nanoerp.model.system;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import in.cloudnine.serverframework.data.interfaces.root.DataReferenceImpl;

import java.util.List;


/**
 * The persistent class for the Company database table.
 * 
 */

@JsonIdentityInfo(
		generator=ObjectIdGenerators.UUIDGenerator.class,
		property="_companyId",
		scope=Company.class
		
	)
//@JsonIdentityInfo(generator=ObjectIdGenerators.UUIDGenerator.class, property="_@Id")
@Entity
@Table(name="Company")
@NamedQuery(name="Company.findAll", query="SELECT c FROM Company c")
public class Company extends DataReferenceImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CompanyId", unique=true, nullable=false, length=36)
	private String companyId;

	@Lob
	@Column(name="Address")
	private String address;

	@Column(name="Code", length=36)
	private String code;

	@Column(name="EmailAddress", length=36)
	private String emailAddress;

	@Column(name="Name", nullable=false, length=256)
	private String name;

	@Column(name="PhoneNumber", length=36)
	private String phoneNumber;

	@Column(name="Pincode", nullable=false, length=36)
	private String pincode;

	//bi-directional many-to-one association to AccessControlListMaster
	@JsonIgnore
	@OneToMany(mappedBy="company", fetch=FetchType.EAGER)
	private List<AccessControlListMaster> accessControlListMasters;

	//bi-directional many-to-one association to City
	@ManyToOne
	@JoinColumn(name="CityId", nullable=false)
	private City city;

	//bi-directional many-to-one association to Country
	@ManyToOne
	@JoinColumn(name="CountryId", nullable=false)
	private Country country;

	//bi-directional many-to-one association to State
	@ManyToOne
	@JoinColumn(name="StateId", nullable=false)
	private State state;

	//bi-directional many-to-one association to DocumentSerialNumber
	@JsonIgnore
	@OneToMany(mappedBy="company", fetch=FetchType.EAGER)
	private List<DocumentSerialNumber> documentSerialNumbers;

	//bi-directional many-to-one association to SystemUser
	@JsonIgnore
	@OneToMany(mappedBy="company", fetch=FetchType.EAGER)
	private List<SystemUser> systemUsers;

	//bi-directional many-to-one association to UserGroup
	@JsonIgnore
	@OneToMany(mappedBy="company", fetch=FetchType.EAGER)
	private List<UserGroup> userGroups;

	public Company() {
	}

	public String getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getEmailAddress() {
		return this.emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPincode() {
		return this.pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public List<AccessControlListMaster> getAccessControlListMasters() {
		return this.accessControlListMasters;
	}

	public void setAccessControlListMasters(List<AccessControlListMaster> accessControlListMasters) {
		this.accessControlListMasters = accessControlListMasters;
	}

	public AccessControlListMaster addAccessControlListMaster(AccessControlListMaster accessControlListMaster) {
		getAccessControlListMasters().add(accessControlListMaster);
		accessControlListMaster.setCompany(this);

		return accessControlListMaster;
	}

	public AccessControlListMaster removeAccessControlListMaster(AccessControlListMaster accessControlListMaster) {
		getAccessControlListMasters().remove(accessControlListMaster);
		accessControlListMaster.setCompany(null);

		return accessControlListMaster;
	}

	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public State getState() {
		return this.state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public List<DocumentSerialNumber> getDocumentSerialNumbers() {
		return this.documentSerialNumbers;
	}

	public void setDocumentSerialNumbers(List<DocumentSerialNumber> documentSerialNumbers) {
		this.documentSerialNumbers = documentSerialNumbers;
	}

	public DocumentSerialNumber addDocumentSerialNumber(DocumentSerialNumber documentSerialNumber) {
		getDocumentSerialNumbers().add(documentSerialNumber);
		documentSerialNumber.setCompany(this);

		return documentSerialNumber;
	}

	public DocumentSerialNumber removeDocumentSerialNumber(DocumentSerialNumber documentSerialNumber) {
		getDocumentSerialNumbers().remove(documentSerialNumber);
		documentSerialNumber.setCompany(null);

		return documentSerialNumber;
	}

	public List<SystemUser> getSystemUsers() {
		return this.systemUsers;
	}

	public void setSystemUsers(List<SystemUser> systemUsers) {
		this.systemUsers = systemUsers;
	}

	public SystemUser addSystemUser(SystemUser systemUser) {
		getSystemUsers().add(systemUser);
		systemUser.setCompany(this);

		return systemUser;
	}

	public SystemUser removeSystemUser(SystemUser systemUser) {
		getSystemUsers().remove(systemUser);
		systemUser.setCompany(null);

		return systemUser;
	}

	public List<UserGroup> getUserGroups() {
		return this.userGroups;
	}

	public void setUserGroups(List<UserGroup> userGroups) {
		this.userGroups = userGroups;
	}

	public UserGroup addUserGroup(UserGroup userGroup) {
		getUserGroups().add(userGroup);
		userGroup.setCompany(this);

		return userGroup;
	}

	public UserGroup removeUserGroup(UserGroup userGroup) {
		getUserGroups().remove(userGroup);
		userGroup.setCompany(null);

		return userGroup;
	}

}