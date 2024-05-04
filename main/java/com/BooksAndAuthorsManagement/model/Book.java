package com.BooksAndAuthorsManagement.model;

public class Book {
    private  String name;
    private String id;
    private String authorId;
    private int numberOfPages;

    public Book(String name, String id, int numberOfPages, String authorId) {
        this.name = name;
        this.id = id;
        this.numberOfPages = numberOfPages;
        this.authorId = authorId;
    }
    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }


    public String getId() {
        return id;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }





}
