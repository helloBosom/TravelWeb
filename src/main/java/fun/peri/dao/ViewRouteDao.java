package fun.peri.dao;

import java.util.List;

import fun.peri.model.ViewRoute;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.stereotype.Repository;

@Repository
public class ViewRouteDao extends BaseDao<ViewRoute> {

	public List<ViewRoute> queryLikeViewRoute(String key){
		String hql = "from ViewRoute v where v.routename like '%"+key+"%'";
		return find(hql);
	}
	
	
	/**
	 *  分页查询全部路线
	 */
	public List<ViewRoute> queryViewRoute(final int currentPage,final int pageSize){
		final String hql="from ViewRoute";
		List<ViewRoute> results = this.getHibernateTemplate().execute(new HibernateCallback<List<ViewRoute>>(){

			@Override
			public List<ViewRoute> doInHibernate(Session session) throws HibernateException {
				List<ViewRoute> rows =session.createQuery(hql)
						.setFirstResult((currentPage-1)*pageSize)
						.setMaxResults(pageSize)
						.list();
			return rows;
				
			}});
		return results;
	}
	/**
	 * 查询路线记录数
	 * @return
	 */
	public int queryViewRouteCount(String routename){
		final String hql="select count(*) from ViewRoute where routename like ?";
		routename="%"+routename+"%";
		
		List<Object> results =find(hql,routename);
		int count = Integer.parseInt(results.get(0).toString());
		
		return count;
	}
	  
	public List<ViewRoute> querypage(String routename, int currenpage, int pagesize){
		String hql="from  ViewRoute where routename like ?";
		routename="%"+routename+"%";
		Object[] param={routename};
		List<ViewRoute> list=find(hql,param,currenpage,pagesize);
		return list;
	}
	
	
	//前端
	
	public List<ViewRoute> queryWebViewRoute(){
		return loadAll();
	}	
	
	public List<ViewRoute> queryWebViewRoute(final int currentPage,final int pageSize){
		final String hql="from ViewRoute";
		List<ViewRoute> results = this.getHibernateTemplate().execute(new HibernateCallback<List<ViewRoute>>(){

			@Override
			public List<ViewRoute> doInHibernate(Session session) throws HibernateException {
				List<ViewRoute> rows =session.createQuery(hql)
						.setFirstResult((currentPage-1)*pageSize)
						.setMaxResults(pageSize)
						.list();
			return rows;
				
			}});
		return results;
	}
	/**
	 * 查询路线记录数
	 * @return
	 */
	public int queryWebViewRouteCount(){
		final String hql="select count(*) from ViewRoute";
		List<Object> results = (List<Object>) this.getHibernateTemplate().find(hql, null);
		int count = Integer.parseInt(results.get(0).toString());
			
		return count;
	}
}
