package com.cissst.software.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cissst.software.dao.RoleManageDao;
import com.cissst.software.model.Role;
import com.cissst.software.service.IRoleManageService;

@Service("roleManageServiceImpl")
public class RoleManageServiceImpl implements IRoleManageService {
	
	@Autowired
	private RoleManageDao roleManageDao;

	/**
	 * 新增一个角色
	 * @param viewSpace
	 */
	public void addRole(Role role) {
		roleManageDao.save(role);
	}

	/**
	 * 查询所有角色
	 */
	@Override
	public List<Role> queryAllRole() {
		return roleManageDao.find();
		
	}

	@Override
	public Role findRoleById(int id) {
		
		return roleManageDao.find(new Object[]{id});
	}

	@Override
	public void updateRole(Role role) {
		
		roleManageDao.update(role);
	}

	@Override
	public List<Role> queryRoleByInfo(String name, String desc) {
		
		return roleManageDao.findSomeRole(name, desc);
	}

	@Override
	public void deleteCheckedRoles(int[] id) {
		roleManageDao.deleteBatchById(id);
		
	}
	
	public void delete(int[] id){
		roleManageDao.remove(id);
	}
	
}
