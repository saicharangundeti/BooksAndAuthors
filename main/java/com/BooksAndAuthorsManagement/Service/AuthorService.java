package com.BooksAndAuthorsManagement.Service;

import com.BooksAndAuthorsManagement.model.Author;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class AuthorService {
     static Map<String,Author> authorMap = new HashMap<>();

    public ArrayList findAll(){
        return new ArrayList<>(authorMap.values());
    }
    public ArrayList findAllAuthorByName(String name){
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
        if(author.getId() != null){
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
    public boolean deleteAuthorById(String id){
        if(authorMap.containsKey(id)){
            authorMap.remove(id);
            return true;
        }
        return false;
    }
}
