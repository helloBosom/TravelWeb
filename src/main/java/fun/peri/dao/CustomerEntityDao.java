package fun.peri.dao;

import fun.peri.model.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerEntityDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void addCustomer(CustomerEntity customer) {
        this.getHibernateTemplate().save(customer);
    }

    public boolean customerLogin(String customername, String password) {
        String hql = "select count(*) from CustomerEntity c where c.customername='" + customername + "'  and c.password='" + password
                + "'";
        List<Object> results = (List<Object>) this.getHibernateTemplate().find(hql, null);
        int count = Integer.parseInt(results.get(0).toString());
        if (count > 0) {
            return true;
        } else {
            return false;
        }
    }

    public CustomerEntity queryWebCoustomr(String customername, String password) {
        String hql = "from CustomerEntity c where c.customername='" + customername + "'  and c.password='" + password + "'";
        List<CustomerEntity> results = (List<CustomerEntity>) this.getHibernateTemplate().find(hql, null);
        return results.get(0);
    }
}
