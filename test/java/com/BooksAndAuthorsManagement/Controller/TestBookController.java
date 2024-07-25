package com.BooksAndAuthorsManagement.Controller;

import com.BooksAndAuthorsManagement.Service.BookService;
import com.BooksAndAuthorsManagement.controller.BookController;
import com.BooksAndAuthorsManagement.model.Book;
import com.BooksAndAuthorsManagement.repo.BookRepo;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
//import static org.junit.jupiter.api.Assertions.*;
//
//public class TestBookController {
//    @Test
//    public void testGetABookReturnsOkStatus(){
//        BookRepo bookRepo = new BookRepo();
//        BookService bookService = new BookService(bookRepo);
//        BookController bookController = new BookController(bookService);
//        bookController.postBook(new Book("hell","B1",20,"A1"));
//        ResponseEntity<Book> response = bookController.getABook("B1");
//        assertEquals(HttpStatus.OK,response.getStatusCode());
//
//    }
//    @Test
//    public void testGetABookReturnsNotFoundStatus(){
//        BookRepo bookRepo = new BookRepo();
//        BookService bookService = new BookService(bookRepo);
//        BookController bookController = new BookController(bookService);
//        bookController.postBook(new Book("hell","B1",20,"A1"));
//        ResponseEntity<Book> response = bookController.getABook("B2");
//        assertEquals(HttpStatus.NOT_FOUND,response.getStatusCode());
//
//    }
//    @Test
//    public void testGetABookReturnsValidBookName(){
//        BookRepo bookRepo = new BookRepo();
//        BookService bookService = new BookService(bookRepo);
//        BookController bookController = new BookController(bookService);
//        bookController.postBook(new Book("hell","B1",20,"A1"));
//        ResponseEntity<Book> response = bookController.getABook("B1");
//        assertEquals("hell",response.getBody().getName());
//    }
//    @Test
//    public void testGetABookReturnsNull(){
//        BookRepo bookRepo = new BookRepo();
//        BookService bookService = new BookService(bookRepo);
//        BookController bookController = new BookController(bookService);
//        bookController.postBook(new Book("hell","B1",20,"A1"));
//        ResponseEntity<Book> response = bookController.getABook("B2");
//        assertNull(response.getBody());
//    }
//    @Test
//    public void testGetAllBookReturnsOKStatus(){
//        BookRepo bookRepo = new BookRepo();
//        BookService bookService = new BookService(bookRepo);
//        BookController bookController = new BookController(bookService);
//        bookController.postBook(new Book("hell","B1",20,"A1"));
//        bookController.postBook(new Book("heaven","B2",18,"A2"));
//        ResponseEntity<ArrayList<Book>> response = bookController.getAllBooks(null);
//        assertEquals(HttpStatus.OK,response.getStatusCode());
//
//    }
//    @Test
//    public void testGetAllBookReturnsNotFoundStatus(){
//        BookRepo bookRepo = new BookRepo();
//        BookService bookService = new BookService(bookRepo);
//        BookController bookController = new BookController(bookService);
//        bookController.postBook(new Book("hell","B1",20,"A1"));
//        bookController.postBook(new Book("heaven","B2",18,"A2"));
//        ResponseEntity<ArrayList<Book>> response = bookController.getAllBooks("Dark");
//        assertEquals(HttpStatus.NOT_FOUND,response.getStatusCode());
//    }
//    @Test
//    public void testGetAllBookReturnsValidSize(){
//        BookRepo bookRepo = new BookRepo();
//        BookService bookService = new BookService(bookRepo);
//        BookController bookController = new BookController(bookService);
//        bookController.postBook(new Book("hell","B1",20,"A1"));
//        bookController.postBook(new Book("heaven","B2",18,"A2"));
//        ResponseEntity<ArrayList<Book>> response = bookController.getAllBooks(null);
//        assertEquals(2,response.getBody().size());
//    }
//    @Test
//    public void testGetAllBookReturnsInValidSize(){
//        BookRepo bookRepo = new BookRepo();
//        BookService bookService = new BookService(bookRepo);
//        BookController bookController = new BookController(bookService);
//        bookController.postBook(new Book("hell","B1",20,"A1"));
//        bookController.postBook(new Book("heaven","B2",18,"A2"));
//        ResponseEntity<ArrayList<Book>> response = bookController.getAllBooks("hell");
//        assertNotEquals(2,response.getBody().size());
//    }
//    @Test
//    public void testPostBookReturnsOkStatusCode(){
//        BookRepo bookRepo = new BookRepo();
//        BookService bookService = new BookService(bookRepo);
//        BookController bookController = new BookController(bookService);
//        ResponseEntity<Book> response = bookController.postBook(new Book("hell","B1",20,"A1"));
//        assertEquals(HttpStatus.OK,response.getStatusCode());
//    }
//    @Test
//    public void testPostBookReturnsBadRequestStatusCode(){
//        BookRepo bookRepo = new BookRepo();
//        BookService bookService = new BookService(bookRepo);
//        BookController bookController = new BookController(bookService);
//        bookController.postBook(new Book("hell","B1",20,"A1"));
//        ResponseEntity<Book> response = bookController.postBook(new Book("heaven","B1",10,"A2"));
//        assertEquals(HttpStatus.BAD_REQUEST,response.getStatusCode());
//    }
//    @Test
//    public void testPostBookReturnsValidName(){
//        BookRepo bookRepo = new BookRepo();
//        BookService bookService = new BookService(bookRepo);
//        BookController bookController = new BookController(bookService);
//        ResponseEntity<Book> response = bookController.postBook(new Book("hell","B1",20,"A1"));
//        assertEquals("hell",response.getBody().getName());
//    }
//    @Test
//    public void testPostBookReturnsNull(){
//        BookRepo bookRepo = new BookRepo();
//        BookService bookService = new BookService(bookRepo);
//        BookController bookController = new BookController(bookService);
//        bookController.postBook(new Book("hell","B1",20,"A1"));
//        ResponseEntity<Book> response = bookController.postBook(new Book("heaven","B1",10,"A2"));
//        assertNull(response.getBody());
//    }
//    @Test
//    public void testUpdateBookReturnsOKStatusCode(){
//        BookRepo bookRepo = new BookRepo();
//        BookService bookService = new BookService(bookRepo);
//        BookController bookController = new BookController(bookService);
//        bookController.postBook(new Book("hell","B1",20,"A1"));
//        ResponseEntity<Book> response = bookController.updateBook(new Book("heaven","B1",10,"A2"));
//        assertEquals(HttpStatus.OK,response.getStatusCode());
//    }
//    @Test
//    public void testUpdateBookReturnsBadRequestStatusCode(){
//        BookRepo bookRepo = new BookRepo();
//        BookService bookService = new BookService(bookRepo);
//        BookController bookController = new BookController(bookService);
//        bookController.postBook(new Book("hell","B1",20,"A1"));
//        ResponseEntity<Book> response = bookController.updateBook(new Book("heaven","B2",10,"A2"));
//        assertEquals(HttpStatus.BAD_REQUEST,response.getStatusCode());
//    }
//    @Test
//    public void testUpdateBookReturnsValidName(){
//        BookRepo bookRepo = new BookRepo();
//        BookService bookService = new BookService(bookRepo);
//        BookController bookController = new BookController(bookService);
//        bookController.postBook(new Book("hell","B1",20,"A1"));
//        ResponseEntity<Book> response = bookController.updateBook(new Book("heaven","B1",10,"A2"));
//        assertEquals("heaven",response.getBody().getName());
//    }
//    @Test
//    public void testUpdateBookReturnsNull(){
//        BookRepo bookRepo = new BookRepo();
//        BookService bookService = new BookService(bookRepo);
//        BookController bookController = new BookController(bookService);
//        bookController.postBook(new Book("hell","B1",20,"A1"));
//        ResponseEntity<Book> response = bookController.updateBook(new Book("heaven","B2",10,"A2"));
//        assertNull(response.getBody());
//    }
//
//    @Test
//    public void testDeleteBookReturnsOkStatusCode(){
//        BookRepo bookRepo = new BookRepo();
//        BookService bookService = new BookService(bookRepo);
//        BookController bookController = new BookController(bookService);
//        bookController.postBook(new Book("hell","B1",20,"A1"));
//        ResponseEntity<Boolean> response = bookController.deleteBook("B1");
//        assertEquals(HttpStatus.OK,response.getStatusCode());
//    }
//    @Test
//    public void testDeleteBookReturnsNotFoundStatusCode(){
//        BookRepo bookRepo = new BookRepo();
//        BookService bookService = new BookService(bookRepo);
//        BookController bookController = new BookController(bookService);
//        bookController.postBook(new Book("hell","B1",20,"A1"));
//        ResponseEntity<Boolean> response = bookController.deleteBook("B2");
//        assertEquals(HttpStatus.NOT_FOUND,response.getStatusCode());
//    }
//    @Test
//    public void testDeleteBookReturnsTrue(){
//        BookRepo bookRepo = new BookRepo();
//        BookService bookService = new BookService(bookRepo);
//        BookController bookController = new BookController(bookService);
//        bookController.postBook(new Book("hell","B1",20,"A1"));
//        ResponseEntity<Boolean> response = bookController.deleteBook("B1");
//        assertEquals(true,response.getBody());
//    }
//    @Test
//    public void testDeleteBookReturnsFalse(){
//        BookRepo bookRepo = new BookRepo();
//        BookService bookService = new BookService(bookRepo);
//        BookController bookController = new BookController(bookService);
//        bookController.postBook(new Book("hell","B1",20,"A1"));
//        ResponseEntity<Boolean> response = bookController.deleteBook("B2");
//        assertEquals(false,response.getBody());
//    }
//
//}
