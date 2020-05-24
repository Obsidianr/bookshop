package com.ex.bookshop.dao;


import com.ex.bookshop.pojo.entity.ShopCar;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
@Mapper
public interface ShopCarDao {
    int deleteByPrimaryKey(Integer carId);

    int insert(ShopCar record);

    int insertSelective(ShopCar record);

    ShopCar selectByPrimaryKey(Integer carId);

    int updateByPrimaryKeySelective(ShopCar record);

    int updateByPrimaryKey(ShopCar record);

    ArrayList<ShopCar> selectByUserid(Integer userid);

    ShopCar selectByUseridAndBid(Integer userid, Integer bid);
}