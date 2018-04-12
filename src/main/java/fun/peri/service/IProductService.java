package fun.peri.service;

import java.util.List;

import fun.peri.model.Product;
import fun.peri.model.ProductDetail;
import fun.peri.model.ViewRoute;

/**
 * 产品服务层
 * @author Administrator
 *
 */
public interface IProductService {
	
	/**
	 * 添加产品
	 * @param product
	 */
	public void addProduct(Product product);
	
	/**
	 * 删除
	 * @param id
	 */
	public void deleteProduct(String id);
	
	/**
	 * 修改产品
	 * @param product
	 */
	public void updateProduct(Product product);
	
	/**
	 * 模糊查询
	 * @param name
	 * @return
	 */
	public List<Product> queryProductByName(String name);
	
	/**获取所有产品对象
	 * 
	 */
  public List<Product> queryAllProduct();
  
  /**
   * 分页查询说
   * @param currentPage
   * @return
   */
  public List<Object[]> queryByPage(final int currentPage);
  
  /**
   * 通过名称查询对应的线路对象
   * @return
   */
  public List<Object[]>  queryRouteName();
  
  /**
   * 通过id查询产品信息
   * @param productId
   * @return
   */
  public Product queryProductById(String productId);
  
  
  
  public List<Object> vagueQueryProduct(Product product, String routename);
  /**
   * 
   */
  	public int queryCount();
  
  /**
   * *****************************详细信息***************************************************
   */
  
  public List<ProductDetail> queryAllProductDetail(String productid);
  
  
  
  
  
  /**
   * ************String hql=" from Product p where p.productName = ?";*****************
   */
  
  
  public List<ViewRoute> queryRouteByName(String routename);
  
  
  public List<Object[]> queryProductName();
  
  public void addProductDetail(ProductDetail productDetail,String productname );
  
  public ProductDetail queryProductDetailById(int id);
  
  
  
  public void deleteProductDetailById(int in);

  
  public void updateProductDetail(String productid, ProductDetail productDetail);
  
  //前端
  
  /**
   * 通过ID查询产品列表
   * @return
   */
  public Product queryWebProductById(String productid);
  /**
   * 查询一个路线产品列表记录数
   * @return
   */
  public int queryWebProductCount(int routeid);
  
  public List<Product> queryWebProduct(int currentPage,int pageSize,int routeid);
  public List<ProductDetail> queryWebProductDetail(String productid);
  
}
