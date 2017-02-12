package in.cloudnine.nanoerp.model.production;

import java.io.Serializable;



import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import in.cloudnine.minerva.serverframework.data.impl.DocumentImpl;
import in.cloudnine.nanoerp.model.inventory.StockRoll;
import in.cloudnine.nanoerp.model.inventory.StockTransferVoucher;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ProductionRegister database table.
 * 
 */
@JsonIdentityInfo(
		generator=ObjectIdGenerators.UUIDGenerator.class,
		property="_productionRegisterId",
		scope=ProductionRegister.class
		)

@Entity
@Table(name="ProductionRegister")
@NamedQuery(name="ProductionRegister.findAll", query="SELECT p FROM ProductionRegister p")
public class ProductionRegister extends DocumentImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ProductionRegisterId", unique=true, nullable=false, length=36)
	private String productionRegisterId;

	@Column(name="Color", nullable=false, length=36)
	private String color;

	
	@Column(name="Discolored", nullable=false)
	private Boolean discolored;

	@Column(name="RollNo", nullable=false, length=36)
	private String rollNo;

	
	@Column(name="GrossWeight", nullable=false, precision=10, scale=3)
	private BigDecimal grossWeight;

	@Column(name="GSM", nullable=false)
	private Integer gsm;

	@Column(name="Meters", nullable=false)
	private Integer meters;

	@Column(name="NetWeight", nullable=false, precision=10, scale=3)
	private BigDecimal netWeight;

	@Column(name="Size", nullable=false)
	private Integer size;

	//bi-directional many-to-one association to Lot
	@ManyToOne
	@JoinColumn(name="LotId", nullable=false)
	private Lot lot;

	//bi-directional many-to-one association to StockTransferVoucher
	@ManyToOne
	@JoinColumn(name="StockTransferVoucherId")
	private StockTransferVoucher stockTransferVoucher;

	//bi-directional many-to-one association to StockRoll
	@OneToMany(mappedBy="productionRegister", fetch=FetchType.EAGER,cascade=CascadeType.PERSIST)
	private List<StockRoll> stockRolls=new ArrayList<StockRoll>();

	public ProductionRegister() {
	}

	public String getProductionRegisterId() {
		return this.productionRegisterId;
	}

	public void setProductionRegisterId(String productionRegisterId) {
		this.productionRegisterId = productionRegisterId;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	
	

	public Boolean getDiscolored() {
		return this.discolored;
	}

	public void setDiscolored(Boolean discolored) {
		this.discolored = discolored;
	}

	public String getRollNo() {
		return this.rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo=rollNo;
	}

	public BigDecimal getGrossWeight() {
		return this.grossWeight;
	}

	public void setGrossWeight(BigDecimal grossWeight) {
		this.grossWeight = grossWeight;
	}

	public Integer getGsm() {
		return this.gsm;
	}

	public void setGsm(Integer gsm) {
		this.gsm = gsm;
	}

	public Integer getMeters() {
		return this.meters;
	}

	public void setMeters(Integer meters) {
		this.meters = meters;
	}

	public BigDecimal getNetWeight() {
		return this.netWeight;
	}

	public void setNetWeight(BigDecimal netWeight) {
		this.netWeight = netWeight;
	}

	public Integer getSize() {
		return this.size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Lot getLot() {
		return this.lot;
	}

	public void setLot(Lot lot) {
		this.lot = lot;
	}

	public StockTransferVoucher getStockTransferVoucher() {
		return this.stockTransferVoucher;
	}

	public void setStockTransferVoucher(StockTransferVoucher stockTransferVoucher) {
		this.stockTransferVoucher = stockTransferVoucher;
	}

	public List<StockRoll> getStockRolls() {
		return this.stockRolls;
	}

	public void setStockRolls(List<StockRoll> stockRolls) {
		this.stockRolls = stockRolls;
	}

	public StockRoll addStockRoll(StockRoll stockRoll) {
		getStockRolls().add(stockRoll);
		stockRoll.setProductionRegister(this);

		return stockRoll;
	}

	public StockRoll removeStockRoll(StockRoll stockRoll) {
		getStockRolls().remove(stockRoll);
		stockRoll.setProductionRegister(null);

		return stockRoll;
	}
	@Override
	public String getDocumentClassId(){
	return "PRREG";
	}
}