package fun.peri.service;

import java.util.List;

import fun.peri.model.Administrator;
import fun.peri.model.Menu;

public interface ILoginService {

	public List<Administrator> findByName(String username);
	
	public List<Integer> findCheckedMenu(String loginName);
	
	
	public List<Menu> findAll();
	
  /*public Menu findMenuById(int menuId);
	
	public Integer findPidById(int menuId);*/
	
	
}
