package com.ex.bookshop.service;

import com.ex.bookshop.pojo.entity.Administrator;
import com.ex.bookshop.pojo.entity.Book;
import com.ex.bookshop.pojo.entity.BookOrder;
import com.ex.bookshop.pojo.entity.OrderInfo;
import com.ex.bookshop.pojo.vo.HistoryRecord;
import com.ex.bookshop.pojo.vo.UserOrder;

import java.util.ArrayList;
import java.util.List;

public interface AdminService {

    boolean addAdmin(Administrator admin);

    List<Administrator> findAllAdministrator();

    boolean delAdmin(int aid);

    Administrator selectAdminById(int aid);

    boolean updateAdminById(Administrator administrator);

    Administrator login(String phone, String password);

    Integer getCheckOrderCount();

    List<BookOrder> getCheckOrder();

    boolean confirmOrder(Integer id);

    List<Book> getOrderDetailById(Integer id);

    List<HistoryRecord> selectOrderByBid(Integer id);
}
