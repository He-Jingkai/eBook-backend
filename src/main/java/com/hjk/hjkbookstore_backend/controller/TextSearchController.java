package com.hjk.hjkbookstore_backend.controller;

import com.hjk.hjkbookstore_backend.entity.Book;
import com.hjk.hjkbookstore_backend.service.BookService;
import com.hjk.hjkbookstore_backend.service.SolrService;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TextSearchController {
    @Autowired
    private SolrService solrService;
    @Autowired
    private BookService bookService;

    @CrossOrigin
    @RequestMapping("/query")
    public List<Book> query(@RequestParam("needle") String needle) throws SolrServerException, IOException {
//        solrService.addAll();
        List<Book> books=new ArrayList<>();
        List<Integer> ids=solrService.query(needle);
        for(Integer id:ids)
            books.add(bookService.findBookById(id));
        return books;
    }

}
