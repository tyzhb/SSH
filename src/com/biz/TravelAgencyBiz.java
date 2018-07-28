package com.biz;

import java.util.List;

import com.entity.TravelAgency;

public interface TravelAgencyBiz {
	public List search(TravelAgency condition); //查找
	public int add(TravelAgency condition,byte[] bussinessL,byte[] texL,byte[] codeL);
	public int delete(TravelAgency condition);
	public int update(TravelAgency condition,byte[] bussinessL,byte[] texL,byte[] codeL);
	public List searchbystate(TravelAgency condition); //查找
	public int updatestate(TravelAgency condition);
}
