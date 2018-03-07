package com.cissst.software.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cissst.software.dao.ICustomerEntityDao;
import com.cissst.software.model.CustomerEntity;
import com.cissst.software.service.ICustomerEntityService;

@Service
public class CustomerEntityServiceImpl implements ICustomerEntityService {
	@Autowired
	private ICustomerEntityDao customerEntityDaoImpl;

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
