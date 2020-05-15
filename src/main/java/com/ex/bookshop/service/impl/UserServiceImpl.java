package com.ex.bookshop.service.impl;

import com.ex.bookshop.dao.BookDao;
import com.ex.bookshop.dao.ShopCarDao;
import com.ex.bookshop.dao.UsersDao;
import com.ex.bookshop.pojo.entity.Book;
import com.ex.bookshop.pojo.entity.ShopCar;
import com.ex.bookshop.pojo.entity.Users;
import com.ex.bookshop.pojo.vo.ShopcartItem;
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
    ShopCarDao shopCarDao;

    @Resource
    BookServiceImpl bookService;


    /**
     * 验证用户是否存在
     * @param phone
     * @param password
     * @return
     */
    @Override
    public Integer login(String phone, String password) {
        Users user =  usersDao.selectBytel(phone);
        if(user == null){
            return null;
        }else{
            if(user.getPassword().equals(password)){
                return user.getId();
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

    /**
     * 根据用户id查询其购物车
     * @param userid
     * @return
     */
    @Override
    public ArrayList<ShopcartItem> findShopcartByUserid(Integer userid) {
        ArrayList<ShopcartItem> shopList = new ArrayList<>();

        ArrayList<ShopCar> shopCars = shopCarDao.selectByUserid(userid);
        if(shopCars == null){
            return null;
        }else{
            ArrayList<Book> bookList = bookService.selectBookByIds(shopCars);
            for (int i=0;i<shopCars.size();i++){
                ShopcartItem item = new ShopcartItem();
                item.setCarId(shopCars.get(i).getCarId());
                item.setbId(shopCars.get(i).getbId());
                item.setBookName(bookList.get(i).getBookName());
                item.setAuthor(bookList.get(i).getAuthor());
                item.setPrice(bookList.get(i).getPrice());
                item.setImg(bookList.get(i).getImg());
                item.setCount(shopCars.get(i).getCount());
                item.setPublisher(bookList.get(i).getPublisher());
                shopList.add(item);
            }
            return shopList;
        }
    }

    /**
     * 按id删除用户购物车中的项目
     * @param id
     * @return
     */
    @Override
    public boolean delShopItemById(String id) {
        int cid = Integer.parseInt(id);
        int res = shopCarDao.deleteByPrimaryKey(cid);
        if(res == 1){
            return true;
        }else{
            return false;
        }
    }
}
