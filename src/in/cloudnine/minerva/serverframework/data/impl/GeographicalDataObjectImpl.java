package in.cloudnine.minerva.serverframework.data.impl;

import javax.persistence.Column;



import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import in.cloudnine.minerva.serverframework.data.interfaces.GeographicalEntity;
import in.cloudnine.nanoerp.model.system.City;
import in.cloudnine.nanoerp.model.system.Country;
import in.cloudnine.nanoerp.model.system.State;
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.PROTECTED_AND_PUBLIC)
@MappedSuperclass
public abstract class GeographicalDataObjectImpl extends DataObjectImpl implements GeographicalEntity{
	
	@Lob
	@Column(name="Address")
	private String address;


	@Column(name="PostalCode", nullable=false, length=36)
	private String postalCode;

	
	@ManyToOne
	@JoinColumn(name="CityId", nullable=false)
	private City city;
	

	@ManyToOne
	@JoinColumn(name="StateId", nullable=false)
	private State state;
	
	@ManyToOne
	@JoinColumn(name="CountryId", nullable=false)
	private Country country;

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
