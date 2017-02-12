package in.cloudnine.minerva.serverframework.data.interfaces;

import in.cloudnine.nanoerp.model.system.City;
import in.cloudnine.nanoerp.model.system.Country;
import in.cloudnine.nanoerp.model.system.State;

public interface GeographicalEntity {
public City getCity();
public State getState();
public Country getCountry();
public String getPostalCode();
public String getAddress();
public void setCity(City city);
public void setState(State state);
public void setCountry(Country country);
public void setPostalCode(String postalCode);
public void setAddress(String address);



}
