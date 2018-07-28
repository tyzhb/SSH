package com.dao;

import java.util.List;


import com.entity.TravelAgency;

public interface TravelAgencyDAO {
	public List search(TravelAgency condition);
	public List getAllTravelAgency();
	public int add(TravelAgency condition,byte[] bussinessL,byte[] texL,byte[] codeL);
	public int delete(TravelAgency condition);
	public int update(TravelAgency condition,byte[] bussinessL,byte[] texL,byte[] codeL);
	public List searchbystate(TravelAgency condition);
	public int updatestate(TravelAgency condition);

}
