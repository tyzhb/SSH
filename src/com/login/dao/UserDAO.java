//数据访问层接口
package com.login.dao;
import java.util.List;
import com.login.entity.Person;

public interface UserDAO {
	public List search(Person condition);
}
