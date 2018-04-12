package fun.peri.dao;

import java.util.List;

import javax.persistence.criteria.From;

import fun.peri.model.Theme;
import org.springframework.stereotype.Repository;

@Repository
public class ThemeDao extends BaseDao<Theme>{

	//根据主题名称查询
	public List<Theme> queryByName(String name){
		String hql="from Theme where themeName like ?";
		name="%"+name+"%";
		return find(hql,name);
	}
	
	//查询全部分页总页数
	public List<Object> count(){
		String hql="select count(*) from Theme";
		return find(hql);
	}
	
	//按名称查询总页数
	
	public List<Object> countparam(Object[] param){
		String hql="select count(*) from Theme where themeName like ?";
		return find(hql, param);
	}
	//分页查询
	
	public List<Theme> find(Object[] param, Integer page, Integer rows){
		String hql="from Theme where themeName like ?";
		return find(hql, param, page, rows);
	}
}
