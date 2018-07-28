package com.biz;

import java.util.List;

import com.dao.TravelAgencyDAO;
import com.entity.TravelAgency;

public class TravelAgencyBizImpl implements TravelAgencyBiz {
	TravelAgencyDAO travelAgencyDAO;

	public TravelAgencyDAO getTravelAgencyDAO() {
		return travelAgencyDAO;
	}

	public void setTravelAgencyDAO(TravelAgencyDAO travelAgencyDAO) {
		this.travelAgencyDAO = travelAgencyDAO;
	}

	@Override
	public List search(TravelAgency condition) {
		// TODO Auto-generated method stub
		if (!condition.getAgencyName().equals(""))
			return travelAgencyDAO.search(condition);
		else
			return travelAgencyDAO.getAllTravelAgency();
	}

	@Override
	public int add(TravelAgency condition,byte[] bussinessL,byte[] texL,byte[] codeL) {
		// TODO Auto-generated method stub
		return travelAgencyDAO.add(condition,bussinessL,texL,codeL);
	}

	@Override
	public int delete(TravelAgency condition) {
		// TODO Auto-generated method stub
		return travelAgencyDAO.delete(condition);
	}

	@Override
	public int update(TravelAgency condition,byte[] bussinessL,byte[] texL,byte[] codeL) {
		// TODO Auto-generated method stub
		return travelAgencyDAO.update(condition,bussinessL,texL,codeL);
	}

	@Override
	public List searchbystate(TravelAgency condition) {
		// TODO Auto-generated method stub
		return travelAgencyDAO.searchbystate(condition);
	}

	@Override
	public int updatestate(TravelAgency condition) {
		// TODO Auto-generated method stub
		return travelAgencyDAO.updatestate(condition);
	}



}
