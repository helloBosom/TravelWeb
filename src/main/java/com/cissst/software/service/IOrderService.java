package com.cissst.software.service;

import java.util.List;

import com.cissst.software.model.Order;

/**
 * 订单服务层
 * @author Administrator
 *
 */
public interface IOrderService {
	public void addOrder(Order order);
	public void updateOrder(Order order);
	public void deleteOrder(Order order);
	/**
	 * 通过订单编号审核订单
	 * @param orderid
	 */
	public void checkOrder(int orderId);
	/**
	 * 模糊查询
	 * @param productname
	 * @param routename
	 * @param orderstatus
	 * @return
	 */
	public List<Object[]> queryOrderByName(int currenpage,String productname,String routename,String orderstatus);
	/**
	 * 分页查询
	 * @param currentPage
	 * @return
	 */
	public List<Order[]> queryByPage(final int currentPage);
	/**
	 * 实现多表查询
	 * @return
	 */
	public List<Object[]> queryOrderAll();
	/**
	 * 根据订单编号查询订单详情
	 * @return
	 */
	public List<Object[]> queryOrderById(int orderId);
	/**
	 * 根据订单编号查询订单
	 * @return
	 */
	public Order get(int orderId);
	/**
	 * 根据订单编号查询订单
	 * @return
	 */
	public void update(Order order);
	
	/**
	 * 根据订单编号查询订单
	 * @return
	 */
	public List<Object[]> count(String productname,String routename,String orderstatus);
	
	public void addWebOrder(Order order);
}
