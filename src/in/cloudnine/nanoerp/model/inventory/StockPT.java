package in.cloudnine.nanoerp.model.inventory;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import in.cloudnine.minerva.serverframework.data.impl.DataObjectImpl;
import in.cloudnine.nanoerp.model.masters.Manufacturer;

import java.math.BigDecimal;


/**
 * The persistent class for the StockPT database table.
 * 
 */
@JsonIdentityInfo(
		generator=ObjectIdGenerators.UUIDGenerator.class,
		property="_stockPTId",
		scope=StockPT.class
		)

@Entity
@Table(name="StockPT")
@NamedQuery(name="StockPT.findAll", query="SELECT s FROM StockPT s")
public class StockPT extends DataObjectImpl  implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="StockPTId", unique=true, nullable=false, length=36)
	private String stockPTId;

	@Column(name="ClosingStockPTNos", nullable=false)
	private Integer closingStockPTNos;

	@Column(name="ClosingStockValue", nullable=false, precision=10, scale=2)
	private BigDecimal closingStockValue;

	
	@Column(name="InnerDiameter", nullable=false, precision=10, scale=2)
	private BigDecimal innerDiameter;

	@Column(name="IssuesNos", nullable=false)
	private Integer issuesNos;

	@Column(name="IssuesValue", nullable=false, precision=10, scale=2)
	private BigDecimal issuesValue;

	@Column(name="ManufacturerProgramNumber", length=36)
	private String manufacturerProgramNumber;

	@Column(name="OpeningStockPTNos", nullable=false)
	private Integer openingStockPTNos;

	@Column(name="OpeningStockValue", nullable=false, precision=10, scale=2)
	private BigDecimal openingStockValue;

	@Column(name="OuterDiameter", nullable=false, precision=10, scale=2)
	private BigDecimal outerDiameter;

	@Column(name="ReceiptsNos", nullable=false)
	private Integer receiptsNos;

	@Column(name="ReceiptsValue", nullable=false, precision=10, scale=2)
	private BigDecimal receiptsValue;

	@Column(name="Size", nullable=false, precision=10, scale=2)
	private BigDecimal size;

	@Column(name="Weight", nullable=false, precision=10, scale=2)
	private BigDecimal weight;

	@Column(name="WeightPerInch", nullable=false, precision=10, scale=2)
	private BigDecimal weightPerInch;

	//bi-directional many-to-one association to Manufacturer
	@ManyToOne
	@JoinColumn(name="ManufacturerId", nullable=false)
	private Manufacturer manufacturer;


	public StockPT() {
	}

	public String getStockPTId() {
		return this.stockPTId;
	}

	public void setStockPTId(String stockPTId) {
		this.stockPTId = stockPTId;
	}

	public Integer getClosingStockPTNos() {
		return this.closingStockPTNos;
	}

	public void setClosingStockPTNos(Integer closingStockPTNos) {
		this.closingStockPTNos = closingStockPTNos;
	}

	public BigDecimal getClosingStockValue() {
		return this.closingStockValue;
	}

	public void setClosingStockValue(BigDecimal closingStockValue) {
		this.closingStockValue = closingStockValue;
	}

	public BigDecimal getInnerDiameter() {
		return this.innerDiameter;
	}

	public void setInnerDiameter(BigDecimal innerDiameter) {
		this.innerDiameter = innerDiameter;
	}

	public Integer getIssuesNos() {
		return this.issuesNos;
	}

	public void setIssuesNos(Integer issuesNos) {
		this.issuesNos = issuesNos;
	}

	public BigDecimal getIssuesValue() {
		return this.issuesValue;
	}

	public void setIssuesValue(BigDecimal issuesValue) {
		this.issuesValue = issuesValue;
	}

	public String getManufacturerProgramNumber() {
		return this.manufacturerProgramNumber;
	}

	public void setManufacturerProgramNumber(String manufacturerProgramNumber) {
		this.manufacturerProgramNumber = manufacturerProgramNumber;
	}

	public Integer getOpeningStockPTNos() {
		return this.openingStockPTNos;
	}

	public void setOpeningStockPTNos(Integer openingStockPTNos) {
		this.openingStockPTNos = openingStockPTNos;
	}

	public BigDecimal getOpeningStockValue() {
		return this.openingStockValue;
	}

	public void setOpeningStockValue(BigDecimal openingStockValue) {
		this.openingStockValue = openingStockValue;
	}

	public BigDecimal getOuterDiameter() {
		return this.outerDiameter;
	}

	public void setOuterDiameter(BigDecimal outerDiameter) {
		this.outerDiameter = outerDiameter;
	}

	public Integer getReceiptsNos() {
		return this.receiptsNos;
	}

	public void setReceiptsNos(Integer receiptsNos) {
		this.receiptsNos = receiptsNos;
	}

	public BigDecimal getReceiptsValue() {
		return this.receiptsValue;
	}

	public void setReceiptsValue(BigDecimal receiptsValue) {
		this.receiptsValue = receiptsValue;
	}

	public BigDecimal getSize() {
		return this.size;
	}

	public void setSize(BigDecimal size) {
		this.size = size;
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



}