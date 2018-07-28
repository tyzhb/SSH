package com.entity;

import java.sql.Blob;

/**
 * TravelAgency entity. @author MyEclipse Persistence Tools
 */
public class TravelAgency extends AbstractTravelAgency implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public TravelAgency() {
    }

	/** minimal constructor */
    public TravelAgency(String agencyName, String phone) {
        super(agencyName, phone);        
    }
    
    /** full constructor */
    public TravelAgency(String agencyName, String address, String discription, String phone, Blob bussinessLicense, Blob texLicense, Blob codeLicense, String state) {
        super(agencyName, address, discription, phone, bussinessLicense, texLicense, codeLicense, state);        
    }
   
}
