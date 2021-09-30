package com.hjk.hjkbookstore_backend.service;

import com.hjk.hjkbookstore_backend.entity.BookDetail;

import java.util.List;
import java.util.Map;


public interface BookDetailService {

    BookDetail findBookDetailById(Integer id);

    List<BookDetail> findAll();

    void delete(BookDetail bookDetail);

    void saveABook(Map<String,Object> map);

    void newABook(Map<String,Object> map);

    void deleteById(String id);

}
