package fun.peri.service.impl;

import fun.peri.dao.AdministratorManageDao;
import fun.peri.model.Administrator;
import fun.peri.model.AdministratorAndRole;
import fun.peri.model.Role;
import fun.peri.service.IAdministratorManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("administratorManageServiceImpl")
public class AdministratorManageServiceImpl implements IAdministratorManageService {

    private final AdministratorManageDao administratorManageDao;

    @Autowired
    public AdministratorManageServiceImpl(AdministratorManageDao administratorManageDao) {
        this.administratorManageDao = administratorManageDao;
    }

    @Override
    public List<Role> findRole() {
        return administratorManageDao.findAllRole();
    }

    @Override
    public void addAdministrator(Administrator administrator) {
        administratorManageDao.addAdministrator(administrator);
    }

    @Override
    public void saveRoleById(AdministratorAndRole administratorAndRole) {
        administratorManageDao.saveRoleById(administratorAndRole);
    }

    @Override
    public List<Administrator> findAllAdministrator() {
        return administratorManageDao.findAllAdministrator();
    }

    @Override
    public List findRoleNameByAdminId(int id) {
        return administratorManageDao.findRoleNameByAdminId(id);
    }

    @Override
    public void deleteAdministratorById(int[] id) {
        administratorManageDao.deleteAdministratorById(id);
    }

    @Override
    public Administrator findAdministratorById(int id) {
        return administratorManageDao.findAdministratorById(id);
    }

    @Override
    public List<Integer> findAdministratorAndRoleId(int adminId) {
        return administratorManageDao.findAdministratorAndRoleId(adminId);
    }

    @Override
    public void deleteAdminAndRole(AdministratorAndRole adminAndRole) {
        administratorManageDao.deleteAdminAndRole(adminAndRole);
    }

    @Override
    public void updateAdministrator(Administrator admin) {
        administratorManageDao.update(admin);
    }
}
