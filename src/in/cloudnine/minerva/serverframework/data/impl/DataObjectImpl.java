/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.cloudnine.minerva.serverframework.data.impl;

import java.util.Date;




import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import in.cloudnine.minerva.serverframework.data.interfaces.DataObject;

import in.cloudnine.nanoerp.model.system.Company;
import in.cloudnine.nanoerp.model.system.SystemUser;
import in.cloudnine.serverframework.data.interfaces.root.DataReferenceImpl;


/**
 *
 * @author sagar
 */
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.PROTECTED_AND_PUBLIC)
@MappedSuperclass
public abstract class DataObjectImpl extends DataReferenceImpl implements DataObject{
    @ManyToOne
	@JoinColumn(name="CompanyId")
	protected Company company;
        @Temporal(TemporalType.DATE)
        @Column(name="Date")
        protected Date date;
        
        @Temporal(TemporalType.DATE)
        @Column(name="CreatedOn")
        protected Date createdOn=new Date();
        
        @Temporal(TemporalType.DATE)
        @Column(name="ModifiedOn")
        protected Date modifiedOn;
        
        
        
        @ManyToOne
    	@JoinColumn(name="SystemUserId")
        protected SystemUser systemUser;
        
      
	

    @Override
    public void setDate(Date date) {
    	
        this.date=date;
    }

    @Override
    public void setSystemUser(SystemUser systemUser) {
        this.systemUser=systemUser;
    }

   // @Override
    public void setCreatedOn(Date date) {
    	
    	if(getDataClass().getSimpleName().contains("StoresVoucherExternalRoll")){
    		System.out.println(getDataClass().getSimpleName()+":"+"Setting date:"+date);
    		
    	}

        this.createdOn=date;
    }

   // @Override
    public void setModifiedOn(Date date) {
        this.modifiedOn=date;
    }

    
  //  @Override
    public Date getDate() {
        return date;
    }

  //  @Override
    public SystemUser getSystemUser() {
        return systemUser;
    }

  //  @Override
    public Date getCreatedOn() {
        return createdOn;
    }

	@Override
	public Date getModifiedOn() {
		
		return modifiedOn; 
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}


   
}
