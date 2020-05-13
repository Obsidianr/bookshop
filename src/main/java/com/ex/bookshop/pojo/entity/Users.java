package com.ex.bookshop.pojo.entity;

import java.io.Serializable;

/**
 * users
 * @author 
 */
public class Users implements Serializable {
    private Integer id;

    private String name;

    private String password;

    private String tel;

    private String adress;

    private String gende;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getGende() {
        return gende;
    }

    public void setGende(String gende) {
        this.gende = gende;
    }
}