package in.cloudnine.nanoerp.model.inventory;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import in.cloudnine.serverframework.data.interfaces.root.DataReferenceImpl;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the StoresVoucherInternalType database table.
 * 
 */
@JsonIdentityInfo(
		generator=ObjectIdGenerators.UUIDGenerator.class,
		property="_storesVoucherInternalTypeId",
		scope=StoresVoucherInternalType.class
		)

@Entity
@Table(name="StoresVoucherInternalType")
@NamedQuery(name="StoresVoucherInternalType.findAll", query="SELECT s FROM StoresVoucherInternalType s")
public class StoresVoucherInternalType  extends DataReferenceImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="StoresVoucherInternalTypeId", unique=true, nullable=false, length=36)
	private String storesVoucherInternalTypeId;

	@Column(name="Code", nullable=false, length=36)
	private String code;

	
	@Column(name="Name", nullable=false, length=36)
	private String name;

	@Column(name="ReceiptOrIssue", nullable=false)
	private Boolean receiptOrIssue;

	//bi-directional many-to-one association to StoresVoucherInternal
	@JsonIgnore
	@OneToMany(mappedBy="storesVoucherInternalType", fetch=FetchType.EAGER)
	private List<StoresVoucherInternal> storesVoucherInternals;

	public StoresVoucherInternalType() {
	}

	public String getStoresVoucherInternalTypeId() {
		return this.storesVoucherInternalTypeId;
	}

	public void setStoresVoucherInternalTypeId(String storesVoucherInternalTypeId) {
		this.storesVoucherInternalTypeId = storesVoucherInternalTypeId;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getReceiptOrIssue() {
		return this.receiptOrIssue;
	}

	public void setReceiptOrIssue(Boolean receiptOrIssue) {
		this.receiptOrIssue = receiptOrIssue;
	}

	public List<StoresVoucherInternal> getStoresVoucherInternals() {
		return this.storesVoucherInternals;
	}

	public void setStoresVoucherInternals(List<StoresVoucherInternal> storesVoucherInternals) {
		this.storesVoucherInternals = storesVoucherInternals;
	}

	public StoresVoucherInternal addStoresVoucherInternal(StoresVoucherInternal storesVoucherInternal) {
		getStoresVoucherInternals().add(storesVoucherInternal);
		storesVoucherInternal.setStoresVoucherInternalType(this);

		return storesVoucherInternal;
	}

	public StoresVoucherInternal removeStoresVoucherInternal(StoresVoucherInternal storesVoucherInternal) {
		getStoresVoucherInternals().remove(storesVoucherInternal);
		storesVoucherInternal.setStoresVoucherInternalType(null);

		return storesVoucherInternal;
	}

}