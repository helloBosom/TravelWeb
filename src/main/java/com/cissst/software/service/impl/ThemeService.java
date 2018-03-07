package com.cissst.software.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cissst.software.dao.ThemeDao;
import com.cissst.software.model.Theme;
import com.cissst.software.service.IThemeService;

@Service
public class ThemeService implements IThemeService {
	@Autowired
	private  ThemeDao Themedao;
		
	
	@Override
	public List<Theme> queryAllTheme() {
		
		return Themedao.loadAll();
	}


	@Override
	public void addTheme(Theme theme) {
		Themedao.save(theme);
	}


	@Override
	public List<Theme> queryByName(String name) {
		
		return Themedao.queryByName(name);
	}


	@Override
	public Theme queryById(int themeId) {
		
		return Themedao.get(themeId);
	}


	@Override
	public void updateTheme(Theme theme) {
		
		Themedao.update(theme);
	}


	@Override
	public void deleteTheme(Theme theme) {
		Themedao.remove(theme);
	}


	@Override
	public List<Object> count() {
		
		return Themedao.count();
	}


	@Override
	public List<Theme> find(Object[] param, Integer page, Integer rows) {
		
		return Themedao.find( param, page, rows);
	}
	

	
	public List<Object> countparam(Object[] param) {
		String hql = "select count(*) from Theme where themeName like ?";
		return Themedao.countparam(param);
	}
}
