package in.cloudnine.nanoerp.model.system;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import in.cloudnine.serverframework.data.interfaces.root.DataReferenceImpl;


/**
 * The persistent class for the BusinessParameter database table.
 * 
 */

@JsonIdentityInfo(
		generator=ObjectIdGenerators.UUIDGenerator.class,
		property="_name",
		scope=BusinessParameter.class
		)
@Entity
@Table(name="BusinessParameter")
@NamedQuery(name="BusinessParameter.findAll", query="SELECT b FROM BusinessParameter b")
public class BusinessParameter extends DataReferenceImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="Name", unique=true, nullable=false, length=36)
	private String name;

	@Column(name="Value", nullable=false, length=256)
	private String value;

	public BusinessParameter() {
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