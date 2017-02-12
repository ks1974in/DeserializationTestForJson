package in.cloudnine.nanoerp.model.system;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import in.cloudnine.serverframework.data.interfaces.root.DataReferenceImpl;


/**
 * The persistent class for the DocumentSerialNumber database table.
 * 
 */
@JsonIdentityInfo(
		generator=ObjectIdGenerators.UUIDGenerator.class,
		property="_documentSerialNumberId",
		scope=DocumentSerialNumber.class
		)

@Entity
@Table(name="DocumentSerialNumber")
@NamedQuery(name="DocumentSerialNumber.findAll", query="SELECT d FROM DocumentSerialNumber d")
public class DocumentSerialNumber extends DataReferenceImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="DocumentSerialNumberId", unique=true, nullable=false, length=36)
	private String documentSerialNumberId;

	@Column(name="LastSerialNumber", nullable=false)
	private int lastSerialNumber;

	//bi-directional many-to-one association to Company
	@ManyToOne
	@JoinColumn(name="CompanyId", nullable=false)
	private Company company;

	//bi-directional many-to-one association to Document
	@ManyToOne
	@JoinColumn(name="DocumentId", nullable=false)
	private Document document;

	//bi-directional many-to-one association to FinancialYear
	@ManyToOne
	@JoinColumn(name="FinancialYearId", nullable=false)
	private FinancialYear financialYear;

	public DocumentSerialNumber() {
	}

	public String getDocumentSerialNumberId() {
		return this.documentSerialNumberId;
	}

	public void setDocumentSerialNumberId(String documentSerialNumberId) {
		this.documentSerialNumberId = documentSerialNumberId;
	}

	public int getLastSerialNumber() {
		return this.lastSerialNumber;
	}

	public void setLastSerialNumber(int lastSerialNumber) {
		this.lastSerialNumber = lastSerialNumber;
	}

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Document getDocument() {
		return this.document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public FinancialYear getFinancialYear() {
		return this.financialYear;
	}

	public void setFinancialYear(FinancialYear financialYear) {
		this.financialYear = financialYear;
	}

}