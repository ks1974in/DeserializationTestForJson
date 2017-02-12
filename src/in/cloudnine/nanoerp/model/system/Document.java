package in.cloudnine.nanoerp.model.system;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import in.cloudnine.serverframework.data.interfaces.root.DataReferenceImpl;

import java.util.List;


/**
 * The persistent class for the Document database table.
 * 
 */
@JsonIdentityInfo(
		generator=ObjectIdGenerators.UUIDGenerator.class,
		property="_documentId",
		scope=Document.class
		)

@Entity
@Table(name="Document")
@NamedQuery(name="Document.findAll", query="SELECT d FROM Document d")
public class Document extends DataReferenceImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="DocumentId", unique=true, nullable=false, length=36)
	private String documentId;

	@Column(name="Code", nullable=false, length=36)
	private String code;

	@Column(name="Name", nullable=false, length=256)
	private String name;

	//bi-directional many-to-one association to Module
	@ManyToOne
	@JoinColumn(name="ModuleId", nullable=false)
	private Module module;

	//bi-directional many-to-one association to DocumentSerialNumber
	@OneToMany(mappedBy="document", fetch=FetchType.EAGER)
	private List<DocumentSerialNumber> documentSerialNumbers;

	public Document() {
	}

	public String getDocumentId() {
		return this.documentId;
	}

	public void setDocumentId(String documentId) {
		this.documentId = documentId;
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

	public Module getModule() {
		return this.module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public List<DocumentSerialNumber> getDocumentSerialNumbers() {
		return this.documentSerialNumbers;
	}

	public void setDocumentSerialNumbers(List<DocumentSerialNumber> documentSerialNumbers) {
		this.documentSerialNumbers = documentSerialNumbers;
	}

	public DocumentSerialNumber addDocumentSerialNumber(DocumentSerialNumber documentSerialNumber) {
		getDocumentSerialNumbers().add(documentSerialNumber);
		documentSerialNumber.setDocument(this);

		return documentSerialNumber;
	}

	public DocumentSerialNumber removeDocumentSerialNumber(DocumentSerialNumber documentSerialNumber) {
		getDocumentSerialNumbers().remove(documentSerialNumber);
		documentSerialNumber.setDocument(null);

		return documentSerialNumber;
	}

}