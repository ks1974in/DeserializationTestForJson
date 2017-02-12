package in.cloudnine.nanoerp.model.masters;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import in.cloudnine.serverframework.data.interfaces.root.DataReferenceImpl;

import java.util.Date;


/**
 * The persistent class for the StockType database table.
 * 
 */
@JsonIdentityInfo(
		generator=ObjectIdGenerators.UUIDGenerator.class,
		property="_stockTypeId",
		scope=StockType.class
		)
@Table(name="StockType")
@Entity
@NamedQuery(name="StockType.findAll", query="SELECT s FROM StockType s")
public class StockType extends DataReferenceImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="StockTypeId")
	private String stockTypeId;

	@Column(name="Code")
	private String code;

	

	@Column(name="Name")
	private String name;

	public StockType() {
	}

	public String getStockTypeId() {
		return this.stockTypeId;
	}

	public void setStockTypeId(String stockTypeId) {
		this.stockTypeId = stockTypeId;
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

}