package com.ex.bookshop.dao;

import com.ex.bookshop.pojo.entity.Book;
import com.ex.bookshop.pojo.entity.ShopCar;
import com.ex.bookshop.pojo.vo.ShopcartItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

@Mapper
public interface BookDao {
    int deleteByPrimaryKey(Integer bId);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Integer bId);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);

    ArrayList<Book> selectAll();

    ArrayList<Book> selectByType(String bookType);

    ArrayList<Book> selectByPrimaryKeys(@Param("ids") ArrayList<ShopCar> shopCars);
}