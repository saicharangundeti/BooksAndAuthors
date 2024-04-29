package com.BooksAndAuthorsManagement.model;
import com.BooksAndAuthorsManagement.model.Author;

public class Book {
    private  String bookName;
    private String bookId;
    private String authorId;
    private int numberOfPages;

    public Book(String name, String id, int numberOfPages, String authorId) {
        this.bookName = name;
        this.bookId = id;
        this.numberOfPages = numberOfPages;
        this.authorId = authorId;
    }
    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
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
