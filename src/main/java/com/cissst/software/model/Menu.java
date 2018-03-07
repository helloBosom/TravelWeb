package com.cissst.software.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbl_menu")
public class Menu  implements java.io.Serializable {

	private Integer id;
	private Menu menu;
	private String text;
	private String href;
	private Integer orderNumber;
	private Integer sn;
	private List<Menu> children;
	private String checked;
	private String state;

	
	//private Set<RoleAndMenu> roleMenu;


	


	


	public Menu(Integer id, String text,String state, List<Menu> children,String checked) {
 		this.id = id;
 		this.text = text;
 		this.children = children;
 		this.checked = checked;
 		this.state = state;
 		
 	}

     
    /** default constructor */
    public Menu() {
    }    
    
    
    public Menu(Integer id) {
		this.id = id;
	}

    
    

	public Menu(Integer id, String text, String state, List<Menu> children,String checked,String href) {
		this.id = id;
		this.text = text;
		this.children = children;
		this.state = state;
		this.href = href;
		this.checked = checked;

	}


	/** full constructor */

    // Property accessors
    @Id 
    @GeneratedValue(strategy=IDENTITY)    
    @Column(name="menuid", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer menuid) {
        this.id = menuid;
    }

    
	public Menu(String checked) {
		this.checked = checked;
	}

	public Menu(Integer id, String checked) {
		this.id = id;
		this.checked = checked;
	}


	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="pid")
    public Menu getMenu() {
        return this.menu;
    }
    
    public void setMenu(Menu menu) {
        this.menu = menu;
    }
    
    @Column(name="name", length=20)
    public String getText() {
        return this.text;
    }
    
    public void setText(String text) {
        this.text = text;
    }
    
    @Column(name="href", length=20)
    public String getHref() {
        return this.href;
    }
    
    public void setHref(String href) {
        this.href = href;
    }
    
    @Column(name="orderNumber")
    public Integer getOrderNumber() {
        return this.orderNumber;
    }
    
    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }
    
    /*@Column(name="sn")
    public Integer getSn() {
        return this.sn;
    }
    
    public void setSn(Integer sn) {
        this.sn = sn;
    }*/
    
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="menu")
    public List<Menu> getChildren() {
        return this.children;
    }
    
    public void setChildren(List<Menu> children) {
        this.children = children;
    }
    
    @Column(name="state")
    public String getState() {
  		return state;
  	}
  	public void setState(String state) {
  		this.state = state;
  	}
  	@Column(name="checked")
  	public String getChecked() {
  		return checked;
  	}
  	public void setChecked(String checked) {
  		this.checked = checked;
  	}
    
  	
  	
  /*	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL,mappedBy="menu")
  	public Set<RoleAndMenu> getRoleMenu() {
		return roleMenu;
	}

	public void setRoleMenu(Set<RoleAndMenu> roleMenu) {
		this.roleMenu = roleMenu;
	}*/
  	
  	
}
