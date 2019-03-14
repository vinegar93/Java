package cn.hwd.paging.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hwd.paging.bean.User;
import cn.hwd.paging.mapper.UserMapper;
import cn.hwd.paging.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
    private UserMapper userMapper;
	
	public Integer count() throws Exception {
		return userMapper.count();
	}
	
	@Override
	public List<User> findAll(Map<String, Object> map) throws Exception {
        return userMapper.findAll(map);
	}

}
