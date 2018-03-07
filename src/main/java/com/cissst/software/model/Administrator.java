package com.cissst.software.model;

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
@Table(name = "tbl_administrator")
public class Administrator implements Comparable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer administratorid;
	@Column
	private String administratorname;
	@Column
	private String loginname;
	@Column
	private String password;
	@Column(name = "phonenumber")
	private String phoneNumber;
	@Column
	private String sex;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, mappedBy = "user")
	private Set<AdministratorAndRole> userRoles;

	public Integer getAdministratorid() {
		return administratorid;
	}

	public void setAdministratorid(Integer administratorid) {
		this.administratorid = administratorid;
	}

	public String getAdministratorname() {
		return administratorname;
	}

	public void setAdministratorname(String administratorname) {
		this.administratorname = administratorname;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Set<AdministratorAndRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<AdministratorAndRole> userRoles) {
		this.userRoles = userRoles;
	}

	public Administrator() {

	}

	public Administrator(Integer administratorid, String administratorname, String loginname, String password,
			String phoneNumber, String sex) {
		this.administratorid = administratorid;
		this.administratorname = administratorname;
		this.loginname = loginname;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.sex = sex;
	}

	public Administrator(Integer administratorid, String administratorname, String loginname, String password,
			String phoneNumber, String sex, Set<AdministratorAndRole> userRoles) {
		this.administratorid = administratorid;
		this.administratorname = administratorname;
		this.loginname = loginname;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.sex = sex;
		this.userRoles = userRoles;
	}

	public Administrator(String administratorname, String loginname, String password, String phoneNumber, String sex,
			Set<AdministratorAndRole> userRoles) {
		this.administratorname = administratorname;
		this.loginname = loginname;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.sex = sex;
		this.userRoles = userRoles;
	}

	public Administrator(String administratorname, String loginname, String password, String phoneNumber, String sex) {
		this.administratorname = administratorname;
		this.loginname = loginname;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.sex = sex;
	}

	public Administrator(Integer administratorid) {
		this.administratorid = administratorid;
	}

	@Override
	public int compareTo(Object o) {
		if (!(o instanceof Administrator))
			return 0;
		else {
			Administrator administratoer = (Administrator) o;
			return this.administratorid.compareTo(administratoer.administratorid);
		}
	}

}
