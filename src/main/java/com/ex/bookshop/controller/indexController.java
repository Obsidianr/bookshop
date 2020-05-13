package com.ex.bookshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: liruiqiang
 * @create: 2020-05-06 12:41
 **/
@Controller
public class indexController {
    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("now",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        return "index";
    }
}
