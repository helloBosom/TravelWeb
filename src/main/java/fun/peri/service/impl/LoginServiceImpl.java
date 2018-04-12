package fun.peri.service.impl;

import java.util.List;

import fun.peri.model.Administrator;
import fun.peri.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fun.peri.dao.LoginDao;
import fun.peri.model.Menu;

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
