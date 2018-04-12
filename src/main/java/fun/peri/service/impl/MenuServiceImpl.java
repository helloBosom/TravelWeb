package fun.peri.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fun.peri.dao.MenuDao;
import fun.peri.model.Menu;
import fun.peri.model.Role;
import fun.peri.model.RoleAndMenu;
import fun.peri.service.IMenuService;




@Service(value="menuServiceImpl")
public class MenuServiceImpl implements IMenuService {

	@Autowired
	protected MenuDao menuDao;
	
	@Override
	public List<Menu> findAll() {
		// TODO Auto-generated method stub
		return menuDao.findAll();
	}

	@Override
	public List<Role> findAllRole() {
		
		return menuDao.findAllRole();
	}

	@Override
	public List<Integer> findRoleAndMenuByRoleid(int roleid) {
		
		return menuDao.findRoleAndMenuByRoleid(roleid);
	}

	@Override
	public void deleteRoleAndMenu(RoleAndMenu roleAndMenu) {
		menuDao.deleteRoleAndMenu(roleAndMenu);
	}

	@Override
	public void saveRoleAndMenu(RoleAndMenu roleAndMenu) {
		menuDao.saveRoleAndMenu(roleAndMenu);
		
	}

	@Override
	public void updateMenu() {
		menuDao.updateMenu();
		
	}

	@Override
	public void updateCheckedMenu(Menu menu) {
		menuDao.updateCheckedMenu(menu);
		
	}

	@Override
	public Menu findMenuEntityById(int menuId) {
		
		return menuDao.findMenuEntityById(menuId);
	}

	@Override
	public List<Integer> findMenuIdByRoleid(int roleId) {
	
		return menuDao.findMenuIdByRoleid(roleId);
	}

}
