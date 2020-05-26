package com.ex.bookshop.dao;

import com.ex.bookshop.pojo.entity.BookOrder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookOrderDao {
    int deleteByPrimaryKey(Integer oId);

    int insert(BookOrder record);

    int insertSelective(BookOrder record);

    BookOrder selectByPrimaryKey(Integer oId);

    int updateByPrimaryKeySelective(BookOrder record);

    int updateByPrimaryKey(BookOrder record);

    BookOrder selectByUidAndCreateTime(Integer uId, String createTime);

    List<BookOrder> selectUncheckedOrder();

    List<BookOrder> selectByUid(Integer userid);
}