package com.cissst.software.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.cissst.software.model.Administrator;
import com.cissst.software.model.AdministratorAndRole;
import com.cissst.software.model.Role;

@Service
public interface IAdministratorManageService {

	
	public List<Role> findRole();
	
	public void addAdministrator(Administrator administrator);
	
	public void saveRoleById(AdministratorAndRole administratorAndRole);
	
	public List<Administrator> findAllAdministrator();
	
	public List findRoleNameByAdminId(int id);
	
	public void deleteAdministratorById(int[] id);
	
	public Administrator findAdministratorById(int id);
	
	public List<Integer> findAdministratorAndRoleId(int adminId);
	
	public void deleteAdminAndRole(AdministratorAndRole adminAndRole);
	
	public void updateAdministrator(Administrator admin);
}
