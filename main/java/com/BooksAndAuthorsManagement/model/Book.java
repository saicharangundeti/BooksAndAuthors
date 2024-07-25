package com.BooksAndAuthorsManagement.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Book {
    private int id;
    @Size(min=2)
    private  String name;
    @NotNull
    private int authorId;
    private int numberOfPages;
    public Book(){}

    public Book(int id,String name,int numberOfPages,int authorId) {
        this.id = id;
        this.name=name;
        this.numberOfPages = numberOfPages;
        this.authorId = authorId;

    }
    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }


    public int getId() {
        return id;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", authorId=" + authorId +
                ", numberOfPages=" + numberOfPages +
                '}';
    }
}
