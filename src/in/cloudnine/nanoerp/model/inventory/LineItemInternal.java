package in.cloudnine.nanoerp.model.inventory;

import java.io.Serializable;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import in.cloudnine.minerva.serverframework.data.impl.DataObjectImpl;
import in.cloudnine.nanoerp.model.masters.Color;
import in.cloudnine.nanoerp.model.masters.Manufacturer;
import in.cloudnine.nanoerp.model.masters.StockType;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the LineItemInternal database table.
 * 
 */
@JsonIdentityInfo(
		generator=ObjectIdGenerators.UUIDGenerator.class,
		property="_lineItemInternalId",
		scope=LineItemInternal.class
		)

@Entity
@Table(name="LineItemInternal")
@NamedQuery(name="LineItemInternal.findAll", query="SELECT l FROM LineItemInternal l")
public class LineItemInternal extends DataObjectImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="LineItemInternalId", unique=true, nullable=false, length=36)
	private String lineItemInternalId;

	@Column(name="Bags", nullable=false)
	private Integer bags;

	
	
	@Column(name="Kgs", nullable=false, precision=10, scale=2)
	private BigDecimal kgs;

	@Column(name="ManufacturerBatchNumber", nullable=false, length=36)
	private String manufacturerBatchNumber;

	@Column(name="Rate", nullable=false, precision=10, scale=2)
	private BigDecimal rate;


	@Column(name="Subtotal", nullable=false, precision=10, scale=2)
	private BigDecimal subtotal;

	@Column(name="Virgin", nullable=false)
	private Boolean virgin;

	//bi-directional many-to-one association to Color
	@ManyToOne
	@JoinColumn(name="ColorId", nullable=false)
	private Color color;

	//bi-directional many-to-one association to Manufacturer
	@ManyToOne
	@JoinColumn(name="ManufacturerId", nullable=false)
	private Manufacturer manufacturer;

	//bi-directional many-to-one association to Stock
	@ManyToOne
	@JoinColumn(name="StockId", nullable=false)
	private Stock stock;

	//bi-directional many-to-one association to StockType
	@ManyToOne
	@JoinColumn(name="StockTypeId", nullable=false)
	private StockType stockType;

	//bi-directional many-to-one association to StoresVoucherInternal
	@ManyToOne
	@JoinColumn(name="StoresVoucherInternalId", nullable=false)
	private StoresVoucherInternal storesVoucherInternal;

	
	@Column(name="SerialNumber", nullable=false, length=36)
	private String serialNumber;


	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public LineItemInternal() {
	}

	public String getLineItemInternalId() {
		return this.lineItemInternalId;
	}

	public void setLineItemInternalId(String lineItemInternalId) {
		this.lineItemInternalId = lineItemInternalId;
	}

	public Integer getBags() {
		return this.bags;
	}

	public void setBags(Integer bags) {
		this.bags = bags;
	}

	

	public BigDecimal getKgs() {
		return this.kgs;
	}

	public void setKgs(BigDecimal kgs) {
		this.kgs = kgs;
	}

	public String getManufacturerBatchNumber() {
		return this.manufacturerBatchNumber;
	}

	public void setManufacturerBatchNumber(String manufacturerBatchNumber) {
		this.manufacturerBatchNumber = manufacturerBatchNumber;
	}

	public BigDecimal getRate() {
		return this.rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	
	public BigDecimal getSubtotal() {
		return this.subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public Boolean getVirgin() {
		return this.virgin;
	}

	public void setVirgin(Boolean virgin) {
		this.virgin = virgin;
	}

	public Color getColor() {
		return this.color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Manufacturer getManufacturer() {
		return this.manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Stock getStock() {
		return this.stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public StockType getStockType() {
		return this.stockType;
	}

	public void setStockType(StockType stockType) {
		this.stockType = stockType;
	}

	public StoresVoucherInternal getStoresVoucherInternal() {
		return this.storesVoucherInternal;
	}

	public void setStoresVoucherInternal(StoresVoucherInternal storesVoucherInternal) {
		this.storesVoucherInternal = storesVoucherInternal;
	}

}