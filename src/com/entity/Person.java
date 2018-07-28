package com.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Person entity. @author MyEclipse Persistence Tools
 */
public class Person extends AbstractPerson implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Person() {
	}

	/** minimal constructor */
	public Person(String username, String password, String role) {
		super(username, password, role);
	}

	/** full constructor */
	public Person(BigDecimal id, String userid, String username,
			String password, String role, String userType,
			Timestamp createTime, Timestamp logTime, BigDecimal logCount) {
		super(id, userid, username, password, role, userType, createTime,
				logTime, logCount);
	}

}
