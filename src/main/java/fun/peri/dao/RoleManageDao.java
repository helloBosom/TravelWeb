package fun.peri.dao;

import java.util.List;

import fun.peri.model.Role;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository("roleManageDao")
public class RoleManageDao extends BaseDao<Role> {

	
	public List<Role> find() {
		String hql = "from Role";
        return super.find(hql);
    }
	
	public Role find(Object[] params) {
		String hql = "from Role where roleid=?";
		List<Role> role = super.find(hql, params);
         return role.get(0);
    }
	
	public List<Role> findSomeRole(String name,String desc){
		String hql = "from Role where rolename=? or roledesc =?";
		return (List<Role>)this.getHibernateTemplate().find(hql, new Object[]{name,desc});
		 
	}
	
	public void deleteBatchById(final int[] id){
		this.getHibernateTemplate().execute(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				if(id != null && id.length > 0){
					for(int i =0;i<id.length;i++){
						String hql = "delete from Role r where r.roleid="+id[i];
					int count = session.createQuery(hql).executeUpdate();
					}
				}
				return true;
			}
		});
	}
	
	public void remove(int[] id){
		
		if(id != null && id.length>0){
			for(int i=0;i<id.length;i++){
				//Role role =super.load(id);
				Role role = this.getHibernateTemplate().get(Role.class, id[i]);
				
				/*Set<RoleAndMenu> menus = role.getRoleMenu();
				for(RoleAndMenu roleAndMenu : menus){
					//roleAndMenu.setMenu(null);
					super.hibernateTemplate.delete(roleAndMenu);
				}
				
				Set<AdministratorAndRole> roles = role.getUserRoles();
				for(AdministratorAndRole roleAndAdmin : roles){
					//roleAndAdmin.setUser(null);
					super.hibernateTemplate.delete(roleAndAdmin);
				}*/
				//Role role = new Role(id[i]);
				super.remove(role);
			}
		}
	}
	
	
	
}
