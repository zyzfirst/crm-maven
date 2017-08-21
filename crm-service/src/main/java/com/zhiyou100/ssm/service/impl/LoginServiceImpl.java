package com.zhiyou100.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.ssm.mapper.UserMapper;
import com.zhiyou100.ssm.model.User;
import com.zhiyou100.ssm.model.UserExample;
import com.zhiyou100.ssm.service.LoginService;
@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	UserMapper um;

	@Override
	public List<User> getUser(String username, String password) {
		UserExample ue = new  UserExample();
		ue.createCriteria().andUNameEqualTo(username).andUPwdEqualTo(password);
		 List<User> list = um.selectByExample(ue);
		return list;
	}

	@Override
	public User findUserById(Integer id) {
		
		return um.selectByPrimaryKey(id);
	}

	@Override
	public void updateUserById(User u) {
		um.updateByPrimaryKeySelective(u);
		
	}

}
