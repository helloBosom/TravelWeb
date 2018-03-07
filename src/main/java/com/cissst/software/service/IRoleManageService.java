package com.cissst.software.service;

import java.util.List;

import com.cissst.software.model.Role;

public interface IRoleManageService {

	public void addRole(Role role);
	
	public List<Role> queryAllRole();
	
	public Role findRoleById(int id);
	
	public void updateRole(Role role);
	
	public List<Role> queryRoleByInfo(String name,String desc);
	
	public void deleteCheckedRoles(int[] id);
	
	public void delete(int[] id);
}
