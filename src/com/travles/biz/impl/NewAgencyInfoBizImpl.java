package com.travles.biz.impl;

import com.travles.biz.NewAgencyInfoBiz;
import com.travles.dao.AgencyInfoDAO;
import com.travles.entity.TravelAgency;

public class NewAgencyInfoBizImpl implements NewAgencyInfoBiz{
	AgencyInfoDAO agencyInfoDAO;

	public void setAgencyInfoDAO(AgencyInfoDAO agencyInfoDAO) {
		this.agencyInfoDAO = agencyInfoDAO;
	}

	@Override
	public boolean newInfo(TravelAgency condition) {
		return agencyInfoDAO.add(condition); 
	}
}
