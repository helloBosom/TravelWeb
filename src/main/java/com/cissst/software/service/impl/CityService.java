package com.cissst.software.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cissst.software.dao.CityDao;
import com.cissst.software.model.City;
import com.cissst.software.service.ICityService;

@Service
public class CityService implements ICityService {

	@Autowired 
	protected CityDao citydao;
	@Override
	public List<City> queryall() {
	
		return citydao.loadAll();
	}
	@Override
	public City getbyId(int id) {
		
		return citydao.get(id);
	}
	@Override
	public City queryCityById(int id) {
		
		return citydao.get(id);
	}
	@Override
	public void updateCity(City city) {
		citydao.update(city);
		
	}
	@Override
	public List<City> queryCityByCondition(Object[] parameters) {
		
		return citydao.queryCityByCondition(parameters);
	}
	@Override
	public void addCity(City city) {
		citydao.save(city);
	}
	@Override
	public void deleteCity(int id) {
		citydao.deleteCity(id);
		
	}

}
