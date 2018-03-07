package com.cissst.software.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cissst.software.model.Menu;
import com.cissst.software.model.MenuTreeVO;
import com.cissst.software.model.Role;
import com.cissst.software.model.RoleAndMenu;
import com.cissst.software.service.IMenuService;
import com.google.gson.Gson;

/**
 * <br>
 * <b>类描述:</b>
 * 
 * <pre>
 *   景区登录控制器，处理登录验证、注销等操作
 * </pre>
 * 
 * @see
 * @since
 */
@Controller
@RequestMapping("/menu")
public class MenuManageController {
	/**
	 * 自动注入
	 */
	@Autowired
	private IMenuService menuService;
	/**
	 * 用户登录
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/doLogin")
	public void login(HttpServletRequest request, HttpServletResponse response, @RequestParam("roleid") int roleId)
			throws IOException {

		List<Integer> menuIds = menuService.findMenuIdByRoleid(roleId);
		Menu menu = null;
		menuService.updateMenu();
		if (menuIds != null && menuIds.size() > 0) {
			for (int menuId : menuIds) {
				menu = menuService.findMenuEntityById(menuId);
				menu.setChecked("ture");
				menuService.updateCheckedMenu(menu);
			}
		}

		List<Menu> menus = menuService.findAll();
		List vos = new ArrayList();
		MenuTreeVO menuTreeVo = new MenuTreeVO();
		for (Menu topMenu : menus) {
			vos.add(menuTreeVo.getMenu(topMenu));
		}

		String treeBeanStr = new Gson().toJson(vos);
		// System.out.println("treeBeanstr:" + treeBeanStr);
		PrintWriter out = response.getWriter();
		out.print(treeBeanStr);
		out.flush();
		out.close();
	}

	/**
	 * 将角色对象传递到角色列表用来为角色分配权限
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/queryrole")
	public String queryRole(HttpServletRequest request) {
		List<Role> roles = menuService.findAllRole();
		request.setAttribute("roles", roles);
		return "admin/jsp/system_manage/order_list";
	}

	/**
	 * 保存分配的权限
	 */
	@RequestMapping("/savemenu")
	public String saveMenu(HttpServletRequest request, @RequestParam("roleid") int roleId) {
		List<Integer> roleMenuIds = menuService.findRoleAndMenuByRoleid(roleId);
		RoleAndMenu roleAndMenu = null;
		Menu menu = null;
		Role role = null;
		menuService.updateMenu();
		if (roleMenuIds != null && roleMenuIds.size() > 0) {
			for (int roleAndMenuId : roleMenuIds) {
				roleAndMenu = new RoleAndMenu(roleAndMenuId);
				menuService.deleteRoleAndMenu(roleAndMenu);
			}
		}
		String[] menuIds = request.getParameterValues("id");
		if (menuIds != null && menuIds.length > 0) {
			role = new Role(roleId);
			for (String menuid : menuIds) {
				menu = new Menu(Integer.parseInt(menuid));
				roleAndMenu = new RoleAndMenu(role, menu);
				menuService.saveRoleAndMenu(roleAndMenu);
				menu = menuService.findMenuEntityById(Integer.parseInt(menuid));
				menu.setChecked("ture");
				menuService.updateCheckedMenu(menu);
			}
		}
		return queryRole(request);
	}

	/**
	 * 返回权限分配页面
	 */
	@RequestMapping("/return")
	public String returnOrderList(HttpServletRequest request) {
		return queryRole(request);
	}

}
