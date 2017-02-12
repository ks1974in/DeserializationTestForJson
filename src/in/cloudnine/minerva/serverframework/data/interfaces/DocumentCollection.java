/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.cloudnine.minerva.serverframework.data.interfaces;

import java.util.Iterator;

/**
 *
 * @author sagar
 */
public interface DocumentCollection extends DataObjectCollection{


public Document addDocument(Document document);
public Document[] addDocuments(Document[] document);
public Document updateDocument(Document document);
public Document mergeDocument(Document document);
public Document[] updateDocuments(Document[] documents);
public Document[] mergeDocuments(Document[] documents);
public void removeDocument(Document document);
public void removeDocuments(Document[] document);
public Document getDocumentById(String documentId);
public Document getDocumentSQL(String sql);
public Document[] getDocuments(String sql);

   


}
