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
        ArrayList allAuthors = authorRepo.findAll();
        return allAuthors;
    }
    public ArrayList<Author> findAllAuthorByName(String name){
        return authorRepo.findAllAuthorByName(name);
    }
    public Author getAuthorById(String id) {
        return authorRepo.getAuthorById(id);
    }
    public Author saveAuthor(Author author) {
        Author savedAuthor = authorRepo.saveAuthor(author);
        return savedAuthor;
    }
    public Author updateAuthor(Author author){
        Author updateAuthor = authorRepo.updateAuthor(author);
        return updateAuthor;
    }
    public boolean deleteAuthorById(String id){
        return authorRepo.deleteAuthor(id);
    }
}
