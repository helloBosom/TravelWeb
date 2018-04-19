package fun.peri.dao;

import fun.peri.model.Menu;
import fun.peri.model.Role;
import fun.peri.model.RoleAndMenu;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("menuDao")
public class MenuDao extends BaseDao<Menu> {

    public List<Menu> findAll() {
        String hql = " from Menu m where m.menu is null ";
        List<Menu> menus = (List<Menu>) this.getHibernateTemplate().find(hql, null);
        return menus;
    }

    public List<Role> findAllRole() {
        String hql = "from Role";
        return (List<Role>) this.getHibernateTemplate().find(hql, null);
    }

    public List<Integer> findRoleAndMenuByRoleid(int roleid) {
        String hql = "select rm.rolemenuid from RoleAndMenu rm inner join rm.role r where r.roleid=?";
        List<Integer> roleMenuIds = (List<Integer>) this.getHibernateTemplate().find(hql, new Object[]{roleid});
        return roleMenuIds;
    }

    public void deleteRoleAndMenu(RoleAndMenu roleAndMenu) {
        this.getHibernateTemplate().delete(roleAndMenu);
    }

    public void saveRoleAndMenu(RoleAndMenu roleAndMenu) {
        this.getHibernateTemplate().save(roleAndMenu);
    }

    public void updateMenu() {
        this.getHibernateTemplate().execute(new HibernateCallback() {

            @Override
            public Object doInHibernate(Session session) throws HibernateException {
                String hql = "update Menu set checked=''";
                int count = session.createQuery(hql).executeUpdate();
                System.out.println(count);
                return null;
            }
        });

    }

    public void updateCheckedMenu(Menu menu) {
        super.update(menu);
    }

    public Menu findMenuEntityById(int menuId) {
        return super.get(menuId);
    }

    public List<Integer> findMenuIdByRoleid(int roleId) {
        String hql = "select m.id from RoleAndMenu rm inner join rm.menu m inner join rm.role r"
                + " where r.roleid=" + roleId;
        List<Integer> menuIds = (List<Integer>) this.getHibernateTemplate().find(hql, null);
        return menuIds;
    }
}
