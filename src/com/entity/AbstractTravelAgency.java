package com.entity;


import java.math.BigDecimal;
import java.sql.Blob;



/**
 * AbstractTravelAgency entity provides the base persistence definition of the TravelAgency entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTravelAgency  implements java.io.Serializable {


    // Fields    

     private BigDecimal idKey;
     private String agencyName;
     private String address;
     private String discription;
     private String phone;
     private Blob bussinessLicense;
     private Blob texLicense;
     private Blob codeLicense;
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
    public AbstractTravelAgency(String agencyName, String address, String discription, String phone, Blob bussinessLicense, Blob texLicense, Blob codeLicense, String state) {
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

    public Blob getBussinessLicense() {
        return this.bussinessLicense;
    }
    
    public void setBussinessLicense(Blob Blob) {
        this.bussinessLicense = Blob;
    }

    public Blob getTexLicense() {
        return this.texLicense;
    }
    
    public void setTexLicense(Blob texLicense) {
        this.texLicense = texLicense;
    }

    public Blob getCodeLicense() {
        return this.codeLicense;
    }
    
    public void setCodeLicense(Blob codeLicense) {
        this.codeLicense = codeLicense;
    }

    public String getState() {
        return this.state;
    }
    
    public void setState(String state) {
        this.state = state;
    }
   








}