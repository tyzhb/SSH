package com.login.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Role entity. @author MyEclipse Persistence Tools
 */
public class Role extends AbstractRole implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Role() {
	}

	/** minimal constructor */
	public Role(BigDecimal roleId) {
		super(roleId);
	}

	/** full constructor */
	public Role(BigDecimal roleId, String describe, Timestamp createTime) {
		super(roleId, describe, createTime);
	}

}
