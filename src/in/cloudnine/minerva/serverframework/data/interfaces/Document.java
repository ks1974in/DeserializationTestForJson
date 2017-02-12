/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.cloudnine.minerva.serverframework.data.interfaces;

import java.util.Date;

import in.cloudnine.nanoerp.model.system.FinancialYear;







/**
 *
 * @author sagar
 */
public interface Document extends DataObject{
   public String getDocumentClassId();
   public void setSerialNumber(String serialNumber);
   public String getSerialNumber();
   public void setFinancialYear(FinancialYear financialYear);
   public FinancialYear getFinancialYear();
   
   
}
