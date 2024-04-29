package com.BooksAndAuthorsManagement.model;

public class Author {
    private String Name;
    private String Id;

    public Author(String authorName, String authorId) {
        this.Name = authorName;
        this.Id = authorId;
    }
    public String getName() {
        return Name;
    }
    public String getId() {
        return Id;
    }
    public void setName(String name) {
        this.Name = name;
    }

    public void setId(String id) {
        this.Id = id;
    }




}
