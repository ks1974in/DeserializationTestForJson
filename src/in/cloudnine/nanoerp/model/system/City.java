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
 * The persistent class for the City database table.
 * 
 */

@JsonIdentityInfo(
		generator=ObjectIdGenerators.UUIDGenerator.class,
		property="_cityId",
		scope=City.class
		)
@Entity
@Table(name="City")
@NamedQuery(name="City.findAll", query="SELECT c FROM City c")
public class City extends DataReferenceImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CityId", unique=true, nullable=false, length=36)
	private String cityId;

	@Column(name="Code", nullable=false, length=36)
	private String code;

	@Temporal(TemporalType.DATE)
	@Column(name="Date", nullable=false)
	private Date date;

	@Column(name="Name", nullable=false, length=36)
	private String name;

	//bi-directional many-to-one association to State
	@ManyToOne
	@JoinColumn(name="StateId", nullable=false)
	private State state;

	//bi-directional many-to-one association to Company
	@JsonIgnore
	@OneToMany(mappedBy="city", fetch=FetchType.EAGER)
	private List<Company> companies;

	public City() {
	}

	public String getCityId() {
		return this.cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
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

	public State getState() {
		return this.state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public List<Company> getCompanies() {
		return this.companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

	public Company addCompany(Company company) {
		getCompanies().add(company);
		company.setCity(this);

		return company;
	}

	public Company removeCompany(Company company) {
		getCompanies().remove(company);
		company.setCity(null);

		return company;
	}

}