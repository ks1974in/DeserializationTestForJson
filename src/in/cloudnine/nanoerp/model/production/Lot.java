package in.cloudnine.nanoerp.model.production;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import in.cloudnine.minerva.serverframework.data.impl.DocumentImpl;
import in.cloudnine.nanoerp.model.inventory.RollDispatchVoucher;
import in.cloudnine.nanoerp.model.inventory.RollReceiptVoucher;
import in.cloudnine.nanoerp.model.inventory.StockRoll;
import in.cloudnine.nanoerp.model.inventory.StockTransferVoucher;
import in.cloudnine.nanoerp.model.inventory.StoresVoucherExternalRoll;
import in.cloudnine.nanoerp.model.inventory.StoresVoucherInternal;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Lot database table.
 * 
 */

@JsonIdentityInfo(
		generator=ObjectIdGenerators.UUIDGenerator.class,
		property="_lotId",
		scope=Lot.class
		)

@Entity
@Table(name="Lot")
@NamedQuery(name="Lot.findAll", query="SELECT l FROM Lot l")
public class Lot extends DocumentImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="LotId", unique=true, nullable=false, length=36)
	private String lotId;

	@Column(name="ActualBalanceFiller", precision=10, scale=3)
	private BigDecimal actualBalanceFiller;

	@Column(name="ActualBalanceMasterBatch", precision=10, scale=3)
	private BigDecimal actualBalanceMasterBatch;

	@Column(name="ActualBalancePolypropylene", precision=10, scale=3)
	private BigDecimal actualBalancePolypropylene;

	@Column(name="ActualFIPercentage", precision=10, scale=2)
	private BigDecimal actualFIPercentage;

	@Column(name="ActualMBPercentage", precision=10, scale=2)
	private BigDecimal actualMBPercentage;

	@Column(name="ActualTotalKgs", precision=10, scale=2)
	private BigDecimal actualTotalKgs;

	@Column(name="ActualTotalMtrs")
	private Integer actualTotalMtrs;

	@Column(name="ActualTotalRolls")
	private Integer actualTotalRolls;

	@Column(name="ActualYield", precision=10, scale=2)
	private BigDecimal actualYield;

	@Column(name="BalanceFiller")
	private BigDecimal balanceFiller;

	@Column(name="BalanceMasterBatch")
	private BigDecimal balanceMasterBatch;

	@Column(name="BalancePolypropylene")
	private BigDecimal balancePolypropylene;

	
	@Column(name="Complete")
	private Boolean complete;

	
	@Column(name="DieTemperature")
	private Integer dieTemperature;

	@Column(name="DropMotherRPM", precision=10, scale=2)
	private BigDecimal dropMotherRPM;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="EndTime")
	private Date endTime;

	
	@Column(precision=10, scale=2)
	private BigDecimal FIPercentage;

	@Column(name="InputFiller")
	private BigDecimal inputFiller;

	@Column(name="InputFillerActual", precision=10, scale=2)
	private BigDecimal inputFillerActual;

	@Column(name="InputMasterBatch")
	private BigDecimal inputMasterBatch;

	@Column(name="InputMasterBatchActual", precision=10, scale=2)
	private BigDecimal inputMasterBatchActual;

	@Column(name="InputPolyPropylene")
	private BigDecimal inputPolyPropylene;

	@Column(name="InputPolypropyleneActual", precision=10, scale=2)
	private BigDecimal inputPolypropyleneActual;

	@Column(name="InputScrap")
	private BigDecimal inputScrap;

	@Column(name="InputScrapActual", precision=10, scale=2)
	private BigDecimal inputScrapActual;

	@Column(name="MasterBatchRPM", precision=10, scale=2)
	private BigDecimal masterBatchRPM;

	@Column(precision=10, scale=2)
	private BigDecimal MBPercentage;

	@Column(name="OutputFinishedRollsKgs")
	private BigDecimal outputFinishedRollsKgs;

	@Column(name="OutputFinishedRollsNos")
	private Integer outputFinishedRollsNos;

	@Column(name="OutputScrap")
	private BigDecimal outputScrap;

	@Lob
	@Column(name="Remarks")
	private String remarks;

	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="StartTime", nullable=false)
	private Date startTime;

	//bi-directional many-to-one association to Program
	@ManyToOne
	@JoinColumn(name="ProgramId")
	private Program program;

	//bi-directional many-to-one association to SubProgram
	@ManyToOne
	@JoinColumn(name="SubProgramId", nullable=false)
	private SubProgram subProgram;

	//bi-directional many-to-one association to ProductionRegister
	@OrderBy("rollNo")
	@OneToMany(mappedBy="lot", fetch=FetchType.EAGER,cascade=CascadeType.PERSIST)
	private List<ProductionRegister> productionRegisters=new ArrayList<>();;

	
	//bi-directional many-to-one association to RollDispatchVoucher
	@OneToMany(mappedBy="lot", fetch=FetchType.EAGER)
	private List<RollDispatchVoucher> rollDispatchVouchers=new ArrayList<>();;

	//bi-directional many-to-one association to RollReceiptVoucher
	@OneToMany(mappedBy="lot", fetch=FetchType.EAGER)
	private List<RollReceiptVoucher> rollReceiptVouchers=new ArrayList<>();;

	//bi-directional many-to-one association to StockRoll
	//@JsonManagedReference("stockRollsForLot")
	@OneToMany(mappedBy="lot", fetch=FetchType.EAGER)
	private List<StockRoll> stockRolls=new ArrayList<>();;

	//bi-directional many-to-one association to StockTransferVoucher
	@OneToMany(mappedBy="lot", fetch=FetchType.EAGER)
	private List<StockTransferVoucher> stockTransferVouchers=new ArrayList<>();;

	//bi-directional many-to-one association to StoresVoucherExternalRoll
	@OneToMany(mappedBy="lot", fetch=FetchType.EAGER)
	private List<StoresVoucherExternalRoll> storesVoucherExternalRolls=new ArrayList<>();;

	//bi-directional many-to-one association to StoresVoucherInternal
	@OneToMany(mappedBy="lot", fetch=FetchType.EAGER)
	private List<StoresVoucherInternal> storesVoucherInternals=new ArrayList<>();;

	public Lot() {
	}

	public String getLotId() {
		return this.lotId;
	}

	public void setLotId(String lotId) {
		this.lotId = lotId;
	}

	public BigDecimal getActualBalanceFiller() {
		return this.actualBalanceFiller;
	}

	public void setActualBalanceFiller(BigDecimal actualBalanceFiller) {
		this.actualBalanceFiller = actualBalanceFiller;
	}

	public BigDecimal getActualBalanceMasterBatch() {
		return this.actualBalanceMasterBatch;
	}

	public void setActualBalanceMasterBatch(BigDecimal actualBalanceMasterBatch) {
		this.actualBalanceMasterBatch = actualBalanceMasterBatch;
	}

	public BigDecimal getActualBalancePolypropylene() {
		return this.actualBalancePolypropylene;
	}

	public void setActualBalancePolypropylene(BigDecimal actualBalancePolypropylene) {
		this.actualBalancePolypropylene = actualBalancePolypropylene;
	}

	public BigDecimal getActualFIPercentage() {
		return this.actualFIPercentage;
	}

	public void setActualFIPercentage(BigDecimal actualFIPercentage) {
		this.actualFIPercentage = actualFIPercentage;
	}

	public BigDecimal getActualMBPercentage() {
		return this.actualMBPercentage;
	}

	public void setActualMBPercentage(BigDecimal actualMBPercentage) {
		this.actualMBPercentage = actualMBPercentage;
	}

	public BigDecimal getActualTotalKgs() {
		return this.actualTotalKgs;
	}

	public void setActualTotalKgs(BigDecimal actualTotalKgs) {
		this.actualTotalKgs = actualTotalKgs;
	}

	public Integer getActualTotalMtrs() {
		return actualTotalMtrs;
	}

	public void setActualTotalMtrs(Integer actualTotalMtrs) {
		this.actualTotalMtrs = actualTotalMtrs;
	}

	public Integer getActualTotalRolls() {
		return actualTotalRolls;
	}

	public void setActualTotalRolls(Integer actualTotalRolls) {
		this.actualTotalRolls = actualTotalRolls;
	}

	public Integer getDieTemperature() {
		return dieTemperature;
	}

	public void setDieTemperature(Integer dieTemperature) {
		this.dieTemperature = dieTemperature;
	}

	public Integer getOutputFinishedRollsNos() {
		return outputFinishedRollsNos;
	}

	public void setOutputFinishedRollsNos(Integer outputFinishedRollsNos) {
		this.outputFinishedRollsNos = outputFinishedRollsNos;
	}

	public BigDecimal getActualYield() {
		return this.actualYield;
	}

	public void setActualYield(BigDecimal actualYield) {
		this.actualYield = actualYield;
	}

	public BigDecimal getBalanceFiller() {
		return this.balanceFiller;
	}

	public void setBalanceFiller(BigDecimal balanceFiller) {
		this.balanceFiller = balanceFiller;
	}

	public BigDecimal getBalanceMasterBatch() {
		return this.balanceMasterBatch;
	}

	public void setBalanceMasterBatch(BigDecimal balanceMasterBatch) {
		this.balanceMasterBatch = balanceMasterBatch;
	}

	public BigDecimal getBalancePolypropylene() {
		return this.balancePolypropylene;
	}

	public void setBalancePolypropylene(BigDecimal balancePolypropylene) {
		this.balancePolypropylene = balancePolypropylene;
	}

	

	public Boolean getComplete() {
		return this.complete;
	}

	public void setComplete(Boolean complete) {
		this.complete = complete;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


	public BigDecimal getDropMotherRPM() {
		return this.dropMotherRPM;
	}

	public void setDropMotherRPM(BigDecimal dropMotherRPM) {
		this.dropMotherRPM = dropMotherRPM;
	}

	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	
	public BigDecimal getFIPercentage() {
		return this.FIPercentage;
	}

	public void setFIPercentage(BigDecimal FIPercentage) {
		this.FIPercentage = FIPercentage;
	}

	public BigDecimal getInputFiller() {
		return this.inputFiller;
	}

	public void setInputFiller(BigDecimal inputFiller) {
		this.inputFiller = inputFiller;
	}

	public BigDecimal getInputFillerActual() {
		return this.inputFillerActual;
	}

	public void setInputFillerActual(BigDecimal inputFillerActual) {
		this.inputFillerActual = inputFillerActual;
	}

	public BigDecimal getInputMasterBatch() {
		return this.inputMasterBatch;
	}

	public void setInputMasterBatch(BigDecimal inputMasterBatch) {
		this.inputMasterBatch = inputMasterBatch;
	}

	public BigDecimal getInputMasterBatchActual() {
		return this.inputMasterBatchActual;
	}

	public void setInputMasterBatchActual(BigDecimal inputMasterBatchActual) {
		this.inputMasterBatchActual = inputMasterBatchActual;
	}

	public BigDecimal getInputPolyPropylene() {
		return this.inputPolyPropylene;
	}

	public void setInputPolyPropylene(BigDecimal inputPolyPropylene) {
		this.inputPolyPropylene = inputPolyPropylene;
	}

	public BigDecimal getInputPolypropyleneActual() {
		return this.inputPolypropyleneActual;
	}

	public void setInputPolypropyleneActual(BigDecimal inputPolypropyleneActual) {
		this.inputPolypropyleneActual = inputPolypropyleneActual;
	}

	public BigDecimal getInputScrap() {
		return this.inputScrap;
	}

	public void setInputScrap(BigDecimal inputScrap) {
		this.inputScrap = inputScrap;
	}

	public BigDecimal getInputScrapActual() {
		return this.inputScrapActual;
	}

	public void setInputScrapActual(BigDecimal inputScrapActual) {
		this.inputScrapActual = inputScrapActual;
	}

	public BigDecimal getMasterBatchRPM() {
		return this.masterBatchRPM;
	}

	public void setMasterBatchRPM(BigDecimal masterBatchRPM) {
		this.masterBatchRPM = masterBatchRPM;
	}

	public BigDecimal getMBPercentage() {
		return this.MBPercentage;
	}

	public void setMBPercentage(BigDecimal MBPercentage) {
		this.MBPercentage = MBPercentage;
	}

	public BigDecimal getOutputFinishedRollsKgs() {
		return this.outputFinishedRollsKgs;
	}

	public void setOutputFinishedRollsKgs(BigDecimal outputFinishedRollsKgs) {
		this.outputFinishedRollsKgs = outputFinishedRollsKgs;
	}

	public BigDecimal getOutputScrap() {
		return this.outputScrap;
	}

	public void setOutputScrap(BigDecimal outputScrap) {
		this.outputScrap = outputScrap;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getSerialNumber() {
		return this.serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Date getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
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

	public List<ProductionRegister> getProductionRegisters() {
		return this.productionRegisters;
	}

	public void setProductionRegisters(List<ProductionRegister> productionRegisters) {
		this.productionRegisters = productionRegisters;
	}

	public ProductionRegister addProductionRegister(ProductionRegister productionRegister) {
		getProductionRegisters().add(productionRegister);
		productionRegister.setLot(this);

		return productionRegister;
	}

	public ProductionRegister removeProductionRegister(ProductionRegister productionRegister) {
		getProductionRegisters().remove(productionRegister);
		productionRegister.setLot(null);

		return productionRegister;
	}

	public List<RollDispatchVoucher> getRollDispatchVouchers() {
		return this.rollDispatchVouchers;
	}

	public void setRollDispatchVouchers(List<RollDispatchVoucher> rollDispatchVouchers) {
		this.rollDispatchVouchers = rollDispatchVouchers;
	}

	public RollDispatchVoucher addRollDispatchVoucher(RollDispatchVoucher rollDispatchVoucher) {
		getRollDispatchVouchers().add(rollDispatchVoucher);
		rollDispatchVoucher.setLot(this);

		return rollDispatchVoucher;
	}

	public RollDispatchVoucher removeRollDispatchVoucher(RollDispatchVoucher rollDispatchVoucher) {
		getRollDispatchVouchers().remove(rollDispatchVoucher);
		rollDispatchVoucher.setLot(null);

		return rollDispatchVoucher;
	}

	public List<RollReceiptVoucher> getRollReceiptVouchers() {
		return this.rollReceiptVouchers;
	}

	public void setRollReceiptVouchers(List<RollReceiptVoucher> rollReceiptVouchers) {
		this.rollReceiptVouchers = rollReceiptVouchers;
	}

	public RollReceiptVoucher addRollReceiptVoucher(RollReceiptVoucher rollReceiptVoucher) {
		getRollReceiptVouchers().add(rollReceiptVoucher);
		rollReceiptVoucher.setLot(this);

		return rollReceiptVoucher;
	}

	public RollReceiptVoucher removeRollReceiptVoucher(RollReceiptVoucher rollReceiptVoucher) {
		getRollReceiptVouchers().remove(rollReceiptVoucher);
		rollReceiptVoucher.setLot(null);

		return rollReceiptVoucher;
	}

	public List<StockRoll> getStockRolls() {
		return this.stockRolls;
	}

	public void setStockRolls(List<StockRoll> stockRolls) {
		this.stockRolls = stockRolls;
	}

	public StockRoll addStockRoll(StockRoll stockRoll) {
		getStockRolls().add(stockRoll);
		stockRoll.setLot(this);

		return stockRoll;
	}

	public StockRoll removeStockRoll(StockRoll stockRoll) {
		getStockRolls().remove(stockRoll);
		stockRoll.setLot(null);

		return stockRoll;
	}

	public List<StockTransferVoucher> getStockTransferVouchers() {
		return this.stockTransferVouchers;
	}

	public void setStockTransferVouchers(List<StockTransferVoucher> stockTransferVouchers) {
		this.stockTransferVouchers = stockTransferVouchers;
	}

	public StockTransferVoucher addStockTransferVoucher(StockTransferVoucher stockTransferVoucher) {
		getStockTransferVouchers().add(stockTransferVoucher);
		stockTransferVoucher.setLot(this);

		return stockTransferVoucher;
	}

	public StockTransferVoucher removeStockTransferVoucher(StockTransferVoucher stockTransferVoucher) {
		getStockTransferVouchers().remove(stockTransferVoucher);
		stockTransferVoucher.setLot(null);

		return stockTransferVoucher;
	}

	public List<StoresVoucherExternalRoll> getStoresVoucherExternalRolls() {
		return this.storesVoucherExternalRolls;
	}

	public void setStoresVoucherExternalRolls(List<StoresVoucherExternalRoll> storesVoucherExternalRolls) {
		this.storesVoucherExternalRolls = storesVoucherExternalRolls;
	}

	public StoresVoucherExternalRoll addStoresVoucherExternalRoll(StoresVoucherExternalRoll storesVoucherExternalRoll) {
		getStoresVoucherExternalRolls().add(storesVoucherExternalRoll);
		storesVoucherExternalRoll.setLot(this);

		return storesVoucherExternalRoll;
	}

	public StoresVoucherExternalRoll removeStoresVoucherExternalRoll(StoresVoucherExternalRoll storesVoucherExternalRoll) {
		getStoresVoucherExternalRolls().remove(storesVoucherExternalRoll);
		storesVoucherExternalRoll.setLot(null);

		return storesVoucherExternalRoll;
	}

	public List<StoresVoucherInternal> getStoresVoucherInternals() {
		return this.storesVoucherInternals;
	}

	public void setStoresVoucherInternals(List<StoresVoucherInternal> storesVoucherInternals) {
		this.storesVoucherInternals = storesVoucherInternals;
	}

	public StoresVoucherInternal addStoresVoucherInternal(StoresVoucherInternal storesVoucherInternal) {
		getStoresVoucherInternals().add(storesVoucherInternal);
		storesVoucherInternal.setLot(this);

		return storesVoucherInternal;
	}

	public StoresVoucherInternal removeStoresVoucherInternal(StoresVoucherInternal storesVoucherInternal) {
		getStoresVoucherInternals().remove(storesVoucherInternal);
		storesVoucherInternal.setLot(null);

		return storesVoucherInternal;
	}
	@Override
	public String getDocumentClassId(){
	return "LOT";
	}
}