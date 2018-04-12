package fun.peri.controller;

import fun.peri.model.Administrator;
import fun.peri.model.AdministratorAndRole;
import fun.peri.model.Role;
import fun.peri.service.IAdministratorManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Controller
@RequestMapping(value = "/administrator")
public class AdministratorManageController {

    @Autowired
    private IAdministratorManageService administratorManageServiceImpl;

    /**
     * 查询所有的角色
     */
    @RequestMapping(value = "/role")
    public String findRole(HttpServletRequest request) {
        List<Role> roles = administratorManageServiceImpl.findRole();
        request.setAttribute("roles", roles);
        return "admin/jsp/system_manage/user_manage_add";
    }

    /**
     * 添加用户
     */
    @RequestMapping(value = "/add")
    public ModelAndView addAdministrator(HttpServletRequest request, @RequestParam("name") String name, @RequestParam("loginname") String loginName, @RequestParam("password") String passWord, @RequestParam("phonenumber") String phoneNumber, @RequestParam("sex") String sex) {
        String[] roleid = request.getParameterValues("role");
        Role role = null;
        AdministratorAndRole adminAndRole = null;
        Administrator administrator = null;
        administrator = new Administrator(name, loginName, passWord, phoneNumber, sex);
        administratorManageServiceImpl.addAdministrator(administrator);
        int adminId = administrator.getAdministratorid();
        if (roleid != null && roleid.length > 0) {
            for (String id : roleid) {
                role = new Role(Integer.parseInt(id));
                administrator = new Administrator(adminId);
                adminAndRole = new AdministratorAndRole(administrator, role);
                administratorManageServiceImpl.saveRoleById(adminAndRole);
            }
        }
        return queryAllAdministrator();
    }

    /**
     * 查询所有的用户信息
     *
     * @return
     */
    @RequestMapping(value = "/query")
    public ModelAndView queryAllAdministrator() {
        List<Administrator> administrators = administratorManageServiceImpl.findAllAdministrator();
        Map<Administrator, List> map = new TreeMap<Administrator, List>();
        for (Administrator admin : administrators) {
            int id = admin.getAdministratorid();
            List str = administratorManageServiceImpl.findRoleNameByAdminId(id);
            map.put(admin, str);
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("administrators", map);
        mv.setViewName("admin/jsp/system_manage/user_manage");
        return mv;
    }

    /**
     * 删除勾选的用户信息
     *
     * @param adminId
     * @return
     */
    @RequestMapping(value = "/delete")
    public ModelAndView deleteAdministrator(@RequestParam("id") int[] adminId) {
        administratorManageServiceImpl.deleteAdministratorById(adminId);
        return queryAllAdministrator();
    }

    /**
     * 根据编号获取要修改的用户信息
     */
    @RequestMapping(value = "/update")
    public String updateRole(HttpServletRequest request, @RequestParam("id") int id) {
        Administrator admin = administratorManageServiceImpl.findAdministratorById(id);
        request.setAttribute("admin", admin);
        findRole(request);
        return "admin/jsp/system_manage/user_manage_update";
    }

    /**
     * 根据编号修改用户信息
     */
    @RequestMapping(value = "/updatebyid")
    public ModelAndView updateAdministratorById(HttpServletRequest request, @RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("loginname") String loginName, @RequestParam("password") String password, @RequestParam("sex") String sex, @RequestParam("phonenumber") String phoneNumber) {
        List<Integer> adminAndRoleIds = administratorManageServiceImpl.findAdministratorAndRoleId(id);
        AdministratorAndRole adminAndRole = null;
        Administrator admin = null;
        Role role = null;
        if (adminAndRoleIds != null && adminAndRoleIds.size() > 0) {
            for (int adminAndRoleId : adminAndRoleIds) {
                adminAndRole = new AdministratorAndRole(adminAndRoleId);
                administratorManageServiceImpl.deleteAdminAndRole(adminAndRole);
            }
        }
        String[] roleid = request.getParameterValues("role");
        if (roleid != null && roleid.length > 0) {
            admin = new Administrator(id);
            for (String rid : roleid) {
                role = new Role(Integer.parseInt(rid));
                adminAndRole = new AdministratorAndRole(admin, role);
                administratorManageServiceImpl.saveRoleById(adminAndRole);
            }
        }
        admin = new Administrator(id, name, loginName, password, phoneNumber, sex);
        administratorManageServiceImpl.updateAdministrator(admin);
        return queryAllAdministrator();
    }
}