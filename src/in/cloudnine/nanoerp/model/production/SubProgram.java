package in.cloudnine.nanoerp.model.production;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import in.cloudnine.minerva.serverframework.data.impl.DataObjectImpl;
import in.cloudnine.minerva.serverframework.data.impl.DocumentImpl;
import in.cloudnine.nanoerp.model.inventory.RollDispatchVoucher;
import in.cloudnine.nanoerp.model.inventory.RollReceiptVoucher;
import in.cloudnine.nanoerp.model.inventory.StockTransferVoucher;
import in.cloudnine.nanoerp.model.inventory.StoresVoucherExternalRoll;
import in.cloudnine.nanoerp.model.inventory.StoresVoucherInternal;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the SubProgram database table.
 * 
 */
@JsonIdentityInfo(
		generator=ObjectIdGenerators.UUIDGenerator.class,
		property="_subProgramId",
		scope=SubProgram.class
		)

@Entity
@Table(name="SubProgram")
@NamedQuery(name="SubProgram.findAll", query="SELECT s FROM SubProgram s")
public class SubProgram  extends DocumentImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SubProgramId", unique=true, nullable=false, length=36)
	private String subProgramId;

	@Column(name="ActualTotalKgs", precision=10, scale=2)
	private BigDecimal actualTotalKgs;

	@Column(name="ActualTotalMtrs")
	private Integer actualTotalMtrs;

	@Column(name="ActualTotalRolls")
	private Integer actualTotalRolls;

	@Column(name="Color", nullable=false, length=36)
	private String color;

	/*
	@Column(name="SerialNumber", nullable=false, length=36)
	private String serialNumber;
   */
	@Column(name="GSM", nullable=false)
	private Integer gsm;

	@Column(name="KgsPerRoll", nullable=false, precision=10, scale=2)
	private BigDecimal kgsPerRoll;

	
	
	@Column(name="Mtrs", nullable=false)
	private Integer mtrs;

	@Column(name="PaperTubeWeight", nullable=false, precision=10, scale=2)
	private BigDecimal paperTubeWeight;

	@Column(name="Rolls", nullable=false)
	private Integer rolls;


	@Column(name="Size", nullable=false)
	private Integer size;

	@Column(name="TotalKgs", nullable=false)
	private BigDecimal totalKgs;

	//bi-directional many-to-one association to Lot
	@OneToMany(mappedBy="subProgram", fetch=FetchType.EAGER,cascade=CascadeType.PERSIST)
	private List<Lot> lots=new ArrayList<Lot>();;

	//bi-directional many-to-one association to RollDispatchVoucher
	@OneToMany(mappedBy="subProgram", fetch=FetchType.EAGER)
	private List<RollDispatchVoucher> rollDispatchVouchers=new ArrayList<RollDispatchVoucher>();;

	//bi-directional many-to-one association to RollReceiptVoucher
	@OneToMany(mappedBy="subProgram", fetch=FetchType.EAGER)
	private List<RollReceiptVoucher> rollReceiptVouchers=new ArrayList<RollReceiptVoucher>();;

	//bi-directional many-to-one association to StockTransferVoucher
	@OneToMany(mappedBy="subProgram", fetch=FetchType.EAGER)
	private List<StockTransferVoucher> stockTransferVouchers=new ArrayList<StockTransferVoucher>();

	//bi-directional many-to-one association to StoresVoucherExternalRoll
	@OneToMany(mappedBy="subProgram", fetch=FetchType.EAGER)
	private List<StoresVoucherExternalRoll> storesVoucherExternalRolls=new ArrayList<StoresVoucherExternalRoll>();;

	//bi-directional many-to-one association to StoresVoucherInternal
	@OneToMany(mappedBy="subProgram", fetch=FetchType.EAGER)
	private List<StoresVoucherInternal> storesVoucherInternals=new ArrayList<StoresVoucherInternal>();;

	//bi-directional many-to-one association to Program
	@JsonBackReference("subPrograms")
	@ManyToOne
	@JoinColumn(name="ProgramId", nullable=false)
	private Program program;

	public SubProgram() {
	}

	public String getSubProgramId() {
		return this.subProgramId;
	}

	public void setSubProgramId(String subProgramId) {
		this.subProgramId = subProgramId;
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

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getGsm() {
		return this.gsm;
	}

	public void setGsm(Integer gsm) {
		this.gsm = gsm;
	}

	public BigDecimal getKgsPerRoll() {
		return this.kgsPerRoll;
	}

	public void setKgsPerRoll(BigDecimal kgsPerRoll) {
		this.kgsPerRoll = kgsPerRoll;
	}

	public Integer getMtrs() {
		return this.mtrs;
	}

	public void setMtrs(Integer mtrs) {
		this.mtrs = mtrs;
	}

	public BigDecimal getPaperTubeWeight() {
		return this.paperTubeWeight;
	}

	public void setPaperTubeWeight(BigDecimal paperTubeWeight) {
		this.paperTubeWeight = paperTubeWeight;
	}

	public Integer getRolls() {
		return this.rolls;
	}

	public void setRolls(Integer rolls) {
		this.rolls = rolls;
	}

		public Integer getSize() {
		return this.size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public BigDecimal getTotalKgs() {
		return this.totalKgs;
	}

	public void setTotalKgs(BigDecimal totalKgs) {
		this.totalKgs = totalKgs;
	}

	public List<Lot> getLots() {
		return this.lots;
	}

	public void setLots(List<Lot> lots) {
		this.lots = lots;
	}

	public Lot addLot(Lot lot) {
		getLots().add(lot);
		lot.setSubProgram(this);

		return lot;
	}

	public Lot removeLot(Lot lot) {
		getLots().remove(lot);
		lot.setSubProgram(null);

		return lot;
	}

	public List<RollDispatchVoucher> getRollDispatchVouchers() {
		return this.rollDispatchVouchers;
	}

	public void setRollDispatchVouchers(List<RollDispatchVoucher> rollDispatchVouchers) {
		this.rollDispatchVouchers = rollDispatchVouchers;
	}

	public RollDispatchVoucher addRollDispatchVoucher(RollDispatchVoucher rollDispatchVoucher) {
		getRollDispatchVouchers().add(rollDispatchVoucher);
		rollDispatchVoucher.setSubProgram(this);

		return rollDispatchVoucher;
	}

	public RollDispatchVoucher removeRollDispatchVoucher(RollDispatchVoucher rollDispatchVoucher) {
		getRollDispatchVouchers().remove(rollDispatchVoucher);
		rollDispatchVoucher.setSubProgram(null);

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
		rollReceiptVoucher.setSubProgram(this);

		return rollReceiptVoucher;
	}

	public RollReceiptVoucher removeRollReceiptVoucher(RollReceiptVoucher rollReceiptVoucher) {
		getRollReceiptVouchers().remove(rollReceiptVoucher);
		rollReceiptVoucher.setSubProgram(null);

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
		stockTransferVoucher.setSubProgram(this);

		return stockTransferVoucher;
	}

	public StockTransferVoucher removeStockTransferVoucher(StockTransferVoucher stockTransferVoucher) {
		getStockTransferVouchers().remove(stockTransferVoucher);
		stockTransferVoucher.setSubProgram(null);

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
		storesVoucherExternalRoll.setSubProgram(this);

		return storesVoucherExternalRoll;
	}

	public StoresVoucherExternalRoll removeStoresVoucherExternalRoll(StoresVoucherExternalRoll storesVoucherExternalRoll) {
		getStoresVoucherExternalRolls().remove(storesVoucherExternalRoll);
		storesVoucherExternalRoll.setSubProgram(null);

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
		storesVoucherInternal.setSubProgram(this);

		return storesVoucherInternal;
	}

	public StoresVoucherInternal removeStoresVoucherInternal(StoresVoucherInternal storesVoucherInternal) {
		getStoresVoucherInternals().remove(storesVoucherInternal);
		storesVoucherInternal.setSubProgram(null);

		return storesVoucherInternal;
	}

	public Program getProgram() {
		return this.program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	@Override
	public String getDocumentClassId() {
		// TODO Auto-generated method stub
		return "SUB-PR";
	}

}