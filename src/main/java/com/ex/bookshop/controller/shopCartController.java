package com.ex.bookshop.controller;

import com.alibaba.fastjson.JSON;
import com.ex.bookshop.pojo.entity.Users;
import com.ex.bookshop.pojo.vo.ShopcartItem;
import com.ex.bookshop.pojo.vo.CartInfo;
import com.ex.bookshop.service.ShopCartService;

import com.ex.bookshop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Li Rui Qiang
 * @create: 2020-05-20 11:05
 **/
@Controller
public class shopCartController {
    @Resource
    ShopCartService shopCartService;
    @Resource
    UserService userService;


    /**
     * 根据用户id显示用户购物车
     * @return
     */
    @RequestMapping("shopcartPage")
    public ModelAndView showShopcartPage(ModelAndView modelAndView, String Msg){
        Integer userid = (Integer)((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession().getAttribute("userid");
        if(userid == null){
            modelAndView = new ModelAndView("front/login");
        }else{
            modelAndView = new ModelAndView("front/shopcart");
            ArrayList<ShopcartItem> shoppingList = shopCartService.findShopcartByUserid(userid);
            if(shoppingList == null){
                modelAndView.addObject("Msg","购物车空空如也！");
            }else{

                modelAndView.addObject("shoppingList",shoppingList);
                modelAndView.addObject("shopCount",shoppingList.size());
            }

        }
        if(Msg != null){
            modelAndView.addObject("Msg",Msg);
        }
        return modelAndView;
    }

    /**
     * 删除购物车中商品
     * @param id
     * @param session
     * @return
     */
    @RequestMapping("delshopItem")
    public ModelAndView delshopItem(Integer id, HttpSession session){
        ModelAndView modelAndView = new ModelAndView("redirect:shopcartPage");
        boolean res = shopCartService.delShopItemById(id);
        if(res){
            modelAndView.addObject("Msg","<script>alert('删除成功！');</script>");
            session.setAttribute("shopCount", shopCartService.getShopCount((Integer)session.getAttribute("userid")));
            return modelAndView;
        }else{
            modelAndView.addObject("Msg","<script>alert('删除失败！');</script>");
            return modelAndView;
        }
    }

    /**
     * 添加商品到购物车
     * @param id
     * @param session
     * @return
     */
    @RequestMapping("addShopToCart")
    public ModelAndView addShop(Integer id, HttpSession session){
        ModelAndView modelAndView;
        Integer userid = (Integer) session.getAttribute("userid");
        if(userid == null){
            modelAndView = new ModelAndView("front/login");
            return modelAndView;
        }
        boolean res = shopCartService.addShopItemToCart(userid, id);
        modelAndView = new ModelAndView( "redirect:bookDetail?id="+ id);
        if(res){
            Integer count = (Integer)session.getAttribute("shopCount");
            session.setAttribute("shopCount", ++count);
//            modelAndView.addObject("Msg","<script>alert('添加成功！')</script>");
            return modelAndView;
        }else{
            modelAndView.addObject("Msg","<script>alert('添加失败！')</script>");
            return modelAndView;
        }
    }

    /**
     * 结算确认
     * @param
     * @return
     */
    @RequestMapping("doBill")
    public String  doBill(String cartInfo, HttpSession session,Model model){
        double sum = 0;
        ArrayList<ShopcartItem> billList = new ArrayList<>();
        List<CartInfo> carts = JSON.parseArray(cartInfo, CartInfo.class);
        Integer userid = (Integer) session.getAttribute("userid");
        ArrayList<ShopcartItem> shoppingList = shopCartService.findShopcartByUserid(userid);
        for(int i=0,j=0;i<shoppingList.size()&&j<carts.size();i++){
            if(shoppingList.get(i).getCarId() == carts.get(j).getId()){
                shoppingList.get(i).setCount(carts.get(j).getCount());
                billList.add(shoppingList.get(i));
                sum += shoppingList.get(i).getPrice() * shoppingList.get(i).getCount();
                j++;
            }
        }
        Users user = userService.selectUserById(userid);
        session.setAttribute("billList",billList);
        session.setAttribute("userInfo",user);
        session.setAttribute("sum",sum);
        return "front/billPage";
    }

    /**
     * 生成订单
     * @param name
     * @param tel
     * @param adress
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("generateOrder")
    public String generateOrder( String name, String tel, String adress, HttpSession session, Model model){
        Users receiver  = new Users();
        receiver.setId((Integer) session.getAttribute("userid"));
        receiver.setAdress(adress);
        receiver.setName(name);
        receiver.setTel(tel);
        Integer oid = shopCartService.GenerateOrder(receiver, (ArrayList<ShopcartItem>)session.getAttribute("billList") ,(double)session.getAttribute("sum"));
        session.setAttribute("shopCount",shopCartService.getShopCount((Integer) session.getAttribute("userid")));
        if(oid != null){
            model.addAttribute("oid",oid);
            model.addAttribute("cost",(double)session.getAttribute("sum"));
            return "front/paymentPage";
        }else {
            model.addAttribute("Msg","订单提交失败!");
            return "front/errorPage";
        }
    }

    @RequestMapping("payment")
    public String payment(Integer id,Model model){
        boolean res = shopCartService.pay(id);
        if(res){
            model.addAttribute("Msg","支付成功！");
            return "front/errorPage";
        }else{
            model.addAttribute("Msg","支付失败！");
            return "front/errorPage";
        }

    }

}
