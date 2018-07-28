package com.travles.entity;

import java.math.BigDecimal;

/**
 * AbstractTravelAgency entity provides the base persistence definition of the
 * TravelAgency entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTravelAgency implements java.io.Serializable {

	// Fields

	private BigDecimal idKey;
	private String agencyName;
	private String address;
	private String discription;
	private String phone;
	private String bussinessLicense;
	private String texLicense;
	private String codeLicense;
	private String state;

	// Constructors

	/** default constructor */
	public AbstractTravelAgency() {
	}

	/** minimal constructor */
	public AbstractTravelAgency(String agencyName, String phone) {
		this.agencyName = agencyName;
		this.phone = phone;
	}

	/** full constructor */
	public AbstractTravelAgency(String agencyName, String address,
			String discription, String phone, String bussinessLicense,
			String texLicense, String codeLicense, String state) {
		this.agencyName = agencyName;
		this.address = address;
		this.discription = discription;
		this.phone = phone;
		this.bussinessLicense = bussinessLicense;
		this.texLicense = texLicense;
		this.codeLicense = codeLicense;
		this.state = state;
	}

	// Property accessors

	public BigDecimal getIdKey() {
		return this.idKey;
	}

	public void setIdKey(BigDecimal idKey) {
		this.idKey = idKey;
	}

	public String getAgencyName() {
		return this.agencyName;
	}

	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDiscription() {
		return this.discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBussinessLicense() {
		return this.bussinessLicense;
	}

	public void setBussinessLicense(String bussinessLicense) {
		this.bussinessLicense = bussinessLicense;
	}

	public String getTexLicense() {
		return this.texLicense;
	}

	public void setTexLicense(String texLicense) {
		this.texLicense = texLicense;
	}

	public String getCodeLicense() {
		return this.codeLicense;
	}

	public void setCodeLicense(String codeLicense) {
		this.codeLicense = codeLicense;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

}