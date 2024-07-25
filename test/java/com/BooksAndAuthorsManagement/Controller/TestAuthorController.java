package com.BooksAndAuthorsManagement.Controller;
//
//import com.BooksAndAuthorsManagement.Service.AuthorService;
//import com.BooksAndAuthorsManagement.controller.AuthorController;
//import com.BooksAndAuthorsManagement.model.Author;
//import com.BooksAndAuthorsManagement.repo.AuthorRepo;
//import org.junit.jupiter.api.Test;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import java.util.ArrayList;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//
//public class TestAuthorController {
//    @Test
//    public void testGetAnAuthorReturnsOkStatusCode() {
//        AuthorRepo authorRepo = new AuthorRepo();
//        AuthorService authorService = new AuthorService(authorRepo);
//        AuthorController authorController = new AuthorController(authorService);
//        authorController.postAuthor(new Author("sai","A1"));
//        ResponseEntity<Author> response = authorController.getAnAuthor("A1");
//        assertEquals(HttpStatus.OK,response.getStatusCode());
//    }
//    @Test
//    public void tesGetAnAuthorReturnsNotFoundStatusCode(){
//        AuthorRepo authorRepo = new AuthorRepo();
//        AuthorService authorService = new AuthorService(authorRepo);
//        AuthorController authorController = new AuthorController(authorService);
//        authorController.postAuthor(new Author("sai","A1"));
//        ResponseEntity<Author> response = authorController.getAnAuthor("A2");
//        assertEquals(HttpStatus.NOT_FOUND,response.getStatusCode());
//    }
//    @Test
//    public void tesGetAnAuthorReturnsValidAuthorName(){
//        AuthorRepo authorRepo = new AuthorRepo();
//        AuthorService authorService = new AuthorService(authorRepo);
//        AuthorController authorController = new AuthorController(authorService);
//        authorController.postAuthor(new Author("sai","A1"));
//        ResponseEntity<Author> response = authorController.getAnAuthor("A1");
//        assertEquals("sai",response.getBody().getName());
//    }
//    @Test
//    public void testGetAnAuthorReturnsNull(){
//        AuthorRepo authorRepo = new AuthorRepo();
//        AuthorService authorService = new AuthorService(authorRepo);
//        AuthorController authorController = new AuthorController(authorService);
//        authorController.postAuthor(new Author("sai","A1"));
//        ResponseEntity<Author> response = authorController.getAnAuthor("A2");
//        assertNull(response.getBody());
//
//    }
//    @Test
//    public void testGetAllAuthorsReturnsOkStatusCode(){
//        AuthorRepo authorRepo = new AuthorRepo();
//        AuthorService authorService = new AuthorService(authorRepo);
//        AuthorController authorController = new AuthorController(authorService);
//        authorController.postAuthor(new Author("sai","A1"));
//        ResponseEntity<ArrayList<Author>> response = authorController.getAllAuthors(null);
//        assertEquals(HttpStatus.OK,response.getStatusCode());
//    }
//    @Test
//    public void testGetAllAuthorsReturnsNotFoundStatusCode(){
//        AuthorRepo authorRepo = new AuthorRepo();
//        AuthorService authorService = new AuthorService(authorRepo);
//        AuthorController authorController = new AuthorController(authorService);
//        authorController.postAuthor(new Author("sai","A1"));
//        ResponseEntity<ArrayList<Author>> response = authorController.getAllAuthors("charan");
//        assertEquals(HttpStatus.NOT_FOUND,response.getStatusCode());
//    }
//    @Test
//    public void testGetAllAuthorsReturnsValidSize(){
//        AuthorRepo authorRepo = new AuthorRepo();
//        AuthorService authorService = new AuthorService(authorRepo);
//        AuthorController authorController = new AuthorController(authorService);
//        authorController.postAuthor(new Author("sai","A1"));
//        authorController.postAuthor(new Author("charan","A2"));
//        ResponseEntity<ArrayList<Author>> response = authorController.getAllAuthors(null);
//        assertEquals(2,response.getBody().size());
//    }
//    @Test
//    public void testGetAllAuthorsReturnsInValidSize(){
//        AuthorRepo authorRepo = new AuthorRepo();
//        AuthorService authorService = new AuthorService(authorRepo);
//        AuthorController authorController = new AuthorController(authorService);
//        authorController.postAuthor(new Author("sai","A1"));
//        authorController.postAuthor(new Author("charan","A2"));
//        ResponseEntity<ArrayList<Author>> response = authorController.getAllAuthors(null);
//        assertNotEquals(1,response.getBody().size());
//    }
//    @Test
//    public void testPostAuthorReturnsOkStatusCode(){
//        AuthorRepo authorRepo = new AuthorRepo();
//        AuthorService authorService = new AuthorService(authorRepo);
//        AuthorController authorController = new AuthorController(authorService);
//        ResponseEntity<Author> response = authorController.postAuthor(new Author("sai","A1"));
//        assertEquals(HttpStatus.OK,response.getStatusCode());
//
//    }
//
//    @Test
//    public void testPostAuthorReturnsValidName(){
//        AuthorRepo authorRepo = new AuthorRepo();
//        AuthorService authorService = new AuthorService(authorRepo);
//        AuthorController authorController = new AuthorController(authorService);
//        ResponseEntity<Author> response = authorController.postAuthor(new Author("sai","A1"));
//        assertEquals("sai",response.getBody().getName());
//    }
//
//    @Test
//    public void testPostAuthorReturnsInvalidName(){
//        AuthorRepo authorRepo = new AuthorRepo();
//        AuthorService authorService = new AuthorService(authorRepo);
//        AuthorController authorController = new AuthorController(authorService);
//        ResponseEntity<Author> response = authorController.postAuthor(new Author("sai","A1"));
//        assertNotEquals("charan",response.getBody().getName());
//
//    }
//    @Test
//    public void testUpdateAuthorReturnsOkStatusCode(){
//        AuthorRepo authorRepo = new AuthorRepo();
//        AuthorService authorService = new AuthorService(authorRepo);
//        AuthorController authorController = new AuthorController(authorService);
//        authorController.postAuthor(new Author("sai","A1"));
//        ResponseEntity<Author> response = authorController.updateAuthor(new Author("update sai","A1"));
//        assertEquals(HttpStatus.OK,response.getStatusCode());
//    }
//    @Test
//    public void testUpdateAuthorReturnsNotFoundStatusCode(){
//        AuthorRepo authorRepo = new AuthorRepo();
//        AuthorService authorService = new AuthorService(authorRepo);
//        AuthorController authorController = new AuthorController(authorService);
//        authorController.postAuthor(new Author("sai","A1"));
//        ResponseEntity<Author> response = authorController.updateAuthor(new Author("update sai","A2"));
//        assertEquals(HttpStatus.NOT_FOUND,response.getStatusCode());
//    }
//    @Test
//    public void testUpdateAuthorReturnsValidName(){
//        AuthorRepo authorRepo = new AuthorRepo();
//        AuthorService authorService = new AuthorService(authorRepo);
//        AuthorController authorController = new AuthorController(authorService);
//        authorController.postAuthor(new Author("sai","A1"));
//        ResponseEntity<Author> response = authorController.updateAuthor(new Author("update sai","A1"));
//        assertEquals("update sai",response.getBody().getName());
//    }
//    @Test
//    public void testUpdateAuthorReturnsInValidName(){
//        AuthorRepo authorRepo = new AuthorRepo();
//        AuthorService authorService = new AuthorService(authorRepo);
//        AuthorController authorController = new AuthorController(authorService);
//        authorController.postAuthor(new Author("sai","A1"));
//        ResponseEntity<Author> response = authorController.updateAuthor(new Author("update sai","A2"));
//        assertNull(response.getBody());
//    }
//    @Test
//    public void testDeleteAuthorReturnsOKStatusCode(){
//        AuthorRepo authorRepo = new AuthorRepo();
//        AuthorService authorService = new AuthorService(authorRepo);
//        AuthorController authorController = new AuthorController(authorService);
//        authorController.postAuthor(new Author("sai","A1"));
//        ResponseEntity<Boolean> response = authorController.deleteAuthor("A1");
//        assertEquals(HttpStatus.OK,response.getStatusCode());
//    }
//    @Test
//    public void testDeleteAuthorReturnsNotFoundStatusCode(){
//        AuthorRepo authorRepo = new AuthorRepo();
//        AuthorService authorService = new AuthorService(authorRepo);
//        AuthorController authorController = new AuthorController(authorService);
//        authorController.postAuthor(new Author("sai","A1"));
//        ResponseEntity<Boolean> response = authorController.deleteAuthor("A2");
//        assertEquals(HttpStatus.NOT_FOUND,response.getStatusCode());
//    }
//    @Test
//    public void testDeleteAuthorReturnsTrue(){
//        AuthorRepo authorRepo = new AuthorRepo();
//        AuthorService authorService = new AuthorService(authorRepo);
//        AuthorController authorController = new AuthorController(authorService);
//        authorController.postAuthor(new Author("sai","A1"));
//        ResponseEntity<Boolean> response = authorController.deleteAuthor("A1");
//        assertEquals(true,response.getBody());
//    }
//    @Test
//    public void testDeleteAuthorReturnsFalse(){
//        AuthorRepo authorRepo = new AuthorRepo();
//        AuthorService authorService = new AuthorService(authorRepo);
//        AuthorController authorController = new AuthorController(authorService);
//        authorController.postAuthor(new Author("sai","A1"));
//        ResponseEntity<Boolean> response = authorController.deleteAuthor("A2");
//        assertEquals(false,response.getBody());
//    }
//}
