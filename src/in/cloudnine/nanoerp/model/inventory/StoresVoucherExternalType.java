package in.cloudnine.nanoerp.model.inventory;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import in.cloudnine.serverframework.data.interfaces.root.DataReferenceImpl;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the StoresVoucherExternalType database table.
 * 
 */
@JsonIdentityInfo(
		generator=ObjectIdGenerators.UUIDGenerator.class,
		property="_storesVoucherExternalTypeId",
		scope=StoresVoucherExternalType.class
		)

@Entity
@Table(name="StoresVoucherExternalType")
@NamedQuery(name="StoresVoucherExternalType.findAll", query="SELECT s FROM StoresVoucherExternalType s")
public class StoresVoucherExternalType extends DataReferenceImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="StoresVoucherExternalTypeId", unique=true, nullable=false, length=36)
	private String storesVoucherExternalTypeId;

	@Column(name="Code", nullable=false, length=36)
	private String code;

	@Column(name="Name", nullable=false, length=36)
	private String name;

	@Column(name="ReceiptOrIssue", nullable=false)
	private Boolean receiptOrIssue;

	//bi-directional many-to-one association to StoresVoucherExternal
	@OneToMany(mappedBy="storesVoucherExternalType", fetch=FetchType.EAGER)
	private List<StoresVoucherExternal> storesVoucherExternals;

	public StoresVoucherExternalType() {
	}

	public String getStoresVoucherExternalTypeId() {
		return this.storesVoucherExternalTypeId;
	}

	public void setStoresVoucherExternalTypeId(String storesVoucherExternalTypeId) {
		this.storesVoucherExternalTypeId = storesVoucherExternalTypeId;
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

	public List<StoresVoucherExternal> getStoresVoucherExternals() {
		return this.storesVoucherExternals;
	}

	public void setStoresVoucherExternals(List<StoresVoucherExternal> storesVoucherExternals) {
		this.storesVoucherExternals = storesVoucherExternals;
	}

	public StoresVoucherExternal addStoresVoucherExternal(StoresVoucherExternal storesVoucherExternal) {
		getStoresVoucherExternals().add(storesVoucherExternal);
		storesVoucherExternal.setStoresVoucherExternalType(this);

		return storesVoucherExternal;
	}

	public StoresVoucherExternal removeStoresVoucherExternal(StoresVoucherExternal storesVoucherExternal) {
		getStoresVoucherExternals().remove(storesVoucherExternal);
		storesVoucherExternal.setStoresVoucherExternalType(null);

		return storesVoucherExternal;
	}

}