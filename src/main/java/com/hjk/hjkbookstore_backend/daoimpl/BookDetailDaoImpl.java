package com.hjk.hjkbookstore_backend.daoimpl;

import com.hjk.hjkbookstore_backend.entity.BookDetail;
import com.hjk.hjkbookstore_backend.repository.BookDetailRepository;
import com.hjk.hjkbookstore_backend.dao.BookDetailDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class BookDetailDaoImpl implements BookDetailDao {

    @Autowired
    private BookDetailRepository bookDetailRepository;

    @Override
    public BookDetail findOne(Integer id){
        return bookDetailRepository.getOne(id);
    }

    @Override
    public void saveOne(BookDetail bookDetail){bookDetailRepository.save(bookDetail);}

    @Override
    public List<BookDetail> findAll(){return bookDetailRepository.findAll();}

    @Override
    public void delete(BookDetail bookDetail){bookDetailRepository.delete(bookDetail);}

}
