//业务控制，调用逻辑层接口；Action类；登录处理
package com.action;

import com.opensymphony.xwork2.*;
import com.biz.UserBiz;
import com.entity.Person;
import com.entity.Role;
import com.entity.TravelAgency;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserManagerAction extends ActionSupport {
	private String username;
	private String password;
	private String role;
	private String userid;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	// gets、sets实例封装
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

	/*
	 * 验证码验证函数 正确返回true,错误false;
	 */
	public boolean checkVerificationCode() {
		HttpServletRequest request = ServletActionContext.getRequest();

		String randcode = request.getParameter("randcode");// 获取输入框内容
		// 获取session保存的验证码
		String rightcode = (String) request.getSession().getAttribute("rCode");

		// System.out.println("randcode" + randcode + "\r\nrightcode" +
		// rightcode);
		if (randcode.equals(rightcode))
			return true;
		return false;

	}

	// 声明一个UserBiz属性
	UserBiz userBiz;

	// 添加set方法用于spring依赖注入
	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}

	//登录
	public String login() throws Exception {
		 ActionContext actionContext = ActionContext.getContext();
	       Map session = actionContext.getSession();
		if (checkVerificationCode()) {
			// 声明hibernate成员
			Person condition = new Person();
			// 初始化hibernate成员
			condition.setUsername(username);
			condition.setPassword(password);
			// 登录判断
			List list = userBiz.login(condition);
			if (list.size() > 0) {
				 session.put("username", username);//将username放入session中以判断是否登录
				return "success";
			} else {
				return "error";
			}
		} else {
			System.out.println("验证码错误");// 有没有办法传到页面上
			return "error";
		}
	}

	//增加导游
	public String addTourGuide() throws Exception {

		// 声明hibernate成员
		Person condition = new Person();
		// 初始化hibernate成员
		condition.setUserid(userid);
		condition.setUsername(username);
		condition.setPassword(password);
		condition.setRole("导游");
		condition.setUserType("导游");
		// 注册
		int ret = userBiz.register(condition);
		if (ret == 0) {
			return "success";
		} else {
			return "error";
		}
	}
	
	//增加旅行社
	//将旅行社的名称与电话插入person表,提供旅行社登录
	public String addTravelAgency(TravelAgency ta) throws Exception {

		// 声明hibernate成员
		Person condition = new Person();
		// 初始化hibernate成员
		condition.setUserid(ta.getAgencyName());
		condition.setUsername(ta.getAgencyName());
		condition.setPassword(ta.getPhone());
		condition.setRole("旅行社");
		condition.setUserType("admin");
		// 注册
		int ret = userBiz.register(condition);
		if (ret == 0) {
			return "success";
		} else {
			return "error";
		}
	}
	
	
}
