package fun.peri.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fun.peri.comm.CommonConstant;
import fun.peri.model.ViewRoute;
import fun.peri.service.IViewRouteService;

@Controller
@RequestMapping(value="/route")
public class ViewRouteController{
 
	@Autowired
	private  IViewRouteService viewRouteServiceImpl;
	private static int pageSize;
	
	//查询(添加)线路
	@RequestMapping(value="/queryallviewroute",method={RequestMethod.GET,RequestMethod.POST})
	public String queryViewRoute(HttpServletRequest request, ModelMap map){
		
		List<ViewRoute> viewRoutes = viewRouteServiceImpl.queryAllViewRoute();
		System.out.println(viewRoutes.size());
		map.put("viewroutes", viewRoutes);
		
		return "admin/jsp/routedate/route_list";
        }
	
	 //查询路线
	@RequestMapping(value="/querylikeviewroute",method={RequestMethod.GET,RequestMethod.POST})
	public String queryLikeViewRoute(HttpServletRequest request, ModelMap map){
		String routeName=request.getParameter("routename");
		List<ViewRoute> viewRoutes = viewRouteServiceImpl.queryLikeViewRoute(routeName);
		System.out.println(viewRoutes.size());
		map.put("viewroutes", viewRoutes);
		
		return "admin/jsp/routedate/route_list";
        }
	
	  //添加线路
	@RequestMapping(value="/addviewroute",method={RequestMethod.GET,RequestMethod.POST})
		
	public String addViewRoute(HttpServletRequest request, ModelMap map) throws ParseException{
		
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
		
		  String routename = request.getParameter("routename");
		  String routestates = request.getParameter("routestates");
		  String routeuserid = request.getParameter("routeuserid");
		  String publishdate = request.getParameter("publishdate");
		  String enddate = request.getParameter("enddate");
		  String remarks = request.getParameter("remarks");
		  Date publishDate = sdf.parse(publishdate);
		  Date endDate = sdf.parse(enddate);
		  
		  
		  ViewRoute viewRoute = new ViewRoute();
		  viewRoute.setRoutename(routename);
		  viewRoute.setRoutestates(routestates);
		  viewRoute.setRouteuserid(routeuserid);
		  viewRoute.setPublishdate(publishDate);
		  viewRoute.setEnddate(endDate);
		  viewRoute.setRemarks(remarks);
		  
		
		  viewRouteServiceImpl.addViewRoute(viewRoute);
		  
		       return "redirect:"+"/route/currentPage.do";
	
	}
	
	//修改线路
	@RequestMapping(value="/queryviewroutebyid",method={RequestMethod.GET,RequestMethod.POST})
	public String queryViewRouteById (HttpServletRequest request, ModelMap map) throws Exception{
		String routeid = request.getParameter("viewrouteid");
		
		 ViewRoute viewRoute = viewRouteServiceImpl.queryViewRouteById(Integer.parseInt(routeid));
		 map.put("viewroute", viewRoute);
		 
		 return "admin/jsp/routedate/route_update";
	}
	
	//修改已添加线路
	@RequestMapping(value="/updateviewroutebyid",method={RequestMethod.GET,RequestMethod.POST})
	public String updateViewRouteById (HttpServletRequest request, ModelMap map) throws Exception{
		
		String routeid = request.getParameter("viewrouteid");
				SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
		 
		  String routename = request.getParameter("routename");
		  String routestates = request.getParameter("routestates");
		  String routeuserid = request.getParameter("routeuserid");
		  String publishdate = request.getParameter("publishdate");
		  String enddate = request.getParameter("enddate");
		  String remarks = request.getParameter("remarks");
		  System.out.println(remarks);
		  Date publishDate = sdf.parse(publishdate);
		  Date endDate = sdf.parse(enddate);
		  
		  
		  ViewRoute vr = new ViewRoute();
		  vr.setRouteid(Integer.parseInt(routeid));
		  vr.setRoutename(routename);
		  vr.setRoutestates(routestates);
		  vr.setRouteuserid(routeuserid);
		  vr.setPublishdate(publishDate);
		  vr.setEnddate(endDate);
		  vr.setRemarks(remarks);
		  
		 viewRouteServiceImpl.updateViewRoute(vr);
		 return "redirect:"+"/route/currentPage.do";
	}
	
	
	//删除线路
	@RequestMapping(value="/removeviewroute",method={RequestMethod.GET,RequestMethod.POST})
	public String deleteViewRouteById (HttpServletRequest request, ModelMap map) throws Exception{
		
		String routeid = request.getParameter("viewrouteid");
				SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
		 		
	     String routeuserid = request.getParameter("routeuserid");
	     ViewRoute vr = new ViewRoute();
	     vr.setRouteid(Integer.parseInt(routeid));
		 viewRouteServiceImpl.removeViewRoute(vr);
		 
		 return "redirect:"+"/route/currentPage.do";
	}
	
	//打开查询页面
	@RequestMapping(value="open")
	public String open(HttpServletRequest request){
		System.out.println("dasdasdasd");
		return "redirect:"+"currentPage";
	}
	
	/**
	 * 分页查询
	 */
	@RequestMapping(value="currentPage",method={RequestMethod.GET,RequestMethod.POST})
	public String querylikeviewroute(HttpServletRequest request,
			@RequestParam(value="routename",defaultValue="") String routename,
			@RequestParam(value="currenpage",defaultValue="1") int currenpage){
	
		int totalRecords = viewRouteServiceImpl.queryViewRouteCount(routename);
	int totalPages = totalRecords/CommonConstant.PAGE_SIZE;
	if(totalRecords % CommonConstant.PAGE_SIZE!=0){
		totalPages++;
	}
	System.out.println(routename+"---------");
	List<ViewRoute> routes= viewRouteServiceImpl.querypage(routename, currenpage,CommonConstant.PAGE_SIZE );
	System.out.println(routes.size()+"  ===");
	request.setAttribute("viewroutes", routes);
	request.setAttribute("totalpages", totalPages);
	request.setAttribute("currenpage", currenpage);
     return "admin/jsp/routedate/route_list";
}	
	
}