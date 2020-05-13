package com.ex.bookshop.dao;

import com.ex.bookshop.pojo.entity.Comment;

public interface CommentDao {
    int deleteByPrimaryKey(Integer cId);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer cId);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);
}