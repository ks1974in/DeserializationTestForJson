package in.cloudnine.nanoerp.model.system;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import in.cloudnine.serverframework.data.interfaces.root.DataReferenceImpl;

import java.util.List;


/**
 * The persistent class for the Master database table.
 * 
 */
@JsonIdentityInfo(
		generator=ObjectIdGenerators.UUIDGenerator.class,
		property="_masterId",
		scope=Master.class
		)

@Entity
@Table(name="Master")
@NamedQuery(name="Master.findAll", query="SELECT m FROM Master m")
public class Master extends DataReferenceImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MasterId", unique=true, nullable=false, length=36)
	private String masterId;

	@Column(name="Code", nullable=false, length=36)
	private String code;

	@Column(name="ModuleId", nullable=false, length=36)
	private String moduleId;

	@Column(name="Name", nullable=false, length=36)
	private String name;

	//bi-directional many-to-one association to AccessControlListMaster
	@OneToMany(mappedBy="master", fetch=FetchType.EAGER)
	private List<AccessControlListMaster> accessControlListMasters;

	public Master() {
	}

	public String getMasterId() {
		return this.masterId;
	}

	public void setMasterId(String masterId) {
		this.masterId = masterId;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getModuleId() {
		return this.moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<AccessControlListMaster> getAccessControlListMasters() {
		return this.accessControlListMasters;
	}

	public void setAccessControlListMasters(List<AccessControlListMaster> accessControlListMasters) {
		this.accessControlListMasters = accessControlListMasters;
	}

	public AccessControlListMaster addAccessControlListMaster(AccessControlListMaster accessControlListMaster) {
		getAccessControlListMasters().add(accessControlListMaster);
		accessControlListMaster.setMaster(this);

		return accessControlListMaster;
	}

	public AccessControlListMaster removeAccessControlListMaster(AccessControlListMaster accessControlListMaster) {
		getAccessControlListMasters().remove(accessControlListMaster);
		accessControlListMaster.setMaster(null);

		return accessControlListMaster;
	}

}