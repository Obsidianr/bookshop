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

    private Integer uId;

    private Integer count;

    private BigDecimal originPrice;

    private static final long serialVersionUID = 1L;

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

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getOriginPrice() {
        return originPrice;
    }

    public void setOriginPrice(BigDecimal originPrice) {
        this.originPrice = originPrice;
    }
}