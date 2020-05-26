package com.ex.bookshop.pojo.tag;

import com.ex.bookshop.pojo.entity.Book;
import com.ex.bookshop.pojo.entity.OrderInfo;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.List;

/**
 * @description:
 * @author: Li Rui Qiang
 * @create: 2020-05-26 14:57
 **/

public class OrderItemTag extends SimpleTagSupport {
    List<Book> books ;
    public void setbooks( List<Book> books){
        this.books = books;
    }

    @Override
    public void doTag() throws JspException, IOException {
        String outItem = "";
        for (Book book: books) {
            outItem += "<div style=\"display: flex;width: 100%;border: solid lightgray 1px;\" class=\"booklist\">\n" +
                    "                        <div><img src=\""+book.getImg()+"\" style=\"width: 70px; height: 70px\"></div>\n" +
                    "                        <div>\n" +
                    "                            <div style=\\\"margin: 10px;font-size: x-large;padding: 10px\\\">"+book.getBookName()+"</div> "+
                    "                            <div style=\"margin: 10px;font-size: smaller;margin-top: 10px;text-align: right;padding-right: 10px;\">×"+book.getStock()+"</div>\n" +
                    "                            <div style=\"margin: 10px;font-size: smaller;color: red;margin-top: 5px;text-align: right;padding-right: 10px;\">¥"+book.getPrice()*book.getStock() +"</div>\n" +
                    "                        </div>\n" +
                    "                    </div>";
        }
        getJspContext().getOut().print(outItem);
    }

}
