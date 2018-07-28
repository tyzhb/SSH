//数据访问层接口
package com.dao;
import java.util.List;

import com.entity.Person;

public interface UserDAO {
	public List search(Person condition);
	public int save(Person condition);
}
