//数据访问层实例；
package com.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.entity.Person;
import com.entity.TravelAgency;

import oracle.sql.TIMESTAMP;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;
import org.hibernate.cfg.*;
import org.hibernate.*;

public class UserDAOImpl implements UserDAO {
	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List search(Person condition) {
		List list = null;
		// 获取session
		Session session = sessionFactory.getCurrentSession();
		// 开始事务
		Transaction tx = session.beginTransaction();
		try {
			// 创建Criteria对象
			Criteria c = session.createCriteria(Person.class);
			// 使用Example工具类创建示例对象
			Example example = Example.create(condition);
			// 为Criteria对象指定实例对象example作为查询条件
			c.add(example);
			list = c.list(); // 执行查询
			tx.commit(); // 提交事务
		} catch (Exception e) {
			tx.rollback(); // 事务回顾
		}
		return list;
	}

	@Override
	public int save(Person condition) {
		Date now = new Date();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			// condition = new Person();
			condition.setCreateTime(now);

			session.save(condition);
			tx.commit();
		} catch (Exception e) {
			System.out.print(e);
			return -1;
		}
		return 0;
	}

	public List searchbyusername(Person condition) {
		List list = null;
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		tx = session.beginTransaction();
		try {
			Criteria criteria = session.createCriteria(Person.class);

			criteria.add(Restrictions.like("username", condition.getUsername()));

			list = criteria.list();
			tx.commit();
		} catch (Exception e) {
			System.out.print(e);
			tx.rollback(); //
		}

		return list;
	}
}
