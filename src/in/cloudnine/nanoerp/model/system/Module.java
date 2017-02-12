package in.cloudnine.nanoerp.model.system;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import in.cloudnine.serverframework.data.interfaces.root.DataReferenceImpl;

import java.util.List;


/**
 * The persistent class for the Module database table.
 * 
 */
@JsonIdentityInfo(
		generator=ObjectIdGenerators.UUIDGenerator.class,
		property="_moduleId",
		scope=Module.class
		)

@Entity
@Table(name="Module")
@NamedQuery(name="Module.findAll", query="SELECT m FROM Module m")
public class Module extends DataReferenceImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ModuleId", unique=true, nullable=false, length=36)
	private String moduleId;

	@Column(name="Code", nullable=false, length=36)
	private String code;

	@Column(name="Name", nullable=false, length=36)
	private String name;

	//bi-directional many-to-one association to Document
	@OneToMany(mappedBy="module", fetch=FetchType.EAGER)
	private List<Document> documents;

	public Module() {
	}

	public String getModuleId() {
		return this.moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
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

	public List<Document> getDocuments() {
		return this.documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	public Document addDocument(Document document) {
		getDocuments().add(document);
		document.setModule(this);

		return document;
	}

	public Document removeDocument(Document document) {
		getDocuments().remove(document);
		document.setModule(null);

		return document;
	}

}