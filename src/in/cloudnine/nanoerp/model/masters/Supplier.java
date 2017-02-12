package in.cloudnine.nanoerp.model.masters;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import in.cloudnine.minerva.serverframework.data.impl.GeographicalDataObjectImpl;

import java.util.Date;


/**
 * The persistent class for the Supplier database table.
 * 
 */
@JsonIdentityInfo(
		generator=ObjectIdGenerators.UUIDGenerator.class,
		property="_supplierId",
		scope=Supplier.class
		)
@Table(name="Supplier")
@Entity
@NamedQuery(name="Supplier.findAll", query="SELECT s FROM Supplier s")
public class Supplier extends GeographicalDataObjectImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SupplierId")
	private String supplierId;

	@Lob
	@Column(name="Address")
	private String address;

	
	@Column(name="Code")
	private String code;


	@Column(name="ContactPerson")
	private String contactPerson;

	
	@Column(name="GST")
	private String gst;

	@Column(name="LedgerId")
	private String ledgerId;

	@Column(name="Mobile")
	private String mobile;

	@Column(name="Name")
	private String name;

	@Column(name="PAN")
	private String pan;

	@Column(name="PostalCode")
	private String postalCode;


	public Supplier() {
	}

	public String getSupplierId() {
		return this.supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getContactPerson() {
		return this.contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getGst() {
		return this.gst;
	}

	public void setGst(String gst) {
		this.gst = gst;
	}

	public String getLedgerId() {
		return this.ledgerId;
	}

	public void setLedgerId(String ledgerId) {
		this.ledgerId = ledgerId;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPan() {
		return this.pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	

}