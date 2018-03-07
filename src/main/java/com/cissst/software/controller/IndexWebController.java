package com.cissst.software.controller;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cissst.software.model.City;
import com.cissst.software.model.CustomerEntity;
import com.cissst.software.model.Order;
import com.cissst.software.model.OrderModel;
import com.cissst.software.model.Product;
import com.cissst.software.model.ProductDetail;
import com.cissst.software.model.TravelTailer;
import com.cissst.software.model.ViewRoute;
import com.cissst.software.model.ViewSpace;
import com.cissst.software.service.ICityWebService;
import com.cissst.software.service.ICustomerEntityService;
import com.cissst.software.service.IOrderService;
import com.cissst.software.service.IProductService;
import com.cissst.software.service.ITravelTailerService;
import com.cissst.software.service.IViewRouteService;
import com.cissst.software.service.IViewSpaceService;

@Controller
@RequestMapping(value = "/index")
public class IndexWebController {
	@Autowired
	private ICustomerEntityService customerEntityServiceImpl;
	@Autowired
	private IViewSpaceService viewSpaceServiceImpl;
	@Autowired
	private IViewRouteService viewRouteServiceImpl;
	@Autowired
	private IProductService productServiceImpl;
	@Autowired
	private IOrderService orderServiceImpl;
	@Autowired
	private ICityWebService cityWebServiceImpl;
	@Autowired
	private ITravelTailerService travelTailerServiceImpl;
	private int pageSize = 5;

	@RequestMapping(value = "/querybannerbasedata", method = { RequestMethod.GET, RequestMethod.POST })
	public void queryBannerBaseData(HttpServletRequest request, ModelMap map) {

		List<ViewSpace> viewSpaces = viewSpaceServiceImpl.queryWebViewSpace(1, 3);
		List<ViewSpace> viewSpaces1 = viewSpaceServiceImpl.queryWebViewSpace(2, 3);

		map.put("viewspaces", viewSpaces);
		map.put("viewspacess", viewSpaces1);
	}

	@RequestMapping(value = "/queryleftbasedata", method = { RequestMethod.GET, RequestMethod.POST })
	public void queryLeftBaseData(HttpServletRequest request, ModelMap map) {

		List<ViewRoute> viewRoutes = viewRouteServiceImpl.queryWebViewRoute(1, 6);

		map.put("viewroutes", viewRoutes);
	}

	/**
	 * 查询首页基本数据
	 * 
	 * @param request
	 * @return
	 */

	@RequestMapping(value = "/querybasedata", method = { RequestMethod.GET, RequestMethod.POST })
	public String queryBaseData(HttpServletRequest request, ModelMap map) {
		queryBannerBaseData(request, map);
		queryLeftBaseData(request, map);
		/*
		 * List<ViewSpace> viewSpaces =
		 * viewSpaceServiceImpl.queryWebViewSpace(1, 3); List<ViewSpace>
		 * viewSpaces1 = viewSpaceServiceImpl.queryWebViewSpace(2, 3);
		 * 
		 * 
		 * List<ViewRoute> viewRoutes =
		 * viewRouteServiceImpl.queryWebViewRoute(1,6);
		 */

		int currentpage = 1;
		String current = request.getParameter("currentPage");
		if (current != null) {
			currentpage = Integer.parseInt(current);
		}
		int totalRecord = viewRouteServiceImpl.queryWebViewRouteCount();
		int totalPage = totalRecord / pageSize;
		if ((totalRecord % pageSize) != 0) {
			totalPage++;
		}
		List<ViewRoute> viewRoutes1 = viewRouteServiceImpl.queryWebViewRoute(currentpage, pageSize);

		map.put("currentpage", currentpage);
		// map.put("viewroutes", viewRoutes);
		map.put("viewroutess", viewRoutes1);
		// map.put("viewspaces", viewSpaces);
		// map.put("viewspacess", viewSpaces1);
		map.put("totalPage", totalPage);

		return "web/index";
	}

	/**
	 * ͨ��more��ѯ�����б�
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/queryviewspace", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView queryWebViewSpace(HttpServletRequest request) {
		/**
		 * ��ȡͷ������Ļ���ݣ���ʾ����ҳ���棩
		 */
		List<ViewSpace> viewSpaces = viewSpaceServiceImpl.queryWebViewSpace(1, 3);
		List<ViewSpace> viewSpaces1 = viewSpaceServiceImpl.queryWebViewSpace(2, 3);
		/**
		 * ��ȡ·�߻���Ϣ����ʾ·������ߣ�
		 */

		List<ViewRoute> viewRoutes = viewRouteServiceImpl.queryWebViewRoute(1, 6);
		// ��������·�߷�ҳ����
		int currentPage = 1;
		String currPage = request.getParameter("currentPage");

		if (currPage != null) {
			currentPage = Integer.parseInt(currPage);
		}

		int totalRecords = viewSpaceServiceImpl.queryWebViewSpaceCount();
		int totalPages = totalRecords / pageSize;
		if (totalRecords % pageSize != 0) {
			totalPages++;
		}
		List<ViewSpace> viewSpaces3 = viewSpaceServiceImpl.queryWebViewSpace(currentPage, pageSize);

		ModelAndView mv = new ModelAndView();
		mv.addObject("currentpage", currentPage);
		mv.addObject("viewroutes", viewRoutes);
		mv.addObject("viewspacess", viewSpaces1);
		mv.addObject("viewspaces", viewSpaces);
		mv.addObject("viewspacesss", viewSpaces3);
		mv.addObject("totalPages", totalPages);
		mv.setViewName("web/scenic");
		return mv;
	}

	/**
	 * ͨ��ȥ��������ѯ��������
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/queryviewspacedetail", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView queryWebViewSpaceDetail(HttpServletRequest request) {
		/**
		 * ��ȡ·�߻���Ϣ����ʾ·������ߣ�
		 */

		List<ViewRoute> viewRoutes = viewRouteServiceImpl.queryWebViewRoute(1, 6);
		/**
		 * ���ID��ѯ������Ϣ���鼰������Ϣ
		 */
		int id = Integer.parseInt(request.getParameter("viewspaceid"));
		ViewSpace viewSpace = viewSpaceServiceImpl.getViewSpace(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("viewroutes", viewRoutes);
		mv.addObject("viewspace", viewSpace);
		mv.setViewName("web/scenicdetail");
		return mv;
	}

	/**
	 * ͨ��·���б?ȥ��������ѯ��Ӧ�Ĳ�Ʒ�б�
	 * 
	 * @param request
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/queryproductlist", method = { RequestMethod.GET, RequestMethod.POST })
	public String queryWebProductList(HttpServletRequest request, ModelMap map) {
		String routeid = request.getParameter("routeid");
		queryBannerBaseData(request, map);
		queryLeftBaseData(request, map);
		/**
		 * ��Ʒ��ҳ
		 */
		int currentPage = 1;
		String currPage = request.getParameter("currentPage");

		if (currPage != null) {
			currentPage = Integer.parseInt(currPage);
		}

		int totalRecords = productServiceImpl.queryWebProductCount(Integer.parseInt(routeid));

		int totalPages = totalRecords / pageSize;
		if (totalRecords % pageSize != 0) {
			totalPages++;
		}

		List<Product> products = productServiceImpl.queryWebProduct(currentPage, pageSize, Integer.parseInt(routeid));

		map.put("currentpage", currentPage);

		map.put("products", products);
		map.put("routeid", routeid);
		map.put("totalpages", totalPages);
		return "web/route_productlist";

	}

	/**
	 * ͨ��ȥ������ѯ��Ʒ����
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/queryproductdetail", method = { RequestMethod.GET, RequestMethod.POST })
	public String queryWebProductDetail(HttpServletRequest request, ModelMap map) {
		queryLeftBaseData(request, map);
		String productid = request.getParameter("productid");
		Product product = productServiceImpl.queryWebProductById(productid);
		List<ProductDetail> productdetails = productServiceImpl.queryWebProductDetail(productid);

		map.put("product", product);
		map.put("productdetails", productdetails);
		return "web/productdetail";

	}

	/**
	 * 旅游定制获取城市信息
	 * 
	 * @param request
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/querycity", method = { RequestMethod.GET, RequestMethod.POST })
	public String queryWebDetail(HttpServletRequest request, ModelMap map) {
		queryLeftBaseData(request, map);
		List<City> citys = cityWebServiceImpl.queryWebCity();

		map.put("citys", citys);

		return "web/citydisplay";

	}

	@RequestMapping(value = "/gaincity", method = { RequestMethod.GET, RequestMethod.POST })
	public String queryWebCity(HttpServletRequest request, ModelMap map, HttpSession session) {
		session.setAttribute("cityname", request.getParameter("citys"));
		session.setAttribute("startcity", request.getParameter("realname"));
		session.setAttribute("year", request.getParameter("year"));
		session.setAttribute("month", request.getParameter("month"));
		session.setAttribute("day", request.getParameter("day"));
		session.setAttribute("days", request.getParameter("tel"));
		session.setAttribute("peoplenumber", request.getParameter("peoplenumber"));
		session.setAttribute("avgexpense", request.getParameter("money"));
		session.setAttribute("remarks", request.getParameter("Content"));
		return "web/writephone";

	}

	/**
	 * 旅游定制
	 * 
	 * @param request
	 * @param map
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping(value = "/addtraveltailer", method = { RequestMethod.GET, RequestMethod.POST })
	public String addWebDetail(HttpServletRequest request, ModelMap map, HttpSession session) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");

		String cityname = (String) session.getAttribute("cityname");
		try {
			cityname = new String(cityname.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String startcity = (String) session.getAttribute("startcity");
		String startdate = (String) session.getAttribute("year") + "-" + (String) session.getAttribute("month") + "-"
				+ (String) session.getAttribute("day");
		String days = (String) session.getAttribute("days");
		String peoplenumber = (String) session.getAttribute("peoplenumber");
		String avgexpense = (String) session.getAttribute("avgexpense");
		String remarks = (String) session.getAttribute("remarks");
		String name = (String) session.getAttribute("customername");
		String telephone = request.getParameter("telephone");
		System.out.println("----------------------");
		System.out.println(cityname);
		System.out.println(startdate);

		TravelTailer traveltailer = new TravelTailer();
		traveltailer.setAvgexpense(Double.parseDouble(avgexpense));
		traveltailer.setCityname(cityname);
		traveltailer.setDays(Integer.parseInt(days));
		traveltailer.setName(name);
		traveltailer.setPeoplenumber(Integer.parseInt(peoplenumber));
		traveltailer.setRemarks(remarks);
		traveltailer.setStartcity(startcity);

		traveltailer.setStartdate(sdf.parse(startdate));
		traveltailer.setTelephone(telephone);

		travelTailerServiceImpl.addTravelTailer(traveltailer);

		return "index";
	}

	@RequestMapping(value = "/customerlogin")
	public String customerLogin(HttpServletRequest request, ModelMap map) {
		String customername = request.getParameter("customername");
		String password = request.getParameter("password");

		HttpSession session = request.getSession();
		if (customername != null && password != null) {
			boolean flag = customerEntityServiceImpl.customerLogin(customername, password);
			if (flag) {

				session.setAttribute("customername", customername);
				session.setAttribute("password", password);

			}
		}

		if ("invalidate".equals(request.getParameter("operation"))) {
			System.out.println("jj");
			session.invalidate();
		}
		return queryBaseData(request, map);

	}

	@RequestMapping(value = "/addcustomer")
	public String addUser(CustomerEntity customer, HttpServletRequest request, ModelMap map) {
		System.out.println(customer.getCustomername());
		customerEntityServiceImpl.addCustomer(customer);
		return queryBaseData(request, map);

	}

	@RequestMapping(value = "/gotoOrder", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView gotoOrder(HttpServletRequest request, HttpSession session, ModelMap map) throws ParseException {
		Object customername = session.getAttribute("customername");
		if (customername == null) {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("web/register");
			return mv;
		}
		queryLeftBaseData(request, map);
		String productId = request.getParameter("productid");
		if (productId != null) {
			OrderModel od = null;
			// type:0为产品，1为景区
			Product p = productServiceImpl.queryWebProductById(productId);
			od = new OrderModel();
			od.setProductId(productId);
			od.setType("0");
			od.setProductName(p.getProductName());
			od.setPrice(p.getPrice());
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
			String ab = sdf.format(new Date());
			Date dd = sdf.parse(ab);
			od.setOrderdate(dd);
			od.setpNum(1);
			List<OrderModel> lists = null;
			Object obj = session.getAttribute("orders");
			boolean flag = true;
			if (obj != null) {
				lists = (List<OrderModel>) obj;
				for (OrderModel m : lists) {
					String mid = m.getProductId();
					String oid = od.getProductId() + "";
					boolean a = mid.equals(oid);
					if (a) {
						flag = false;
					}
				}
				if (flag) {
					od.setNum(lists.size() + 1);
					lists.add(od);
					session.setAttribute("orders", lists);
				}
			} else {
				lists = new ArrayList<OrderModel>();
				od.setNum(1);
				lists.add(od);
				session.setAttribute("orders", lists);
			}
		}
		/*
		 * double sum =0; for(OrderModel m:lists){ sum +=
		 * m.getPrice()*m.getpNum(); }
		 */
		ModelAndView mv = new ModelAndView();
		// mv.addObject("sum",sum);
		mv.setViewName("web/shoppingcar");
		return mv;
	}

	@RequestMapping(value = "/savetosession", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView saveToSession(HttpServletRequest request, HttpSession session, ModelMap map) {
		queryLeftBaseData(request, map);
		Object obj = session.getAttribute("orders");
		String[] peoplenums = request.getParameterValues("peoplenum");
		List<OrderModel> orders = null;
		if (obj != null && peoplenums != null) {
			orders = (List<OrderModel>) obj;
			for (int i = 0; i < peoplenums.length; i++) {
				int peoplenum = Integer.parseInt(peoplenums[i]);
				orders.get(i).setpNum(peoplenum);
			}
			session.setAttribute("orders", orders);
		}
		ModelAndView mv = new ModelAndView();
		return mv;
	}

	@RequestMapping(value = "/orderdetail", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView gotoOrderDetail(HttpServletRequest request, HttpSession session, ModelMap map)
			throws ParseException {
		saveToSession(request, session, map);
		Object obj = session.getAttribute("orders");
		List<OrderModel> orders = null;
		if (obj != null) {
			String customername = (String) session.getAttribute("customername");
			String password = (String) session.getAttribute("password");
			orders = (List<OrderModel>) obj;
			int peoplenum = 0;
			double sum = 0;
			for (OrderModel m : orders) {
				int pnum = m.getpNum();
				double mnum = m.getPrice() * m.getpNum();
				peoplenum += pnum;
				sum += mnum;
			}
			CustomerEntity customer = customerEntityServiceImpl.queryWebCoustomr(customername, password);
			String telphone = customer.getIphone();

			ModelAndView mv = new ModelAndView();
			mv.addObject("peoplenum", peoplenum);
			mv.addObject("sum", sum);
			mv.addObject("telphone", telphone);
			mv.setViewName("web/orderdetail");
			return mv;
		} else {
			ModelAndView mv = new ModelAndView();
			mv = gotoOrder(request, session, map);
			return mv;
		}
	}

	@RequestMapping(value = "/gotoback", method = { RequestMethod.GET, RequestMethod.POST })
	public String gotoBack(HttpServletRequest request, HttpSession session, ModelMap map) {
		saveToSession(request, session, map);
		return queryBaseData(request, map);
	}

	@RequestMapping(value = "/delorderbyordernum", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView delOrderByOrdernum(HttpServletRequest request, HttpSession session, ModelMap map) {
		saveToSession(request, session, map);
		List<OrderModel> orders = (List<OrderModel>) session.getAttribute("orders");
		String orderNum = request.getParameter("ordernum");
		int ordernum = Integer.parseInt(orderNum);
		for (int i = 0; i < orders.size(); i++) {
			if (orders.get(i).getNum() == ordernum) {
				orders.remove(i);
			}
		}
		for (int i = ordernum - 1; i < orders.size(); i++) {
			orders.get(i).setNum(i + 1);
		}
		session.setAttribute("orders", orders);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("web/shoppingcar");
		return mv;
	}

	@RequestMapping(value = "/batchdelorder", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView batchDelOrder(HttpServletRequest request, HttpSession session, ModelMap map) {
		saveToSession(request, session, map);
		List<OrderModel> orders = (List<OrderModel>) session.getAttribute("orders");
		String[] orderNums = request.getParameterValues("ordernums");
		for (int i = 0; i < orderNums.length; i++) {
			int ordernum = Integer.parseInt(orderNums[i]);
			for (int j = 0; j < orders.size(); j++) {
				if (orders.get(j).getNum() == ordernum) {
					orders.remove(j);
				}
			}
		}
		for (int i = 0; i < orders.size(); i++) {
			orders.get(i).setNum(i + 1);
		}
		session.setAttribute("orders", orders);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("web/shoppingcar");
		return mv;
	}

	@RequestMapping(value = "/buyit", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView buyIt(HttpServletRequest request, HttpSession session) {
		String customername = request.getParameter("realname");
		String telnum1 = request.getParameter("telnum1");
		String telnum2 = request.getParameter("telnum2");
		String totalmoney = request.getParameter("money");
		String pay = request.getParameter("pay");
		Object obj = session.getAttribute("orders");

		if (obj != null) {
			List<OrderModel> orders = (List<OrderModel>) obj;
			for (OrderModel m : orders) {
				Order od = new Order();
				UUID uuid = UUID.randomUUID();
				od.setOrderNum(uuid.toString().replaceAll("-", ""));
				od.setCustomer(customername);
				od.setC_phone1(telnum1);
				od.setC_phone2(telnum2);
				double money = m.getPrice() * m.getpNum();
				od.setPayable(money);
				od.setUnPay(0.0);
				Product p = productServiceImpl.queryWebProductById(m.getProductId());
				od.setProduct(p);
				od.setSubmitDate(m.getOrderdate());
				od.setPeopleNum(m.getpNum());
				od.setOrderStatus("0");
				orderServiceImpl.addWebOrder(od);
			}
			session.removeAttribute("orders");
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("customername", customername);
		mv.addObject("telnum1", telnum1);
		mv.addObject("telnum2", telnum2);
		mv.setViewName("web/ordersuccess");
		return mv;
	}

}