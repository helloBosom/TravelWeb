package fun.peri.dao;

import java.util.List;

import fun.peri.model.ViewSpace;
import org.springframework.stereotype.Repository;

/**
 * User对象Dao
 */
@Repository
public class ViewSpaceDao extends BaseDao<ViewSpace> {
	/**
	 * 根据风景区名进行模糊查询的方法
	 * 
	 * @param name
	 * @return 风景区名称包括<code>name</code>的所有记录
	 */
	public List<ViewSpace> queryByName(String name) {
		String hql = "from ViewSpace vs where vs.spaceName like ?";
		name = "%" + name + "%";
		return (List<ViewSpace>) find(hql, name);
	}
    
	/**
	 * 获取用户管理的所有景区
	 * @param userId 景区管理员的Id
	 * @return 
	 */
public List<ViewSpace> queryWebViewSpace(int currentPage, int pageSize) {
		String hql="from ViewSpace where spaceName like ?";
		Object[] param={"%%"};
		return find(hql, param, currentPage,pageSize);
		
	}
	 
	String hql="from ViewSpace where spaceName like ?";
	
	//查询总页数
	@SuppressWarnings("unchecked")
	public List<Object> count(String name) {
		String hql = "select count(*) from ViewSpace vs where vs.spaceName like ?";
		name = "%" + name+ "%";
		
		return (List<Object>) find(hql, name);
	}
	//查询总页数
		@SuppressWarnings("unchecked")
		public int count() {
			String hql = "select count(*) from ViewSpace vs where vs.spaceName like ?";
			Object[] param={"%%"};
			
			List<Object> list= find(hql,param);
			return Integer.parseInt(list.get(0).toString());
		}
	
}
