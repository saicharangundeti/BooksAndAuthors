package com.BooksAndAuthorsManagement.model;

import jakarta.validation.constraints.Size;

public class Author {
    private int id;
    @Size(min=2)
    private String name;

    public Author(){}

    public Author(int authorId,String authorName){
        this.id=authorId;
        this.name = authorName;

    }
    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
