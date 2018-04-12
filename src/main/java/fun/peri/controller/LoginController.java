package fun.peri.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fun.peri.model.Administrator;
import fun.peri.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fun.peri.model.Menu;
import fun.peri.model.MenuTreeVO;
import com.google.gson.Gson;

@Controller
public class LoginController {

	@Autowired
	private ILoginService loginServiceImpl;

	@RequestMapping(value = "dologin")
	public String login(HttpServletRequest request, @RequestParam("username") String username,
			@RequestParam("password") String password) {
		String error = "";
		List<Administrator> list = loginServiceImpl.findByName(username);
		if (list.size() == 0) {
			error = "用户不存在";
			request.setAttribute("error", error);
			return "login";
		} else if (!(username.equals(list.get(0).getLoginname()) && password.equals(list.get(0).getPassword()))) {
			error = "密码错误";
			request.setAttribute("error", error);
			return "login";
		}
		request.getSession().setAttribute("username", username);
		request.getSession().setAttribute("password", password);
		return "redirect:admin/frame/Frame.jsp";
	}

	@RequestMapping("/menu")
	public void findMenu(HttpSession session, HttpServletResponse response) throws IOException {
		String loginName = (String) session.getAttribute("username");
		List<Integer> menuIds = loginServiceImpl.findCheckedMenu(loginName);
		Set<Integer> checkedIds = new HashSet<Integer>();

		if (menuIds != null && menuIds.size() > 0) {
			for (Integer id : menuIds) {
				checkedIds.add(id);
			}
		}
		/*
		 * for(int id : checkedIds){ System.out.println("checkedId:--->"+id); }
		 */
		List<Menu> allMenu = loginServiceImpl.findAll();
		List vos = new ArrayList();
		MenuTreeVO menuTreeVo = new MenuTreeVO();
		for (Menu topMenu : allMenu) {
			if ((menuTreeVo.getCheckedMenu(topMenu, checkedIds)) != null) {
				vos.add(menuTreeVo.getCheckedMenu(topMenu, checkedIds));
			}
		}
		String treeBeanStr = new Gson().toJson(vos);
		// System.out.println("treeBeanstr:" + treeBeanStr);
		PrintWriter out = response.getWriter();
		out.print(treeBeanStr);
		out.flush();
		out.close();
	}

}
