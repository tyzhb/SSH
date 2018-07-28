package com.travles.entity;

/**
 * TravelAgency entity. @author MyEclipse Persistence Tools
 */
public class TravelAgency extends AbstractTravelAgency implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public TravelAgency() {
	}

	/** minimal constructor */
	public TravelAgency(String agencyName, String phone) {
		super(agencyName, phone);
	}

	/** full constructor */
	public TravelAgency(String agencyName, String address, String discription,
			String phone, String bussinessLicense, String texLicense,
			String codeLicense, String state) {
		super(agencyName, address, discription, phone, bussinessLicense,
				texLicense, codeLicense, state);
	}

}
