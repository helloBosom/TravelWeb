package fun.peri.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import fun.peri.model.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import fun.peri.service.ICustomerEntityService;

@Controller
@RequestMapping(value = "/customer")
public class CustomerEntityController {
	@Autowired
	private ICustomerEntityService customerEntityServiceImpl;

	@RequestMapping(value = "/addcustomer")
	public ModelAndView addUser(HttpServletRequest request, CustomerEntity customer) {
		System.out.println(customer.getCustomername());
		customerEntityServiceImpl.addCustomer(customer);
		System.out.println("over");
		ModelAndView mv = new ModelAndView();

		mv.setViewName("");
		return mv;

	}

	@RequestMapping(value = "/customerlogin")
	public ModelAndView customerLogin(HttpServletRequest request) {
		String customername = request.getParameter("customername");
		String password = request.getParameter("password");
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		if (customername != null & password != null) {
			boolean flag = customerEntityServiceImpl.customerLogin(customername, password);
			if (flag) {

				session.setAttribute("customername", customername);
				session.setAttribute("password", password);
			} else {
				// System.out.println("failure");
			}
		}
		return mv;
	}
}
