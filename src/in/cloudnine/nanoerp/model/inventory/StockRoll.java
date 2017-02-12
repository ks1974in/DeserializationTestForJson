package in.cloudnine.nanoerp.model.inventory;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonValueInstantiator;

import in.cloudnine.minerva.serverframework.data.impl.DataObjectImpl;
import in.cloudnine.nanoerp.model.production.Lot;
import in.cloudnine.nanoerp.model.production.ProductionRegister;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;


/**
 * The persistent class for the StockRoll database table.
 * 
 */


@JsonIdentityInfo(
		generator=ObjectIdGenerators.UUIDGenerator.class,
		property="_stockRollsId",
		scope=StockRoll.class
		
		)

@Entity
@Table(name="StockRoll")
@NamedQuery(name="StockRoll.findAll", query="SELECT s FROM StockRoll s")
public class StockRoll extends DataObjectImpl  implements Serializable {
	private static final long serialVersionUID = 1L;

	@Transient
	private UUID _stockRollsId;
	
	public StockRoll(UUID id){
		this._stockRollsId=id;
	}
	
	@Id
	@Column(name="StockRollsId", unique=true, nullable=false, length=36)
	private String stockRollsId;

	@Column(name="Color", nullable=false, length=36)
	private String color;

	@Column(name="Discolored", nullable=false)
	private Boolean discolored;

	
@Column(name="GrossWeight", nullable=false, precision=10, scale=3)
	private BigDecimal grossWeight;

	@Column(name="GSM", nullable=false)
	private Integer gsm;

	@Column(name="Meters", nullable=false)
	private Integer meters;

	@Column(name="Multiple", nullable=false)
	private Boolean multiple;

	@Column(name="NetWeight", nullable=false, precision=10, scale=3)
	private BigDecimal netWeight;

	@Column(name="RollNo", nullable=false, length=36)
	private String rollNo;

	@Column(name="Size", nullable=false)
	private Integer size;

	//bi-directional many-to-one association to RollTransaction
	@OneToMany(mappedBy="stockRoll", fetch=FetchType.EAGER)
	private List<RollTransaction> rollTransactions;

	//bi-directional many-to-one association to Lot
	//@JsonBackReference("stockRollsForLot")
	
	@ManyToOne
	@JoinColumn(name="LotId", nullable=false)
	private Lot lot;

	//bi-directional many-to-one association to ProductionRegister
	@ManyToOne
	@JoinColumn(name="ProductionRegisterId", nullable=false)
	private ProductionRegister productionRegister;

	//bi-directional many-to-one association to StockTransferVoucher
	@ManyToOne
	@JoinColumn(name="StockTransferVoucherId")
	private StockTransferVoucher stockTransferVoucher;

	//bi-directional many-to-one association to StoresVoucherExternalRoll
	@ManyToOne
	@JoinColumn(name="StoresVoucherExternalRollsId")
	private StoresVoucherExternalRoll storesVoucherExternalRoll;

	public StockRoll() {
	}

	public String getStockRollsId() {
		return this.stockRollsId;
	}

	public void setStockRollsId(String stockRollsId) {
		this.stockRollsId = stockRollsId;
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

	public Boolean getMultiple() {
		return this.multiple;
	}

	public void setMultiple(Boolean multiple) {
		this.multiple = multiple;
	}

	public BigDecimal getNetWeight() {
		return this.netWeight;
	}

	public void setNetWeight(BigDecimal netWeight) {
		this.netWeight = netWeight;
	}

	public String getRollNo() {
		return this.rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public Integer getSize() {
		return this.size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public List<RollTransaction> getRollTransactions() {
		return this.rollTransactions;
	}

	public void setRollTransactions(List<RollTransaction> rollTransactions) {
		this.rollTransactions = rollTransactions;
	}

	public RollTransaction addRollTransaction(RollTransaction rollTransaction) {
		getRollTransactions().add(rollTransaction);
		rollTransaction.setStockRoll(this);

		return rollTransaction;
	}

	public RollTransaction removeRollTransaction(RollTransaction rollTransaction) {
		getRollTransactions().remove(rollTransaction);
		rollTransaction.setStockRoll(null);

		return rollTransaction;
	}

	public Lot getLot() {
		return this.lot;
	}

	public void setLot(Lot lot) {
		this.lot = lot;
	}

	public ProductionRegister getProductionRegister() {
		return this.productionRegister;
	}

	public void setProductionRegister(ProductionRegister productionRegister) {
		this.productionRegister = productionRegister;
	}

	public StockTransferVoucher getStockTransferVoucher() {
		return this.stockTransferVoucher;
	}

	public void setStockTransferVoucher(StockTransferVoucher stockTransferVoucher) {
		this.stockTransferVoucher = stockTransferVoucher;
	}

	public StoresVoucherExternalRoll getStoresVoucherExternalRoll() {
		return this.storesVoucherExternalRoll;
	}

	public void setStoresVoucherExternalRoll(StoresVoucherExternalRoll storesVoucherExternalRoll) {
		this.storesVoucherExternalRoll = storesVoucherExternalRoll;
	}
	@Override
    public String toString(){
	return rollNo;
}
}