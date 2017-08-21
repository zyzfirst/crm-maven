package com.zhiyou100.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.ssm.mapper.RoleMapper;
import com.zhiyou100.ssm.model.Role;
import com.zhiyou100.ssm.model.RoleExample;
import com.zhiyou100.ssm.model.RoleVO;
import com.zhiyou100.ssm.service.RoleService;
import com.zhiyou100.ssm.util.Page;

@Service
public class RoleServiceImpl implements RoleService {
   
	@Autowired
	RoleMapper rm;

	@Override
	public List<Role> findRole() {
		
		return rm.selectByExample(null);
	}

	@Override
	public void addRole(Role r) {
		rm.insertSelective(r);
		
	}

	@Override
	public Role findRoleById(Integer theId) {
		
		return rm.selectByPrimaryKey(theId);
	}

	@Override
	public void updateRoleById(Role r) {
		rm.updateByPrimaryKeySelective(r);
		
	}

	@Override
	public void multieditRole(List<Role> list) {
		
		//批量修改传过来list ,需要遍历每个对象调一次方法,做到的批量修改
		for (Role role : list) {
			
			rm.updateByPrimaryKeySelective(role);
		}
		/*new 一个example对象,对象调方法,创建规则criteria
		调and 一直加规则就可以,带条件的查询
		RoleExample example = new RoleExample();
		example.createCriteria().andRDescLike(value)
		rm.updateByExampleSelective(Role对象(record), example规则传进来)*/
		
	}

	@Override
	public void deleteRole(Integer id) {
		rm.deleteByPrimaryKey(id);
		
	}

	@Override
	public List<Role> findRoleByName(String string) {
		RoleExample ex = new RoleExample();
		ex.createCriteria().andRNameLike("%" +string+ "%");
		return rm.selectByExample(ex);
	}

	@Override
	public void updateRole(Role r) {
		rm.updateByPrimaryKeySelective(r);
		//rm.updateByExampleSelective(r, null);
		
	}

	@Override
	public int findRoleCountByString(RoleVO rv) {
		
		return rm.findRoleCountByString(rv);
	}

	@Override
	public Page<Role> findRoleByString(RoleVO rv) {
		Page<Role> page = new Page<>();
		page.setSize(5);
		page.setTotal(rv.getTotal());
		page.setPage(rv.getCuruntpage());
		int startpage = (rv.getCuruntpage()-1)*5;
		rv.setStartpage(startpage);
		List<Role> rows = rm.findRoleByString(rv);
		
		
		page.setRows(rows);
		return page;
	}

	@Override
	public int findAllRoleCountByString(RoleVO rv) {
		
		System.out.println(rm.findRoleCountByString(rv));
		return rm.findRoleCountByString(rv);
	}

	@Override
	public Page<Role> findAllRoleByString(RoleVO rv) {
		Page<Role> page = new Page<>();
		page.setSize(5);
		page.setTotal(rv.getTotal());
		page.setPage(rv.getCuruntpage());
		List<Role> rows = rm.findRoleByString(rv);
		page.setRows(rows);
		return page;
	}

	

	

	

	

	
}
