package in.cloudnine.nanoerp.model.production;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import in.cloudnine.minerva.serverframework.data.impl.DocumentImpl;
import in.cloudnine.nanoerp.model.inventory.RollDispatchVoucher;
import in.cloudnine.nanoerp.model.inventory.RollReceiptVoucher;
import in.cloudnine.nanoerp.model.inventory.Stock;
import in.cloudnine.nanoerp.model.inventory.StockPT;
import in.cloudnine.nanoerp.model.inventory.StockTransferVoucher;
import in.cloudnine.nanoerp.model.inventory.StoresVoucherExternal;
import in.cloudnine.nanoerp.model.inventory.StoresVoucherExternalRoll;
import in.cloudnine.nanoerp.model.inventory.StoresVoucherInternal;
import in.cloudnine.nanoerp.model.masters.Customer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Program database table.
 * 
 */
@JsonIdentityInfo(
		generator=ObjectIdGenerators.UUIDGenerator.class,
		property="_programId",
		scope=Program.class
		)

@Entity
@Table(name="Program")
@NamedQuery(name="Program.findAll", query="SELECT p FROM Program p")
public class Program extends DocumentImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ProgramId", unique=true, nullable=false, length=36)
	private String programId;

	@Column(name="ActualOutputKgs")
	private BigDecimal actualOutputKgs;

	@Column(name="ActualTotalKgs", precision=10, scale=2)
	private BigDecimal actualTotalKgs;

	@Column(name="ActualTotalMtrs")
	private Integer actualTotalMtrs;

	@Column(name="ActualTotalRolls")
	private Integer actualTotalRolls;

	
	@Column(name="Complete")
	private Boolean complete;

	
	@Column(name="InputKgs")
	private BigDecimal inputKgs;

	@Column(name="PaperTubeWeightPerInch", precision=10, scale=2)
	private BigDecimal paperTubeWeightPerInch;

	@Column(name="PlannedOutputKgs")
	private BigDecimal plannedOutputKgs;

	@Lob
	@Column(name="Remarks")
	private String remarks;

	
	@Column(name="Title", nullable=false, length=36)
	private String title;

	//bi-directional many-to-one association to Lot
	@OneToMany(mappedBy="program", fetch=FetchType.EAGER)
	private List<Lot> lots=new ArrayList<Lot>();
	
	

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="CustomerId", nullable=false)
	private Customer customer;

	//bi-directional many-to-one association to RollDispatchVoucher
	@OneToMany(mappedBy="program", fetch=FetchType.EAGER)
	private List<RollDispatchVoucher> rollDispatchVouchers=new ArrayList<RollDispatchVoucher>();

	//bi-directional many-to-one association to RollReceiptVoucher
	@OneToMany(mappedBy="program", fetch=FetchType.EAGER)
	private List<RollReceiptVoucher> rollReceiptVouchers=new ArrayList<RollReceiptVoucher>();;

	//bi-directional many-to-one association to StockTransferVoucher
	@OneToMany(mappedBy="program", fetch=FetchType.EAGER)
	private List<StockTransferVoucher> stockTransferVouchers=new ArrayList<StockTransferVoucher>();;

	//bi-directional many-to-one association to StoresVoucherExternal
	@OneToMany(mappedBy="program", fetch=FetchType.EAGER)
	private List<StoresVoucherExternal> storesVoucherExternals=new ArrayList<StoresVoucherExternal>();;

	//bi-directional many-to-one association to StoresVoucherExternalRoll
	@OneToMany(mappedBy="program", fetch=FetchType.EAGER)
	private List<StoresVoucherExternalRoll> storesVoucherExternalRolls=new ArrayList<StoresVoucherExternalRoll>();;

	//bi-directional many-to-one association to StoresVoucherInternal
	@OneToMany(mappedBy="program", fetch=FetchType.EAGER)
	private List<StoresVoucherInternal> storesVoucherInternals=new ArrayList<StoresVoucherInternal>();;

	//bi-directional many-to-one association to SubProgram
	@OrderBy("serialNumber")
	@JsonManagedReference("subPrograms")
	@OneToMany(mappedBy="program", fetch=FetchType.EAGER,cascade=CascadeType.PERSIST)
	private List<SubProgram> subPrograms=new ArrayList<SubProgram>();

	public Program() {
	}

	public String getProgramId() {
		return this.programId;
	}

	public void setProgramId(String programId) {
		this.programId = programId;
	}

	


	public BigDecimal getActualTotalKgs() {
		return this.actualTotalKgs;
	}

	public void setActualTotalKgs(BigDecimal actualTotalKgs) {
		this.actualTotalKgs = actualTotalKgs;
	}

	public Integer getActualTotalMtrs() {
		return this.actualTotalMtrs;
	}

	public void setActualTotalMtrs(Integer actualTotalMtrs) {
		this.actualTotalMtrs = actualTotalMtrs;
	}

	public Integer getActualTotalRolls() {
		return this.actualTotalRolls;
	}

	public void setActualTotalRolls(Integer actualTotalRolls) {
		this.actualTotalRolls = actualTotalRolls;
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

	

	

	public BigDecimal getPaperTubeWeightPerInch() {
		return this.paperTubeWeightPerInch;
	}

	public void setPaperTubeWeightPerInch(BigDecimal paperTubeWeightPerInch) {
		this.paperTubeWeightPerInch = paperTubeWeightPerInch;
	}


	public BigDecimal getActualOutputKgs() {
		return actualOutputKgs;
	}

	public void setActualOutputKgs(BigDecimal actualOutputKgs) {
		this.actualOutputKgs = actualOutputKgs;
	}

	public BigDecimal getInputKgs() {
		return inputKgs;
	}

	public void setInputKgs(BigDecimal inputKgs) {
		this.inputKgs = inputKgs;
	}

	public BigDecimal getPlannedOutputKgs() {
		return plannedOutputKgs;
	}

	public void setPlannedOutputKgs(BigDecimal plannedOutputKgs) {
		this.plannedOutputKgs = plannedOutputKgs;
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

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Lot> getLots() {
		return this.lots;
	}

	public void setLots(List<Lot> lots) {
		this.lots = lots;
	}

	public Lot addLot(Lot lot) {
		getLots().add(lot);
		lot.setProgram(this);

		return lot;
	}

	public Lot removeLot(Lot lot) {
		getLots().remove(lot);
		lot.setProgram(null);

		return lot;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<RollDispatchVoucher> getRollDispatchVouchers() {
		return this.rollDispatchVouchers;
	}

	public void setRollDispatchVouchers(List<RollDispatchVoucher> rollDispatchVouchers) {
		this.rollDispatchVouchers = rollDispatchVouchers;
	}

	public RollDispatchVoucher addRollDispatchVoucher(RollDispatchVoucher rollDispatchVoucher) {
		getRollDispatchVouchers().add(rollDispatchVoucher);
		rollDispatchVoucher.setProgram(this);

		return rollDispatchVoucher;
	}

	public RollDispatchVoucher removeRollDispatchVoucher(RollDispatchVoucher rollDispatchVoucher) {
		getRollDispatchVouchers().remove(rollDispatchVoucher);
		rollDispatchVoucher.setProgram(null);

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
		rollReceiptVoucher.setProgram(this);

		return rollReceiptVoucher;
	}

	public RollReceiptVoucher removeRollReceiptVoucher(RollReceiptVoucher rollReceiptVoucher) {
		getRollReceiptVouchers().remove(rollReceiptVoucher);
		rollReceiptVoucher.setProgram(null);

		return rollReceiptVoucher;
	}

	
	
	public List<StockTransferVoucher> getStockTransferVouchers() {
		return this.stockTransferVouchers;
	}

	public void setStockTransferVouchers(List<StockTransferVoucher> stockTransferVouchers) {
		this.stockTransferVouchers = stockTransferVouchers;
	}

	public StockTransferVoucher addStockTransferVoucher(StockTransferVoucher stockTransferVoucher) {
		getStockTransferVouchers().add(stockTransferVoucher);
		stockTransferVoucher.setProgram(this);

		return stockTransferVoucher;
	}

	public StockTransferVoucher removeStockTransferVoucher(StockTransferVoucher stockTransferVoucher) {
		getStockTransferVouchers().remove(stockTransferVoucher);
		stockTransferVoucher.setProgram(null);

		return stockTransferVoucher;
	}

	public List<StoresVoucherExternal> getStoresVoucherExternals() {
		return this.storesVoucherExternals;
	}

	public void setStoresVoucherExternals(List<StoresVoucherExternal> storesVoucherExternals) {
		this.storesVoucherExternals = storesVoucherExternals;
	}

	public StoresVoucherExternal addStoresVoucherExternal(StoresVoucherExternal storesVoucherExternal) {
		getStoresVoucherExternals().add(storesVoucherExternal);
		storesVoucherExternal.setProgram(this);

		return storesVoucherExternal;
	}

	public StoresVoucherExternal removeStoresVoucherExternal(StoresVoucherExternal storesVoucherExternal) {
		getStoresVoucherExternals().remove(storesVoucherExternal);
		storesVoucherExternal.setProgram(null);

		return storesVoucherExternal;
	}

	public List<StoresVoucherExternalRoll> getStoresVoucherExternalRolls() {
		return this.storesVoucherExternalRolls;
	}

	public void setStoresVoucherExternalRolls(List<StoresVoucherExternalRoll> storesVoucherExternalRolls) {
		this.storesVoucherExternalRolls = storesVoucherExternalRolls;
	}

	public StoresVoucherExternalRoll addStoresVoucherExternalRoll(StoresVoucherExternalRoll storesVoucherExternalRoll) {
		getStoresVoucherExternalRolls().add(storesVoucherExternalRoll);
		storesVoucherExternalRoll.setProgram(this);

		return storesVoucherExternalRoll;
	}

	public StoresVoucherExternalRoll removeStoresVoucherExternalRoll(StoresVoucherExternalRoll storesVoucherExternalRoll) {
		getStoresVoucherExternalRolls().remove(storesVoucherExternalRoll);
		storesVoucherExternalRoll.setProgram(null);

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
		storesVoucherInternal.setProgram(this);

		return storesVoucherInternal;
	}

	public StoresVoucherInternal removeStoresVoucherInternal(StoresVoucherInternal storesVoucherInternal) {
		getStoresVoucherInternals().remove(storesVoucherInternal);
		storesVoucherInternal.setProgram(null);

		return storesVoucherInternal;
	}

	public List<SubProgram> getSubPrograms() {
		return this.subPrograms;
	}

	public void setSubPrograms(List<SubProgram> subPrograms) {
		this.subPrograms = subPrograms;
	}

	public SubProgram addSubProgram(SubProgram subProgram) {
		getSubPrograms().add(subProgram);
		subProgram.setProgram(this);

		return subProgram;
	}

	public SubProgram removeSubProgram(SubProgram subProgram) {
		getSubPrograms().remove(subProgram);
		subProgram.setProgram(null);

		return subProgram;
	}
//	@Override
	public String getDocumentClassId(){
	return "PR";
	}
}