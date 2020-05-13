package com.ex.bookshop.service.impl;

import com.ex.bookshop.dao.BookDao;
import com.ex.bookshop.pojo.entity.Book;
import com.ex.bookshop.service.BookService;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @description:
 * @author: Li Rui Qiang
 * @create: 2020-05-09 20:51
 **/
@Service
public class BookServiceImpl implements BookService {
    @Resource
    BookDao bookDao;

    /**
     * 保存上传得书籍封面图片
     * @param file
     * @return
     */
    @Override
    public String savePic(MultipartFile file) {
        //获取文件名
        String fileName = file.getOriginalFilename();
        //获取文件后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //重新生成文件名
        fileName = UUID.randomUUID()+suffixName;
        //指定本地文件夹存储图片
     //   String path = ClassUtils.getDefaultClassLoader().getResource("static").getPath();
        String path = "H:\\IEDAWorkspace\\bookshop\\src\\main\\resources\\static\\imgs\\";

        try {
            //将图片保存到static/imgs文件夹里
            file.transferTo(new File(path+fileName));
            return fileName;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 添加书籍
     * @param book
     * @return
     */
    @Override
    public boolean addBook(Book book) {
        int res = bookDao.insert(book);
        if(res == 1){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 查看所有书籍
     * @return
     */
    @Override
    public List<Book> findAllBook() {
        List<Book> bookList = new ArrayList<Book>();
        bookList = bookDao.selectAll();
        return bookList;
    }

    /**
     * 按id删除书籍
     * @param bid
     * @return
     */
    @Override
    public boolean delBook(int bid) {
        int res = bookDao.deleteByPrimaryKey(bid);
        if(res == 1){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 根据id修改书记信息
     * @param book
     * @return
     */
    @Override
    public boolean updateBookById(Book book) {
        int res = bookDao.updateByPrimaryKey(book);
        if(res == 1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Book selectBookById(int bid) {
        Book book = bookDao.selectByPrimaryKey(bid);
        return book;
    }
}
