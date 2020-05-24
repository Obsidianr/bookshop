package com.ex.bookshop.service;

import com.ex.bookshop.pojo.entity.Users;
import com.ex.bookshop.pojo.vo.ShopcartItem;

import java.util.ArrayList;

public interface ShopCartService {
    ArrayList<ShopcartItem> findShopcartByUserid(Integer userid);

    boolean delShopItemById(Integer id);

    boolean addShopItemToCart(Integer userid, Integer bid);

    Integer getShopCount(Integer userid);

    boolean GenerateOrder(Users receiver, ArrayList<ShopcartItem> billList,  double cost);
}
