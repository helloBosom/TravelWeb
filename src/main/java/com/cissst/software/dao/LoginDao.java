package com.cissst.software.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cissst.software.model.Administrator;
import com.cissst.software.model.Menu;

@Repository("loginDao")
public class LoginDao extends BaseDao<Administrator> {

	public List<Administrator> findByName(String username) {
		
		String hql="from Administrator where loginname='"+username +"'";
		return find(hql);
	}
	
	public List<Integer> findCheckedMenu(String loginName){
		String hql = " select m.id from AdministratorAndRole ar "
				+ "inner join ar.user u inner join ar.role r "
				+ "inner join r.roleMenu rm inner join rm.menu m where u.loginname=?";
		List<Integer> list = (List<Integer>)this.getHibernateTemplate().find(hql, new Object[]{loginName});
		return list;
	}
	
	public List<Menu> findAll(){
		String hql = " from Menu m where m.menu.id is null";
		List<Menu> menus =
				(List<Menu>)this.getHibernateTemplate().find(hql, null);
		return menus;		
	}
	
	
	/*public Menu findMenuById(int menuId){
	String hql = "from Menu m where m.id=?";
	List<Menu> menus = (List<Menu>)this.getHibernateTemplate().find(hql, new Object[]{menuId});
	return menus.get(0);
}

public Integer findPidById(int menuId){
	final String sql = "select pid from tbl_menu where menuid="+menuId;
	Integer pid = this.getHibernateTemplate().execute(new HibernateCallback<Integer>() {

		@Override
		public Integer doInHibernate(Session session) throws HibernateException {
			List<Integer> pids =  session.createSQLQuery(sql).list();
			if(pids !=null && pids.size() > 0){
				return pids.get(0);
			}else{
				return null;
			}
			
		}
	});
	return pid;
}
*/
	
}
