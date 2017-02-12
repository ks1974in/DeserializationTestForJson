/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.cloudnine.minerva.serverframework.data.interfaces;

import java.util.Date;

import in.cloudnine.nanoerp.model.system.Company;
import in.cloudnine.nanoerp.model.system.SystemUser;
import in.cloudnine.serverframework.data.interfaces.root.DataReference;


/**
 *
 * @author sagar
 */
public interface DataObject extends DataReference{
    public void setCompany(Company company);
    public void setDate(Date data);
    public void setSystemUser(SystemUser systemUser);
    public void setCreatedOn(Date date);
    public void setModifiedOn(Date date);
    public Company getCompany() ;
    public Date getDate();
    public SystemUser getSystemUser();
    public Date getCreatedOn();
    public Date getModifiedOn();
}
