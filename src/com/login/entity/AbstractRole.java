package com.login.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * AbstractRole entity provides the base persistence definition of the Role
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractRole implements java.io.Serializable {

	// Fields

	private String roleName;
	private BigDecimal roleId;
	private String describe;
	private Timestamp createTime;

	// Constructors

	/** default constructor */
	public AbstractRole() {
	}

	/** minimal constructor */
	public AbstractRole(BigDecimal roleId) {
		this.roleId = roleId;
	}

	/** full constructor */
	public AbstractRole(BigDecimal roleId, String describe, Timestamp createTime) {
		this.roleId = roleId;
		this.describe = describe;
		this.createTime = createTime;
	}

	// Property accessors

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public BigDecimal getRoleId() {
		return this.roleId;
	}

	public void setRoleId(BigDecimal roleId) {
		this.roleId = roleId;
	}

	public String getDescribe() {
		return this.describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}