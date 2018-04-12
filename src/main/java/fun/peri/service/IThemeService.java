
package fun.peri.service;

import java.util.List;

import fun.peri.model.Theme;
import org.springframework.stereotype.Service;

@Service
public interface IThemeService {
	/*
	 * 
	 * 查询所有主题信息
	 */
	
	public List<Theme> queryAllTheme();
	
	//添加主题
	public void addTheme(Theme theme);
	
	//根据名称查询
	
	public List<Theme> queryByName(String name);
	
	//根据Id查询
	
	public Theme queryById(int themeId);
	
	//修改
	public void updateTheme(Theme theme);
	
	//删除
	
	public void deleteTheme(Theme theme);
	
	//页数
	public List<Object> count();
	
	//分页查询
	public List<Theme> find(Object[] param, Integer page, Integer rows);
	
	//按名称查询总页数
	
	public List<Object> countparam(Object[] param);
			
}
