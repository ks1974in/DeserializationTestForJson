package in.cloudnine.nanoerp.model.system;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import in.cloudnine.serverframework.data.interfaces.root.DataReferenceImpl;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the FinancialYear database table.
 * 
 */
@JsonIdentityInfo(
		generator=ObjectIdGenerators.UUIDGenerator.class,
		property="_financialYearId",
		scope=FinancialYear.class
		)

@Entity
@Table(name="FinancialYear")
@NamedQuery(name="FinancialYear.findAll", query="SELECT f FROM FinancialYear f")
public class FinancialYear extends DataReferenceImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="FinancialYearId", unique=true, nullable=false, length=36)
	private String financialYearId;

	@Column(name="Code", nullable=false, length=36)
	private String code;

	@Temporal(TemporalType.DATE)
	@Column(name="EndDate", nullable=false)
	private Date endDate;

	@Column(name="Name", nullable=false, length=36)
	private String name;

	@Lob
	@Column(name="Remarks", nullable=false)
	private String remarks;

	@Temporal(TemporalType.DATE)
	@Column(name="StartDate", nullable=false)
	private Date startDate;

	//bi-directional many-to-one association to DocumentSerialNumber
	@JsonIgnore
	@OneToMany(mappedBy="financialYear", fetch=FetchType.EAGER)
	private List<DocumentSerialNumber> documentSerialNumbers;

	public FinancialYear() {
	}

	public String getFinancialYearId() {
		return this.financialYearId;
	}

	public void setFinancialYearId(String financialYearId) {
		this.financialYearId = financialYearId;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public List<DocumentSerialNumber> getDocumentSerialNumbers() {
		return this.documentSerialNumbers;
	}

	public void setDocumentSerialNumbers(List<DocumentSerialNumber> documentSerialNumbers) {
		this.documentSerialNumbers = documentSerialNumbers;
	}

	public DocumentSerialNumber addDocumentSerialNumber(DocumentSerialNumber documentSerialNumber) {
		getDocumentSerialNumbers().add(documentSerialNumber);
		documentSerialNumber.setFinancialYear(this);

		return documentSerialNumber;
	}

	public DocumentSerialNumber removeDocumentSerialNumber(DocumentSerialNumber documentSerialNumber) {
		getDocumentSerialNumbers().remove(documentSerialNumber);
		documentSerialNumber.setFinancialYear(null);

		return documentSerialNumber;
	}

}