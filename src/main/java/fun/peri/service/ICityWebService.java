package fun.peri.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fun.peri.model.City;
@Service
public interface ICityWebService {

	public List<City> queryWebCity();
	public City queryWebCityById(int id);
}
