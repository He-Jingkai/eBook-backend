package com.hjk.hjkbookstore_backend.repository;

import com.hjk.hjkbookstore_backend.entity.BookDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookDetailRepository extends JpaRepository<BookDetail,Integer> {

}
