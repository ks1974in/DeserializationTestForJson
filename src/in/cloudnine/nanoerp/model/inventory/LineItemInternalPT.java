package in.cloudnine.nanoerp.model.inventory;

import java.io.Serializable;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import in.cloudnine.minerva.serverframework.data.impl.DataObjectImpl;
import in.cloudnine.nanoerp.model.masters.Manufacturer;

import java.math.BigDecimal;


/**
 * The persistent class for the LineItemInternalPT database table.
 * 
 */
@JsonIdentityInfo(
		generator=ObjectIdGenerators.UUIDGenerator.class,
		property="_lineItemInternalPTId",
		scope=LineItemInternalPT.class
		)

@Entity
@Table(name="LineItemInternalPT")
@NamedQuery(name="LineItemInternalPT.findAll", query="SELECT l FROM LineItemInternalPT l")
public class LineItemInternalPT extends DataObjectImpl  implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="LineItemInternalPTId", unique=true, nullable=false, length=36)
	private String lineItemInternalPTId;

	

	@Column(name="InnerDiameter", nullable=false, precision=10, scale=2)
	private BigDecimal innerDiameter;

	@Column(name="Nos", nullable=false)
	private Integer nos;

	@Column(name="OuterDiameter", nullable=false, precision=10, scale=2)
	private BigDecimal outerDiameter;

	@Column(name="Size", nullable=false, precision=10, scale=2)
	private BigDecimal size;

	@Column(name="StockPTId", nullable=false, length=36)
	private String stockPTId;

	@Column(name="Weight", nullable=false, precision=10, scale=2)
	private BigDecimal weight;

	@Column(name="WeightPerInch", nullable=false, precision=10, scale=2)
	private BigDecimal weightPerInch;

	//bi-directional many-to-one association to Manufacturer
	@ManyToOne
	@JoinColumn(name="ManufacturerId", nullable=false)
	private Manufacturer manufacturer;

	//bi-directional many-to-one association to StoresVoucherInternal
	@ManyToOne
	@JoinColumn(name="StoresVoucherInternalId", nullable=false)
	private StoresVoucherInternal storesVoucherInternal;

	public LineItemInternalPT() {
	}

	public String getLineItemInternalPTId() {
		return this.lineItemInternalPTId;
	}

	public void setLineItemInternalPTId(String lineItemInternalPTId) {
		this.lineItemInternalPTId = lineItemInternalPTId;
	}


	public BigDecimal getInnerDiameter() {
		return this.innerDiameter;
	}

	public void setInnerDiameter(BigDecimal innerDiameter) {
		this.innerDiameter = innerDiameter;
	}

	public Integer getNos() {
		return this.nos;
	}

	public void setNos(Integer nos) {
		this.nos = nos;
	}

	public BigDecimal getOuterDiameter() {
		return this.outerDiameter;
	}

	public void setOuterDiameter(BigDecimal outerDiameter) {
		this.outerDiameter = outerDiameter;
	}

	public BigDecimal getSize() {
		return this.size;
	}

	public void setSize(BigDecimal size) {
		this.size = size;
	}

	public String getStockPTId() {
		return this.stockPTId;
	}

	public void setStockPTId(String stockPTId) {
		this.stockPTId = stockPTId;
	}

	public BigDecimal getWeight() {
		return this.weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public BigDecimal getWeightPerInch() {
		return this.weightPerInch;
	}

	public void setWeightPerInch(BigDecimal weightPerInch) {
		this.weightPerInch = weightPerInch;
	}

	public Manufacturer getManufacturer() {
		return this.manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	public StoresVoucherInternal getStoresVoucherInternal() {
		return this.storesVoucherInternal;
	}

	public void setStoresVoucherInternal(StoresVoucherInternal storesVoucherInternal) {
		this.storesVoucherInternal = storesVoucherInternal;
	}

}