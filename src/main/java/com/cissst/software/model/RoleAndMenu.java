package com.cissst.software.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_role_menu")
public class RoleAndMenu {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer rolemenuid;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="roleid")
	private Role role;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="menuid")
	private Menu menu;
	@Column
	private String remarks;
	
	
	public Integer getRolemenuid() {
		return rolemenuid;
	}
	public void setRolemenuid(Integer rolemenuid) {
		this.rolemenuid = rolemenuid;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	public RoleAndMenu() {
		
	}
	
	public RoleAndMenu(Integer rolemenuid, Role role, Menu menu, String remarks) {
		this.rolemenuid = rolemenuid;
		this.role = role;
		//this.menu = menu;
		this.remarks = remarks;
	}
	
	public RoleAndMenu(Integer rolemenuid) {
		this.rolemenuid = rolemenuid;
	}
	
	public RoleAndMenu(Role role, Menu menu) {
		this.role = role;
		this.menu = menu;
	}
	
	
	
}
