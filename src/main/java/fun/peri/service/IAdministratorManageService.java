package fun.peri.service;

import java.util.List;

import fun.peri.model.AdministratorAndRole;
import org.springframework.stereotype.Service;

import fun.peri.model.Administrator;
import fun.peri.model.Role;

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
