//业务逻辑层实例
package com.login.biz;

import java.util.List;
import com.login.dao.UserDAO;
import com.login.entity.Person;

public class UserBizImpl implements UserBiz {
	UserDAO userDAO;
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	@Override
	public List login(Person condition) {
		return userDAO.search(condition);
	}
}
