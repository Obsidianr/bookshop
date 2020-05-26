package com.ex.bookshop.service.impl;

import com.ex.bookshop.dao.AdministratorDao;
import com.ex.bookshop.dao.BookDao;
import com.ex.bookshop.dao.BookOrderDao;
import com.ex.bookshop.dao.OrderInfoDao;
import com.ex.bookshop.pojo.entity.*;
import com.ex.bookshop.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: Li Rui Qiang
 * @create: 2020-05-10 14:38
 **/
@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    AdministratorDao administratorDao;

    @Resource
    BookOrderDao bookOrderDao;

    @Resource
    OrderInfoDao orderInfoDao;

    @Resource
    BookDao bookDao;

    @Override
    public boolean addAdmin(Administrator admin) {
        int res = administratorDao.insert(admin);
        if(res == 1){
            return true;
        }
        return false;
    }

    @Override
    public List<Administrator> findAllAdministrator() {
        List<Administrator> alist;
        alist = administratorDao.findAllAdmin();
        return alist;
    }

    @Override
    public boolean delAdmin(int aid) {
        int res = administratorDao.deleteByPrimaryKey(aid);
        if(res == 1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Administrator selectAdminById(int aid) {
        Administrator administrator = administratorDao.selectByPrimaryKey(aid);
        return administrator;
    }

    @Override
    public boolean updateAdminById(Administrator administrator) {
        int res = administratorDao.updateByPrimaryKey(administrator);
        if(res == 1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Administrator login(String phone, String password) {
        Administrator admin =  administratorDao.selectBytel(phone);
        if(admin == null){
            return null;
        }else{
            if(admin.getPassword().equals(password)){
                return admin;
            }
        }
        return null;
    }

    @Override
    public Integer getCheckOrderCount() {
        List<BookOrder> orderlist = bookOrderDao.selectUncheckedOrder();
        return orderlist.size();
    }

    @Override
    public List<BookOrder> getCheckOrder() {
        List<BookOrder> orderlist = bookOrderDao.selectUncheckedOrder();
        return orderlist;
    }

    @Override
    public boolean confirmOrder(Integer id) {
        try{
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  // 设置日期格式
            String finishTime = simpleDateFormat.format(new Date());
            BookOrder bookOrder = bookOrderDao.selectByPrimaryKey(id);
            bookOrder.setState(3);
            bookOrder.setFinishTime(finishTime);
            bookOrderDao.updateByPrimaryKey(bookOrder);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public List<Book> getOrderDetailById(Integer id) {
        List<OrderInfo> olist = orderInfoDao.selectByOrderId(id);
        List<Book> bookList = new ArrayList<>();
        for(OrderInfo o: olist){
            Book book = bookDao.selectByPrimaryKey(o.getbId());
            book.setPrice(o.getOriginPrice());
            book.setStock(o.getCount());
            bookList.add(book);
        }
        return bookList;
    }
}
