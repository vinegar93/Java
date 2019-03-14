package cn.hwd.ssm.mapper;

import cn.hwd.ssm.bean.User;

public interface UserMapper {
	
	public User findUserById(int id) throws Exception; 
	
}
