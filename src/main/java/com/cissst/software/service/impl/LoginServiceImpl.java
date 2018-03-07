package com.cissst.software.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cissst.software.dao.LoginDao;
import com.cissst.software.model.Administrator;
import com.cissst.software.model.Menu;
import com.cissst.software.service.ILoginService;

@Service("loginServiceImpl")
public class LoginServiceImpl implements ILoginService {
	
	@Autowired
	private LoginDao loginDao;

	@Override
	public List<Administrator> findByName(String username) {
	
		return loginDao.findByName(username);
	}
	
	@Override
	public List<Integer> findCheckedMenu(String loginName) {
		
		return loginDao.findCheckedMenu(loginName);
	}

	@Override
	public List<Menu> findAll() {
		
		return loginDao.findAll();
	}
	
	/*@Override
	public Menu findMenuById(int menuId) {
		
		return loginDao.findMenuById(menuId);
	}

	@Override
	public Integer findPidById(int menuId) {
		// TODO Auto-generated method stub
		return loginDao.findPidById(menuId);
	}
*/
	
}
