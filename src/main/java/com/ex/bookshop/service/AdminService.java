package com.ex.bookshop.service;

import com.ex.bookshop.pojo.entity.Administrator;

import java.util.List;

public interface AdminService {

    boolean addAdmin(Administrator admin);

    List<Administrator> findAllAdministrator();

    boolean delAdmin(int aid);

    Administrator selectAdminById(int aid);

    boolean updateAdminById(Administrator administrator);
}
