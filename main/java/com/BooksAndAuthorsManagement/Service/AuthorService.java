package com.BooksAndAuthorsManagement.Service;
import com.BooksAndAuthorsManagement.model.Author;
import com.BooksAndAuthorsManagement.repo.AuthorRepo;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AuthorService {
    private  AuthorRepo authorRepo;
    private  int authorId=0;

    public AuthorService(AuthorRepo authorRepo){
        this.authorRepo = authorRepo;
    }

    public List<Author> findAllAuthors(){
        return authorRepo.findAll();
    }
     public Author findAuthorByName(String name){
        return authorRepo.findAuthorByName(name);
    }
    public Author getAuthorById(int id)
    {
        if(authorRepo.getAuthor(id) != null){
            return authorRepo.getAuthor(id);
        }
        return null;
    }
    public Author saveAuthor(Author author)
    {
        if(authorRepo.findAuthorByName(author.getName()) == null) {
            authorRepo.saveAuthor(author);
            return author;
        }
        return null;


    }
    public Author updateAuthor(Author author){
        //if author doesn't exit
        if(authorRepo.getAuthor(author.getId()) == null){
            return null;
        }
        authorRepo.updateAuthor(author);
        return author;
    }
    public boolean deleteAuthorById(int id){
        // if author doesn't exit
        if(authorRepo.getAuthor(id) == null){
            return false;
        }
        authorRepo.removeAuthor(id);
        return true;
    }
}
