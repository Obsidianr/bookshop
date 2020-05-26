package com.ex.bookshop.pojo.vo;

import com.ex.bookshop.pojo.entity.Book;
import com.ex.bookshop.pojo.entity.OrderInfo;

import java.util.List;

/**
 * @description:
 * @author: Li Rui Qiang
 * @create: 2020-05-25 17:00
 **/

public class UserOrder {
    private Integer oId;

    private Integer uId;

    private String consignee;

    private Double payment;

    private String createTime;

    private String consigneeAdress;

    private String consigneeTel;

    private String finishTime;

    private List<Book> books;
    public List<Book> getBooks(){
        return books;
    }
    public void setBooks(List<Book> books){
        this.books = books;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    private Integer state;


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


    public Double getPayment() {
        return payment;
    }

    public void setPayment(Double payment) {
        this.payment = payment;
    }

    public String getcreateTime() {
        return createTime;
    }

    public void setcreateTime(String time) {
        this.createTime = time;
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

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }
}
