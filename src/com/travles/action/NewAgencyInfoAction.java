package com.travles.action;

import java.math.BigDecimal;

import com.login.entity.Person;
import com.travles.biz.NewAgencyInfoBiz;
import com.travles.entity.TravelAgency;

public class NewAgencyInfoAction {
	private BigDecimal idKey;
	private String agencyName;
	private String address;
	private String discription;
	private String phone;
	private String bussinessLicense;
	private String texLicense;
	private String codeLicense;
	
	public BigDecimal getIdKey() {
		return idKey;
	}
	public void setIdKey(BigDecimal idKey) {
		this.idKey = idKey;
	}
	public String getAgencyName() {
		return agencyName;
	}
	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBussinessLicense() {
		return bussinessLicense;
	}
	public void setBussinessLicense(String bussinessLicense) {
		this.bussinessLicense = bussinessLicense;
	}
	public String getTexLicense() {
		return texLicense;
	}
	public void setTexLicense(String texLicense) {
		this.texLicense = texLicense;
	}
	public String getCodeLicense() {
		return codeLicense;
	}
	public void setCodeLicense(String codeLicense) {
		this.codeLicense = codeLicense;
	}

	NewAgencyInfoBiz agencyInfoBiz;

	public void setAgencyInfoBiz(NewAgencyInfoBiz agencyInfoBiz) {
		this.agencyInfoBiz = agencyInfoBiz;
	}
	public String execute() throws Exception {
		TravelAgency condition = new TravelAgency();
		condition.setAddress(address);
		condition.setAgencyName(agencyName);
		condition.setBussinessLicense(bussinessLicense);
		condition.setCodeLicense(codeLicense);
		condition.setDiscription(discription);
		condition.setIdKey(idKey);
		condition.setPhone(phone);
		condition.setTexLicense(texLicense);
		boolean ret = agencyInfoBiz.newInfo(condition);
		if(ret) {
			return "success";
		} else {
			return "error";
		}
	}
}
