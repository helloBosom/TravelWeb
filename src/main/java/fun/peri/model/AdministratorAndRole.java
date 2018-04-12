package fun.peri.model;

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
@Table(name = "tbl_administrator_role")
public class AdministratorAndRole {

	private Integer id;
	private Administrator user;
	private Role role;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "adminroleid", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "administratorid")
	public Administrator getUser() {
		return user;
	}

	public void setUser(Administrator user) {
		this.user = user;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "roleid")
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public AdministratorAndRole() {

	}

	public AdministratorAndRole(Integer id, Administrator user, Role role) {
		this.id = id;
		this.user = user;
		this.role = role;
	}

	public AdministratorAndRole(Administrator user, Role role) {
		this.user = user;
		this.role = role;
	}

	public AdministratorAndRole(Role role) {
		this.role = role;
	}

	public AdministratorAndRole(Integer id) {
		this.id = id;
	}

}
