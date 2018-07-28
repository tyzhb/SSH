package com.dao;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.entity.TourGuide;

/**
 * A data access object (DAO) providing persistence and search support for
 * TourGuide entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see .TourGuide
 * @author MyEclipse Persistence Tools
 */
public class TourGuideDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(TourGuideDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String PASSWORD = "password";
	public static final String CERTIFICATENO = "certificateno";
	public static final String PHONE = "phone";
	public static final String TRAVELAGENCY = "travelagency";
	public static final String ROLE = "role";

	protected void initDao() {
		// do nothing
	}

	public void save(TourGuide transientInstance) {
		log.debug("saving TourGuide instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TourGuide persistentInstance) {
		log.debug("deleting TourGuide instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TourGuide findById(java.math.BigDecimal id) {
		log.debug("getting TourGuide instance with id: " + id);
		try {
			TourGuide instance = (TourGuide) getHibernateTemplate().get(
					"TourGuide", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TourGuide instance) {
		log.debug("finding TourGuide instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TourGuide instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TourGuide as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List findByCertificateno(Object certificateno) {
		return findByProperty(CERTIFICATENO, certificateno);
	}

	public List findByPhone(Object phone) {
		return findByProperty(PHONE, phone);
	}

	public List findByTravelagency(Object travelagency) {
		return findByProperty(TRAVELAGENCY, travelagency);
	}

	public List findByRole(Object role) {
		return findByProperty(ROLE, role);
	}

	public List findAll() {
		log.debug("finding all TourGuide instances");
		try {
			String queryString = "from TourGuide";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TourGuide merge(TourGuide detachedInstance) {
		log.debug("merging TourGuide instance");
		try {
			TourGuide result = (TourGuide) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TourGuide instance) {
		log.debug("attaching dirty TourGuide instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TourGuide instance) {
		log.debug("attaching clean TourGuide instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TourGuideDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TourGuideDAO) ctx.getBean("TourGuideDAO");
	}
}