package com.ex.bookshop.pojo.entity;

import java.io.Serializable;

/**
 * book_order
 * @author 
 */
public class BookOrder implements Serializable {
    private Integer oId;

    private Integer uId;

    private String consignee;

    private Integer count;

    private Double payment;

    private String time;

    private String consigneeAdress;

    private String consigneeTel;

    private static final long serialVersionUID = 1L;

    public Integer getoId() {
        return oId;
    }

    public void setoId(Integer oId) {
        this.oId = oId;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getPayment() {
        return payment;
    }

    public void setPayment(Double payment) {
        this.payment = payment;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getConsigneeAdress() {
        return consigneeAdress;
    }

    public void setConsigneeAdress(String consigneeAdress) {
        this.consigneeAdress = consigneeAdress;
    }

    public String getConsigneeTel() {
        return consigneeTel;
    }

    public void setConsigneeTel(String consigneeTel) {
        this.consigneeTel = consigneeTel;
    }
}