package in.cloudnine.nanoerp.model.system;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import in.cloudnine.serverframework.data.interfaces.root.DataReferenceImpl;


/**
 * The persistent class for the SystemParameter database table.
 * 
 */
@JsonIdentityInfo(
		generator=ObjectIdGenerators.UUIDGenerator.class,
		property="_name",
		scope=SystemParameter.class
		)

@Entity
@Table(name="SystemParameter")
@NamedQuery(name="SystemParameter.findAll", query="SELECT s FROM SystemParameter s")
public class SystemParameter extends DataReferenceImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="Name", unique=true, nullable=false, length=36)
	private String name;

	@Column(name="Value", length=256)
	private String value;

	public SystemParameter() {
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}