package fun.peri.service.impl;

import java.util.List;

import fun.peri.service.IFinancialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fun.peri.dao.FinancialDao;

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
