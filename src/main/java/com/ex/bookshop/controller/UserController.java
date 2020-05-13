package com.ex.bookshop.controller;

import com.ex.bookshop.pojo.entity.Book;
import com.ex.bookshop.pojo.entity.Users;
import com.ex.bookshop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: Li Rui Qiang
 * @create: 2020-05-10 13:42
 **/
@Controller
public class UserController {
    @Resource
    UserService userService;


    /**
     * 跳转添加用户页面
     * @return
     */
    @RequestMapping("addUserPage")
    public String addUserPage(){
        return "back/addUser";
    }


    /**
     * 添加用户
     * @return
     */
    @RequestMapping("addUser")
    public String addUser(Users user, Model model){
        boolean res = userService.addUser(user);
        if(res){
            model.addAttribute("Msg","<script>alert('添加成功！');</script>");
            return "back/addUser";
        }else {
            model.addAttribute("Msg","<script>alert('添加失败！');</script>");
            return "back/addUser";
        }
    }

    /**
     * 用户管理返回所有用户列表
     * @param modelAndView
     * @param Msg
     * @return
     */
    @RequestMapping("adminUserPage")
    public ModelAndView adminBookPage(ModelAndView modelAndView, String Msg){
        modelAndView = new ModelAndView("back/adminUser");
        List<Users> usersList ;
        usersList = userService.findAllUsers();
        modelAndView.addObject("UList",usersList);
        if(Msg != null){
            modelAndView.addObject("Msg",Msg);
        }
        return modelAndView;
    }

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    @RequestMapping("delUser")
    public ModelAndView delUser(String id){
        ModelAndView modelAndView = new ModelAndView("redirect:adminUserPage");
        int uid = Integer.parseInt(id);
        boolean res = userService.delUser(uid);
        if(res){
            modelAndView.addObject("Msg","<script>alert('删除成功！');</script>");
            return modelAndView;
        }else{
            modelAndView.addObject("Msg","<script>alert('删除失败！');</script>");
            return modelAndView;
        }
    }

    /**
     * 跳转到用户信息修改页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("updateUserPage")
    public String updateBookPage(String id,Model model){
        int uid = Integer.parseInt(id);
        Users user = userService.selectUserById(uid);
        model.addAttribute("user",user);
        return "back/updateUser";
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @RequestMapping("updateUser")
    public ModelAndView updateBook(Users user){
        ModelAndView modelAndView = new ModelAndView("redirect:adminUserPage");
        boolean res = userService.updateUserById(user);
        if(res){
            modelAndView.addObject("Msg","<script>alert('修改成功！');</script>");
            return modelAndView;
        }else{
            modelAndView.addObject("Msg","<script>alert('修改失败！');</script>");
            return modelAndView;
        }
    }

}
