package com.BooksAndAuthorsManagement.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public class Book {
    private int id;
    @Size(min=2)
    private  String name;
    @NotNull
    private List<Integer> authorIds;
    private int numberOfPages;
    public Book(){}

    public Book(int id,String name,int numberOfPages,List<Integer> authorIds) {
        this.id = id;
        this.name=name;
        this.numberOfPages = numberOfPages;
        this.authorIds = authorIds;

    }
    public List<Integer> getAuthorIds() {
        return authorIds;
    }

    public void setAuthors(List<Integer> authorIds) {
        this.authorIds = authorIds;
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
                ", authorId=" + authorIds +
                ", numberOfPages=" + numberOfPages +
                '}';
    }
}
