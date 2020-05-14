package com.ex.bookshop.service;

import com.ex.bookshop.pojo.entity.Book;
import net.sf.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public interface BookService {
    public JSONObject savePic(MultipartFile file);
    public boolean addBook(Book book);

    List<Book> findAllBook();

    boolean delBook(int bid);

    boolean updateBookById(Book book);

    Book selectBookById(int bid);

    JSONObject showBookByType(int typeId);
}
