package in.cloudnine.serverframework.data.interfaces.root;



public interface DataReferenceCollection {
	public DataReference getDataReferenceById(String DataReferenceId);
	public DataReference getDataReferenceSQL(String sql);
	public DataReference addDataReference(DataReference document);
	public DataReference mergeDataReference(DataReference document);
	public void removeDataReference(DataReference document);
	public DataReference[] getDataReferences(String sql);
	public DataReference[] addDataReferences(DataReference[] document);
	public DataReference updateDataReference(DataReference document);
	public DataReference[] updateDataReferences(DataReference[] documents);
	public DataReference[]mergeDataReferences(DataReference[]documents);
	public void removeDataReferences(DataReference[] document);	
	public Class getDataClass();
	public String getName();
	
	
}
