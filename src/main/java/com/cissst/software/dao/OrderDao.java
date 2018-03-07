package com.cissst.software.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.cissst.software.comm.CommonConstant;
import com.cissst.software.model.Order;

@Repository
public class OrderDao extends BaseDao<Order> {
	/**
	 * 通过id审核订单
	 * @param orderId
	 */
	public void checkOrder(int  orderId){
		System.out.println("aaaaa");
		String hql = "update tbl_order set orderStatus = '1' where orderId =?";
		System.out.println("bbbbb");
		this.getHibernateTemplate().find(hql, new Object[]{orderId});
	}
	/**
	 * 模糊查询
	 * @param productname
	 * @param routename
	 * @param orderstatus
	 * @return
	 */
	public List<Object[]> queryOrderByName(final int currenpage,String productname,String routename,String orderstatus){
		
		final String hql = "select o.orderId,o.customer,o.c_phone1,p.productName,r.routename,o.peopleNum,o.payable,"
				+ "o.manageName,o.orderStatus from Order o inner join o.product p inner join p.route r "
				+ "where p.productName like '%"+productname+"%' and r.routename like '%"+routename+"%' and o.orderStatus='"+orderstatus+"' ";
		System.out.println(orderstatus+"haha");
		List<Object[]> orderInfo = this.getHibernateTemplate().execute(new HibernateCallback<List<Object[]>>() {

			@Override
			public List<Object[]> doInHibernate(Session session) throws HibernateException {
				List<Object[]> results = (List<Object[]>) session.createQuery(hql).setFirstResult((currenpage-1)*CommonConstant.PAGE_SIZE).setMaxResults(currenpage*CommonConstant.PAGE_SIZE).list();
				return results;
			}			
		});	
		
		return orderInfo;
	}
	/**
	 * 查询所有订单
	 * @return
	 */
	public List<Object[]> queryAllOrder(){
		System.out.println("kkkkkkkkkkkkkkk");
		final String hql = "select o.orderId,o.customer,o.c_phone1,p.productName,r.routename,o.peopleNum,o.payable,"
				+ "o.manageName,o.orderStatus from Order o inner join o.product p inner join p.route r";
		List<Object[]> orderInfo = this.getHibernateTemplate().execute(new HibernateCallback<List<Object[]>>() {

			@Override
			public List<Object[]> doInHibernate(Session session) throws HibernateException {
				List<Object[]> results = (List<Object[]>) session.createQuery(hql).list();		
				return results;
			}			
		});	
		for(Object[] obj:orderInfo)
			System.out.println(obj[2]);
		return orderInfo;
	}
	/**
	 * 根据订单编号查询订单详情
	 * @return
	 */
	public List<Object[]> queryOrderById(int orderId){
		System.out.println("oooooooooooo");
		
		 String hql = "select o.orderId,o.orderNum,o.customer,o.c_phone1,o.c_phone2,p.productName,r.routename,"
				+ "o.submitDate,o.startDate,o.endDate,o.peopleNum,o.payable,o.unPay,o.orderStatus,"
				+ "o.manageName,o.managePhone from Order o inner join o.product p inner join p.route r"
				+ " where o.orderId =?";
		List<Object[]> orderInfo = (List<Object[]>)this.getHibernateTemplate().find(hql, new Object[]{orderId});
		
		return orderInfo;
	}
	
	/**
	 * 分页查询
	 */
	public List<Object[]> queryByPage(final int currentPage){
		final String hql = "select o.orderId,o.orderNum,o.customer,o.c_phone1,o.c_phone2,p.productName,r.routename,"
				+ "o.submitDate,o.startDate,o.endDate,o.peopleNum,o.payable,o.unPay,o.orderStatus,"
				+ "o.manageName,o.managePhone from Order o inner join o.product p inner join p.route r";
		List<Object[]> orderInfo = this.getHibernateTemplate().execute(new HibernateCallback<List<Object[]>>() {

			@Override
			public List<Object[]> doInHibernate(Session session) throws HibernateException {
				List<Object[]> results = (List<Object[]>) session.createQuery(hql)
						.setFirstResult((currentPage-1)*CommonConstant.PAGE_SIZE)
						.setMaxResults(CommonConstant.PAGE_SIZE);
				return results;
			}			
		});		
		return orderInfo;
	}
	
	
	//总记录条数
public List<Object[]> count(String productname,String routename,String orderstatus){
		
		final String hql = "select count(*) from Order o inner join o.product p inner join p.route r "
				+ "where p.productName like '%"+productname+"%' and r.routename like '%"+routename+"%' and o.orderStatus='"+orderstatus+"' ";
		System.out.println(orderstatus+"haha");
		List<Object[]> orderInfo = this.getHibernateTemplate().execute(new HibernateCallback<List<Object[]>>() {

			@Override
			public List<Object[]> doInHibernate(Session session) throws HibernateException {
				List<Object[]> results = (List<Object[]>) session.createQuery(hql).list();
				return results;
			}			
		});	
		
		return orderInfo;
	}

public void addWebOrder(Order order){
	this.getHibernateTemplate().save(order);
}
}
