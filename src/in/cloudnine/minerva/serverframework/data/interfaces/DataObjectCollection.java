/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.cloudnine.minerva.serverframework.data.interfaces;

import in.cloudnine.serverframework.data.interfaces.root.DataReferenceCollection;

/**
 *
 * @author sagar
 */
public interface DataObjectCollection extends DataReferenceCollection{
public DataObject addDataObject(DataObject document);
public DataObject mergeDataObject(DataObject document);
public void removeDataObject(DataObject document);
public DataObject getDataObjectById(String documentId);
public DataObject getDataObjectSQL(String sql);
public DataObject[] getDataObjects(String sql);
public DataObject[] addDataObjects(DataObject[] document);
public DataObject updateDataObject(DataObject document);
public DataObject[] updateDataObjects(DataObject[] documents);
public DataObject[] mergeDataObjects(DataObject[] documents);
public void removeDataObjects(DataObject[] document);

    
}
