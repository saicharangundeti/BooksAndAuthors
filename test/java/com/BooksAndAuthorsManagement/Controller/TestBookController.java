package com.BooksAndAuthorsManagement.Controller;

import com.BooksAndAuthorsManagement.Service.BookService;
import com.BooksAndAuthorsManagement.controller.BookController;
import com.BooksAndAuthorsManagement.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestBookController {
    @Test
    public void testGetAllBooks() {
        BookService bookServiceMock = mock(BookService.class);
        Book book = new Book(1, "python", 200, Set.of(1, 2, 3));
        List<Book> books = Arrays.asList(book);
        when(bookServiceMock.findAllBooks()).thenReturn(books);
        BookController bookController = new BookController(bookServiceMock);

        ResponseEntity<List<Book>> response = bookController.getAllBooks();

        assertEquals(1, response.getBody().size(), "Should be correct size of Books");
        assertEquals(HttpStatus.OK, response.getStatusCode(), "Should be ok http status code");
    }

    @Test
    public void testGetBookById_Found() {
        BookService bookServiceMock = mock(BookService.class);
        Book book = new Book(1, "python", 200, Set.of(1, 2, 3));
        when(bookServiceMock.findBookById(anyInt())).thenReturn(book);
        BookController bookController = new BookController(bookServiceMock);

        ResponseEntity<Book> response = bookController.getBookById(2);

        assertEquals("python", response.getBody().getName(), "Should be correct book name");
        assertEquals(HttpStatus.OK, response.getStatusCode(), "Should be ok http status code");

    }

    @Test
    public void testGetBookById_BookNotFound() {
        BookService bookServiceMock = mock(BookService.class);
        Book book = new Book(1, "python", 200, Set.of(1, 2, 3));
        when(bookServiceMock.findBookById(0)).thenReturn(null);
        BookController bookController = new BookController(bookServiceMock);

        ResponseEntity<Book> response = bookController.getBookById(0);

        assertEquals(null, response.getBody(), "Should be null");
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode(), "Should be Not Found http status code");

    }

    @Test
    public void testGetBookByName_BookFound() {

        BookService bookServiceMock = mock(BookService.class);
        Book book = new Book(1,"Test Book",67,Set.of(2,3,4));
        String bookName = book.getName();
        when(bookServiceMock.findBookByName(bookName)).thenReturn(book);
        BookController bookController = new BookController(bookServiceMock);

        // Act
        ResponseEntity<Book> response = bookController.getBookByName(bookName);

        // Assert
        assertEquals(1, response.getBody().getId(), "Should be a valid book");
        assertEquals(HttpStatus.OK, response.getStatusCode(), "Should be Ok  http status code");

    }
    @Test
    public void testGetBookByName_NotFound(){

        BookService bookServiceMock = mock(BookService.class);
        Book book = new Book(1,"Test Book",67,Set.of(2,3,4));
        String bookName = book.getName();
        when(bookServiceMock.findBookByName("book")).thenReturn(null);
        BookController bookController = new BookController(bookServiceMock);

        // Act
        ResponseEntity<Book> response = bookController.getBookByName(bookName);

        // Assert
        assertEquals(null, response.getBody(), "Should be a valid book");
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode(), "Should be Ok  http status code");

    }
    @Test
    public void testPostBook_Success(){
        BookService bookServiceMock = mock(BookService.class);
        Book book = new Book();
        book.setId(1);
        book.setName("Test Book");

        when(bookServiceMock.saveBook(book)).thenReturn(book);
        BookController bookController = new BookController(bookServiceMock);

        // Act
        ResponseEntity<String> response = bookController.postBook(book);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode(),"Should be a ok http Status code");
        assertEquals("successfully posted", response.getBody(),"Should be a successfully posted message");
    }
    @Test
    public void testPostBook_Failure(){
        BookService bookServiceMock = mock(BookService.class);
        Book book = new Book();
        book.setId(1);
        book.setName("Test Book");

        when(bookServiceMock.saveBook(book)).thenReturn(null);
        BookController bookController = new BookController(bookServiceMock);

        // Act
        ResponseEntity<String> response = bookController.postBook(book);

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(null, response.getBody());
    }
    @Test
    public void testUpdateBook_Success(){
        BookService bookServiceMock = mock(BookService.class);
        Book book = new Book();
        book.setId(1);
        book.setName("Test Book");
        when(bookServiceMock.findBookById(1)).thenReturn(book);
        when(bookServiceMock.updateBook(1,book)).thenReturn(book);
        BookController bookController = new BookController(bookServiceMock);

        // Act
        ResponseEntity<Book> response = bookController.updateBook(1,book);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode(),"Should be a ok http Status code");
        assertEquals("Test Book", response.getBody().getName(),"Should be a correct book name");
    }
    @Test
    public void testUpdateBook_Failure(){
        BookService bookServiceMock = mock(BookService.class);
        Book book = new Book();
        book.setId(1);
        book.setName("Test Book");
        when(bookServiceMock.findBookById(0)).thenReturn(null);
        when(bookServiceMock.updateBook(0,book)).thenReturn(null);
        BookController bookController = new BookController(bookServiceMock);

        // Act
        ResponseEntity<Book> response = bookController.updateBook(0,book);

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode(),"Should be a Bad Request http Status code");
        assertEquals(null, response.getBody(),"Should be a correct book name");
    }
    @Test
    public void testDeleteBook_Success(){
        BookService bookServiceMock = mock(BookService.class);
        Book book = new Book();
        book.setId(1);
        book.setName("Test Book");
        when(bookServiceMock.deleteBook(1)).thenReturn(true);
        BookController bookController = new BookController(bookServiceMock);

        // Act
        ResponseEntity<Boolean> response = bookController.deleteBook(1);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode(),"Should be a ok http Status code");
        assertEquals(true, response.getBody(),"Should be true");
    }
    @Test
    public void testDeleteBook_Failure(){
        BookService bookServiceMock = mock(BookService.class);
        Book book = new Book();
        book.setId(1);
        book.setName("Test Book");
        when(bookServiceMock.deleteBook(0)).thenReturn(false);
        BookController bookController = new BookController(bookServiceMock);

        // Act
        ResponseEntity<Boolean> response = bookController.deleteBook(0);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode(),"Should be Not Found http Status code");
        assertEquals(false, response.getBody(),"Should be a false");
    }
}

