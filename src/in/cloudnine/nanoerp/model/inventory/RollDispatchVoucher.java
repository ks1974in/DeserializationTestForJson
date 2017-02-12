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

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the RollDispatchVoucher database table.
 * 
 */

@JsonIdentityInfo(
		generator=ObjectIdGenerators.UUIDGenerator.class,
		property="_rollDispatchVoucherId",
		scope=RollDispatchVoucher.class
		)

@Entity
@Table(name="RollDispatchVoucher")
@NamedQuery(name="RollDispatchVoucher.findAll", query="SELECT r FROM RollDispatchVoucher r")
public class RollDispatchVoucher extends DocumentImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="RollDispatchVoucherId", unique=true, nullable=false, length=36)
	private String rollDispatchVoucherId;

	@Column(name="Kgs", nullable=false, precision=10, scale=2)
	private BigDecimal kgs;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ReferenceDate")
	private Date referenceDate;

	@Column(name="ReferenceNumber", length=36)
	private String referenceNumber;

	@Column(name="Remarks", length=36)
	private String remarks;

	@Column(name="Rolls", nullable=false)
	private Integer rolls;

	
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

	//bi-directional many-to-one association to StoresVoucherExternalRoll
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="StoresVoucherExternalRollId", nullable=false)
	private StoresVoucherExternalRoll storesVoucherExternalRoll;

	//bi-directional many-to-one association to SubProgram
	@ManyToOne
	@JoinColumn(name="SubProgramId", nullable=false)
	private SubProgram subProgram;

	public RollDispatchVoucher() {
	}

	public String getRollDispatchVoucherId() {
		return this.rollDispatchVoucherId;
	}

	public void setRollDispatchVoucherId(String rollDispatchVoucherId) {
		this.rollDispatchVoucherId = rollDispatchVoucherId;
	}



	public BigDecimal getKgs() {
		return this.kgs;
	}

	public void setKgs(BigDecimal kgs) {
		this.kgs = kgs;
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

	public Integer getRolls() {
		return this.rolls;
	}

	public void setRolls(Integer rolls) {
		this.rolls = rolls;
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

	public StoresVoucherExternalRoll getStoresVoucherExternalRoll() {
		return this.storesVoucherExternalRoll;
	}

	public void setStoresVoucherExternalRoll(StoresVoucherExternalRoll storesVoucherExternalRoll) {
		this.storesVoucherExternalRoll = storesVoucherExternalRoll;
	}

	public SubProgram getSubProgram() {
		return this.subProgram;
	}

	public void setSubProgram(SubProgram subProgram) {
		this.subProgram = subProgram;
	}
	@Override
	public String getDocumentClassId(){
	return "RLDIS";
	}
	
}