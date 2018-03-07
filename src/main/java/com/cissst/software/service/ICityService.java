package com.cissst.software.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cissst.software.model.City;

@Service
public interface ICityService {
	 
	public List<City> queryall();
	public City getbyId(int id);
	public City queryCityById(int parseInt);
	public void updateCity(City city);
	public List<City> queryCityByCondition(Object[] parameters);
	public void addCity(City city);
	public void deleteCity(int parseInt);
}
