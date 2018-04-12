package fun.peri.service;

import fun.peri.model.ViewPoint;
import fun.peri.model.ViewSpace;

import java.util.List;

/**
 * 旅游网站的服务类
 */
public interface IViewSpaceService {

    // --------------------旅游景区维护------------------

    /**
     * 获取一个旅游景区
     *
     * @param viewSpace
     */


    public ViewSpace getViewSpace(int spaceId);

    /**
     * 新增一个旅游景区
     *
     * @param viewSpace
     */
    public void addViewSpace(ViewSpace viewSpace);

    /**
     * 删除一个景区
     *
     * @param spaceId
     */
    public void deleteViewSpace(int spaceId);

    /**
     * 更改景区信息
     *
     * @param viewSpace
     */
    public void updateViewSpace(ViewSpace viewSpace);

    /**
     * 根据景区名模糊查询所有匹配的景区
     *
     * @param name 查询条件
     * @return
     */
    public List<ViewSpace> queryViewSpaceByName(String name);

    /**
     * 获取所有景区对象
     *
     * @return
     */
    public List<ViewSpace> getAllViewSpaces();

    // -------------------------------------------------

    // --------------------旅游景点维护------------------

    /**
     * 添加一个景区
     */
    public void addViewPoint(ViewPoint viewPoint);

    /**
     * 获取某个景点对象
     *
     * @param pointId
     * @return
     */
    public ViewPoint getFullViewPoint(int pointId);


    /**
     * 更改某个景点对象
     *
     * @param pointId
     */
    public void updateViewPoint(ViewPoint vp);


    /**
     * 删除某个景点对象
     *
     * @param pointId
     */
    public void deleteViewPoint(int pointId);

    // -------------------------------------------------
    //分页查询
    public List<ViewSpace> find(String hql, Object[] param, Integer page, Integer rows);

    //总页数
    public List<Object> count(String param);

    public List<ViewSpace> queryWebViewSpace(int currentPage, int pageSize);

    public int queryWebViewSpaceCount();

}
