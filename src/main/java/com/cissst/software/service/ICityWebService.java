package com.cissst.software.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cissst.software.model.City;
@Service
public interface ICityWebService {

	public List<City> queryWebCity();
	public City queryWebCityById(int id);
}
