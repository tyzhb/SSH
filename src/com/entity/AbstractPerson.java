package com.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * AbstractPerson entity provides the base persistence definition of the Person
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractPerson implements java.io.Serializable {

	// Fields

	private String userid;
	private BigDecimal id;
	private String username;
	private String password;
	private String role;
	private String userType;
	private Date createTime;
	private Timestamp logTime;
	private BigDecimal logCount;

	// Constructors

	/** default constructor */
	public AbstractPerson() {
	}

	/** minimal constructor */
	public AbstractPerson(String username, String password, String role) {
		this.username = username;
		this.password = password;
		this.role = role;
	}

	/** full constructor */
	public AbstractPerson(BigDecimal id, String userid, String username,
			String password, String role, String userType,
			Timestamp createTime, Timestamp logTime, BigDecimal logCount) {
		this.id = id;
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.role = role;
		this.userType = userType;
		this.createTime = createTime;
		this.logTime = logTime;
		this.logCount = logCount;
	}

	// Property accessors

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUserType() {
		return this.userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date now) {
		this.createTime = now;
	}

	public Timestamp getLogTime() {
		return this.logTime;
	}

	public void setLogTime(Timestamp logTime) {
		this.logTime = logTime;
	}

	public BigDecimal getLogCount() {
		return this.logCount;
	}

	public void setLogCount(BigDecimal logCount) {
		this.logCount = logCount;
	}

}