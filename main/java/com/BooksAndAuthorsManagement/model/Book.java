package com.BooksAndAuthorsManagement.model;
import com.BooksAndAuthorsManagement.model.Author;

public class Book {
    private  String bookName;
    private String bookId;
    private Author author;

    private int numberOfPages;
    public Book(String bookName, String bookId, int numberOfPages, Author author) {
        this.bookName = bookName;
        this.bookId = bookId;
        this.numberOfPages = numberOfPages;
        this.author = author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Author getAuthor() {
        return author;
    }

    public Book() {
    }
    public String getBookName() {
        return bookName;
    }


    public String getBookId() {
        return bookId;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }





}
