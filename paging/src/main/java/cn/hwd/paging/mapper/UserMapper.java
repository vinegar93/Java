package cn.hwd.paging.mapper;

import java.util.List;
import java.util.Map;

import cn.hwd.paging.bean.User;

public interface UserMapper {
	
	public Integer count() throws Exception;
	
	public List<User> findAll(Map<String, Object> map) throws Exception; 
	
}
