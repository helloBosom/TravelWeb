package fun.peri.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fun.peri.model.Comment;
import fun.peri.model.ViewRoute;
import fun.peri.model.ViewSpace;
import fun.peri.service.ICommentService;
import fun.peri.service.IViewRouteService;
import fun.peri.service.IViewSpaceService;

@Controller
@RequestMapping(value = "/comment")
public class CommentController {
	@Qualifier("ICommentService")
	@Autowired
	protected ICommentService commentservice;
	@Autowired
	protected IViewSpaceService viewSpaceService;
	@Autowired
	private IViewRouteService viewRouteService;

	@RequestMapping(value = "/queryleftbasedata", method = { RequestMethod.GET, RequestMethod.POST })
	public void queryLeftBaseData(HttpServletRequest request, ModelMap map) {

		List<ViewRoute> viewRoutes = viewRouteService.queryWebViewRoute(1, 6);

		map.put("viewroutes", viewRoutes);
	}

	// 打开前台景区详情
	@RequestMapping(value = "/roatedetail")
	public String roatedetail(HttpServletRequest request) {
		ViewSpace viewSpace = viewSpaceService.getViewSpace(1);
		request.setAttribute("viewSpace", viewSpace);
		return "web/scenicdetail";

	}

	// 打开评论页
	@RequestMapping(value = "addcomm")
	public String comm(@RequestParam("spaceId") int spaceid, HttpServletRequest request, ModelMap map) {
		queryLeftBaseData(request, map);
		ViewSpace viewSpace = viewSpaceService.getViewSpace(spaceid);
		request.setAttribute("spaceId", spaceid);
		request.setAttribute("viewspace", viewSpace);
		return "web/remark";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String addcomment(HttpServletRequest request, @RequestParam("username") String username,
			@RequestParam("tel") String tel, @RequestParam("content") String content, ModelAndView mv,
			@RequestParam("spaceId") int spaceId, ModelMap map) {
		queryLeftBaseData(request, map);
		ViewSpace viewSpace = viewSpaceService.getViewSpace(spaceId);
		String ip = request.getRemoteAddr();
		Comment comment = new Comment();
		comment.setViewSpace(viewSpace);
		comment.setContent(content);
		comment.setIp(ip);
		comment.setPhone(tel);
		comment.setUsername(username);
		commentservice.addcomment(comment);
		request.setAttribute("spaceId", spaceId);
		request.setAttribute("viewspace", viewSpace);
		return "web/remark";
	}

	// 根据ID删除评论
	@RequestMapping(value = "delete")
	public String deletecomment(HttpServletRequest request, @RequestParam("commentid") int commentid,
			@RequestParam("spaceId") int spaceid) {
		Comment comment = new Comment(commentid);
		commentservice.deletecomment(comment);
		return "redirect:" + "/view/showview/" + spaceid + ".do";
	}

	// 不通过评论
	@RequestMapping(value = "nopass")
	public String nopasscomment(HttpServletRequest request, @RequestParam("commentid") int commentid,
			@RequestParam("spaceId") int spaceid) {
		Comment comment = commentservice.getcomment(commentid);
		comment.setStatus(2);
		commentservice.updatecomment(comment);
		return "redirect:" + "/view/showview/" + spaceid + ".do";
	}

	// 通过评论
	@RequestMapping(value = "pass")
	public String passcomment(HttpServletRequest request, @RequestParam("commentid") int commentid,
			@RequestParam("spaceId") int spaceid) {
		Comment comment = commentservice.getcomment(commentid);
		comment.setStatus(1);
		commentservice.updatecomment(comment);

		return "redirect:" + "/view/showview/" + spaceid + ".do";
	}

	// 查看评论
	@RequestMapping(value = "show")
	public String show(HttpServletRequest request, @RequestParam("spaceId") int spaceId, ModelMap map) {
		queryLeftBaseData(request, map);
		List<Object> contents = commentservice.show(spaceId);
		ViewSpace viewSpace = viewSpaceService.getViewSpace(spaceId);
		request.setAttribute("contents", contents);
		request.setAttribute("spaceId", spaceId);
		request.setAttribute("viewspace", viewSpace);
		return "web/remark";
	}
}
