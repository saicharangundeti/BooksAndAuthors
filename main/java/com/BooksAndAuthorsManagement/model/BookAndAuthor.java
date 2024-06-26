package com.BooksAndAuthorsManagement.model;

import org.springframework.beans.factory.annotation.Autowired;

public class BookAndAuthor {
    @Autowired
    Book book  ;
    @Autowired
    Author author ;
    BookAndAuthor(Book book,Author author){
        this.book = book;
        this.author = author;
    }
    public Book getBook(){
        return book;
    }
    public Author getAuthor(){
        return author;
    }
    public void setBook(Book book){
        this.book = book;
    }
    public void setAuthor(Author author){
        this.author = author;
    }

}
