package fun.peri.service.impl;

import java.util.List;

import fun.peri.dao.ProductDao;
import fun.peri.dao.ProductDetailDao;
import fun.peri.model.Product;
import fun.peri.model.ProductDetail;
import fun.peri.model.ViewRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fun.peri.service.IProductService;

@Service(value = "productServiceImpl")
public class ProductServiceImpl implements IProductService {
	@Autowired
	private ProductDao productDao;
	@Autowired
	private ProductDetailDao productDetailDao;

	/**
	 * 添加产品
	 */
	@Override
	public void addProduct(Product product) {
		productDao.save(product);
	}

	/**
	 * 删除产品
	 */
	@Override
	public void deleteProduct(String id) {
		Product product = productDao.get(id);
		productDao.remove(product);

	}

	/**
	 * 修改产品信息
	 */
	@Override
	public void updateProduct(Product product) {
		productDao.update(product);
		// System.out.println(product.getProductid()+"更新成功!");
	}

	/**
	 * 模糊查询
	 */
	@Override
	public List<Product> queryProductByName(String name) {

		return productDao.queryByName(name);
	}

	/**
	 * 查询全部产品信息
	 */
	@Override
	public List<Product> queryAllProduct() {

		return productDao.loadAll();
	}

	@Override
	public List<Object[]> queryByPage(int currentPage) {

		return productDao.queryByPage(currentPage);
	}

	@Override
	public List<ProductDetail> queryAllProductDetail(String productid) {

		return productDetailDao.queryAllProductDetail(productid);
	}

	/**
	 * 通过名称查询产品对象
	 */
	@Override
	public List<ViewRoute> queryRouteByName(String routename) {

		return productDao.queryRouteByName(routename);
	}

	/**
	 * 查询所有线路名称
	 */
	@Override
	public List<Object[]> queryRouteName() {
		return productDao.queryRouteName();
	}

	/**
	 * 通过ID查询产品总数
	 */
	@Override
	public Product queryProductById(String productId) {

		return productDao.get(productId);
	}

	/**
	 * 查询所有产品记录总数
	 */
	@Override
	public int queryCount() {
		// TODO Auto-generated method stub
		return productDao.queryCount();
	}

	/**
	 * 查询所有产品名称
	 */
	@Override
	public List<Object[]> queryProductName() {

		return productDetailDao.queryProductName();
	}

	/**
	 * 保存详细信息
	 */
	@Override
	public void addProductDetail(ProductDetail productDetail, String productname) {
		System.out.println(productname+"0000000");
		Product product = productDao.queryProductByName(productname).get(0);
		// System.out.println(product.getProductid());
		productDetail.setProduct(product);
		// System.out.println("id="+productDetail.getId());

		productDetailDao.save(productDetail);
	}

	/**
	 * 通过ID查询详细信息对象
	 */
	@Override
	public ProductDetail queryProductDetailById(int id) {
		return productDetailDao.get(id);
	}

	/**
	 * 删除详细信息
	 */
	@Override
	public void deleteProductDetailById(int id) {
		productDetailDao.remove(productDetailDao.get(id));

	}

	/**
	 * 修改产品详情信息
	 */
	@Override
	public void updateProductDetail(String productid, ProductDetail productDetail) {
		System.out.println(productid+"~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		Product product = productDao.get(productid);
		productDetail.setProduct(product);
		productDetailDao.update(productDetail);

	}
	
	//前端
	
	@Override
	public Product queryWebProductById(String productid) {
		
		return productDao.queryProductById(productid);
	}

	@Override
	public int queryWebProductCount(int routeid) {
		
		return productDao.queryWebProductCount(routeid);
	}

	@Override
	public List<Product> queryWebProduct(int currentPage,int pageSize,int routeid) {
		
		return productDao.queryWebProduct(currentPage, pageSize,routeid);
	}

	@Override
	public List<ProductDetail> queryWebProductDetail(String productid) {
		
		return productDetailDao.queryWebProduct(productid);
	}

	@Override
	public List<Object> vagueQueryProduct(Product product, String routename) {
	
		return productDao.avagueQueryProduct(product, routename);
	}

}
