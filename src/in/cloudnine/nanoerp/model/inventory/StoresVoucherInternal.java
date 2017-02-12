package in.cloudnine.nanoerp.model.inventory;


import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import in.cloudnine.minerva.serverframework.data.impl.DocumentImpl;
import in.cloudnine.nanoerp.model.masters.StockType;
import in.cloudnine.nanoerp.model.production.Lot;
import in.cloudnine.nanoerp.model.production.Program;
import in.cloudnine.nanoerp.model.production.SubProgram;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the StoresVoucherInternal database table.
 * 
 */
@JsonIdentityInfo(
		generator=ObjectIdGenerators.UUIDGenerator.class,
		property="_storesVoucherInternalId",
		scope=StoresVoucherInternal.class
		)

@Entity
@Table(name="StoresVoucherInternal")
@NamedQuery(name="StoresVoucherInternal.findAll", query="SELECT s FROM StoresVoucherInternal s")
public class StoresVoucherInternal extends DocumentImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="StoresVoucherInternalId", unique=true, nullable=false, length=36)
	private String storesVoucherInternalId;


	@Lob
	@Column(name="Remarks")
	private String remarks;

	
	//bi-directional many-to-one association to LineItemInternal
	@OneToMany(mappedBy="storesVoucherInternal", fetch=FetchType.EAGER,cascade=CascadeType.PERSIST)
	private List<LineItemInternal> lineItemInternals=new ArrayList<>();;

	//bi-directional many-to-one association to LineItemInternalPT
	@OneToMany(mappedBy="storesVoucherInternal", fetch=FetchType.EAGER,cascade=CascadeType.PERSIST)
	private List<LineItemInternalPT> lineItemInternalPts=new ArrayList<>();;

	//bi-directional many-to-one association to Lot
	@ManyToOne
	@JoinColumn(name="LotId", nullable=false)
	private Lot lot;

	//bi-directional many-to-one association to Program
	@ManyToOne
	@JoinColumn(name="ProgramId", nullable=false)
	private Program program;

	//bi-directional many-to-one association to StockType
	@ManyToOne
	@JoinColumn(name="StockTypeId", nullable=false)
	private StockType stockType;

	//bi-directional many-to-one association to StoresVoucherInternalType
	@ManyToOne
	@JoinColumn(name="StoresVoucherInternalTypeId", nullable=false)
	private StoresVoucherInternalType storesVoucherInternalType;

	//bi-directional many-to-one association to SubProgram
	@ManyToOne
	@JoinColumn(name="SubProgramId", nullable=false)
	private SubProgram subProgram;

	public StoresVoucherInternal() {
	}

	public String getStoresVoucherInternalId() {
		return this.storesVoucherInternalId;
	}

	public void setStoresVoucherInternalId(String storesVoucherInternalId) {
		this.storesVoucherInternalId = storesVoucherInternalId;
	}

	
	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

		public List<LineItemInternal> getLineItemInternals() {
		return this.lineItemInternals;
	}

	public void setLineItemInternals(List<LineItemInternal> lineItemInternals) {
		this.lineItemInternals = lineItemInternals;
	}

	public LineItemInternal addLineItemInternal(LineItemInternal lineItemInternal) {
		getLineItemInternals().add(lineItemInternal);
		lineItemInternal.setStoresVoucherInternal(this);

		return lineItemInternal;
	}

	public LineItemInternal removeLineItemInternal(LineItemInternal lineItemInternal) {
		getLineItemInternals().remove(lineItemInternal);
		lineItemInternal.setStoresVoucherInternal(null);

		return lineItemInternal;
	}

	public List<LineItemInternalPT> getLineItemInternalPts() {
		return this.lineItemInternalPts;
	}

	public void setLineItemInternalPts(List<LineItemInternalPT> lineItemInternalPts) {
		this.lineItemInternalPts = lineItemInternalPts;
	}

	public LineItemInternalPT addLineItemInternalPt(LineItemInternalPT lineItemInternalPt) {
		getLineItemInternalPts().add(lineItemInternalPt);
		lineItemInternalPt.setStoresVoucherInternal(this);

		return lineItemInternalPt;
	}

	public LineItemInternalPT removeLineItemInternalPt(LineItemInternalPT lineItemInternalPt) {
		getLineItemInternalPts().remove(lineItemInternalPt);
		lineItemInternalPt.setStoresVoucherInternal(null);

		return lineItemInternalPt;
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

	public StockType getStockType() {
		return this.stockType;
	}

	public void setStockType(StockType stockType) {
		this.stockType = stockType;
	}

	public StoresVoucherInternalType getStoresVoucherInternalType() {
		return this.storesVoucherInternalType;
	}

	public void setStoresVoucherInternalType(StoresVoucherInternalType storesVoucherInternalType) {
		this.storesVoucherInternalType = storesVoucherInternalType;
	}

	public SubProgram getSubProgram() {
		return this.subProgram;
	}

	public void setSubProgram(SubProgram subProgram) {
		this.subProgram = subProgram;
	}
	@Override
	public String getDocumentClassId(){
	return storesVoucherInternalType.getStoresVoucherInternalTypeId()+"-"+stockType.getStockTypeId();
	}
	
	
}