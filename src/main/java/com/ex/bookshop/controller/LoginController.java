package com.ex.bookshop.controller;

import com.ex.bookshop.pojo.entity.Administrator;
import com.ex.bookshop.pojo.entity.Users;
import com.ex.bookshop.service.AdminService;
import com.ex.bookshop.service.ShopCartService;
import com.ex.bookshop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 登录控制器
 * 进行登录验证
 * @author: liruiqiang
 * @create: 2020-05-04 18:55
 **/
@Controller
public class LoginController {

    @Resource
    UserService userService;

    @Resource
    AdminService adminService;
    @Resource
    ShopCartService shopCartService;

    /**
     * 跳转登录页面
     * @return
     */
    @RequestMapping("loginPage")
    String loginPage(){

        return "front/login";
    }


    /**
     * 登录验证
     * @return
     */
    @RequestMapping("doLogin")
    String login(HttpServletRequest httpServletRequest,String phone, String password, String admin, Model model,HttpSession session){
//        Pattern p = Pattern.compile("^((13[0-9])|(17[0-1,6-8])|(15[^4,\\\\D])|(18[0-9]))\\d{8}$");
//        Matcher m = p.matcher(phone);
//        if(!m.matches()){
//            model.addAttribute("errorMsg", "请输入正确的手机号！");
//            return "front/login";
//        }
        if(password == null || password == ""){
            model.addAttribute("errorMsg", "请输入密码！");
            return "front/login";
        }

        //判断管理员或用户登录
        if(admin == null){
            Users user = userService.login(phone,password);
            if(user != null){
                session.setAttribute("userid",user.getId());
                session.setAttribute("userName",user.getName());
                session.setAttribute("shopCount",shopCartService.getShopCount(user.getId()));
                session.setMaxInactiveInterval(1000);
                return "index";
            }else{
                model.addAttribute("errorMsg", "手机号或密码错误！");
                return "front/login";
            }

        }else{
            Administrator administrator = adminService.login(phone,password);
            if(administrator != null){
                Integer checkOrderCount = adminService.getCheckOrderCount();
                session.setAttribute("checkOrderCount",checkOrderCount);
                session.setAttribute("adminName",administrator.getName());
                session.setMaxInactiveInterval(1000);
                return "back/backHome";
            }else {
                model.addAttribute("errorMsg", "手机号或密码错误！");
                return "front/login";
            }
        }
    }
}