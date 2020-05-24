package com.ex.bookshop.pojo.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * order_info
 * @author 
 */
public class OrderInfo implements Serializable {
    private Integer oiId;

    private Integer bId;

    private Integer oId;

    private Integer count;

    private double originPrice;

    private static final long serialVersionoId = 1L;

    public Integer getOiId() {
        return oiId;
    }

    public void setOiId(Integer oiId) {
        this.oiId = oiId;
    }

    public Integer getbId() {
        return bId;
    }

    public void setbId(Integer bId) {
        this.bId = bId;
    }

    public Integer getoId() {
        return oId;
    }

    public void setoId(Integer oId) {
        this.oId = oId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public double getOriginPrice() {
        return originPrice;
    }

    public void setOriginPrice(double originPrice) {
        this.originPrice = originPrice;
    }
}