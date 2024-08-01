package com.BooksAndAuthorsManagement.model;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookAndAuthor {
    private int bookId;
    private String bookName;
    private int numberOfPages;
    List<Author> authors ;
    public BookAndAuthor(){}

    public BookAndAuthor(int bookId, String bookName, int numberOfPages, List<Author> authors) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.numberOfPages = numberOfPages;
        this.authors = authors;
    }

    public int getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "BookAndAuthor{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", authors=" + authors +
                '}';
    }
}
