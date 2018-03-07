package com.cissst.software.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import com.google.gson.Gson;



public class MenuTreeVO {

	Menu menu = null;

	public Menu getMenu(Menu m) {
	
		List<Menu> submenus = m.getChildren();
		
		if (submenus != null && submenus.size() > 0) {
			List<Menu> childrens = new ArrayList<Menu>();
			for (Iterator iterator = submenus.iterator(); iterator.hasNext();) {
				Menu submenu = (Menu)iterator.next();
				getMenu(submenu);
				childrens.add(menu);
			}
			return menu = new Menu(m.getId(), m.getText(), m.getState(), childrens, m.getChecked());
		} else {
			return menu = new Menu(m.getId(), m.getText(), m.getState(), null, m.getChecked());
		}

	}
	
	
	public Menu getCheckedMenu(Menu m,Set<Integer> menuIds) {
		
		List<Menu> submenus = m.getChildren();
		
		if (submenus != null && submenus.size() > 0) {
		
			List<Menu> childrens = new ArrayList<Menu>();
			
			for (Iterator iterator = submenus.iterator(); iterator.hasNext();) {
				Menu submenu = (Menu)iterator.next();
				getCheckedMenu(submenu,menuIds);
				if(menu != null){
				childrens.add(menu);
				}
			}
			if(childrens !=null && childrens.size() > 0){
			 return menu = new Menu(m.getId(), m.getText(), m.getState(), childrens,m.getChecked(),m.getHref());
			}else{
				return menu = null;
			}
			
		} else {
			
			if(menuIds != null && menuIds.size() > 0){
				for(int menuId : menuIds){
					if(m.getId() == menuId){
					return menu = new Menu(m.getId(), m.getText(), m.getState(), null,m.getChecked(),m.getHref());
					}
				}
			}
			return menu = null;
		}
		

	} 
		/*
		public void  tree(){
			List<Menu> menus = findAllTopMenus();
			List<Menu> vos = new ArrayList<Menu>();
			MenuTreeVO menu = new MenuTreeVO();
			for(Menu topMenu:menus){
				menu.getMenu(topMenu);
			}
			
			String treeBeanStr ="[" + new Gson().toJson(vos) + "]";
			System.out.println(treeBeanStr);
			
		}*/
		
		/*@Test
		public void testMethod(){
			tree();
		}
		
		public static void main(String[] args) {
			new MenuTreeVO().tree();
		}*/
		/*
		public List<Menu> findAllTopMenus() {
			MenuDaoImpl menu = new MenuDaoImpl();	
			return menu.findAll();
		}*/
	
}
