package com.ex.bookshop.dao;

import com.ex.bookshop.pojo.entity.Users;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;

@Mapper
public interface UsersDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

    /**
     * 根据电话号码查询用户
     * @param phone
     * @return
     */
    Users selectBytel(String phone);

    List<Users> findAllUsers();
}