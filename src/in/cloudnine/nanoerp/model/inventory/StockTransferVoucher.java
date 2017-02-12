package in.cloudnine.nanoerp.model.inventory;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import in.cloudnine.minerva.serverframework.data.impl.DocumentImpl;
import in.cloudnine.nanoerp.model.production.Lot;
import in.cloudnine.nanoerp.model.production.ProductionRegister;
import in.cloudnine.nanoerp.model.production.Program;
import in.cloudnine.nanoerp.model.production.SubProgram;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the StockTransferVoucher database table.
 * 
 */
@JsonIdentityInfo(
		generator=ObjectIdGenerators.UUIDGenerator.class,
		property="_stockTransferVoucherId",
		scope=StockTransferVoucher.class
		)

@Entity
@Table(name="StockTransferVoucher")
@NamedQuery(name="StockTransferVoucher.findAll", query="SELECT s FROM StockTransferVoucher s")
public class StockTransferVoucher extends DocumentImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="StockTransferVoucherId", unique=true, nullable=false, length=36)
	private String stockTransferVoucherId;

	
	@Column(name="Kgs", nullable=false, precision=10, scale=2)
	private BigDecimal kgs;

	@Lob
	@Column(name="Remarks")
	private String remarks;

	@Column(name="Rolls", nullable=false)
	private Integer rolls;

	
	//bi-directional many-to-one association to ProductionRegister
	@OneToMany(mappedBy="stockTransferVoucher", fetch=FetchType.EAGER,cascade=CascadeType.MERGE)
	private List<ProductionRegister> productionRegisters=new ArrayList<>();;

	//bi-directional many-to-one association to StockRoll
	@OneToMany(mappedBy="stockTransferVoucher", fetch=FetchType.EAGER,cascade=CascadeType.PERSIST)
	private List<StockRoll> stockRolls=new ArrayList<>();;

	//bi-directional many-to-one association to Lot
	@ManyToOne
	@JoinColumn(name="LotId", nullable=false)
	private Lot lot;

	//bi-directional many-to-one association to Program
	@ManyToOne
	@JoinColumn(name="ProgramId", nullable=false)
	private Program program;

	//bi-directional many-to-one association to SubProgram
	@ManyToOne
	@JoinColumn(name="SubProgramId", nullable=false)
	private SubProgram subProgram;

	public StockTransferVoucher() {
	}

	public String getStockTransferVoucherId() {
		return this.stockTransferVoucherId;
	}

	public void setStockTransferVoucherId(String stockTransferVoucherId) {
		this.stockTransferVoucherId = stockTransferVoucherId;
	}

	

	public BigDecimal getKgs() {
		return this.kgs;
	}

	public void setKgs(BigDecimal kgs) {
		this.kgs = kgs;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getRolls() {
		return this.rolls;
	}

	public void setRolls(Integer rolls) {
		this.rolls = rolls;
	}

	public String getSerialNumber() {
		return this.serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public List<ProductionRegister> getProductionRegisters() {
		return this.productionRegisters;
	}

	public void setProductionRegisters(List<ProductionRegister> productionRegisters) {
		this.productionRegisters = productionRegisters;
	}

	public ProductionRegister addProductionRegister(ProductionRegister productionRegister) {
		getProductionRegisters().add(productionRegister);
		productionRegister.setStockTransferVoucher(this);

		return productionRegister;
	}

	public ProductionRegister removeProductionRegister(ProductionRegister productionRegister) {
		getProductionRegisters().remove(productionRegister);
		productionRegister.setStockTransferVoucher(null);

		return productionRegister;
	}

	public List<StockRoll> getStockRolls() {
		return this.stockRolls;
	}

	public void setStockRolls(List<StockRoll> stockRolls) {
		this.stockRolls = stockRolls;
	}

	public StockRoll addStockRoll(StockRoll stockRoll) {
		getStockRolls().add(stockRoll);
		stockRoll.setStockTransferVoucher(this);

		return stockRoll;
	}

	public StockRoll removeStockRoll(StockRoll stockRoll) {
		getStockRolls().remove(stockRoll);
		stockRoll.setStockTransferVoucher(null);

		return stockRoll;
	}

	public Lot getLot() {
		return this.lot;
	}

	public void setLot(Lot lot) {
		this.lot = lot;
	}

	public Program getProgram() {
		return this.program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

	public SubProgram getSubProgram() {
		return this.subProgram;
	}

	public void setSubProgram(SubProgram subProgram) {
		this.subProgram = subProgram;
	}
	@Override
	public String getDocumentClassId(){
	return "RLTRF";
	}
}