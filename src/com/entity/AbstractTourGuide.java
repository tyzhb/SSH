package com.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * AbstractTourGuide entity provides the base persistence definition of the TourGuide entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTourGuide  implements java.io.Serializable {


    // Fields    

     private BigDecimal id;
     private String name;
     private String password;
     private String certificateno;
     private String phone;
     private String travelagency;
     private String role;
     private Timestamp createtime;


    // Constructors

    /** default constructor */
    public AbstractTourGuide() {
    }

	/** minimal constructor */
    public AbstractTourGuide(String name, String password, String certificateno, String role) {
        this.name = name;
        this.password = password;
        this.certificateno = certificateno;
        this.role = role;
    }
    
    /** full constructor */
    public AbstractTourGuide(String name, String password, String certificateno, String phone, String travelagency, String role, Timestamp createtime) {
        this.name = name;
        this.password = password;
        this.certificateno = certificateno;
        this.phone = phone;
        this.travelagency = travelagency;
        this.role = role;
        this.createtime = createtime;
    }

   
    // Property accessors

    public BigDecimal getId() {
        return this.id;
    }
    
    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public String getCertificateno() {
        return this.certificateno;
    }
    
    public void setCertificateno(String certificateno) {
        this.certificateno = certificateno;
    }

    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTravelagency() {
        return this.travelagency;
    }
    
    public void setTravelagency(String travelagency) {
        this.travelagency = travelagency;
    }

    public String getRole() {
        return this.role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }

    public Timestamp getCreatetime() {
        return this.createtime;
    }
    
    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }
   








}