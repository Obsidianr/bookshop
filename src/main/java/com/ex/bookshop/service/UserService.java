package com.ex.bookshop.service;

import com.ex.bookshop.pojo.entity.Book;
import com.ex.bookshop.pojo.entity.Users;
import com.ex.bookshop.pojo.vo.ShopcartItem;
import com.ex.bookshop.pojo.vo.UserOrder;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户业务服务
 * @author: liruiqiang
 * @create: 2020-05-04 20:54
 **/
public interface UserService {
    Users login(String phone, String password);

    boolean addUser(Users user);

    List<Users> findAllUsers();

    boolean delUser(int id);

    Users selectUserById(int uid);

    boolean updateUserById(Users user);


    List<UserOrder> selectOrderByUid(Integer userid);

    Users selectUserByTel(String phone);
}
