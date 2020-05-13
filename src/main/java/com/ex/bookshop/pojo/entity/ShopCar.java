package com.ex.bookshop.pojo.entity;

import java.io.Serializable;

/**
 * shop_car
 * @author 
 */
public class ShopCar implements Serializable {
    private Integer carId;

    private Integer uId;

    private Integer bId;

    private Integer count;

    private static final long serialVersionUID = 1L;

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer getbId() {
        return bId;
    }

    public void setbId(Integer bId) {
        this.bId = bId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}