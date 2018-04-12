package fun.peri.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbl_role")
public class Role {

	private Integer roleid;
	private String rolename;
	private String roledesc;
	private String status;
	private Set<AdministratorAndRole> userRoles;
	private Set<RoleAndMenu> roleMenu;
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="roleid",unique = true, nullable = false)
	public Integer getRoleid() {
		return roleid;
	}
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
	
	@Column(name="rolename")
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	
	@Column
	public String getRoledesc() {
		return roledesc;
	}
	public void setRoledesc(String roledesc) {
		this.roledesc = roledesc;
	}
	
	@Column
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.REMOVE,mappedBy="role")
	public Set<AdministratorAndRole> getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(Set<AdministratorAndRole> userRoles) {
		this.userRoles = userRoles;
	}
	
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.REMOVE,mappedBy="role")
	public Set<RoleAndMenu> getRoleMenu() {
		return roleMenu;
	}
	public void setRoleMenu(Set<RoleAndMenu> roleMenu) {
		this.roleMenu = roleMenu;
	}
	
	public Role() {

	}
	
	public Role(Integer roleid, String rolename, String roledesc, String status, Set<AdministratorAndRole> userRoles) {
		this.roleid = roleid;
		this.rolename = rolename;
		this.roledesc = roledesc;
		this.status = status;
		this.userRoles = userRoles;
	}
	
	public Role(String rolename, String roledesc, String status) {
		this.rolename = rolename;
		this.roledesc = roledesc;
		this.status = status;
	}
	
	public Role(Integer roleid, String rolename, String roledesc) {
		this.roleid = roleid;
		this.rolename = rolename;
		this.roledesc = roledesc;
	}
	public Role(Integer roleid) {
		this.roleid = roleid;
	}
	
	
	
}
