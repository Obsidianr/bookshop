package com.ex.bookshop.service.impl;

import com.ex.bookshop.dao.*;
import com.ex.bookshop.pojo.entity.*;
import com.ex.bookshop.pojo.vo.ShopcartItem;
import com.ex.bookshop.pojo.vo.UserOrder;
import com.ex.bookshop.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: liruiqiang
 * @create: 2020-05-04 21:00
 **/

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UsersDao usersDao;

    @Resource
    BookOrderDao bookOrderDao;
    @Resource
    OrderInfoDao orderInfoDao;
    @Resource
    BookDao bookDao;


    /**
     * 验证用户是否存在
     * @param phone
     * @param password
     * @return
     */
    @Override
    public Users login(String phone, String password) {
        Users user =  usersDao.selectBytel(phone);
        if(user == null){
            return null;
        }else{
            if(user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }

    /**
     * 添加用户到数据库
     * @param user
     * @return
     */
    @Override
    public boolean addUser(Users user) {
        int res = usersDao.insert(user);
        if(res == 1){
            return true;
        }
        return false;
    }

    /**
     * 查询所有用户
     * @return
     */
    @Override
    public List<Users> findAllUsers() {
        List<Users> usersList ;
        usersList = usersDao.findAllUsers();
        return usersList;
    }

    /**
     * 按id删除用户
     * @param id
     * @return
     */
    @Override
    public boolean delUser(int id) {
        int res = usersDao.deleteByPrimaryKey(id);
        if(res == 1){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 根据id查询用户
     * @param uid
     * @return
     */
    @Override
    public Users selectUserById(int uid) {
        Users user = usersDao.selectByPrimaryKey(uid);
        return user;
    }

    /**
     * 按id修改用户信息
     * @param user
     * @return
     */
    @Override
    public boolean updateUserById(Users user) {
        int res = usersDao.updateByPrimaryKey(user);
        if(res == 1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public List<UserOrder> selectOrderByUid(Integer userid) {
        List<UserOrder> userOrders = new ArrayList<>();
        List<BookOrder> bookOrders = bookOrderDao.selectByUid(userid);
        for(BookOrder bo: bookOrders){

            UserOrder userOrder = new UserOrder();
            userOrder.setConsignee(bo.getConsignee());
            userOrder.setConsigneeAdress(bo.getConsigneeAdress());
            userOrder.setConsigneeTel(bo.getConsigneeTel());
            userOrder.setcreateTime(bo.getcreateTime());
            userOrder.setFinishTime(bo.getFinishTime());
            userOrder.setoId(bo.getoId());
            userOrder.setPayment(bo.getPayment());
            userOrder.setState(bo.getState());
            userOrder.setuId(bo.getuId());
            List<OrderInfo> orderInfos = orderInfoDao.selectByOrderId(bo.getoId());
            List<Book> bookList = bookDao.selectByPrimaryKeysOrderInfo(orderInfos);
            for (OrderInfo o:orderInfos) {
                for (Book b: bookList) {
                    if(b.getbId() == o.getbId()){
                        b.setStock(o.getCount());
                        b.setPrice(o.getOriginPrice());
                    }
                }
            }
            userOrder.setBooks(bookList);
            userOrders.add(userOrder);
        }
        return userOrders;
    }

    @Override
    public Users selectUserByTel(String phone) {
        Users user =  usersDao.selectBytel(phone);
        return user;
    }


}
