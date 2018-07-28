package com.login.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.login.biz.UserBiz;
import com.login.entity.Person;
import java.util.List;

public class TestLogin {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		UserBiz userBiz = (UserBiz)context.getBean("userBiz");
		Person condition = new Person();
		condition.setUsername("admin");
		List list = userBiz.login(condition);
		if(list.size() > 0) {
			System.out.println("登陆成功");
		} else {
			System.out.println("登录失败");
		}
	}
}
