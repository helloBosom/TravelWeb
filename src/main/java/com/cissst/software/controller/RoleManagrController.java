package com.cissst.software.controller;


import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cissst.software.model.Role;
import com.cissst.software.service.IRoleManageService;



@Controller
@RequestMapping(value="/role")
public class RoleManagrController {

	@Autowired
	private IRoleManageService roleManageServiceImpl;
	
	/**
	 * 添加角色
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value="/add")
	public ModelAndView addRole(@RequestParam("rolename") String rolename,
							@RequestParam("roledesc") String roleDesc) throws UnsupportedEncodingException{
		rolename = new String(rolename.getBytes("iso8859-1"),"utf-8");
		roleDesc = new String(roleDesc.getBytes("iso8859-1"),"utf-8");
		Role role = new Role(rolename,roleDesc,null);
		roleManageServiceImpl.addRole(role);
		return queryAllRole();
	}
	
	/**
	 * 查询所有的角色信息
	 * @return
	 */
	@RequestMapping(value="/query")
	public ModelAndView queryAllRole(){
		
		List<Role> result = roleManageServiceImpl.queryAllRole();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("result",result);
		modelAndView.setViewName("admin/jsp/system_manage/zhiwei_manage");
		return modelAndView;
	} 
	
	/**
	 * 根据编号获取要修改的角色信息
	 */
	@RequestMapping(value="/update")
	public String updateRole(HttpServletRequest request,@RequestParam("id") int id){
		Role role = roleManageServiceImpl.findRoleById(id);
		request.setAttribute("role", role);
		return "admin/jsp/system_manage/zhiwei_update";
	}
	
	/**
	 * 修改角色信息
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value="/updatebyid")
	public ModelAndView updateById(@RequestParam("roleid") int roleid,
					@RequestParam("rolename") String roleName,
					@RequestParam("roledesc") String roleDesc) throws UnsupportedEncodingException{
		roleName = new String(roleName.getBytes("iso8859-1"),"utf-8");
		roleDesc = new String(roleDesc.getBytes("iso8859-1"),"utf-8");
		Role role = new Role(roleid,roleName,roleDesc);
		roleManageServiceImpl.updateRole(role);
		return queryAllRole();
	}
	
	/**
	 * 根据角色的某个属性，查询对应的角色
	 */
	@RequestMapping(value="/querybyinfo")
	public ModelAndView queryByInfo(@RequestParam("rolename") String roleName,@RequestParam("roledesc") String roleDesc){
		String name = roleName;
		String desc = roleDesc;
		List<Role> roles = roleManageServiceImpl.queryRoleByInfo(name, desc);
		ModelAndView mv = new ModelAndView();
		mv.addObject("result", roles);
		mv.setViewName("admin/jsp/system_manage/zhiwei_manage");
		return mv;
	}
	
	/**
	 * 删除选中的角色
	 */
	@RequestMapping(value="/delete")
	public ModelAndView deleteCheckedRoles(@RequestParam("id") int[] id){
		//roleManageServiceImpl.deleteCheckedRoles(id);
		roleManageServiceImpl.delete(id);
		return queryAllRole();
	}
}
