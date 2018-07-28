package com.entity;

import java.sql.Timestamp;


/**
 * TourGuide entity. @author MyEclipse Persistence Tools
 */
public class TourGuide extends AbstractTourGuide implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public TourGuide() {
    }

	/** minimal constructor */
    public TourGuide(String name, String password, String certificateno, String role) {
        super(name, password, certificateno, role);        
    }
    
    /** full constructor */
    public TourGuide(String name, String password, String certificateno, String phone, String travelagency, String role, Timestamp createtime) {
        super(name, password, certificateno, phone, travelagency, role, createtime);        
    }
   
}
