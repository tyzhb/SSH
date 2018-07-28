//数据访问层实例；
package com.login.dao;

import java.util.List;
import com.login.entity.Person;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

public class UserDAOImpl implements UserDAO {
	SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public List search(Person condition) {
		List list = null;
		//获取session
		Session session = sessionFactory.getCurrentSession();
		//开始事务
		Transaction tx = session.beginTransaction();
		
		try {
			//创建Criteria对象
			Criteria c = session.createCriteria(Person.class);
			//使用Example工具类创建示例对象
			Example example = Example.create(condition);
			//为Criteria对象指定实例对象example作为查询条件
			c.add(example);
			list = c.list();	//执行查询
			tx.commit();		//提交事务
		} catch (Exception e) {
			tx.rollback();		//事务回顾
		}
		return list;
	}
}

