package com.cissst.software.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cissst.software.dao.AdministratorManageDao;
import com.cissst.software.model.Administrator;
import com.cissst.software.model.AdministratorAndRole;
import com.cissst.software.model.Role;
import com.cissst.software.service.IAdministratorManageService;

@Service("administratorManageServiceImpl")
public class AdministratorManageServiceImpl implements IAdministratorManageService {

	@Autowired
	protected AdministratorManageDao administratorManageDao;


	@Override
	public List<Role> findRole() {
		
		return administratorManageDao.findAllRole();
	}

	@Override
	public void addAdministrator(Administrator administrator) {
		
		 administratorManageDao.addAdministrator(administrator);
	}

	@Override
	public void saveRoleById(AdministratorAndRole administratorAndRole) {
		
		administratorManageDao.saveRoleById(administratorAndRole);
	}

	@Override
	public List<Administrator> findAllAdministrator() {
		
		return administratorManageDao.findAllAdministrator();
	}

	@Override
	public List findRoleNameByAdminId(int id) {
		
		return administratorManageDao.findRoleNameByAdminId(id);
	}

	@Override
	public void deleteAdministratorById(int[] id) {
		
		administratorManageDao.deleteAdministratorById(id);
	}

	@Override
	public Administrator findAdministratorById(int id) {
		
		return administratorManageDao.findAdministratorById(id);
	}

	@Override
	public List<Integer> findAdministratorAndRoleId(int adminId) {
		
		return administratorManageDao.findAdministratorAndRoleId(adminId);
	}

	@Override
	public void deleteAdminAndRole(AdministratorAndRole adminAndRole) {
		
		administratorManageDao.deleteAdminAndRole(adminAndRole);
	}

	@Override
	public void updateAdministrator(Administrator admin) {
		
		administratorManageDao.update(admin);
	}

}
