package com.cissst.software.dao;

import com.cissst.software.model.CustomerEntity;

public interface ICustomerEntityDao {

	public void addCustomer(CustomerEntity customer);
	
	public boolean customerLogin(String customername,String password);
	
	public CustomerEntity queryWebCoustomr(String customername,String password);
}
