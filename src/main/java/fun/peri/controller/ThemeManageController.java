package fun.peri.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fun.peri.comm.CommonConstant;
import fun.peri.model.Theme;
import fun.peri.service.IThemeService;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


/**
 * <pre>
 *  旅游主题控制器，这部分功能由主题管理操作，包括：主题增删改查控制转发处理
 * </pre>
 */
@Controller
@RequestMapping(value="/theme")
public class ThemeManageController {

	@Autowired
	private IThemeService themeService;
	//查询全部主题
	@RequestMapping(value="queryall")
	public ModelAndView queryAll(ModelAndView mv,HttpServletRequest request,
			@RequestParam(value="currenpage",defaultValue="1") int currenpage){
		List<Object> obj=themeService.count();
		int counts=Integer.parseInt(obj.get(0).toString());
		int totalpages=0;
		
		if((counts% CommonConstant.PAGE_SIZE)==0){
			totalpages=counts/CommonConstant.PAGE_SIZE;
		}else{
			totalpages=(counts/CommonConstant.PAGE_SIZE)+1;
		}
		
		Object[] param={"%%"};
		List<Theme> themes=themeService.find(param, currenpage,CommonConstant.PAGE_SIZE);
		mv.addObject("themes", themes);
		mv.addObject("totalpages", totalpages);
		mv.addObject("currenpage", currenpage);
		mv.setViewName("/admin/jsp/basicdata/traveltopic_list");
		return mv;
	}
	
	//打开添加主题页面
	@RequestMapping(value="add")
	public String addpage(HttpServletRequest request){
		return "/admin/jsp/basicdata/traveltopic_add";
	}
	
	//添加主题
	@RequestMapping(value="addtheme",method=RequestMethod.POST)
	public String addtheme(HttpServletRequest request,@RequestParam("themename") String themename,
			@RequestParam("themeId") int id,@RequestParam("describe") String describe,
			@RequestParam("imgFile") MultipartFile file,
			ModelAndView mv){
		Theme theme=new Theme();
		if(!file.isEmpty()){
			String srcname=file.getOriginalFilename();
			String fileExt=srcname.substring(srcname.lastIndexOf("."));
			String filename=getNewName()+fileExt;
			String filePath=request.getSession().getServletContext().getRealPath("/uploads/"+filename);
			try {
				file.transferTo(new File(filePath));
			} catch (IllegalStateException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			theme.setThemePicture(filename);
		}
		theme.setThemeDescribe(describe);theme.setThemeId(id);theme.setThemeName(themename);
		themeService.addTheme(theme);
		String url="queryall.do";
		return "redirect:"+url;
	}
	
	//根据主题名称查询
	@RequestMapping(value="search",method={RequestMethod.GET,RequestMethod.POST})
	public String queryByaName(HttpServletRequest request,@RequestParam("themename") String themename
			,@RequestParam(value="currenpage",defaultValue="1") int currenpage,HttpServletResponse response){
		try {
			themename=new String(themename.getBytes("iso8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		Object [] param={"%"+themename+"%"};
		List<Object> obj=themeService.countparam(param);
		int counts=Integer.parseInt(obj.get(0).toString());
		int totalpages=0;
		if(counts%CommonConstant.PAGE_SIZE==0){
			totalpages=counts/CommonConstant.PAGE_SIZE;
		}else{
			totalpages=counts/CommonConstant.PAGE_SIZE+1;
		}
		List<Theme> themes=themeService.find(param, currenpage,CommonConstant.PAGE_SIZE);
		request.setAttribute("themes",themes);
		request.setAttribute("themename", themename);
		request.setAttribute("totalpages", totalpages);
		request.setAttribute("currenpage", currenpage);
		return "/admin/jsp/basicdata/traveltopic_list";
	}
	
	//生成uuid名
	public UUID  getNewName() {
		UUID uuid=UUID.randomUUID();	
		return uuid;
	}
	
	//打开修改页面
	@RequestMapping(value="{id}/edit")
	public String Update(HttpServletRequest request,@PathVariable int id){
		Theme theme=themeService.queryById(id);
		request.setAttribute("theme", theme);
		return "/admin/jsp/basicdata/traveltopic_update";
	}
	
	//修改主题
	@RequestMapping(value="{id}/updatetheme")
	public String updateTheme(HttpServletRequest request,@PathVariable int id,
		@RequestParam("themename") String themename,@RequestParam("themedescribe") String describe,
		@RequestParam("imgFile") MultipartFile file){
		Theme theme=new Theme();
		if(!file.isEmpty()){
			String scrname=file.getOriginalFilename();
			String fileExt=scrname.substring(scrname.lastIndexOf("."));
			String filename=getNewName()+fileExt;
			String filepath=request.getSession().getServletContext().getRealPath("/uploads/"+filename);
			try {
				file.transferTo(new File(filepath));
			} catch (IllegalStateException | IOException e) {
				
				e.printStackTrace();
			}
			theme.setThemePicture(filename);
		}
		theme.setThemeDescribe(describe);theme.setThemeId(id);theme.setThemeName(themename);
		themeService.updateTheme(theme);
		String url="/theme/queryall.do";
		return "redirect:"+url;
	}
	
	//删除主题
	@RequestMapping(value="{id}/delete")
	public String deletetheme(HttpServletRequest request,@PathVariable int id){
		Theme theme=themeService.queryById(id);
		themeService.deleteTheme(theme);
		String url="/theme/queryall.do";
		return "redirect:"+url;
	}
	//查询详细信息
	@RequestMapping(value="/{id}/search")
	public ModelAndView search(HttpServletRequest request,@PathVariable int id,ModelAndView mv){
		System.out.println("---------");
		Theme theme=themeService.queryById(id);
		mv.addObject("theme", theme);
		mv.setViewName("/admin/jsp/basicdata/traveltopic_search");
		return mv;
	}
	
	
}
