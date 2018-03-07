package com.cissst.software.service;

import com.cissst.software.model.CustomerEntity;

public interface ICustomerEntityService {

	public void addCustomer(CustomerEntity customer);
	public boolean customerLogin(String customername,String password);
	
	public CustomerEntity queryWebCoustomr(String customername,String password);
}
