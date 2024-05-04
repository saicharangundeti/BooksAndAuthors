package com.BooksAndAuthorsManagement.Controller;

import com.BooksAndAuthorsManagement.Service.AuthorService;
import com.BooksAndAuthorsManagement.controller.AuthorController;
import com.BooksAndAuthorsManagement.model.Author;
import com.BooksAndAuthorsManagement.repo.AuthorRepo;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class TestAuthorController {
    @Test
    public void testGetAnAuthorReturnsOkStatusCode() {
        AuthorRepo authorRepo = new AuthorRepo();
        AuthorService authorService = new AuthorService(authorRepo);
        AuthorController authorController = new AuthorController(authorService);
        ResponseEntity<Author> author = authorController.postAuthor(new Author("sai","A1"));
        ResponseEntity<Author> response = authorController.getAnAuthor("A1");
        assertEquals(HttpStatus.OK,response.getStatusCode());
    }
    @Test
    public void tesGetAnAuthorReturnsNotFoundStatusCode(){
        AuthorRepo authorRepo = new AuthorRepo();
        AuthorService authorService = new AuthorService(authorRepo);
        AuthorController authorController = new AuthorController(authorService);
        ResponseEntity<Author> author = authorController.postAuthor(new Author("sai","A1"));
        ResponseEntity<Author> response = authorController.getAnAuthor("A2");
        assertEquals(HttpStatus.NOT_FOUND,response.getStatusCode());
    }
    @Test
    public void tesGetAnAuthorReturnsValidAuthorName(){
        AuthorRepo authorRepo = new AuthorRepo();
        AuthorService authorService = new AuthorService(authorRepo);
        AuthorController authorController = new AuthorController(authorService);
        ResponseEntity<Author> author = authorController.postAuthor(new Author("sai","A1"));
        ResponseEntity<Author> response = authorController.getAnAuthor("A1");
        assertEquals("sai",response.getBody().getName());
    }
    @Test
    public void testGetAnAuthorReturnsNull(){
        AuthorRepo authorRepo = new AuthorRepo();
        AuthorService authorService = new AuthorService(authorRepo);
        AuthorController authorController = new AuthorController(authorService);
        ResponseEntity<Author> author = authorController.postAuthor(new Author("sai","A1"));
        ResponseEntity<Author> response = authorController.getAnAuthor("A2");
        assertEquals(null,response.getBody());

    }
    @Test
    public void testGetAllAuthorsReturnsOkStatusCode(){
        AuthorRepo authorRepo = new AuthorRepo();
        AuthorService authorService = new AuthorService(authorRepo);
        AuthorController authorController = new AuthorController(authorService);
        ResponseEntity<Author> author = authorController.postAuthor(new Author("sai","A1"));
        ResponseEntity<ArrayList<Author>> response = authorController.getAllAuthors(null);
        assertEquals(HttpStatus.OK,response.getStatusCode());
    }
    @Test
    public void testGetAllAuthorsReturnsNotFoundStatusCode(){
        AuthorRepo authorRepo = new AuthorRepo();
        AuthorService authorService = new AuthorService(authorRepo);
        AuthorController authorController = new AuthorController(authorService);
        ResponseEntity<Author> author = authorController.postAuthor(new Author("sai","A1"));
        ResponseEntity<ArrayList<Author>> response = authorController.getAllAuthors("charan");
        assertEquals(HttpStatus.NOT_FOUND,response.getStatusCode());
    }
    @Test
    public void testGetAllAuthorsReturnsValidSize(){
        AuthorRepo authorRepo = new AuthorRepo();
        AuthorService authorService = new AuthorService(authorRepo);
        AuthorController authorController = new AuthorController(authorService);
        ResponseEntity<Author> author1 = authorController.postAuthor(new Author("sai","A1"));
        ResponseEntity<Author> author2 = authorController.postAuthor(new Author("charan","A2"));
        ResponseEntity<ArrayList<Author>> response = authorController.getAllAuthors(null);
        assertEquals(2,response.getBody().size());
    }
    @Test
    public void testGetAllAuthorsReturnsInValidSize(){
        AuthorRepo authorRepo = new AuthorRepo();
        AuthorService authorService = new AuthorService(authorRepo);
        AuthorController authorController = new AuthorController(authorService);
        ResponseEntity<Author> author1 = authorController.postAuthor(new Author("sai","A1"));
        ResponseEntity<Author> author2 = authorController.postAuthor(new Author("charan","A2"));
        ResponseEntity<ArrayList<Author>> response = authorController.getAllAuthors(null);
        assertNotEquals(1,response.getBody().size());
    }
    @Test
    public void testPostAuthorReturnsOkStatusCode(){
        AuthorRepo authorRepo = new AuthorRepo();
        AuthorService authorService = new AuthorService(authorRepo);
        AuthorController authorController = new AuthorController(authorService);
        ResponseEntity<Author> response = authorController.postAuthor(new Author("sai","A1"));
        assertEquals(HttpStatus.OK,response.getStatusCode());

    }
//    @Test
//    public void testPostAuthorReturnsBadRequestStatusCode(){
//        AuthorRepo authorRepo = new AuthorRepo();
//        AuthorService authorService = new AuthorService(authorRepo);
//        AuthorController authorController = new AuthorController(authorService);
//        ResponseEntity<Author> author1 = authorController.postAuthor(new Author("sai","A1"));
//        ResponseEntity<Author> response = authorController.postAuthor(new Author("charan","A1"));
//        assertEquals(HttpStatus.BAD_REQUEST,response.getStatusCode());
//
//    }



}
