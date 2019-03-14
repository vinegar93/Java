package cn.hwd.ssm.service;

import cn.hwd.ssm.bean.User;

public interface UserService {

	public User findUserById(int id) throws Exception;
	
}
