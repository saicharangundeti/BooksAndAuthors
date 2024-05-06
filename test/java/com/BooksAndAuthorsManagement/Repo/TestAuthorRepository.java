package com.BooksAndAuthorsManagement.Repo;

import com.BooksAndAuthorsManagement.model.Author;
import com.BooksAndAuthorsManagement.repo.AuthorRepo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TestAuthorRepository {
    @Test
    public void testFindAllReturnsValidSize(){
        AuthorRepo authorRepo = new AuthorRepo();
        authorRepo.saveAuthor(new Author("sai","A1"));
        authorRepo.saveAuthor(new Author("charan","A2"));
        ArrayList<Author> response = authorRepo.findAll();
        assertEquals(2,response.size());

    }
    @Test
    public void testFindAllReturnsZeroSize(){
        AuthorRepo authorRepo = new AuthorRepo();
        ArrayList<Author> response = authorRepo.findAll();
        assertEquals(0,response.size());
    }
    @Test
    public void testFindAllAuthorsByNameReturnsValidSize(){
        AuthorRepo authorRepo = new AuthorRepo();
        authorRepo.saveAuthor(new Author("sai","A1"));
        authorRepo.saveAuthor(new Author("charan","A2"));
        ArrayList<Author> response = authorRepo.findAllAuthorByName("sai");
        assertEquals(1,response.size());
    }
    @Test
    public void testFindAllAuthorsByNameReturnsZeroSize(){
        AuthorRepo authorRepo = new AuthorRepo();
        authorRepo.saveAuthor(new Author("sai","A1"));
        authorRepo.saveAuthor(new Author("charan","A2"));
        ArrayList<Author> response = authorRepo.findAllAuthorByName("vamshi");
        assertEquals(0,response.size());
    }
    @Test
    public void testGetAuthorByIdReturnsValidName(){
        AuthorRepo authorRepo = new AuthorRepo();
        authorRepo.saveAuthor(new Author("sai","A1"));
        Author response = authorRepo.getAuthorById("A1");
        assertEquals("sai",response.getName());
    }
    @Test
    public void testGetAuthorByIdReturnsNull(){
        AuthorRepo authorRepo = new AuthorRepo();
        Author response = authorRepo.getAuthorById("A1");
        assertNull(response);
    }
    @Test
    public void testSaveAuthorReturnsValidName(){
        AuthorRepo authorRepo = new AuthorRepo();
        Author response  = authorRepo.saveAuthor(new Author("charan","A1"));
        assertEquals("charan",response.getName());
    }
    @Test
    public void testSaveAuthorReturnsNull(){
        AuthorRepo authorRepo = new AuthorRepo();
        authorRepo.saveAuthor(new Author("sai","A1"));
        Author response  = authorRepo.saveAuthor(new Author("charan","A1"));
        assertNull(response);
    }
    @Test
    public void testUpdateAuthorReturnsValidName(){
        AuthorRepo authorRepo = new AuthorRepo();
        authorRepo.saveAuthor(new Author("sai","A1"));
        Author response  = authorRepo.updateAuthor(new Author("charan","A1"));
        assertEquals("charan",response.getName());
    }
    @Test
    public void testUpdateAuthorReturnsNull(){
        AuthorRepo authorRepo = new AuthorRepo();
        authorRepo.saveAuthor(new Author("sai","A1"));
        Author response  = authorRepo.updateAuthor(new Author("charan","A2"));
        assertNull(response);
    }
    @Test
    public void testDeleteAuthorReturnsTrue(){
        AuthorRepo authorRepo = new AuthorRepo();
        authorRepo.saveAuthor(new Author("sai","A1"));
        Boolean response  = authorRepo.deleteAuthor("A1");
        assertEquals(true,response);
    }
    @Test
    public void testDeleteAuthorReturnsFalse(){
        AuthorRepo authorRepo = new AuthorRepo();
        authorRepo.saveAuthor(new Author("sai","A1"));
        Boolean response  = authorRepo.deleteAuthor("A2");
        assertEquals(false,response);
    }




}
