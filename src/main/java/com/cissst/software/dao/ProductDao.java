package com.cissst.software.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.cissst.software.comm.CommonConstant;
import com.cissst.software.model.Product;
import com.cissst.software.model.ViewRoute;
import com.cissst.software.model.ViewSpace;

@Repository
public class ProductDao extends BaseDao<Product> {
	
	/**
	 * 模糊查询
	 */
public List<Product> queryByName(String name) {
		
		String hql=" from Product p where p.productName like ?";
		List<Product> products = 
		(List<Product>)this.getHibernateTemplate().find(hql, new Object[]{"%"+name+"%"});
		return products;
	}
	
public List<ViewRoute> queryRouteByName(String routename){
	String hql = "from ViewRoute v where v.routename =?";
	List<ViewRoute> routes =	
			(List<ViewRoute>) this.getHibernateTemplate().find(hql, new Object[]{routename});
	
	//System.out.println(routes.size());
	return routes;
}


/**
 * 查询所有线路名称
 */
	
	public List<Object[]>  queryRouteName(){
		String hql = "select r.routename from ViewRoute r";
		List<Object[]> names =(List<Object[]>) getHibernateTemplate().find(hql, null);
		return names;
	}

	
	/**
	 * 根据产品名称查询产品对象
	 * @param routename
	 * @return
	 */
  public List<Product> queryProductByName(String productname){
		String hql = "from Product where productName =?";
		List<Product> product =	(List<Product>) this.getHibernateTemplate().find(hql, new Object[]{productname});
		
		return product;
	}
	
  
	
	/**
	 * 查询总记录数
	 */
	
	public int queryCount(){
		final String hql = "select count(*) from Product";
		int count = this.getHibernateTemplate().execute(new HibernateCallback<Integer>() {

			@Override
			public Integer doInHibernate(Session session) throws HibernateException {
				Integer count =
							Integer.parseInt((session.createQuery(hql).uniqueResult()).toString());
				return count;
			}
		}) ;
		System.out.println(count);
		return count;
		
	}
	
	
	
	
	/**
	 * 分页查询
	 */

	public List<Object[]> queryByPage(final int currentPage){
		final String sql = "select p.productid,p.productName,p.days,r.routename,p.status,p.remarks,p.price from Product p inner join p.route r";
		List<Object[]> productInfo = this.getHibernateTemplate().execute(new HibernateCallback<List<Object[]>>() {

			
			
			
			@Override
			public List<Object[]> doInHibernate(Session session) throws HibernateException {
				List<Object[]> results = (List<Object[]>) session.createQuery(sql)
						.setFirstResult((currentPage-1)*CommonConstant.PAGE_SIZE)
						.setMaxResults(CommonConstant.PAGE_SIZE)
						.list();
				return results;
			}
			
			
			
		});
		return productInfo;
	}
	
	/**
	 * 多条件模糊查询
	 */
	public List<Object> avagueQueryProduct(Product product, String routename) {
		String hql = "select p.productid,p.productName,p.days,r.routename,p.status,p.remarks,p.price from Product p inner join p.route r where 1=1 ";
		if (product != null) {
			if(product.getProductName()!=null &&  !("".equals(product.getProductName()) )){
				hql += "and p.productName like '%" + product.getProductName() + "%'";
			}
			if(product.getStatus()!=null && ! "".equals(product.getStatus())){
				hql +=" and p.status=" + product.getStatus();
						
			}
			if(product.getDays()!=null && ! "".equals(product.getDays())){
				hql +=" and p.days=" + product.getDays();
						
			}
			if(product.getRoute().getRoutename()!=null && ! "".equals(product.getRoute())){
				hql += " and r.routename like '%" + routename + "%'";
			}
			
		}

		List<Object> products = (List<Object>) this.getHibernateTemplate().find(hql, null);
		System.out.println(products.size());
		return products;
	}

	
	
	
	
	
	/**
	 * 通过路线查询产品列表
	 * @param routeid
	 * @return
	 */
	public Product queryProductById(String productid){
		String hql = "from Product p where p.productid=?";
		List<Product> products = (List<Product>)this.getHibernateTemplate().find(hql, new Object[]{productid});
		return products.get(0);
	}
	/**
	 * 产品分页
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public List<Product> queryWebProduct(final int currentPage,final int pageSize,int routeid){
		final String hql="select p from Product p inner join p.route r where r.routeid="+routeid;
		List<Product> results = this.getHibernateTemplate().execute(new HibernateCallback<List<Product>>(){

			@Override
			public List<Product> doInHibernate(Session session) throws HibernateException {
				List<Product> rows =session.createQuery(hql)
						.setFirstResult((currentPage-1)*pageSize)
						.setMaxResults(pageSize)
						.list();
			return rows;
				
			}});
		return results;
	}
	
	//前端
	/**
	 * 查询产品记录数
	 * @return
	 */
	public int queryWebProductCount(int routeid){
		final String hql="select count(*) from Product p inner join p.route r where r.routeid="+routeid;
		List<Object> results = (List<Object>) this.getHibernateTemplate().find(hql, null);
		int count = Integer.parseInt(results.get(0).toString());
			
		return count;
	}
	
}
