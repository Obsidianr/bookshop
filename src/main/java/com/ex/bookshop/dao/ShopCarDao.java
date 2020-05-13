package com.ex.bookshop.dao;


import com.ex.bookshop.pojo.entity.ShopCar;

public interface ShopCarDao {
    int deleteByPrimaryKey(Integer carId);

    int insert(ShopCar record);

    int insertSelective(ShopCar record);

    ShopCar selectByPrimaryKey(Integer carId);

    int updateByPrimaryKeySelective(ShopCar record);

    int updateByPrimaryKey(ShopCar record);
}