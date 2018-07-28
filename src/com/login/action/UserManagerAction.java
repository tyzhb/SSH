//业务控制，调用逻辑层接口；Action类；登录处理
package com.login.action;
import com.opensymphony.xwork2.*;
import com.login.biz.UserBiz;
import com.login.entity.Person;
import com.login.entity.Role;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserManagerAction extends ActionSupport{
	private String username;
	private String password;
	
	//gets、sets实例封装
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	//gets、sets实例封装

	
	//声明一个UserBiz属性
	UserBiz userBiz;
	//添加set方法用于spring依赖注入
	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}
	public String execute() throws Exception {

		//声明hibernate成员
		Person condition = new Person();
		//初始化hibernate成员
		condition.setUsername(username);
		condition.setPassword(password);
		//登录判断
		List list = userBiz.login(condition);
		if(list.size() > 0) {
			return "success";
		} else {
			return "error";
		}
	}
}
