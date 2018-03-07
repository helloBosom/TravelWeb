package com.cissst.software.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cissst.software.dao.ViewPointDao;
import com.cissst.software.dao.ViewSpaceDao;
import com.cissst.software.model.ViewPoint;
import com.cissst.software.model.ViewSpace;
import com.cissst.software.service.IViewSpaceService;


/**
 * 旅游网站的服务类S
 */
@Service(value = "viewSpaceService")
public class ViewSpaceService implements IViewSpaceService {

	@Autowired
	protected ViewSpaceDao viewSpaceDao;
	@Autowired
	protected ViewPointDao viewPointDao;
	
	// --------------------旅游景区维护------------------
	/**
	 * 新增一个旅游景区
	 * @param viewSpace
	 */
	public void addViewSpace(ViewSpace viewSpace) {
		viewSpaceDao.save(viewSpace);
	}

	/**
	 * 删除一个景区
	 * @param spaceId
	 */
	public void deleteViewSpace(int spaceId) {
		
		
        //删除景区		
		ViewSpace vs = viewSpaceDao.load(spaceId);
		viewSpaceDao.remove(vs);
		
	}

	/**
	 * 更改景区信息
	 * @param viewSpace
	 */
	public void updateViewSpace(ViewSpace viewSpace) {
		viewSpaceDao.update(viewSpace);
	}

	/**
	 * 根据景区名模糊查询所有匹配的景区
	 * @param name 查询条件
	 * @return
	 */
	public List<ViewSpace> queryViewSpaceByName(String name) {
		return viewSpaceDao.queryByName(name);
	}
	
	/**
	 * 获取所有景区对象
	 * @return
	 */
	public List<ViewSpace> getAllViewSpaces(){
		return viewSpaceDao.loadAll();
	}
    
	/**
	 * 获取某个景区对象及其关联的对象
	 * @param spaceId
	 * @return
	 */
	public ViewSpace getFullViewSpace(int spaceId) {
		ViewSpace vs = viewSpaceDao.get(spaceId);
		if (vs != null) {// 对ViewSpace的关联对象执行延迟加载初始化
			viewSpaceDao.initialize(vs.getViewPoints());
		}
		return vs;
	}
	
	/**
	 * 获取某个景区对象，关联的对象信息未加载
	 * @param spaceId
	 * @return
	 */
	public ViewSpace getViewSpace(int spaceId) {
		ViewSpace viewSpace = viewSpaceDao.get(spaceId);
		if(viewSpace!=null){
			viewSpaceDao.initialize(viewSpace);
		}
		return viewSpace;
	}

	
	

	// --------------------旅游景点维护------------------
	/**
	 * 添加一个景区
	 */
	public void addViewPoint(ViewPoint viewPoint) {
		viewPointDao.save(viewPoint);
	}
	
	/**
	 * 获取某个景点对象
	 * @param pointId
	 * @return
	 */
	public ViewPoint getFullViewPoint(int pointId) {
		ViewPoint vp = viewPointDao.get(pointId);
		//viewPointDao.initialize(vp.getViewSpace());
		return vp;
	}

	/**
	 * 删除某个景点对象
	 * @param pointId
	 */
	public void deleteViewPoint(int pointId) {
		ViewPoint vp = viewPointDao.load(pointId);
		viewPointDao.remove(vp);
	}

	/**
	 * 更改某个景点的信息
	 * @param viewPoint
	 */
	public void updateViewPoint(ViewPoint viewPoint) {
		/*System.out.println(viewPoint.getPointId()+"_____");
		ViewPoint vp =viewPointDao.load(viewPoint.getPointId());
		vp.setPointId(viewPoint.getPointId());
		vp.setPointName(viewPoint.getPointName());*/
		
		//System.out.println(vp+"--------");
		//viewPoint.setViewSpace(vp.getViewSpace());
		//viewPointDao.update(viewPoint);
		viewPointDao.update(viewPoint);
	}

	// -------------------------------------------------



	public void setViewSpaceDao(ViewSpaceDao viewSpaceDao) {
		this.viewSpaceDao = viewSpaceDao;
	}

	public void setViewPointDao(ViewPointDao viewPointDao) {
		this.viewPointDao = viewPointDao;
	}
	
	public List<ViewSpace> find(String hql, Object[] param, Integer page, Integer rows) {
		return viewSpaceDao.find(hql, param, page, rows);
	}

	public List<Object> count(String param){
		return viewSpaceDao.count(param);
	}

	@Override
	public List<ViewSpace> queryWebViewSpace(int currentPage, int pageSize) {
		return viewSpaceDao.queryWebViewSpace(currentPage, pageSize);
	}

	@Override
	public int queryWebViewSpaceCount() {
		return viewSpaceDao.count();
	}

}
