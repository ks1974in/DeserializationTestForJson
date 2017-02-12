package in.cloudnine.nanoerp.model.inventory;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import in.cloudnine.minerva.serverframework.data.impl.DocumentImpl;
import in.cloudnine.nanoerp.model.masters.StockType;
import in.cloudnine.nanoerp.model.production.Program;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the StoresVoucherExternal database table.
 * 
 */
@JsonIdentityInfo(
		generator=ObjectIdGenerators.UUIDGenerator.class,
		property="_storesVoucherExternalId",
		scope=StoresVoucherExternal.class
		)

@Entity
@Table(name="StoresVoucherExternal")
@NamedQuery(name="StoresVoucherExternal.findAll", query="SELECT s FROM StoresVoucherExternal s")
public class StoresVoucherExternal extends DocumentImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="StoresVoucherExternalId", unique=true, nullable=false, length=36)
	private String storesVoucherExternalId;


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ReferenceDate")
	private Date referenceDate;

	@Column(name="ReferenceNumber", length=36)
	private String referenceNumber;

	@Lob
	@Column(name="Remarks")
	private String remarks;

	
	//bi-directional many-to-one association to LineItemExternal
	@OneToMany(mappedBy="storesVoucherExternal", fetch=FetchType.EAGER,cascade=CascadeType.PERSIST)
	private List<LineItemExternal> lineItemExternals=new ArrayList<>();;

	//bi-directional many-to-one association to LineItemExternalPT
	@OneToMany(mappedBy="storesVoucherExternal", fetch=FetchType.EAGER)
	private List<LineItemExternalPT> lineItemExternalPts=new ArrayList<>();;

	//bi-directional many-to-one association to Program
	@ManyToOne
	@JoinColumn(name="ProgramId", nullable=false)
	private Program program;

	//bi-directional many-to-one association to StockType
	@ManyToOne
	@JoinColumn(name="StockTypiId", nullable=false)
	private StockType stockType;

	//bi-directional many-to-one association to StoresVoucherExternalType
	@ManyToOne
	@JoinColumn(name="StoresVoucherExternalTypeId", nullable=false)
	private StoresVoucherExternalType storesVoucherExternalType;

	public StoresVoucherExternal() {
	}

	public String getStoresVoucherExternalId() {
		return this.storesVoucherExternalId;
	}

	public void setStoresVoucherExternalId(String storesVoucherExternalId) {
		this.storesVoucherExternalId = storesVoucherExternalId;
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

	public String getSerialNumber() {
		return this.serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public List<LineItemExternal> getLineItemExternals() {
		return this.lineItemExternals;
	}

	public void setLineItemExternals(List<LineItemExternal> lineItemExternals) {
		this.lineItemExternals = lineItemExternals;
	}

	public LineItemExternal addLineItemExternal(LineItemExternal lineItemExternal) {
		getLineItemExternals().add(lineItemExternal);
		lineItemExternal.setStoresVoucherExternal(this);

		return lineItemExternal;
	}

	public LineItemExternal removeLineItemExternal(LineItemExternal lineItemExternal) {
		getLineItemExternals().remove(lineItemExternal);
		lineItemExternal.setStoresVoucherExternal(null);

		return lineItemExternal;
	}

	public List<LineItemExternalPT> getLineItemExternalPts() {
		return this.lineItemExternalPts;
	}

	public void setLineItemExternalPts(List<LineItemExternalPT> lineItemExternalPts) {
		this.lineItemExternalPts = lineItemExternalPts;
	}

	public LineItemExternalPT addLineItemExternalPt(LineItemExternalPT lineItemExternalPt) {
		getLineItemExternalPts().add(lineItemExternalPt);
		lineItemExternalPt.setStoresVoucherExternal(this);

		return lineItemExternalPt;
	}

	public LineItemExternalPT removeLineItemExternalPt(LineItemExternalPT lineItemExternalPt) {
		getLineItemExternalPts().remove(lineItemExternalPt);
		lineItemExternalPt.setStoresVoucherExternal(null);

		return lineItemExternalPt;
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

	public StoresVoucherExternalType getStoresVoucherExternalType() {
		return this.storesVoucherExternalType;
	}

	public void setStoresVoucherExternalType(StoresVoucherExternalType storesVoucherExternalType) {
		this.storesVoucherExternalType = storesVoucherExternalType;
	}
	@Override
	public String getDocumentClassId(){
		
	return  "SVEX-MB";//storesVoucherExternalType.getStoresVoucherExternalTypeId()+"-"+stockType.getStockTypeId();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((stockType == null) ? 0 : stockType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StoresVoucherExternal other = (StoresVoucherExternal) obj;
		if (getSerialNumber() == null) {
			if (other.getSerialNumber() != null)
				return false;
		} else if (!getSerialNumber().equals(other.getSerialNumber()))
			return false;
		return true;
	}
	
	
}