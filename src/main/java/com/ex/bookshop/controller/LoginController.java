package com.ex.bookshop.controller;

import com.ex.bookshop.pojo.entity.Administrator;
import com.ex.bookshop.pojo.entity.Users;
import com.ex.bookshop.service.AdminService;
import com.ex.bookshop.service.ShopCartService;
import com.ex.bookshop.service.UserService;
import com.sun.deploy.net.HttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.*;
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
    String loginPage(HttpServletRequest request, Model model){
        String tel = "";
        String password = "";
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for (Cookie c: cookies) {
                if(c.getName().equals("userTel")){
                    tel = c.getValue();
                }
                if(c.getName().equals("password")){
                    password = c.getValue();
                }
            }
        }
        model.addAttribute("userTel",tel);
        model.addAttribute("password",password);
        return "front/login";
    }


    /**
     * 登录验证
     * @return
     */
    @RequestMapping("doLogin")
    String login(HttpServletResponse response, String phone, String password, String admin, Model model, HttpSession session){

        if(password == null || password == ""){
            model.addAttribute("errorMsg", "请输入密码！");
            return "front/login";
        }

        //判断管理员或用户登录
        if(admin == null){
            Users user = userService.login(phone,password);
            if(user != null){
                Cookie cookieTel = new Cookie("userTel",phone);
                Cookie cookiePassword = new Cookie("password",password);
                response.addCookie(cookieTel);
                response.addCookie(cookiePassword);
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
                Cookie cookieTel = new Cookie("userTel",phone);
                Cookie cookiePassword = new Cookie("password",password);
                response.addCookie(cookieTel);
                response.addCookie(cookiePassword);
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

    @RequestMapping("registerPage")
    public String registerPage(){
        return "front/register";
    }

    @RequestMapping("register")
    public String register(String username, String phone, String password, String address, String gende, Model model){
        Users user = userService.selectUserByTel(phone);
        if(user == null){
            user = new Users();
            user.setTel(phone);
            user.setName(username);
            user.setAdress(address);
            user.setPassword(password);
            user.setGende(gende);
            userService.addUser(user);
            model.addAttribute("Msg","<script>alert('注册成功');</script>");
            return "front/login";
        }else{
            model.addAttribute("Msg","<script>alert('手机号已存在');</script>");
            return "front/register";
        }

    }

    /**
     * 退出系统
     * @param session
     * @return
     */
    @RequestMapping("exit")
    public String exit(HttpSession session){
        session.invalidate();
        return "index";
    }

}