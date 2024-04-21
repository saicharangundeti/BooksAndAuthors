package com.BooksAndAuthorsManagement.model;

public class Author {
    private String authorName;
    private String authorId;

    public Author() {
    }

    public Author(String authorName, String authorId) {
        this.authorName = authorName;
        this.authorId = authorId;
    }
    public String getAuthorName() {
        return authorName;
    }
    public String getAuthorId() {
        return authorId;
    }
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }




}
