package com.cissst.software.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cissst.software.dao.CityWebDao;
import com.cissst.software.model.City;
import com.cissst.software.service.ICityWebService;

@Service(value = "cityWebServiceImpl")
public class CityWebServiceImpl implements ICityWebService {
	@Autowired
	private CityWebDao cityWebDao;

	@Override
	public List<City> queryWebCity() {

		return cityWebDao.loadAll();
	}

	@Override
	public City queryWebCityById(int id) {

		return cityWebDao.get(id);
	}

}
