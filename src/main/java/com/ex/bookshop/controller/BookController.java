package com.ex.bookshop.controller;

import com.ex.bookshop.pojo.entity.Book;
import com.ex.bookshop.service.BookService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Li Rui Qiang
 * @create: 2020-05-09 13:25
 **/
@Controller
public class BookController {


    @Resource
    BookService bookService ;


    String imgName = null;
    /**
     * 跳转添加书籍页面
     * @return
     */
    @RequestMapping("addBookPage")
    public String addBook(){
        return "back/addBook";
    }

    /**
     * 接收保存上传的书籍图片
     * @param file
     */
    @RequestMapping("upload")
    @ResponseBody
    public JSONObject upload(MultipartFile file){
        JSONObject jsonObject = bookService.savePic(file);
        imgName = jsonObject.get("src").toString();
        return jsonObject;
    }
    /**
     *添加书籍
     * @param book
     * @return
     */
    @RequestMapping("addBook")
    public String add(Book book , Model model){
        if(imgName == null){
            model.addAttribute("errorMsg","<script>alert('图片保存失败');</script>");
            return "back/addBook";
        }else{
            book.setImg(imgName);
            imgName = null;
            boolean res = bookService.addBook(book);
            if(res){
                model.addAttribute("errorMsg","<script>alert('添加成功');</script>");
                return "back/addBook";
            }else{
                model.addAttribute("errorMsg","<script>alert('添加成功');</script>");
                return "back/addBook";
            }
        }
    }

    /**管理书籍
     *
     * @return
     */
    @RequestMapping("adminBookPage")
    public ModelAndView adminBookPage(ModelAndView modelAndView ,String Msg){
        modelAndView = new ModelAndView("back/adminBook");
        List<Book> bookList ;
        bookList = bookService.findAllBook();
        modelAndView.addObject("BList",bookList);
        if(Msg != null){
            modelAndView.addObject("Msg",Msg);
        }
        return modelAndView;
    }

    /**
     * 删除书籍
     * @param id
     * @param
     * @return
     */
    @RequestMapping("delBook")
    public ModelAndView delBook(String id){
        ModelAndView modelAndView = new ModelAndView("redirect:adminBookPage");
        int bid = Integer.parseInt(id);
        boolean res = bookService.delBook(bid);
        if(res){
            modelAndView.addObject("Msg","<script>alert('删除成功！');</script>");
            return modelAndView;
        }else{
            modelAndView.addObject("Msg","<script>alert('删除失败！');</script>");
            return modelAndView;
        }
    }

    /**
     * 跳转书籍信息修改页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("updateBookPage")
    public String updateBookPage(String id,Model model){
        int bid = Integer.parseInt(id);
        Book book = bookService.selectBookById(bid);
        model.addAttribute("book",book);
        return "back/updateBook";
    }

    /**
     * 修改书籍信息
     * @param book
     * @return
     */
    @RequestMapping("updateBook")
    public ModelAndView updateBook(Book book){
        ModelAndView modelAndView = new ModelAndView("redirect:adminBookPage");
        if(imgName != null){
            book.setImg(imgName);
            imgName = null;
        }
        boolean res = bookService.updateBookById(book);
        if(res){
            modelAndView.addObject("Msg","<script>alert('修改成功！');</script>");
            return modelAndView;
        }else{
            modelAndView.addObject("Msg","<script>alert('修改失败！');</script>");
            return modelAndView;
        }
    }

    /**
     * 首页按类型展示书籍
     * @param id
     * @return
     */
    @RequestMapping("showBook")
    @ResponseBody
    public JSONObject showBook(String id){
        int typeId = Integer.parseInt(id);
        JSONObject res = bookService.showBookByType(typeId);
        return res;
    }

    /**
     * 书籍详情展示
     * @param id
     * @return
     */
    @RequestMapping("bookDetail")
    public ModelAndView bookDetial(Integer id, String Msg){
        Book book = bookService.selectBookById(id);
        ModelAndView modelAndView = new ModelAndView("front/showBook");
        modelAndView.addObject("book",book);
        if(Msg != null){
            modelAndView.addObject("Msg",Msg);
        }
        return modelAndView;
    }
}
