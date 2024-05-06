package com.BooksAndAuthorsManagement.Service;
import com.BooksAndAuthorsManagement.model.Author;
import com.BooksAndAuthorsManagement.repo.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AuthorService {
    @Autowired
    AuthorRepo authorRepo;
    public AuthorService(AuthorRepo authorRepo){
        this.authorRepo = authorRepo;
    }

    public ArrayList<Author> findAllAuthors(){
        return authorRepo.findAll();
    }
    public ArrayList<Author> findAllAuthorByName(String name){
        return authorRepo.findAllAuthorByName(name);
    }
    public Author getAuthorById(String id) {
        return authorRepo.getAuthorById(id);
    }
    public Author saveAuthor(Author author) {
        return authorRepo.saveAuthor(author);
    }
    public Author updateAuthor(Author author){
        return  authorRepo.updateAuthor(author);
    }
    public boolean deleteAuthorById(String id){
        return authorRepo.deleteAuthor(id);
    }
}
