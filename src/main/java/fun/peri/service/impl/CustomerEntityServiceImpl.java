package fun.peri.service.impl;

import fun.peri.model.CustomerEntity;
import fun.peri.service.ICustomerEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerEntityServiceImpl implements ICustomerEntityService {
	@Autowired
	private CustomerEntityDao customerEntityDaoImpl;

	@Override
	public void addCustomer(CustomerEntity customer) {
		customerEntityDaoImpl.addCustomer(customer);
	}

	@Override
	public boolean customerLogin(String customername, String password) {
		// TODO Auto-generated method stub
		return customerEntityDaoImpl.customerLogin(customername, password);
	}

	@Override
	public CustomerEntity queryWebCoustomr(String customername, String password) {
		// TODO Auto-generated method stub
		return customerEntityDaoImpl.queryWebCoustomr(customername, password);
	}

}
