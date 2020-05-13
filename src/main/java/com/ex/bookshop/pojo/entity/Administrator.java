package com.ex.bookshop.pojo.entity;

/**
 * @description:
 * @author: Li Rui Qiang
 * @create: 2020-05-10 12:03
 **/

public class Administrator {
    private Integer aId;

    private String name;

    private String password;

    private String tel;

    public Integer getId() {
        return aId;
    }

    public void setId(Integer aId) {
        this.aId = aId;
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
}
