package in.cloudnine.nanoerp.model.system;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import in.cloudnine.serverframework.data.interfaces.root.DataReferenceImpl;


/**
 * The persistent class for the AccessControlListTransactons database table.
 * 
 */

@JsonIdentityInfo(
		generator=ObjectIdGenerators.UUIDGenerator.class,
		property="_accessControlListTransactionsId",
		scope=AccessControlListTransacton.class
		)
@Entity
@Table(name="AccessControlListTransactons")
@NamedQuery(name="AccessControlListTransacton.findAll", query="SELECT a FROM AccessControlListTransacton a")
public class AccessControlListTransacton extends DataReferenceImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="AccessControlListTransactionsId", unique=true, nullable=false, length=36)
	private String accessControlListTransactionsId;

	@Column(name="CompanyId", nullable=false, length=36)
	private String companyId;

	@Column(name="`Create`", nullable=false)
	private Boolean create;

	@Column(name="`Delete`", nullable=false)
	private Boolean delete;

	@Column(name="DocumentId", nullable=false, length=36)
	private String documentId;

	@Column(name="Print", nullable=false)
	private Boolean print;

	@Column(name="`Update`", nullable=false)
	private Boolean update;

	@Column(name="UserGroupId", nullable=false, length=36)
	private String userGroupId;

	@Column(name="`View`", nullable=false)
	private Boolean view;

	public AccessControlListTransacton() {
	}

	public String getAccessControlListTransactionsId() {
		return this.accessControlListTransactionsId;
	}

	public void setAccessControlListTransactionsId(String accessControlListTransactionsId) {
		this.accessControlListTransactionsId = accessControlListTransactionsId;
	}

	public String getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public Boolean getCreate() {
		return this.create;
	}

	public void setCreate(Boolean create) {
		this.create = create;
	}

	public Boolean getDelete() {
		return this.delete;
	}

	public void setDelete(Boolean delete) {
		this.delete = delete;
	}

	public String getDocumentId() {
		return this.documentId;
	}

	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}

	public Boolean getPrint() {
		return this.print;
	}

	public void setPrint(Boolean print) {
		this.print = print;
	}

	public Boolean getUpdate() {
		return this.update;
	}

	public void setUpdate(Boolean update) {
		this.update = update;
	}

	public String getUserGroupId() {
		return this.userGroupId;
	}

	public void setUserGroupId(String userGroupId) {
		this.userGroupId = userGroupId;
	}

	public Boolean getView() {
		return this.view;
	}

	public void setView(Boolean view) {
		this.view = view;
	}

}