package in.cloudnine.serverframework.data.interfaces.root;

import java.io.Serializable;

public interface SerializableCollection {
	public Serializable getDataById(Class clazz,String DataReferenceId);
	public Serializable getData(Class clazz,String sql);
	public Serializable addData(Class clazz,Serializable document);
	public Serializable[] addData(Class clazz,Serializable[] document);
	public void removeData(Class clazz,Serializable document);
	public Serializable update(Class clazz,Serializable document);
	public Serializable[] update(Class clazz,Serializable[] documents);
	public void removeData(Class clazz,Serializable[] document);	
	public Serializable[] getDataArray(Class clazz,String sql);
	
	
}
