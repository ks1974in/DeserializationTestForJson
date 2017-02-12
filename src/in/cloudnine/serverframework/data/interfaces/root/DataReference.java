package in.cloudnine.serverframework.data.interfaces.root;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

public interface DataReference extends Serializable{
	@JsonIgnore
	public Class getDataClass();
	@JsonIgnore
	public String getId();
}
