package fun.peri.dao;

import fun.peri.model.ViewPoint;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

/**
 * User对象Dao
 */
@Repository
public class ViewPointDao extends BaseDao<ViewPoint> {
	
	public void update(ViewPoint viewPoint) {    	
		
		
		/*ViewPoint vp =this.getHibernateTemplate().get(ViewPoint.class,viewPoint.getPointId());		
		vp.setViewSpace(vp.getViewSpace());*/
		System.out.println(viewPoint.getPointId()+" "+viewPoint.getPointName());
		this.getHibernateTemplate().update(viewPoint);
    }
}
