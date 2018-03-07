package com.cissst.software.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import javax.persistence.GenerationType;
@Entity
@Table(name="tbl_theme")
public class Theme {

	@Id
	@GenericGenerator(strategy="assigned",name="user_assigned")
	@GeneratedValue(generator="user_assigned")
	@Column(name="theme_id")
	protected int themeId;
	
	@OneToMany(mappedBy="theme",cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	protected Set<ViewSpace> viewSpaces;
	
	@Column
	protected String themeName;
	
	@Column
	protected String themeDescribe;
	
	@Column 
	protected String themePicture;
	
	@Column
	protected char status;
	
	@Column
	protected String remarks;

	public int getThemeId() {
		return themeId;
	}

	public void setThemeId(int themeId) {
		this.themeId = themeId;
	}

	public String getThemeName() {
		return themeName;
	}

	public void setThemeName(String themeName) {
		this.themeName = themeName;
	}

	public String getThemeDescribe() {
		return themeDescribe;
	}

	public void setThemeDescribe(String themeDescribe) {
		this.themeDescribe = themeDescribe;
	}

	public String getThemePicture() {
		return themePicture;
	}

	public void setThemePicture(String themePicture) {
		this.themePicture = themePicture;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Theme() {
		
	}
	
	
	
}
