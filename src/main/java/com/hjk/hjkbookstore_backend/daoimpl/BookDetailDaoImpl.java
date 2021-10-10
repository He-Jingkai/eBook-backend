package com.hjk.hjkbookstore_backend.daoimpl;

import com.alibaba.fastjson.JSONArray;
import com.hjk.hjkbookstore_backend.entity.BookDetail;
import com.hjk.hjkbookstore_backend.repository.BookDetailRepository;
import com.hjk.hjkbookstore_backend.dao.BookDetailDao;

import com.hjk.hjkbookstore_backend.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Repository
public class BookDetailDaoImpl implements BookDetailDao {

    @Autowired
    private BookDetailRepository bookDetailRepository;

    @Autowired
    RedisUtil redisUtil;

    @Override
    public BookDetail findOne(Integer id){
        BookDetail bookDetail;
        System.out.println("Searching BookDetail: " + id + " in Redis");
        Object p = redisUtil.get("bookDetail" + id);
        if (p == null) {
            System.out.println("bookDetail: " + id + " is not in Redis");
            System.out.println("Searching bookDetail: " + id + " in DB");
            bookDetail = bookDetailRepository.findBookDetailById(id);
            System.out.println("put bookDetail: " + id + " to Redis");
            redisUtil.set("bookDetail" + id, JSONArray.toJSON(bookDetail));
        } else {
            bookDetail = JSONArray.parseObject(p.toString(), BookDetail.class);
            System.out.println("bookDetail: " + id + " is in Redis");
        }
        return bookDetail;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveOne(BookDetail bookDetail,Integer mode){
        if(mode==0){
            System.out.println("Add a book");
            System.out.println("put newly added bookDetail to DB");
            BookDetail bookDetail1=bookDetailRepository.save(bookDetail);
            System.out.println("put newly added bookDetail: " + bookDetail1.getId() + " to Redis");
            redisUtil.set("bookDetail" + bookDetail1.getId(), JSONArray.toJSON(bookDetail1));
        }
        else {
            System.out.println("update a book");
            System.out.println("update bookDetail: " + bookDetail.getId() + " to Redis");
            redisUtil.set("bookDetail" + bookDetail.getId(), JSONArray.toJSON(bookDetail));
            System.out.println("update bookDetail: " + bookDetail.getId() + " to DB");
            bookDetailRepository.save(bookDetail);
        }
    }

    @Override
    public List<BookDetail> findAll(){
        System.out.println("************* find all bookDetails *************");
        System.out.println("*** find all ID ***");
        List<Integer> ids=bookDetailRepository.getAllId();
        List<BookDetail> bookDetails=new ArrayList<>();
        for(Integer id:ids)
            bookDetails.add(findOne(id));
        System.out.println("************* find all bookDetails end *************");
        return bookDetails;
    }

    @Override
    public void delete(BookDetail bookDetail){
        System.out.println("delete a book");
        System.out.println("delete bookDetail: " + bookDetail.getId() + " in Redis");
        redisUtil.del("bookDetail" + bookDetail.getId());
        System.out.println("delete bookDetail: " + bookDetail.getId() + " in DB");
        bookDetailRepository.delete(bookDetail);
    }

}
