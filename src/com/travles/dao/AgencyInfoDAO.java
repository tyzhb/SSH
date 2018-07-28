package com.travles.dao;

import com.travles.entity.TravelAgency;

public interface AgencyInfoDAO{
	//根据注册用户对应的旅行社ID操作旅行社详细信息
	public boolean add(TravelAgency condition);
	//public void delete(TravelAgency condition);
	//public void update(TravelAgency condition);
	//public TravelAgency get(TravelAgency condition);
}
