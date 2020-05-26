package com.ex.bookshop.service.impl;

import com.ex.bookshop.dao.BookDao;
import com.ex.bookshop.dao.BookOrderDao;
import com.ex.bookshop.dao.OrderInfoDao;
import com.ex.bookshop.dao.ShopCarDao;
import com.ex.bookshop.pojo.entity.*;
import com.ex.bookshop.pojo.vo.ShopcartItem;
import com.ex.bookshop.service.BookService;
import com.ex.bookshop.service.ShopCartService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @description:
 * @author: Li Rui Qiang
 * @create: 2020-05-20 11:14
 **/
@Service
public class ShopCartServiceImpl implements ShopCartService {
    @Resource
    ShopCarDao shopCarDao;
    @Resource
    BookService bookService;

    @Resource
    BookOrderDao bookOrderDao;

    @Resource
    ShopCartService shopCartService;

    @Resource
    OrderInfoDao orderInfoDao;

    /**
     * 根据用户id查询其购物车
     * @param userid
     * @return
     */
    @Override
    public ArrayList<ShopcartItem> findShopcartByUserid(Integer userid) {
        ArrayList<ShopcartItem> shopList = new ArrayList<>();

        ArrayList<ShopCar> shopCars = shopCarDao.selectByUserid(userid);
        if(shopCars.size() == 0 ){
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
    public boolean delShopItemById(Integer id) {
        int res = shopCarDao.deleteByPrimaryKey(id);
        if(res == 1){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 保存用户添加购物车的商品
     * @param userid
     * @param bid
     * @return
     */
    @Override
    public boolean addShopItemToCart(Integer userid, Integer bid) {
        try{
            ShopCar shopCar = shopCarDao.selectByUseridAndBid(userid,bid);
            if(shopCar == null){
                shopCar = new ShopCar();
                shopCar.setbId(bid);
                shopCar.setCount(1);
                shopCar.setuId(userid);
                shopCarDao.insert(shopCar);
                return true;
            }else {
                shopCar.setCount(shopCar.getCount() + 1);
                shopCarDao.updateByPrimaryKey(shopCar);
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 获取当前购物车中商品数量
     * @param userid
     * @return
     */
    @Override
    public Integer getShopCount(Integer userid) {
        ArrayList<ShopCar> shopCars = shopCarDao.selectByUserid(userid);
        int count = 0;
        for(ShopCar s: shopCars){
            count += s.getCount();
        }
        return count;
    }

    @Override
    public Integer GenerateOrder(Users receiver, ArrayList<ShopcartItem> billList,  double cost) {
        try{
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  // 设置日期格式
            String createTime = simpleDateFormat.format(new Date());
            BookOrder bookOrder = new BookOrder();
            bookOrder.setConsignee(receiver.getName());
            bookOrder.setConsigneeAdress(receiver.getAdress());
            bookOrder.setConsigneeTel(receiver.getTel());
            bookOrder.setcreateTime(createTime);
            bookOrder.setPayment(cost);
            bookOrder.setuId(receiver.getId());
            bookOrder.setState(1);
            bookOrderDao.insert(bookOrder);
            BookOrder bo = bookOrderDao.selectByUidAndCreateTime(bookOrder.getuId(),bookOrder.getcreateTime());
            for(ShopcartItem s: billList){
                OrderInfo orderInfo = new OrderInfo();
                orderInfo.setoId(bo.getoId());
                orderInfo.setbId(s.getbId());
                orderInfo.setCount(s.getCount());
                orderInfo.setOriginPrice(s.getPrice());
                orderInfoDao.insert(orderInfo);
                shopCartService.delShopItemById(s.getCarId());
            }
            return bookOrder.getoId();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 支付金额
     * @param oid
     * @return
     */
    @Override
    public boolean pay(Integer oid) {
        try {
            BookOrder bookOrder = bookOrderDao.selectByPrimaryKey(oid);
            bookOrder.setState(2);
            bookOrderDao.updateByPrimaryKey(bookOrder);
            return true;

        }catch (Exception e){
            return false;
        }

    }
}
