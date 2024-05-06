package com.BooksAndAuthorsManagement.repo;

import com.BooksAndAuthorsManagement.model.Author;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class AuthorRepo {
    private final Map<String, Author> authorMap;

    public AuthorRepo() {
        authorMap = new HashMap<>();
    }

    public ArrayList<Author> findAll(){

        return new ArrayList<>(authorMap.values());
    }
    public ArrayList<Author> findAllAuthorByName(String name){
        ArrayList<Author> specificAuthors = new ArrayList<>();
        for(Author author: authorMap.values()){
            if(author.getName().equals(name)){
                specificAuthors.add(author);
            }
        }
        return specificAuthors;
    }
    public Author getAuthorById(String id){
        if(authorMap.containsKey(id)){
            return authorMap.get(id);
        }
        return null;
    }
    public Author saveAuthor(Author author){
        if(author.getId() != null && !authorMap.containsKey(author.getId())){
            authorMap.put(author.getId(), author);
            return author;
        }
        return null;
    }
    public Author updateAuthor(Author author){
        if(authorMap.containsKey(author.getId())){
            Author updateAuthor = authorMap.get(author.getId());
            updateAuthor.setName(author.getName());
            return updateAuthor;
        }
        return null;
    }
    public  boolean deleteAuthor(String id){
        if(authorMap.containsKey(id)){
            authorMap.remove(id);
            return  true;
        }
        return false;
    }
}
