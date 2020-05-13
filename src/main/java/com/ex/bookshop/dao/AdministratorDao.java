package com.ex.bookshop.dao;


import com.ex.bookshop.pojo.entity.Administrator;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdministratorDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Administrator record);

    int insertSelective(Administrator record);

    Administrator selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Administrator record);

    int updateByPrimaryKey(Administrator record);

    List<Administrator> findAllAdmin();
}
