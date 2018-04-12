package fun.peri.dao;

import java.util.List;

import fun.peri.model.ProductDetail;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDetailDao extends BaseDao<ProductDetail>{
	
  public List<ProductDetail> queryAllProductDetail(String productid){
	  String sql = "from ProductDetail where productid =?";
	  List<ProductDetail> productDetails = (List<ProductDetail>) this.getHibernateTemplate().find(sql, productid);
	  
	  
	  return productDetails;
  }
	
	
  
 
  public List<Object[]>  queryProductName(){
		String hql = "select p.productName from Product p";
		List<Object[]> productnames = 
				    (List<Object[]>) this.getHibernateTemplate().find(hql, null);
		
		return productnames;
	}
	
  //前端
  /**
	 * 查询产品详情
	 */
	public List<ProductDetail> queryWebProduct(String productid){
		final String hql="from ProductDetail where productid=?";
		List<ProductDetail> results = (List<ProductDetail>) this.getHibernateTemplate().find(hql, new Object[]{productid});
		return results;
	}
  
  
}
