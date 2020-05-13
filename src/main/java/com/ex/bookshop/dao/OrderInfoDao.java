package com.ex.bookshop.dao;

import com.ex.bookshop.pojo.entity.OrderInfo;

public interface OrderInfoDao {
    int deleteByPrimaryKey(Integer oiId);

    int insert(OrderInfo record);

    int insertSelective(OrderInfo record);

    OrderInfo selectByPrimaryKey(Integer oiId);

    int updateByPrimaryKeySelective(OrderInfo record);

    int updateByPrimaryKey(OrderInfo record);
}