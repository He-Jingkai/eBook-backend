package com.hjk.hjkbookstore_backend.dao;

import com.hjk.hjkbookstore_backend.entity.BookDetail;

import java.util.List;

public interface BookDetailDao {
    BookDetail findOne(Integer id);

    void saveOne(BookDetail bookDetail,Integer mode);

    List<BookDetail> findAll();

    void delete(BookDetail bookDetail);
}
