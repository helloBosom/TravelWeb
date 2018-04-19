package fun.peri.controller;

import fun.peri.comm.CommonConstant;
import fun.peri.model.City;
import fun.peri.model.Theme;
import fun.peri.model.ViewPoint;
import fun.peri.model.ViewSpace;
import fun.peri.service.ICityService;
import fun.peri.service.IThemeService;
import fun.peri.service.IViewSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.UUID;

/**
 * <pre>
 *   景区管理控制器，这部分功能由景区管理操作，包括：景区、景点增删改查控制转发处理
 * </pre>
 */
@Controller
@RequestMapping(value = "/view")
public class ViewManageController {
    @Autowired
    private IViewSpaceService viewSpaceService;
    @Qualifier("IThemeService")
    @Autowired
    private IThemeService themeservie;
    @Qualifier("ICityService")
    @Autowired
    private ICityService cityService;

    // 显示所有景区的列表
    @RequestMapping(value = "/manage", method = RequestMethod.GET)
    public String listViewSpaces(HttpServletRequest request) {

        List<ViewSpace> viewSpaces = viewSpaceService.getAllViewSpaces();

        request.setAttribute("viewSpaces", viewSpaces);
        return "/admin/jsp/viewManeger/viewspacemanage";
    }


    @RequestMapping(value = "/showview/{id}", method = RequestMethod.GET)
    public String showViewSpace(@PathVariable Integer id, HttpServletRequest request) {
        ViewSpace viewSpace = viewSpaceService.getViewSpace(id);
        request.setAttribute("viewSpace", viewSpace);
        return "/admin/jsp/viewManeger/showviewspace";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String queryViewSpaces(HttpServletRequest request,
                                  @RequestParam(value = "currenpage", defaultValue = "1") int currenpage,
                                  @RequestParam("spaceName") String spaceName) {
        String hql = "from ViewSpace where spaceName like ?";
        try {
            spaceName = new String(spaceName.getBytes("iso8859-1"), "utf-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(spaceName);
        Object[] param = {"%" + spaceName + "%"};
        List<ViewSpace> viewSpaces = viewSpaceService.find(hql, param, currenpage, CommonConstant.PAGE_SIZE);
        List<Long> obj = viewSpaceService.count(spaceName);

        long pages = (long) obj.get(0);
        long totalpages = 0;
        if (pages % CommonConstant.PAGE_SIZE == 0) {
            totalpages = pages / CommonConstant.PAGE_SIZE;
        } else {
            totalpages = pages / CommonConstant.PAGE_SIZE + 1;
        }

        System.out.println(totalpages + "--- ");
        request.setAttribute("spaceName", spaceName);
        request.setAttribute("totalpages", totalpages);
        request.setAttribute("currenpage", currenpage);
        request.setAttribute("viewSpaces", viewSpaces);
        return "/admin/jsp/viewManeger/viewspacemanage";
    }


    // 打开新添景区页面
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addViewSpacePage(HttpServletRequest request) {
        List<Theme> themes = themeservie.queryAllTheme();
        List<City> citys = cityService.queryall();
        request.setAttribute("citys", citys);
        request.setAttribute("themes", themes);

        return "/admin/jsp/viewManeger/addviewspace";
    }

    //新添景区

    @RequestMapping(value = "/addviewspace", method = {RequestMethod.GET, RequestMethod.POST})
    public String addViewSpace(HttpServletRequest request,
                               @RequestParam(value = "imgFile", defaultValue = "") MultipartFile file,
                               @RequestParam("cityId") int cityId) {

        ViewSpace viewSpace = new ViewSpace();
        if (!file.isEmpty()) {
            String srcname = file.getOriginalFilename();
            String ext = srcname.substring(srcname.lastIndexOf("."));
            String filename = getNewFileName() + ext;
            String path = request.getSession().getServletContext().getRealPath("/uploads/" + filename);
            try {
                file.transferTo(new File(path));
            } catch (IllegalStateException e) {

                e.printStackTrace();
            } catch (IOException e) {

                e.printStackTrace();
            }
            viewSpace.setPicture(filename);
        }
        String themeid = request.getParameter("themeidvalue");
        String viewspacename = request.getParameter("spaceName");
        String address = request.getParameter("address");
        String price = request.getParameter("price");

        String website = request.getParameter("website");
        String description = request.getParameter("description");
        int themeId = Integer.parseInt(themeid);


        viewSpace.setSpaceName(viewspacename);
        viewSpace.setAddress(address);
        viewSpace.setDescription(description);
        viewSpace.setPrice(Double.parseDouble(price));
        Theme theme = themeservie.queryById(themeId);
        City city = cityService.getbyId(cityId);

        viewSpace.setCity(city);
        viewSpace.setTheme(theme);
        viewSpace.setWebsite(website);
        viewSpaceService.addViewSpace(viewSpace);
        String targetUrl = "/view/viewspacemanage.do";
        return "redirect:" + targetUrl;
    }


    // 打开修改景区页面
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String uopdateViewSpace(@PathVariable Integer id, HttpServletRequest request) {
        ViewSpace viewSpace = viewSpaceService.getViewSpace(id);
        List<Theme> themes = themeservie.queryAllTheme();
        List<City> citys = cityService.queryall();
        request.setAttribute("citys", citys);
        request.setAttribute("themes", themes);
        request.setAttribute("viewSpace", viewSpace);
        return "/admin/jsp/viewManeger/updateviewspace";
    }

    //修改景区
    @RequestMapping(value = "update/{id}", method = RequestMethod.POST)
    public String updateviewSpace(@PathVariable Integer id, HttpServletRequest request, @RequestParam("cityId") int cityId) {

        String viewspacename = request.getParameter("spaceName");
        String address = request.getParameter("address");
        String price = request.getParameter("price");
        String themeid = request.getParameter("themeidvalue");
        int themeId = Integer.parseInt(themeid);
        String website = request.getParameter("website");
        String description = request.getParameter("description");

        String status = request.getParameter("status");
        String remarks = request.getParameter("remarks");
        ViewSpace viewSpace = new ViewSpace();

        viewSpace.setSpaceName(viewspacename);
        viewSpace.setAddress(address);
        viewSpace.setDescription(description);
        viewSpace.setPrice(Double.parseDouble(price));
        Theme theme = themeservie.queryById(themeId);
        City city = cityService.getbyId(cityId);
        viewSpace.setCity(city);
        viewSpace.setTheme(theme);
        viewSpace.setWebsite(website);
        viewSpace.setSpaceId(id);
        viewSpace.setStatus(status);
        viewSpace.setRemarks(remarks);
        viewSpaceService.updateViewSpace(viewSpace);
        String targetUrl = "/view/viewspacemanage.do";
        return "redirect:" + targetUrl;
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String deleteviewSpace(HttpServletRequest request, @PathVariable Integer id) {
        viewSpaceService.deleteViewSpace(id);
        String targetUrl = "/view/viewspacemanage.do";
        return "redirect:" + targetUrl;
    }


    // 打开添加景区的景点的页面
    @RequestMapping(value = "/addpoint/{id}", method = RequestMethod.GET)
    public String addViewPointPage(@PathVariable Integer id, HttpServletRequest request) {
        ViewSpace vs = viewSpaceService.getViewSpace(id);
        request.setAttribute("viewSpace", vs);
        return "/admin/jsp/viewManeger/addviewpoint";
    }

    // 添加景区的景点
    @RequestMapping(value = "/savepoint", method = RequestMethod.POST)
    public String addViewPoint(HttpServletRequest request, @RequestParam("imgFile") MultipartFile file
    ) {
        String spaceId = request.getParameter("spaceId");
        ViewPoint vp = new ViewPoint();
        System.out.println(spaceId);
        if (!file.isEmpty()) {
            try {
                String srcFileName = file.getOriginalFilename();
                String fileExt = srcFileName.substring(srcFileName.lastIndexOf('.'));
                String fileName = getNewFileName() + fileExt;
                String fullFilePath = request.getSession().getServletContext().getRealPath("/uploads/" + fileName);
                file.transferTo(new File(fullFilePath));
                vp.setImgFile(fileName);
                String pointName = request.getParameter("pointName");
                String ticketPrice = request.getParameter("ticketPrice");
                String description = request.getParameter("description");

                vp.getViewSpace().setSpaceId(Integer.parseInt(spaceId));
                vp.setPointName(pointName);
                vp.setTicketPrice(Float.parseFloat(ticketPrice));
                vp.setDescription(description);
                viewSpaceService.addViewPoint(vp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        String targetUrl = "/view/edit/" + spaceId;
        return "redirect:" + targetUrl + ".do";
    }

    //更改景点的页面
    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String updateViewPointPage(@PathVariable Integer id, HttpServletRequest request) {
        ViewPoint vp = viewSpaceService.getFullViewPoint(id);
        request.setAttribute("viewPoint", vp);
        return "/admin/jsp/viewManeger/updateviewpoint";
    }

    // 更改景点
    @RequestMapping(value = "/{id}/updatepoint", method = RequestMethod.POST)
    public String updatepoint(HttpServletRequest request, @PathVariable Integer id, @RequestParam("imgFile") MultipartFile file) {
        String pointName = request.getParameter("pointName");
        String ticketPrice = request.getParameter("ticketPrice");
        String description = request.getParameter("description");
        ViewPoint vp = viewSpaceService.getFullViewPoint(id);
        String spaceId = request.getParameter("spaceId");

        vp.setPointId(id);

        if (!file.isEmpty()) {
            try {
                String srcFileName = file.getOriginalFilename();
                String fileExt = srcFileName.substring(srcFileName
                        .lastIndexOf('.'));
                String fileName = getNewFileName() + fileExt;
                String fullFilePath = request.getSession()
                        .getServletContext().getRealPath(
                                "/uploads/" + fileName);
                file.transferTo(new File(fullFilePath));
                vp.setImgFile(fileName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("dasdas" + pointName + " " + ticketPrice + " " + description);
        vp.setPointName(pointName);
        vp.setTicketPrice(Float.parseFloat(ticketPrice));
        vp.setDescription(description);

        System.out.println("vp-->" + vp);
        viewSpaceService.updateViewPoint(vp);
        String targetUrl = "/view/edit/" + spaceId;
        return "redirect:" + targetUrl + ".do";
    }

    // 删除景区的景点
    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String deleteViewPoint(@PathVariable Integer id) {
        ViewPoint vp = viewSpaceService.getFullViewPoint(id);

        int spaceId = vp.getViewSpace().getSpaceId();

        vp.setViewSpace(null);
        viewSpaceService.updateViewPoint(vp);
        viewSpaceService.deleteViewPoint(id);
        String targetUrl = "/view/edit/" + spaceId;
        return "redirect:" + targetUrl + ".do";
    }

    // 产生一个由UUID生成的文件名
    private String getNewFileName() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().toUpperCase();
    }

    //分页
    @RequestMapping(value = "/viewspacemanage", method = RequestMethod.GET)
    public String listViewSpace(HttpServletRequest request, @RequestParam(value = "currenpage", defaultValue = "1") int currenpage) {


        String hql = "from ViewSpace where spaceName like ?";

        Object[] param = {"%%"};
        List<Long> obj = viewSpaceService.count("");

        long pages = obj.get(0);
        long totalpages = 0;
        if (pages % CommonConstant.PAGE_SIZE == 0) {
            totalpages = pages / CommonConstant.PAGE_SIZE;
        } else {
            totalpages = pages / CommonConstant.PAGE_SIZE + 1;
        }

        List<ViewSpace> viewSpaces = viewSpaceService.find(hql, param, currenpage, CommonConstant.PAGE_SIZE);
        request.setAttribute("totalpages", totalpages);
        request.setAttribute("currenpage", currenpage);
        request.setAttribute("viewSpaces", viewSpaces);
        return "/admin/jsp/viewManeger/viewspacemanage";
    }

}