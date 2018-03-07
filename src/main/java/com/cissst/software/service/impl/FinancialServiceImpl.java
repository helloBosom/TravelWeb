package com.cissst.software.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cissst.software.dao.FinancialDao;
import com.cissst.software.service.IFinancialService;
@Service
public class FinancialServiceImpl implements IFinancialService {

	@Autowired
	private FinancialDao financialDao;
	
	@Override
	public List<Object[]> queryFinancial() {
		
		return financialDao.queryFinanical();
	}

	@Override
	public List<Object[]> queryByDay(String time,String productName) {
		
		return financialDao.queryByDay(time,productName);
	}

}
