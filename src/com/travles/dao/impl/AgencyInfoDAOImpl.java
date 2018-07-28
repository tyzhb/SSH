package com.travles.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.travles.dao.AgencyInfoDAO;
import com.travles.entity.TravelAgency;

public class AgencyInfoDAOImpl implements AgencyInfoDAO{
	SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public boolean add(TravelAgency condition) {
		//获取session
		Session session = sessionFactory.getCurrentSession();
		//开始事务
		Transaction tx = session.beginTransaction();
		
		try {
			//调用save方法持久化TravelAgency对象，之后TravelAgency对象转变为持久状态
			session.save(condition);
			tx.commit();		//提交事务
			return true;
		} catch (Exception e) {
			tx.rollback();		//事务回顾
			return false;
		}
	}
}
