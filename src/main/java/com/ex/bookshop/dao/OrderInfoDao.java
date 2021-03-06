package com.ex.bookshop.dao;

import com.ex.bookshop.pojo.entity.OrderInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderInfoDao {
    int deleteByPrimaryKey(Integer oiId);

    int insert(OrderInfo record);

    int insertSelective(OrderInfo record);

    OrderInfo selectByPrimaryKey(Integer oiId);

    int updateByPrimaryKeySelective(OrderInfo record);

    int updateByPrimaryKey(OrderInfo record);

    List<OrderInfo> selectByOrderId(Integer id);

    List<OrderInfo> selectByBid(Integer id);
}