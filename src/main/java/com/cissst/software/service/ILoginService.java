package com.cissst.software.service;

import java.util.List;
import java.util.Set;

import com.cissst.software.model.Administrator;
import com.cissst.software.model.Menu;

public interface ILoginService {

	public List<Administrator> findByName(String username);
	
	public List<Integer> findCheckedMenu(String loginName);
	
	
	public List<Menu> findAll();
	
  /*public Menu findMenuById(int menuId);
	
	public Integer findPidById(int menuId);*/
	
	
}
