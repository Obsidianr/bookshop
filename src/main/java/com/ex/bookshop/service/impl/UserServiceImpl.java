package com.ex.bookshop.service.impl;

import com.ex.bookshop.dao.UsersDao;
import com.ex.bookshop.pojo.entity.Users;
import com.ex.bookshop.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: liruiqiang
 * @create: 2020-05-04 21:00
 **/

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UsersDao usersDao;

    /**
     * 验证用户是否存在
     * @param phone
     * @param password
     * @return
     */
    @Override
    public boolean login(String phone, String password) {
        Users user =  usersDao.selectBytel(phone);
        if(user == null){
            return false;
        }else{
            if(user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    /**
     * 添加用户到数据库
     * @param user
     * @return
     */
    @Override
    public boolean addUser(Users user) {
        int res = usersDao.insert(user);
        if(res == 1){
            return true;
        }
        return false;
    }

    @Override
    public List<Users> findAllUsers() {
        List<Users> usersList ;
        usersList = usersDao.findAllUsers();
        return usersList;
    }

    @Override
    public boolean delUser(int id) {
        int res = usersDao.deleteByPrimaryKey(id);
        if(res == 1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Users selectUserById(int uid) {
        Users user = usersDao.selectByPrimaryKey(uid);
        return user;
    }

    @Override
    public boolean updateUserById(Users user) {
        int res = usersDao.updateByPrimaryKey(user);
        if(res == 1){
            return true;
        }else{
            return false;
        }
    }
}
