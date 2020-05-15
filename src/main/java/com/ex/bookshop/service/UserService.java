package com.ex.bookshop.service;

import com.ex.bookshop.pojo.entity.Book;
import com.ex.bookshop.pojo.entity.Users;
import com.ex.bookshop.pojo.vo.ShopcartItem;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户业务服务
 * @author: liruiqiang
 * @create: 2020-05-04 20:54
 **/
public interface UserService {
    Integer login(String phone, String password);

    boolean addUser(Users user);

    List<Users> findAllUsers();

    boolean delUser(int id);

    Users selectUserById(int uid);

    boolean updateUserById(Users user);

    ArrayList<ShopcartItem> findShopcartByUserid(Integer userid);

    boolean delShopItemById(String id);
}
