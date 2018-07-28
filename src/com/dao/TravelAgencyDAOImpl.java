package com.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;

import com.entity.Person;
import com.entity.TravelAgency;

public class TravelAgencyDAOImpl implements TravelAgencyDAO {

	SessionFactory sessionFactory;
	List<TravelAgency> list = new ArrayList<TravelAgency>();

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List search(TravelAgency condition) {
		// TODO Auto-generated method stub
		// 获取session
		Session session = sessionFactory.getCurrentSession();
		// 开始事务
		Transaction tx = session.beginTransaction();
		try {
			Criteria c = session.createCriteria(TravelAgency.class);
			Example example = Example.create(condition);
			// 为Criteria对象指定实例对象example作为查询条件
			c.add(example);
			list = c.list(); // 执行查询

			copyimg(list);// 将 图片copy到tmp/img下

			tx.commit(); // 提交事务
		} catch (Exception e) {
			System.out.print(e);
			tx.rollback(); // 事务回顾
		}
		return list;

	}

	@Override
	public List getAllTravelAgency() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		try {
			String hql = "from TravelAgency"; // 类名不是表名注意
			Query query = session.createQuery(hql);
			list = query.list();

			copyimg(list);// 将 图片copy到tmp/img下

			tx.commit();
		} catch (Exception e) {
			System.out.print(e);
			tx.rollback(); //
		}

		return list;
	}

	// 增加
	@Override
	public int add(TravelAgency condition, byte[] bussinessL, byte[] texL,
			byte[] codeL) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		condition.setState("s");// 默认s未审核
		if (bussinessL != null)
			condition.setBussinessLicense(session.getLobHelper().createBlob(
					bussinessL));
		if (texL != null)
			condition.setTexLicense(session.getLobHelper().createBlob(texL));
		if (codeL != null)
			condition.setCodeLicense(session.getLobHelper().createBlob(codeL));

		try {
			session.save(condition);
			tx.commit();
		} catch (Exception e) {
			System.out.print(e);
			tx.rollback();
			return -1;
		}
		return 0;
	}

	// 删除
	@Override
	public int delete(TravelAgency condition) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.delete(condition);

			deleteimg(condition);

			tx.commit();
		} catch (Exception e) {
			System.out.print(e);
			tx.rollback();
			return -1;
		}
		return 0;
	}

	// 更新修改
	@Override
	public int update(TravelAgency condition, byte[] bussinessL, byte[] texL,
			byte[] codeL) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();

		Transaction tx = session.beginTransaction();
		try {
			// 解决部证书字段更新问题 使用condition时会全部更新
			TravelAgency ta = (TravelAgency) session.get(TravelAgency.class,
					condition.getIdKey());

			ta.setAgencyName(condition.getAgencyName());
			ta.setAddress(condition.getAddress());
			ta.setDiscription(condition.getDiscription());
			ta.setPhone(condition.getPhone());
			ta.setState(condition.getState());
			if (bussinessL != null)
				ta.setBussinessLicense(session.getLobHelper().createBlob(
						bussinessL));
			if (texL != null)
				ta.setTexLicense(session.getLobHelper().createBlob(texL));
			if (codeL != null)
				ta.setCodeLicense(session.getLobHelper().createBlob(codeL));

			session.update(ta);

			// 审核通过时将旅行社名称电话插入person表中
			deleteimg(ta);

			tx.commit();
		} catch (Exception e) {
			System.out.print(e);
			tx.rollback();
			return -1;
		}
		return 0;
	}

	// 将从数据库查找出的图片复制到/tmp/img/下,以idkey命名
	public int copyimg(List<TravelAgency> list) throws Exception {
		int size = list.size();
		while ((size--) > 0) {
			TravelAgency ta = new TravelAgency();
			ta = (TravelAgency) list.get(size);

			if (ta.getBussinessLicense() != null) {
				Blob bLimg = ta.getBussinessLicense();
				Blob tLimg = ta.getTexLicense();
				Blob cLimg = ta.getCodeLicense();
				byte[] bL = new byte[(int) bLimg.length()];
				byte[] tL = new byte[(int) tLimg.length()];
				byte[] cL = new byte[(int) cLimg.length()];
				InputStream inbl = bLimg.getBinaryStream();
				inbl.read(bL);
				InputStream intl = tLimg.getBinaryStream();
				intl.read(tL);
				InputStream incl = cLimg.getBinaryStream();
				incl.read(cL);

				// 获取绝对路径
				String filepath = ServletActionContext.getServletContext()
						.getRealPath("/tmp/img");
				String filenamebl = ta.getIdKey() + "bL.jpg";
				File filebl = new File(filepath, filenamebl);
				FileOutputStream foutbl = new FileOutputStream(filebl);
				foutbl.write(bL);
				String filenametl = ta.getIdKey() + "tL.jpg";
				File filetl = new File(filepath, filenametl);
				FileOutputStream fouttl = new FileOutputStream(filetl);
				fouttl.write(tL);
				String filenamecl = ta.getIdKey() + "cL.jpg";
				File filecl = new File(filepath, filenamecl);
				FileOutputStream foutcl = new FileOutputStream(filecl);
				foutcl.write(cL);
				inbl.close();
				foutbl.close();
				fouttl.close();
				foutcl.close();
			}
		}
		return 0;
	}

	public int deleteimg(TravelAgency ta) throws Exception {
		if (ta.getIdKey() != null) {
			// 获取绝对路径
			String filepath = ServletActionContext.getServletContext()
					.getRealPath("/tmp/img");
			String filename = ta.getIdKey() + ".jpg";
			File file = new File(filepath, filename);
			if (file.exists())
				file.delete();
		}
		return 0;
	}

	// 根据状态搜索 state由网页传过来
	@Override
	public List searchbystate(TravelAgency condition) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		try {
			Criteria criteria = session.createCriteria(TravelAgency.class);
			if (condition.getAgencyName() != null
					&& !condition.getAgencyName().equals(""))
				// 映射后的名称agencyName,不是字段名称
				criteria.add(Restrictions.like("agencyName",
						condition.getAgencyName()));

			criteria.add(Restrictions.like("state", condition.getState()));

			list = criteria.list();

			copyimg(list);// 将 图片copy到tmp/img下

			tx.commit();
		} catch (Exception e) {
			System.out.print(e);
			tx.rollback(); //
		}

		return list;
	}

	@Override
	public int updatestate(TravelAgency condition) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();

		Transaction tx = session.beginTransaction();
		try {
			// 将ta插入person表 用旅行社名称与电话号码登录
			Person person = new Person();
			UserDAOImpl userDAOImpl = new UserDAOImpl();

			person.setUserid(condition.getAgencyName());
			//存在时不再操作person表
			if (userDAOImpl.searchbyusername(person).size() <=0 ) {
				person.setUsername(condition.getAgencyName());
				person.setPassword(condition.getPhone());
				person.setRole("admin");
				person.setUserType("旅行社");

				session.saveOrUpdate(person);
			}

			// 解决部证书字段更新问题 使用condition时会全部更新
			TravelAgency ta = (TravelAgency) session.get(TravelAgency.class,
					condition.getIdKey());

			ta.setState(condition.getState()); // 设置状态

			session.update(ta);

			deleteimg(ta);

			tx.commit();
		} catch (Exception e) {
			System.out.print(e);
			tx.rollback();
			return -1;
		}
		return 0;
	}

}
