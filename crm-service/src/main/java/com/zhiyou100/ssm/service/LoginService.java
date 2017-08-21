package com.zhiyou100.ssm.service;

import java.util.List;

import com.zhiyou100.ssm.model.User;

public interface LoginService {

	List<User> getUser(String username, String password);

	User findUserById(Integer id);

	void updateUserById(User u);
    
}
