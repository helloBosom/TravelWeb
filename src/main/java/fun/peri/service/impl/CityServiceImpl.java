package fun.peri.service.impl;

import fun.peri.dao.CityDao;
import fun.peri.model.City;
import fun.peri.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements ICityService {

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
