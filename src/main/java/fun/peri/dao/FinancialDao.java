package fun.peri.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.stereotype.Repository;

@Repository(value="financialDao")
public class FinancialDao extends BaseDao<Object> {

	/**
	 * 查询所有财务情况
	 * @return
	 */
	public List<Object[]> queryFinanical(){		
		final String hql = "select o.submitDate,p.productName,sum(o.peopleNum),sum(o.payable) from Order o inner join "
				+ "o.product p group by p.productName";
		List<Object[]> orderInfo = this.getHibernateTemplate().execute(new HibernateCallback<List<Object[]>>() {
			@Override
			public List<Object[]> doInHibernate(Session session) throws HibernateException {
				List<Object[]> results = (List<Object[]>) session.createQuery(hql).list();		
				return results;
			}			
		});	
		for(Object[] obj:orderInfo)
			System.out.println(obj[0]+" "+obj[1]+" "+obj[2]+" "+obj[3]);
		return orderInfo;
			
	}
	/**
	 * 根据日期查询
	 * @return
	 */
	public List<Object[]> queryByDay(String time,String productName){
		System.out.println("OOOOO");
		final String hql = "select o.submitDate,p.productName,sum(o.peopleNum),sum(o.payable) "
				+ "from Order o inner join o.product p "
				+ "where o.submitDate like '%"+time+"%'and p.productName like '%"+productName+"%' "
						+ "group by p.productName";
		List<Object[]> orderInfo = this.getHibernateTemplate().execute(new HibernateCallback<List<Object[]>>() {
			@Override
			public List<Object[]> doInHibernate(Session session) throws HibernateException {
				List<Object[]> results = (List<Object[]>) session.createQuery(hql).list();		
				return results;
			}			
		});	
		for(Object[] obj:orderInfo)
			System.out.println(obj[0]+" "+obj[1]+" "+obj[2]+" "+obj[3]+"okokokok");
		return orderInfo;		
	}
}
