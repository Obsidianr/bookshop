package com.ex.bookshop.controller;

import com.ex.bookshop.pojo.entity.*;
import com.ex.bookshop.pojo.vo.HistoryRecord;
import com.ex.bookshop.pojo.vo.UserOrder;
import com.ex.bookshop.service.AdminService;
import com.ex.bookshop.service.BookService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Li Rui Qiang
 * @create: 2020-05-10 11:59
 **/
@Controller
public class AdminController {

    @Resource
    AdminService adminService;

    @Resource
    BookService bookService;

    /**
     * 跳转添加管理员页面
     * @return
     */
    @RequestMapping("addAdminPage")
    public String addAdminPage(){
        return "back/addAdmin";
    }

    /**
     * 添加管理员
     * @param admin
     * @param model
     * @return
     */
    @RequestMapping("addAdmin")
    public String addAdmin(Administrator admin, Model model){
        boolean res = adminService.addAdmin(admin);
        if(res){
            model.addAttribute("Msg","<script>alert('添加成功！');</script>");
            return "back/addAdmin";
        }else {
            model.addAttribute("Msg","<script>alert('添加失败！');</script>");
            return "back/addAdmin";
        }
    }

    /**
     * 返回所有管理员信息
     * @return
     */
    @RequestMapping("adminAdministrator")
    public ModelAndView adminAd(ModelAndView modelAndView,String Msg){
        List<Administrator> aList;
        modelAndView = new ModelAndView("back/adminAdministrator");
        aList = adminService.findAllAdministrator();
        modelAndView.addObject("AdminList",aList);
        if(Msg != null){
            modelAndView.addObject("Msg",Msg);
        }
        return modelAndView;
    }

    /**
     * 删除管理员
     * @param id
     * @returnmodelAndView
     */
    @RequestMapping("delAdmin")
    public ModelAndView delAdmin(String id){
        ModelAndView modelAndView = new ModelAndView("redirect:adminAdministrator");
        int aid = Integer.parseInt(id);
        boolean res = adminService.delAdmin(aid);
        if(res){
            modelAndView.addObject("Msg","<script>alert('删除成功！');</script>");
            return modelAndView;
        }else{
            modelAndView.addObject("Msg","<script>alert('删除失败！');</script>");
            return modelAndView;
        }
    }

    /**
     * 跳转到管理员信息修改页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("updateAdminPage")
    public String updateAdminPage(String id,Model model){
        int aid = Integer.parseInt(id);
        Administrator administrator = adminService.selectAdminById(aid);
        model.addAttribute("admin",administrator);
        return "back/updateAdmin";
    }

    /**
     * 修改管理员信息
     * @param administrator
     * @return
     */
    @RequestMapping("updateAdmin")
    public ModelAndView updateAdmin(Administrator administrator){
        ModelAndView modelAndView = new ModelAndView("redirect:adminAdministrator");
        boolean res = adminService.updateAdminById(administrator);
        if(res){
            modelAndView.addObject("Msg","<script>alert('修改成功！');</script>");
            return modelAndView;
        }else{
            modelAndView.addObject("Msg","<script>alert('修改失败！');</script>");
            return modelAndView;
        }
    }

    /**
     * 确认订单页面
     * @param model
     * @return
     */
    @RequestMapping("checkOrderPage")
    public String checkOrder( Model model,String Msg){
        List<BookOrder> orderList = adminService.getCheckOrder();
        model.addAttribute("olist",orderList);
        if(Msg != null){
            model.addAttribute("Msg",Msg);
        }
        return "back/confirmOrder";
    }

    /**
     * 确认订单
     * @param id
     * @return
     */
    @RequestMapping("orderConfirm")
    public ModelAndView orderConfirm(Integer id, HttpSession session){
        ModelAndView modelAndView = new ModelAndView("redirect:checkOrderPage");
        boolean res = adminService.confirmOrder(id);
        if(res){
            session.setAttribute("checkOrderCount",(Integer)session.getAttribute("checkOrderCount")-1);
            return modelAndView;
        }else {
           modelAndView.addObject("Msg","<script>alert('提交失败！');</script>!");
            return modelAndView;
        }
    }

    /**
     * 订单详情
     * @return
     */
    @RequestMapping("orderDetailPage")
    public String orderDetailPage(Integer id, Model model){
        List<Book> bookList = adminService.getOrderDetailById(id);
        model.addAttribute("bookList",bookList);
        return "back/orderDetailPage";
    }

    /**
     * 显示书籍销售历史
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("sellHistoryPage")
    public String sellHistoryPage(Integer id,Model model){
        Book book = bookService.selectBookById(id);
        model.addAttribute("book",book);
        List<HistoryRecord> historyRecords = adminService.selectOrderByBid(id);
        model.addAttribute("historyRecords",historyRecords);
        return "back/sellHistory";
    }
}
