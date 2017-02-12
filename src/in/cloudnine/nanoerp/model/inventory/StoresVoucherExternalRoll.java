package in.cloudnine.nanoerp.model.inventory;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import in.cloudnine.minerva.serverframework.data.impl.DocumentImpl;
import in.cloudnine.nanoerp.model.masters.Customer;
import in.cloudnine.nanoerp.model.production.Lot;
import in.cloudnine.nanoerp.model.production.Program;
import in.cloudnine.nanoerp.model.production.SubProgram;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the StoresVoucherExternalRoll database table.
 * 
 */
@JsonIdentityInfo(
		generator=ObjectIdGenerators.UUIDGenerator.class,
		property="_storesVoucherExternalRollId",
		scope=StoresVoucherExternalRoll.class
		)

@Entity
@Table(name="StoresVoucherExternalRoll")
@NamedQuery(name="StoresVoucherExternalRoll.findAll", query="SELECT s FROM StoresVoucherExternalRoll s")
public class StoresVoucherExternalRoll extends DocumentImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="StoresVoucherExternalRollId", unique=true, nullable=false, length=36)
	private String storesVoucherExternalRollId;

	
	@Column(name="Receipt", nullable=false)
	private Boolean receipt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ReferenceDate")
	private Date referenceDate;

	@Column(name="ReferenceNumber", length=36)
	private String referenceNumber;

	@Lob
	@Column(name="Remarks")
	private String remarks;

	
	
	@OneToOne(mappedBy="storesVoucherExternalRoll", fetch=FetchType.EAGER)
	private RollDispatchVoucher rollDispatchVoucher;

	//bi-directional many-to-one association to RollReceiptVoucher
	@OneToOne(mappedBy="storesVoucherExternalRoll", fetch=FetchType.EAGER,cascade=CascadeType.PERSIST)
	private RollReceiptVoucher rollReceiptVoucher;

	//bi-directional many-to-one association to RollTransaction
	@OneToMany(mappedBy="storesVoucherExternalRoll", fetch=FetchType.EAGER,cascade=CascadeType.PERSIST)
	private List<RollTransaction> rollTransactions=new ArrayList<>();;

	//bi-directional many-to-one association to StockRoll
	@OneToMany(mappedBy="storesVoucherExternalRoll", fetch=FetchType.EAGER,cascade=CascadeType.MERGE)
	private List<StockRoll> stockRolls=new ArrayList<>();;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="CustomerId", nullable=false)
	private Customer customer;

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

	public StoresVoucherExternalRoll() {
	}

	public String getStoresVoucherExternalRollId() {
		return this.storesVoucherExternalRollId;
	}

	public void setStoresVoucherExternalRollId(String storesVoucherExternalRollId) {
		this.storesVoucherExternalRollId = storesVoucherExternalRollId;
	}

	
	public Boolean isReceipt() {
		return this.receipt;
	}

	public void setReceipt(Boolean receipt) {
		this.receipt = receipt;
	}

	public Date getReferenceDate() {
		return this.referenceDate;
	}

	public void setReferenceDate(Date referenceDate) {
		this.referenceDate = referenceDate;
	}

	public String getReferenceNumber() {
		return this.referenceNumber;
	}

	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	

	
	public RollDispatchVoucher getRollDispatchVoucher() {
		return rollDispatchVoucher;
	}

	public void setRollDispatchVoucher(RollDispatchVoucher rollDispatchVoucher) {
		this.rollDispatchVoucher = rollDispatchVoucher;
	}

	public RollReceiptVoucher getRollReceiptVoucher() {
		return rollReceiptVoucher;
	}

	public void setRollReceiptVoucher(RollReceiptVoucher rollReceiptVoucher) {
		this.rollReceiptVoucher = rollReceiptVoucher;
	}

	public List<RollTransaction> getRollTransactions() {
		return this.rollTransactions;
	}

	public void setRollTransactions(List<RollTransaction> rollTransactions) {
		this.rollTransactions = rollTransactions;
	}

	public RollTransaction addRollTransaction(RollTransaction rollTransaction) {
		getRollTransactions().add(rollTransaction);
		rollTransaction.setStoresVoucherExternalRoll(this);

		return rollTransaction;
	}

	public RollTransaction removeRollTransaction(RollTransaction rollTransaction) {
		getRollTransactions().remove(rollTransaction);
		rollTransaction.setStoresVoucherExternalRoll(null);

		return rollTransaction;
	}

	public List<StockRoll> getStockRolls() {
		return this.stockRolls;
	}

	public void setStockRolls(List<StockRoll> stockRolls) {
		this.stockRolls = stockRolls;
	}

	public StockRoll addStockRoll(StockRoll stockRoll) {
		getStockRolls().add(stockRoll);
		stockRoll.setStoresVoucherExternalRoll(this);

		return stockRoll;
	}

	public StockRoll removeStockRoll(StockRoll stockRoll) {
		getStockRolls().remove(stockRoll);
		stockRoll.setStoresVoucherExternalRoll(null);

		return stockRoll;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
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
	if(isReceipt()){
		return "SVEX-RL-RET";
	}
	else{
		return "SVEX-RL-DIS";
	}
	}
}