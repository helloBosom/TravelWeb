package com.cissst.software.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cissst.software.dao.OrderDao;
import com.cissst.software.dao.ProductDao;
import com.cissst.software.model.Order;
import com.cissst.software.service.IOrderService;
@Service(value="orderServiceImpl")
public class OrderServiceImpl implements IOrderService {

	@Autowired
	private OrderDao orderdao;

	@Override
	public List<Order[]> queryByPage(int currentPage) {
		
		return null;
	}

	@Override
	public void addOrder(Order order) {
		orderdao.save(order);
	}

	@Override
	public void updateOrder(Order order) {
		orderdao.update(order);
	}

	@Override
	public void deleteOrder(Order order) {
		
		
		orderdao.remove(order);
	}

	@Override
	public List<Object[]> queryOrderAll() {
		
		return orderdao.queryAllOrder();
	}

	@Override
	public List<Object[]> queryOrderById(int orderId) {
		
		return orderdao.queryOrderById(orderId);
	}

	@Override
	public void checkOrder(int orderId) {
		orderdao.checkOrder(orderId);	
	}

	@Override
	public Order get(int orderId) {
		
		return orderdao.get(orderId);
	}

	@Override
	public void update(Order order) {
		orderdao.update(order);
	}

	@Override
	public List<Object[]> queryOrderByName(int currenpage,String productname, String routename, String orderstatus) {
		
		return orderdao.queryOrderByName(currenpage,productname, routename, orderstatus);
	}

	@Override
	public List<Object[]> count(String productname, String routename, String orderstatus) {
		
		return orderdao.count(productname, routename, orderstatus);
	}

	@Override
	public void addWebOrder(Order order) {
		orderdao.addWebOrder(order);
	}

	

}
