package fun.peri.service;

import java.util.List;

import fun.peri.model.ViewRoute;

public interface IViewRouteService {

	//-----------------------------------
	//查询线路
	public List<ViewRoute> queryAllViewRoute();
	
	public List<ViewRoute> queryLikeViewRoute(String key);
   
	//-------------------------------------
	//添加线路
	public void  addViewRoute(ViewRoute viewRoute);

	
	//--------------------------------------
	//修改线路
	public void updateViewRoute(ViewRoute viewRoute);
	
	//查询
	public ViewRoute queryViewRouteById(int routeid);
	
	//删除线路
	public void removeViewRoute(ViewRoute viewRoute);

	public int queryViewRouteCount(String routename);
	
	
	public List<ViewRoute> querypage(String routename,int currenpage,int pagesize);
	
	
	//前端
   public List<ViewRoute> queryWebViewRoute();
	
	public List<ViewRoute> queryWebViewRoute(final int currentPage,final int pageSize);
	
	public int queryWebViewRouteCount();
}
