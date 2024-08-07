package com.BooksAndAuthorsManagement.model;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

public class BookAndAuthor {
    private int bookId;
    private String bookName;
    private int numberOfPages;
    private Set<Author> authors ;
    public BookAndAuthor(){}

    public BookAndAuthor(int bookId, String bookName, int numberOfPages, Set<Author> authors) {
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

    public Set<Author> getAuthors() {
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

    public void setAuthors(Set<Author> authors) {
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
