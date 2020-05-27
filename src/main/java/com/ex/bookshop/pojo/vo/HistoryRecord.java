package com.ex.bookshop.pojo.vo;

/**
 * @description:
 * @author: Li Rui Qiang
 * @create: 2020-05-27 17:10
 **/

public class HistoryRecord {

    private Integer oId;

    private Integer count;

    private double originPrice;

    private String finishTime;

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

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }
}
