package fun.peri.controller;

import fun.peri.model.City;
import fun.peri.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/city")
public class CityManageController {

    @Qualifier("ICityService")
    @Autowired
    private ICityService iCityService;

    /**
     * 实现查询所有城市操作
     *
     * @return
     */
    @RequestMapping(value = "/queryall", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView QueryAll() {
        // 调用业务逻辑层查询方法
        List<City> cities = iCityService.queryall();
        // 封装数据模型然后跳转到显示页面
        ModelAndView mv = new ModelAndView();
        mv.addObject("cities", cities);
        mv.setViewName("/admin/jsp/city/city_manage");
        return mv;
    }

    /**
     * 转到新增用户页面 并返回角色列表到新增页面
     */
    @RequestMapping(value = "/to_add", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView ToAdd() {
        // 调用业务逻辑层查询方法
        List<City> cities = iCityService.queryall();
        // 封装数据模型然后跳转到显示页面
        ModelAndView mv = new ModelAndView();
        mv.addObject("cities", cities);
        mv.setViewName("/admin/jsp/city/city_add");
        return mv;
    }

    /**
     * 实现add城市操作
     */
    @RequestMapping(value = "/add", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView Add(City city) {
        // 封装数据模型然后跳转到显示页面
        iCityService.addCity(city);
        List<City> cities = new ArrayList<City>();
        cities.add(city);
        return Query(cities);
    }

    /**
     * 实现查询城市操作
     */
    @RequestMapping(value = "/query", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView Query(List<City> cities) {
        // 封装数据模型然后跳转到显示页面
        ModelAndView mv = new ModelAndView();
        mv.addObject("cities", cities);
        mv.setViewName("/admin/jsp/city/city_manage");
        return mv;
    }

    /**
     * delete城市 并返回到查询页面
     */
    @RequestMapping(value = "/delete", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView Delete(@RequestParam("id") String id) {
        iCityService.deleteCity(Integer.parseInt(id));
        return QueryAll();
    }

    /**
     * 实现city查询操作
     */
    @RequestMapping(value = "/querybycondition", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView QueryByCondition(@RequestParam("id") int id, @RequestParam("cityname") String cityname) {
        Object[] parameters = new Object[2];
        System.out.println(cityname + " " + id);
        parameters[0] = id;
        parameters[1] = cityname;
        return Query(iCityService.queryCityByCondition(parameters));
    }

    /**
     * to修改city
     */
    @RequestMapping(value = "/to_update", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView ToUpdate(@RequestParam("id") String id) {
        System.out.println("to_update.do");
        City city = iCityService.queryCityById(Integer.parseInt(id));
        ModelAndView mv = new ModelAndView();
        mv.addObject("city", city);
        mv.setViewName("/admin/jsp/city/city_update");
        return mv;
    }

    /**
     * 修改city
     */
    @RequestMapping(value = "/update", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView Update(HttpServletRequest request, HttpServletResponse response) {
        // 调用业务逻辑层查询方法
        City city = iCityService.queryCityById(Integer.parseInt(request.getParameter("id")));
        city.setCityname(request.getParameter("cityname"));
        city.setRemarks(request.getParameter("remarks"));
        iCityService.updateCity(city);
        List<City> cities = new ArrayList<City>();
        cities.add(city);
        return Query(cities);
    }
}
