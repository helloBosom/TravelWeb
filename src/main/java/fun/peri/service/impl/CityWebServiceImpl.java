package fun.peri.service.impl;

import fun.peri.dao.CityWebDao;
import fun.peri.model.City;
import fun.peri.service.ICityWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
