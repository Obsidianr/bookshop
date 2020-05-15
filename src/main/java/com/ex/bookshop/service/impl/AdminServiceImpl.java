package com.ex.bookshop.service.impl;

import com.ex.bookshop.dao.AdministratorDao;
import com.ex.bookshop.pojo.entity.Administrator;
import com.ex.bookshop.pojo.entity.Users;
import com.ex.bookshop.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: Li Rui Qiang
 * @create: 2020-05-10 14:38
 **/
@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    AdministratorDao administratorDao;

    @Override
    public boolean addAdmin(Administrator admin) {
        int res = administratorDao.insert(admin);
        if(res == 1){
            return true;
        }
        return false;
    }

    @Override
    public List<Administrator> findAllAdministrator() {
        List<Administrator> alist;
        alist = administratorDao.findAllAdmin();
        return alist;
    }

    @Override
    public boolean delAdmin(int aid) {
        int res = administratorDao.deleteByPrimaryKey(aid);
        if(res == 1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Administrator selectAdminById(int aid) {
        Administrator administrator = administratorDao.selectByPrimaryKey(aid);
        return administrator;
    }

    @Override
    public boolean updateAdminById(Administrator administrator) {
        int res = administratorDao.updateByPrimaryKey(administrator);
        if(res == 1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Integer login(String phone, String password) {
        Administrator admin =  administratorDao.selectBytel(phone);
        if(admin == null){
            return null;
        }else{
            if(admin.getPassword().equals(password)){
                return admin.getId();
            }
        }
        return null;
    }
}
