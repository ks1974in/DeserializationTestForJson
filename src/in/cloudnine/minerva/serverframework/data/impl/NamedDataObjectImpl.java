package in.cloudnine.minerva.serverframework.data.impl;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.PROTECTED_AND_PUBLIC)
@MappedSuperclass
public abstract class NamedDataObjectImpl extends DataObjectImpl{

    @Column(name="Name", nullable=false, length=256)
	private String name;

    public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
@Override
public String toString(){
	return name;
}
}
