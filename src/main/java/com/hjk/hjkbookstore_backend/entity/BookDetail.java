package com.hjk.hjkbookstore_backend.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="book")
@Data
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class BookDetail {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "image")
    private String image;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private int price;

    @Column(name = "author")
    private String author;

    @Column(name = "description")
    private String description;

    @Column(name = "content")
    private String content;

    @Column(name = "writer")
    private String writer;

    @Column(name = "inventory")
    private Integer inventory;

    @Column(name = "isbn")
    private String isbn;
}

