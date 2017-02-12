package in.cloudnine.nanoerp.model.inventory;

import java.io.Serializable;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import in.cloudnine.minerva.serverframework.data.impl.DataObjectImpl;
import in.cloudnine.nanoerp.model.masters.Color;
import in.cloudnine.nanoerp.model.masters.Manufacturer;
import in.cloudnine.nanoerp.model.masters.StockType;
import in.cloudnine.nanoerp.model.production.Program;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Stock database table.
 * 
 */
@JsonIdentityInfo(
		generator=ObjectIdGenerators.UUIDGenerator.class,
		property="_stockId",
		scope=Stock.class
		)

@Entity
@Table(name="Stock")
@NamedQuery(name="Stock.findAll", query="SELECT s FROM Stock s")
public class Stock extends DataObjectImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="StockId", unique=true, nullable=false, length=36)
	private String stockId;

	@Column(name="ClosingStockBags", nullable=false)
	private Integer closingStockBags;

	@Column(name="ClosingStockKgs", nullable=false, precision=10, scale=2)
	private BigDecimal closingStockKgs;

	@Column(name="ClosingStockValue", nullable=false, precision=10, scale=2)
	private BigDecimal closingStockValue;

	
	@Column(name="IssuesBags", nullable=false)
	private Integer issuesBags;

	@Column(name="IssuesKgs", nullable=false, precision=10, scale=2)
	private BigDecimal issuesKgs;

	@Column(name="IssuesValue", nullable=false, precision=10, scale=2)
	private BigDecimal issuesValue;

	@Column(name="ManufacturerBatchNumber", length=36)
	private String manufacturerBatchNumber;

	
	@Column(name="OpeningStockBags", nullable=false)
	private Integer openingStockBags;

	@Column(name="OpeningStockKgs", nullable=false, precision=10, scale=2)
	private BigDecimal openingStockKgs;

	@Column(name="OpeningStockValue", nullable=false, precision=10, scale=2)
	private BigDecimal openingStockValue;

	@Column(name="ReceiptsBags", nullable=false)
	private Integer receiptsBags;

	@Column(name="ReceiptsKgs", nullable=false, precision=10, scale=2)
	private BigDecimal receiptsKgs;

	@Column(name="ReceiptsValue", nullable=false, precision=10, scale=2)
	private BigDecimal receiptsValue;

	//bi-directional many-to-one association to LineItemExternal
	@OneToMany(mappedBy="stock", fetch=FetchType.EAGER)
	private List<LineItemExternal> lineItemExternals;

	//bi-directional many-to-one association to LineItemInternal
	@OneToMany(mappedBy="stock", fetch=FetchType.EAGER)
	private List<LineItemInternal> lineItemInternals;

	//bi-directional many-to-one association to Color
	@ManyToOne
	@JoinColumn(name="ColorId")
	private Color color;
	


	//bi-directional many-to-one association to Manufacturer
	@ManyToOne
	@JoinColumn(name="ManufacturerId", nullable=false)
	private Manufacturer manufacturer;

	//bi-directional many-to-one association to Program
	

	//bi-directional many-to-one association to StockType
	@ManyToOne
	@JoinColumn(name="StockTypeId", nullable=false)
	private StockType stockType;

	public Stock() {
	}

	public String getStockId() {
		return this.stockId;
	}

	public void setStockId(String stockId) {
		this.stockId = stockId;
	}

	public Integer getClosingStockBags() {
		return this.closingStockBags;
	}

	public void setClosingStockBags(Integer closingStockBags) {
		this.closingStockBags = closingStockBags;
	}

	public BigDecimal getClosingStockKgs() {
		return this.closingStockKgs;
	}

	public void setClosingStockKgs(BigDecimal closingStockKgs) {
		this.closingStockKgs = closingStockKgs;
	}

	public BigDecimal getClosingStockValue() {
		return this.closingStockValue;
	}

	public void setClosingStockValue(BigDecimal closingStockValue) {
		this.closingStockValue = closingStockValue;
	}


	public Integer getIssuesBags() {
		return this.issuesBags;
	}

	public void setIssuesBags(Integer issuesBags) {
		this.issuesBags = issuesBags;
	}

	public BigDecimal getIssuesKgs() {
		return this.issuesKgs;
	}

	public void setIssuesKgs(BigDecimal issuesKgs) {
		this.issuesKgs = issuesKgs;
	}

	public BigDecimal getIssuesValue() {
		return this.issuesValue;
	}

	public void setIssuesValue(BigDecimal issuesValue) {
		this.issuesValue = issuesValue;
	}

	public String getManufacturerBatchNumber() {
		return this.manufacturerBatchNumber;
	}

	public void setManufacturerBatchNumber(String manufacturerBatchNumber) {
		this.manufacturerBatchNumber = manufacturerBatchNumber;
	}


	public Integer getOpeningStockBags() {
		return this.openingStockBags;
	}

	public void setOpeningStockBags(Integer openingStockBags) {
		this.openingStockBags = openingStockBags;
	}

	public BigDecimal getOpeningStockKgs() {
		return this.openingStockKgs;
	}

	public void setOpeningStockKgs(BigDecimal openingStockKgs) {
		this.openingStockKgs = openingStockKgs;
	}

	public BigDecimal getOpeningStockValue() {
		return this.openingStockValue;
	}

	public void setOpeningStockValue(BigDecimal openingStockValue) {
		this.openingStockValue = openingStockValue;
	}

	public Integer getReceiptsBags() {
		return this.receiptsBags;
	}

	public void setReceiptsBags(Integer receiptsBags) {
		this.receiptsBags = receiptsBags;
	}

	public BigDecimal getReceiptsKgs() {
		return this.receiptsKgs;
	}

	public void setReceiptsKgs(BigDecimal receiptsKgs) {
		this.receiptsKgs = receiptsKgs;
	}

	public BigDecimal getReceiptsValue() {
		return this.receiptsValue;
	}

	public void setReceiptsValue(BigDecimal receiptsValue) {
		this.receiptsValue = receiptsValue;
	}

	public List<LineItemExternal> getLineItemExternals() {
		return this.lineItemExternals;
	}

	public void setLineItemExternals(List<LineItemExternal> lineItemExternals) {
		this.lineItemExternals = lineItemExternals;
	}

	public LineItemExternal addLineItemExternal(LineItemExternal lineItemExternal) {
		getLineItemExternals().add(lineItemExternal);
		lineItemExternal.setStock(this);

		return lineItemExternal;
	}

	public LineItemExternal removeLineItemExternal(LineItemExternal lineItemExternal) {
		getLineItemExternals().remove(lineItemExternal);
		lineItemExternal.setStock(null);

		return lineItemExternal;
	}

	public List<LineItemInternal> getLineItemInternals() {
		return this.lineItemInternals;
	}

	public void setLineItemInternals(List<LineItemInternal> lineItemInternals) {
		this.lineItemInternals = lineItemInternals;
	}

	public LineItemInternal addLineItemInternal(LineItemInternal lineItemInternal) {
		getLineItemInternals().add(lineItemInternal);
		lineItemInternal.setStock(this);

		return lineItemInternal;
	}

	public LineItemInternal removeLineItemInternal(LineItemInternal lineItemInternal) {
		getLineItemInternals().remove(lineItemInternal);
		lineItemInternal.setStock(null);

		return lineItemInternal;
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

	

	public StockType getStockType() {
		return this.stockType;
	}

	public void setStockType(StockType stockType) {
		this.stockType = stockType;
	}

}