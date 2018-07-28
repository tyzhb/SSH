package com.biz;

import java.util.List;

import com.entity.Person;

//增,删,查,改
public interface UserBiz {
	public List login(Person condition);
	public int register(Person condition);
}
