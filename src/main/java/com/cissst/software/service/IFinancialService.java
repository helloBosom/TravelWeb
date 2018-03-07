package com.cissst.software.service;

import java.util.List;

public interface IFinancialService {

	public List<Object[]> queryFinancial();
	public List<Object[]> queryByDay(String time,String productName);
}
