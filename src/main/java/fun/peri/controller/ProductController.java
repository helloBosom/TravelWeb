package fun.peri.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fun.peri.comm.CommonConstant;
import fun.peri.model.Product;
import fun.peri.model.ViewRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fun.peri.model.ProductDetail;
import fun.peri.service.IProductService;


@Controller
@RequestMapping(value = "/product")
public class ProductController {

	@Autowired
	private IProductService productService;

	/**
	 * 添加产品
	 * 
	 * @param product
	 * @return
	 */
	@RequestMapping(value = "/addproduct")
	public String addProduct(String routename, Product product, HttpServletRequest request, ModelMap map) {
		ViewRoute route = productService.queryRouteByName(routename).get(0);
		/*
		 * System.out.println(route.getRouteid());
		 * System.out.println(route.getRoutename());
		 * System.out.println(route.getRoutestates());
		 * System.out.println(route.getRouteid());
		 * product.getRoute().setRouteid(route.getRouteid());
		 */
		product.setRoute(route);
		product.setStatus("0");
		productService.addProduct(product);
		return findProductByPage(request, map);
	}

	/**
	 * 查询全部产品信息
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/queryallproduct")
	public String queryAllProduct(ModelMap map) {

		List<Product> products = productService.queryAllProduct();
		map.put("products", products);
		return "admin/jsp/productdata/product_update3";
	}

	/**
	 * 分页查询
	 * 
	 * @param request
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/findbypage")
	public String findProductByPage(HttpServletRequest request, ModelMap map) {
		int totalRecords = productService.queryCount();
		int totalPages = totalRecords / CommonConstant.PAGE_SIZE;
		if (totalRecords % CommonConstant.PAGE_SIZE != 0) {
			totalPages++;
		}
		// System.out.println(totalPages+"--");
		// 获取当前页
		int currentPage = 1;
		String page = request.getParameter("currentpage");
		if (page != null && !("".equals(page))) {
			currentPage = Integer.parseInt(page);
		}
		// System.out.println(currentPage+"--!!!");
		// 调用业务逻辑层中的查询方法
		List<Object[]> details = productService.queryByPage(currentPage);
		// 跳转到显示页面
		map.put("details", details);
		map.put("totalPages", totalPages);
		map.put("currentpage", currentPage);
		map.put("count", productService.queryCount());
		return "admin/jsp/productdata/product_update3";
	}

	/**
	 * 修改操作input
	 */
	@RequestMapping(value = "/updateinput")
	public String updateProductInput(String productid, ModelMap map) {
		Product product = productService.queryProductById(productid);
		map.put("product", product);
		String routename = product.getRoute().getRoutename();
		/*
		 * System.out.println("修改inpit"); System.out.println(routename);
		 */
		map.put("routename", routename);
		return "admin/jsp/productdata/product_update4";
	}

	/**
	 * 修改操作
	 */
	@RequestMapping(value = "/updateproduct")
	public String updateProduct(String routename, Product product, HttpServletRequest request, ModelMap map) {
		ViewRoute route = productService.queryRouteByName(routename).get(0);
		product.setRoute(route);
		product.setStatus("0");

		productService.updateProduct(product);
		return findProductByPage(request, map);
	}

	/**
	 * 根据ID删除产品信息
	 * 
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/deleteproduct")
	public String deleteProductById(String productid, ModelMap map, HttpServletRequest request) {
		// System.out.println(productid);
		productService.deleteProduct(productid);
		return findProductByPage(request, map);
	}

	/**
	 * 根据ID查询详细信息
	 */
	@RequestMapping(value = "/querydetail")
	public String queryDetail(String productid, ModelMap map) {
		List<ProductDetail> details = productService.queryAllProductDetail(productid);
		map.put("details", details);
		return "admin/jsp/productdata/productdetaillist";
	}

	/**
	 * 查询数据库中的线路名称
	 */
	@RequestMapping(value = "/queryroutename")
	public String queryRouteName(ModelMap map) {
		List<Object[]> names = productService.queryRouteName();
		map.put("names", names);
		return "admin/jsp/productdata/product_add";
	}

	/**
	 * 查询所有产品名称
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/queryproductname")
	public String queryProductName(ModelMap map) {
		List<Object[]> productnames = productService.queryProductName();
		map.put("productnames", productnames);
		return "admin/jsp/productdata/product_detail_add";
	}

	/**
	 * 添加产品详细信息
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/addproductdetail")
	public String addProductDetail(String productname, ProductDetail productDetail, HttpServletRequest request,
			ModelMap map) {

		productService.addProductDetail(productDetail, productname);

		return findProductByPage(request, map);
	}

	/**
	 * 产品详细信息修改操作input
	 */
	@RequestMapping(value = "/updatedetailinpute")
	public String updateProductDetailInput(String id, ModelMap map) {
		ProductDetail productDetail = productService.queryProductDetailById(Integer.parseInt(id));
		map.put("productDetail", productDetail);
		map.put("productid", productDetail.getProduct().getProductid());
		return "admin/jsp/productdata/product_detail_update";
	}

	/**
	 * 修改操作
	 */
	@RequestMapping(value = "/updatedetail")
	public String updateProductDetail( ProductDetail productDetail, String productid,HttpServletRequest request,
			ModelMap map) {
		productService.updateProductDetail(productid, productDetail);
		return findProductByPage(request, map);
	}

	/**
	 * 根据ID删除产品详细信息
	 * 
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/deletedetail")
	public String deleteProductDetailById(String id, ModelMap map, HttpServletRequest request) {
		System.out.println("+++++");
		System.out.println(id+"++++++++++++++");
		productService.deleteProductDetailById(Integer.parseInt(id));
		return findProductByPage(request, map);
	}

	/**
	 * 模糊查询
	 */
	
	@RequestMapping(value = "/vaguequeryproduct")
	public String avageQueryProduct(String routename, ModelMap map,Product product) {
		System.out.println(product.getProductName());
		System.out.println(product.getStatus());
		System.out.println(routename);
		List<Object> details = productService.vagueQueryProduct(product, routename);
		System.out.println(details.size()+"size>>>>");
		map.put("details", details);
		return "admin/jsp/productdata/product_update3";
	}

	
}
