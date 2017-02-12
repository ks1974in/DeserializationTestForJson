package in.cloudnine.nanoerp.model.masters;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import in.cloudnine.minerva.serverframework.data.impl.DataObjectImpl;

import java.util.Date;


/**
 * The persistent class for the Color database table.
 * 
 */
@JsonIdentityInfo(
		generator=ObjectIdGenerators.UUIDGenerator.class,
		property="_colorId",
		scope=Color.class
		)
@Table(name="Color")
@Entity
@NamedQuery(name="Color.findAll", query="SELECT c FROM Color c")
public class Color extends DataObjectImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ColorId")
	private String colorId;

	@Column(name="Code")
	private String code;


	@Column(name="Name")
	private String name;

	@Column(name="Value")
	private String value;

	public Color() {
	}

	public String getColorId() {
		return this.colorId;
	}

	public void setColorId(String colorId) {
		this.colorId = colorId;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
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