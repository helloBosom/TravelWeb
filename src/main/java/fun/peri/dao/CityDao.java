package fun.peri.dao;

import java.util.List;

import fun.peri.model.City;
import org.springframework.stereotype.Repository;

@Repository
public class CityDao extends BaseDao<City>{
	public void deleteCity(int id){
		City city=get(id);
		remove(city);
	}
	
public List<City> queryCityByCondition(Object[] parameters) {
		String hql="from City where id=? or cityname like ?";
		System.out.println("----");
		return find(hql,parameters);
	}
}
