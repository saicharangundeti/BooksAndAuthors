package com.BooksAndAuthorsManagement.model;

public class Author {
    private String name;
    private String id;

    public Author(String authorName, String authorId) {
        this.name = authorName;
        this.id = authorId;
    }
    public String getName() {
        return name;
    }
    public String getId() {
        return id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setId(String id) {
        this.id = id;
    }




}
