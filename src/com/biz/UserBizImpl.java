//业务逻辑层实例
package com.biz;

import java.util.List;

import com.dao.UserDAO;
import com.entity.Person;

public class UserBizImpl implements UserBiz {
	UserDAO userDAO;
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	@Override
	public List login(Person condition) {
		return userDAO.search(condition);
	}
	@Override
	public int register(Person condition) {
		// TODO Auto-generated method stub
		return userDAO.save(condition);
	}
}
