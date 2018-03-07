package com.cissst.software.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cissst.software.dao.ViewRouteDao;
import com.cissst.software.model.ViewRoute;
import com.cissst.software.service.IViewRouteService;


@Service(value="viewRouteServiceImpl")
public class ViewRouteServiceImpl implements IViewRouteService {

	@Autowired
	protected ViewRouteDao viewRouteDao;
	
	//-------------------------------
	//线路查询
	@Override
	public  List<ViewRoute>	queryAllViewRoute() {
		
		return viewRouteDao.loadAll();
	}

	//--------------------------------
	//添加线路
	@Override
	public void addViewRoute(ViewRoute viewRoute) {
		 viewRouteDao.save(viewRoute);
		
	}

	//------------------------------
	//修改线路
	@Override
	public void updateViewRoute(ViewRoute viewRoute) {
          viewRouteDao.update(viewRoute);
		
	}

	@Override
	public ViewRoute queryViewRouteById(int routeid) {
		
		return viewRouteDao.get(routeid);
	}

	@Override
	public List<ViewRoute> queryLikeViewRoute(String key) {
		return viewRouteDao.queryLikeViewRoute(key);
	}

	
	
    //删除
	@Override
	public void removeViewRoute(ViewRoute viewRoute) {
		viewRouteDao.remove(viewRoute);
		
	}

	//分页查询
	@Override
	public int queryViewRouteCount(String routename) {

		return viewRouteDao.queryViewRouteCount(routename);
	}

	@Override
	public List<ViewRoute> querypage(String routename, int currenpage, int pagesize) {
	
		return  viewRouteDao.querypage(routename, currenpage, pagesize);
	}

	@Override
	public List<ViewRoute> queryWebViewRoute() {
		// TODO Auto-generated method stub
		return viewRouteDao.queryWebViewRoute();
	}

	@Override
	public List<ViewRoute> queryWebViewRoute(int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		return viewRouteDao.queryWebViewRoute(currentPage, pageSize);
	}

	@Override
	public int queryWebViewRouteCount() {
		
		return viewRouteDao.queryWebViewRouteCount();
	}

}
