package com.zhiyou100.ssm.service;

import java.util.List;

import com.zhiyou100.ssm.model.Role;
import com.zhiyou100.ssm.model.RoleVO;
import com.zhiyou100.ssm.util.Page;

public interface RoleService {

	List<Role> findRole();

	void addRole(Role r);

	Role findRoleById(Integer theId);

	void updateRoleById(Role r);

	void multieditRole(List<Role> list);

	void deleteRole(Integer id);

	List<Role> findRoleByName(String string);

	void updateRole(Role r);

	int findRoleCountByString(RoleVO rv);

	Page<Role> findRoleByString(RoleVO rv);

	int findAllRoleCountByString(RoleVO rv);

	Page<Role> findAllRoleByString(RoleVO rv);

	

	

	

	

	
}
