/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.cloudnine.minerva.serverframework.data.impl;

import javax.persistence.Column;



import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import in.cloudnine.minerva.serverframework.data.interfaces.Document;
import in.cloudnine.nanoerp.model.system.FinancialYear;


/**
 *
 * @author sagar
 */
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.PROTECTED_AND_PUBLIC)
@MappedSuperclass
public abstract class DocumentImpl extends DataObjectImpl implements Document{
	@Transient
	protected String documentClassId;
    @Column(name="SerialNumber")
    protected String serialNumber;
    
    
     @ManyToOne
	@JoinColumn(name="FinancialYearId")
	protected FinancialYear financialYear;

 
  
   @Override
   public String getSerialNumber() {
		return serialNumber;
	}

   @Override
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

@Override
   public String toString(){
	   return serialNumber;
   }

public FinancialYear getFinancialYear() {

	return financialYear;
}

public void setFinancialYear(FinancialYear financialYear) {
	this.financialYear = financialYear;
}

public void setDocumentClassId(String documentClassId) {
	this.documentClassId = documentClassId;
	
}
   
}


