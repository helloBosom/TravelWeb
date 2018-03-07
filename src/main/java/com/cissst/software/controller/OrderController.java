package com.cissst.software.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.html.FormSubmitEvent.MethodType;

import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cissst.software.comm.CommonConstant;
import com.cissst.software.dao.OrderDao;
import com.cissst.software.model.Order;
import com.cissst.software.model.Product;
import com.cissst.software.service.IOrderService;

@Controller
@RequestMapping(value="/order")
public class OrderController {
	
	@Autowired
	private IOrderService orderService;	
	
	/**
	 * 查询全部订单信息
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/queryallorder")
	public String queryAllOrder(ModelMap map){		
		List<Object[]> orders = orderService.queryOrderAll();		
		map.put("orders", orders);
		for(Object[] obj:orders){
			System.out.println(obj[1]+" "+obj[2]+"abc");
		}
		return "admin/jsp/ordermanager/order_audit_list";
	}
	/**
	 * 查询全部订单信息
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/queryallorder1")
	public String queryAllOrder1(ModelMap map){		
		List<Object[]> orders =	orderService.queryOrderAll();		
		map.put("orders", orders);
		return "admin/jsp/ordermanager/order_audit_update";
	}
	/**
	 * 根据订单编号查询订单详情
	 * @return
	 */
	@RequestMapping(value="/{id}/queryorderbyid")
	public String queryOrderById(@PathVariable int id,ModelMap map){
		List<Object[]> orders=orderService.queryOrderById(id);
		map.put("orders", orders);
		return "admin/jsp/ordermanager/order_detail";
	}
	/**
	 * 根据订单编号查询订单详情
	 * @return
	 */
	@RequestMapping(value="/{id}/queryorderbyid1")
	public String queryOrderById1(@PathVariable int id,ModelMap map){
		List<Object[]> orders=orderService.queryOrderById(id);
		map.put("orders", orders);
		return "admin/jsp/ordermanager/order_audit_update2";
	}
	/**
	 * 根据订单编号查询订单详情
	 * @return
	 */
	@RequestMapping(value="/{id}/queryorderbyid2")
	public String queryOrderById2(@PathVariable int id,ModelMap map){
		List<Object[]> orders=orderService.queryOrderById(id);
		map.put("orders", orders);
		return "admin/jsp/ordermanager/order_detail2";
	}
	//根据订单编号查询订单详情并审核
	@RequestMapping(value="/{id}/checkorder")
	public String checkOrder(@PathVariable int id,ModelMap map){
		List<Object[]> orders=orderService.queryOrderById(id);
		map.put("orders", orders);
		return "admin/jsp/ordermanager/order_audit";
	}
	/**
	 * 根据订单编号审核订单
	 * @return
	 */
	@RequestMapping(value="{id}/checkorderbyid")	
	public String checkOrderById(@PathVariable int id){
		System.out.println("check");
		Order order=orderService.get(id);
		order.setOrderStatus("1");
		orderService.update(order);
		return "redirect:"+"/order/queryallorder.do";
	}
	@RequestMapping(value="{id}/nocheckorderbyid")	
	public String checkOrderById1(@PathVariable int id){
		System.out.println("check");
		Order order=orderService.get(id);
		order.setOrderStatus("2");
		orderService.update(order);
		return "redirect:"+"/order/queryallorder.do";
	}
	/**
	 * 修改订单信息
	 * @param id
	 * @param p1
	 * @param phone2
	 * @param startdate
	 * @param enddate
	 * @param peoplenum
	 * @param payable
	 * @param unpay
	 * @param managename
	 * @param managephone
	 * @return
	 */
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(@RequestParam("id") int id,@RequestParam("phone1") String p1,
			@RequestParam("phone2") String phone2,@RequestParam("startdate") String startdate,
			@RequestParam("enddate") String enddate,@RequestParam("peoplenum") int peoplenum,
			@RequestParam("payable") Double payable,@RequestParam("unpay") Double unpay,
			@RequestParam("managename") String managename,@RequestParam("managephone") String managephone){
		System.out.println(phone2+enddate+startdate);
		Order order = orderService.get(id);		
		SimpleDateFormat sf = new SimpleDateFormat("dd-M月-YYYY");
		System.out.println("okokokok");
		order.setC_phone1(p1);
		order.setC_phone2(phone2);
		order.setStartDate(startdate);
		order.setEndDate(enddate);
		order.setPeopleNum(peoplenum);
		order.setPayable(payable);
		order.setUnPay(unpay);
		order.setManageName(managename);
		order.setManagePhone(managephone);
		orderService.update(order);
		return "redirect:"+"/order/queryallorder1.do";
	}
	/**
	 * 根据ID删除信息
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value="{id}/deleteorder")
	public String deleteOrder(@PathVariable int id){
		Order order=orderService.get(id);
		order.setProduct(null);
		orderService.update(order);
		orderService.deleteOrder(order);
		return "redirect:"+"/order/queryallorder1.do";
	}
	//分页查询
	@RequestMapping(value = "/querybypage",method = RequestMethod.POST)
	public String findOrderByPage(HttpServletRequest request,ModelMap map){
		int  currenpage= 1;
		String str = request.getParameter("currenpage");
		String productname = request.getParameter("productname");
		String routename = request.getParameter("routename");
		String orderstatus = request.getParameter("orderstatus");
		System.out.println(orderstatus+" "+routename+" "+productname);
		if(str != null){
			currenpage = Integer.parseInt(str);
		}
		List<Object[]> orders=orderService.queryOrderByName(currenpage,productname, routename, orderstatus);
		map.put("orders", orders);
		return "admin/jsp/ordermanager/order_audit_list";
	}
	@RequestMapping(value = "/updatequerybypage",method = {RequestMethod.POST,RequestMethod.GET})
	public String findOrderByPage1(HttpServletRequest request,ModelMap map){
		int currenpage = 1;
		String str = request.getParameter("currenpage");
		String productname = request.getParameter("productname");
		String routename = request.getParameter("routename");
		String orderstatus = request.getParameter("orderstatus");		
		if(str != null){
			currenpage = Integer.parseInt(str);
		}
		List<Object[]> obj=orderService.count(productname, routename, orderstatus);
		Object c= obj.get(0);
		int counts=Integer.parseInt(c.toString());
		int totalpages=counts/CommonConstant.PAGE_SIZE;	
		List<Object[]> orders=orderService.queryOrderByName(currenpage,productname, routename, orderstatus);

		map.put("orders", orders);
		map.put("counts",counts);
		map.put("totalpages", totalpages);
		map.put("currenpage", currenpage);
		return "admin/jsp/ordermanager/order_audit_update";
		
	}
	
}
