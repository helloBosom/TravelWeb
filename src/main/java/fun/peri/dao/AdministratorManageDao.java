package fun.peri.dao;

import java.util.List;

import fun.peri.model.AdministratorAndRole;
import org.springframework.stereotype.Repository;

import fun.peri.model.Administrator;
import fun.peri.model.Role;

@Repository("administratorManageDao")
public class AdministratorManageDao extends BaseDao<Administrator>{
	
	public List<Role> findAllRole(){
		String hql = "from Role";
		return (List<Role>)this.getHibernateTemplate().find(hql, null);
	}
	
	public List<Administrator> queryAdministrator(){
		String hql = "from Administrator a left join AdministratorAndRole r";
		return super.find(hql);
	}
	
	public void addAdministrator(Administrator administrator){
		super.save(administrator);
	}
	
	public void saveRoleById(AdministratorAndRole administratorAndRole){
		//String hql = "select a from AdministratorAndRole a inner join a.role r where r.roleid=?";
		//List<AdministratorAndRole> role = (List<AdministratorAndRole>)super.hibernateTemplate.find(hql, new Object[]{id});
		//return role.get(0);
		this.getHibernateTemplate().save(administratorAndRole);
	}
	
	public List<Administrator> findAllAdministrator(){
		String hql = "from Administrator";
		return super.find(hql);
	}
	
	public List findRoleNameByAdminId(int id){
		String hql = "select r.rolename from AdministratorAndRole ad inner join"
				+ " ad.role r inner join ad.user u where u.administratorid=?";
		List rolename = this.getHibernateTemplate().find(hql, new Object[]{id});
		
		return rolename;
	}
	
	public void deleteAdministratorById(int[] id){
		if(id !=null && id.length > 0){
			for(int adminId : id){
				Administrator admin = this.getHibernateTemplate().get(Administrator.class, adminId);
			super.remove(admin);
			}
		}
	}
	
	
	public Administrator findAdministratorById(int id){
		//String hql = "select u from AdministratorAndRole a inner join a.user u where u.administratorid=?";
		String hql = "select a from Administrator a where a.administratorid=?";
		List<Administrator> list = super.find(hql, new Object[]{id});
		return list.get(0);
		//return super.get(id);
	}
	
	public List findAdministratorAndRoleId(int adminId){
		String hql = "select a.id from AdministratorAndRole a inner join a.user u where u.administratorid=?";
		List<Integer> adminAndRoleId = (List<Integer>)this.getHibernateTemplate().find(hql, new Object[]{adminId});
		return adminAndRoleId;
	}
	
	public void deleteAdminAndRole(AdministratorAndRole adminAndRole){
		this.getHibernateTemplate().delete(adminAndRole);
	}
	
	public void updateAdministrator(Administrator admin){
		super.update(admin);
	}
	
}
