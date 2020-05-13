package com.ex.bookshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description:
 * @author: Li Rui Qiang
 * @create: 2020-05-12 10:23
 **/
@Controller
public class OrderController {
    @RequestMapping("checkOrderPage")
    public String checkOrder(){
        return "back/checkOrder";
    }
}
