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
 * The persistent class for the State database table.
 * 
 */
@JsonIdentityInfo(
		generator=ObjectIdGenerators.UUIDGenerator.class,
		property="_stateId",
		scope=State.class
		)

@Entity
@Table(name="State")
@NamedQuery(name="State.findAll", query="SELECT s FROM State s")
public class State extends DataReferenceImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="StateId", unique=true, nullable=false, length=36)
	private String stateId;

	@Column(name="Code", length=36)
	private String code;

	@Temporal(TemporalType.DATE)
	@Column(name="Date", nullable=false)
	private Date date;

	@Column(name="Name", length=36)
	private String name;

	//bi-directional many-to-one association to City
	@JsonIgnore
	@OneToMany(mappedBy="state", fetch=FetchType.EAGER)
	private List<City> cities;

	@JsonIgnore
	//bi-directional many-to-one association to Company
	@OneToMany(mappedBy="state", fetch=FetchType.EAGER)
	private List<Company> companies;

	//bi-directional many-to-one association to Country
	@ManyToOne
	@JoinColumn(name="CountryId")
	private Country country;

	public State() {
	}

	public String getStateId() {
		return this.stateId;
	}

	public void setStateId(String stateId) {
		this.stateId = stateId;
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

	public List<City> getCities() {
		return this.cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	public City addCity(City city) {
		getCities().add(city);
		city.setState(this);

		return city;
	}

	public City removeCity(City city) {
		getCities().remove(city);
		city.setState(null);

		return city;
	}

	public List<Company> getCompanies() {
		return this.companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

	public Company addCompany(Company company) {
		getCompanies().add(company);
		company.setState(this);

		return company;
	}

	public Company removeCompany(Company company) {
		getCompanies().remove(company);
		company.setState(null);

		return company;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

}