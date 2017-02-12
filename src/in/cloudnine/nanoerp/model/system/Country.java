package in.cloudnine.nanoerp.model.system;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import in.cloudnine.serverframework.data.interfaces.root.DataReferenceImpl;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Country database table.
 * 
 */

@JsonIdentityInfo(
		generator=ObjectIdGenerators.UUIDGenerator.class,
		property="_countryId",
		scope=Country.class
		)

@Entity
@Table(name="Country")
@NamedQuery(name="Country.findAll", query="SELECT c FROM Country c")
public class Country extends DataReferenceImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CountryId", unique=true, nullable=false, length=36)
	private String countryId;

	@Column(name="Code", length=36)
	private String code;

	@Temporal(TemporalType.DATE)
	@Column(name="Date", nullable=false)
	private Date date;

	@Column(name="Name", length=36)
	private String name;

	//bi-directional many-to-one association to Company
	@JsonIgnore
	@OneToMany(mappedBy="country", fetch=FetchType.EAGER)
	private List<Company> companies;

	//bi-directional many-to-one association to State
	@JsonIgnore
	@OneToMany(mappedBy="country", fetch=FetchType.EAGER)
	private List<State> states;

	public Country() {
	}

	public String getCountryId() {
		return this.countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public List<Company> getCompanies() {
		return this.companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

	public Company addCompany(Company company) {
		getCompanies().add(company);
		company.setCountry(this);

		return company;
	}

	public Company removeCompany(Company company) {
		getCompanies().remove(company);
		company.setCountry(null);

		return company;
	}

	public List<State> getStates() {
		return this.states;
	}

	public void setStates(List<State> states) {
		this.states = states;
	}

	public State addState(State state) {
		getStates().add(state);
		state.setCountry(this);

		return state;
	}

	public State removeState(State state) {
		getStates().remove(state);
		state.setCountry(null);

		return state;
	}

}