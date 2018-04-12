package fun.peri.service;

import java.util.List;

import fun.peri.model.Menu;
import fun.peri.model.Role;
import fun.peri.model.RoleAndMenu;




public interface IMenuService {
	
	public List<Menu> findAll();
	
	public List<Role> findAllRole();
	
	public List<Integer> findRoleAndMenuByRoleid(int roleid);
	
	public void deleteRoleAndMenu(RoleAndMenu roleAndMenu);
	
	public void saveRoleAndMenu(RoleAndMenu roleAndMenu);
	
	public void updateMenu();
	
	public void updateCheckedMenu(Menu menu);
	
	public Menu findMenuEntityById(int menuId);
	
	public List<Integer> findMenuIdByRoleid(int roleId);
}
