package cn.hwd.paging.service;

import java.util.List;
import java.util.Map;

import cn.hwd.paging.bean.User;

public interface UserService {

	public Integer count() throws Exception;
	
	public List<User> findAll(Map<String, Object> map) throws Exception;
	
}
