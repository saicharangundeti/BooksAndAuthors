package com.BooksAndAuthorsManagement;
import com.BooksAndAuthorsManagement.controller.AuthorsAndBooks;
import com.BooksAndAuthorsManagement.model.Author;
import com.BooksAndAuthorsManagement.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BooksAndAuthorsManagementApplicationTests {
	Author author = new Author("sai","A1");
	AuthorsAndBooks authorsAndBooks = new AuthorsAndBooks();
	ResponseEntity<Book> newBook = authorsAndBooks.postBook(new  Book("Hell","B1",10,author));

	@Test
	public void testGetAllBooks_ReturnsOkStatus() {
		ResponseEntity<Book> book1  = authorsAndBooks.postBook(new Book("Heaven","B2",15,author));
		ResponseEntity<Book> book2  = authorsAndBooks.postBook(new Book("Dream","B3",20,author));
		ResponseEntity<ArrayList<Book>> response = authorsAndBooks.getAllBooks("Heaven");
		assertEquals(response.getStatusCode(), HttpStatus.OK);
	}
	@Test
	public void testGetAllBooks_ReturnsNotFoundStatus() {
		ResponseEntity<Book> book2  = authorsAndBooks.postBook(new Book("Dream","B3",20,author));
		ResponseEntity<ArrayList<Book>> response = authorsAndBooks.getAllBooks("done");
		assertEquals(response.getStatusCode(), HttpStatus.NOT_FOUND);
	}
	@Test
	public void testGetAllBooks_ReturnsValidSizeOfBooks() {
		ResponseEntity<Book> book1  = authorsAndBooks.postBook(new Book("Heaven","B2",15,author));
		ResponseEntity<Book> book2  = authorsAndBooks.postBook(new Book("Heaven","B3",20,author));
		ResponseEntity<ArrayList<Book>> response = authorsAndBooks.getAllBooks("Heaven");
		assertEquals(response.getBody().size(), 2);
	}
	@Test
	public void testGetAllBooks_ReturnsInvalidSizeOfBooks() {
		ResponseEntity<Book> book1  = authorsAndBooks.postBook(new Book("Heaven","B2",15,author));
		ResponseEntity<Book> book2  = authorsAndBooks.postBook(new Book("Heaven","B3",20,author));
		ResponseEntity<ArrayList<Book>> response = authorsAndBooks.getAllBooks("Heaven");
		assertNotEquals(response.getBody().size(),1 );
	}

	@Test
	public void testGetABook_returnValidBook(){
		ResponseEntity<Book> response = authorsAndBooks.getABook("B1");
		assertEquals(response.getBody().getBookName(),"Hell");

	}
	@Test
	public void testGetABook_returnNull(){
		ResponseEntity<Book> response = authorsAndBooks.getABook("B2");
		assertEquals(response.getBody(),null);

	}
	@Test
	public void testGetABook_returnsOkStatusCode(){
		ResponseEntity<Book> response = authorsAndBooks.getABook("B1");
		assertEquals(response.getStatusCode(),HttpStatus.OK);

	}
	@Test
	public void testGetABook_returnsNotFoundStatusCode() {
		ResponseEntity<Book> response = authorsAndBooks.getABook("B2");
		assertEquals(response.getStatusCode(),HttpStatus.NOT_FOUND);
	}
	@Test
	public void testPutABook_returnsOkStatusCode(){
		ResponseEntity<Book> book1  = authorsAndBooks.postBook(new Book("Heaven","B2",15,author));
		ResponseEntity<Book> response = authorsAndBooks.updateBook(new Book("Hell","B2",20,author));
		assertEquals(response.getStatusCode(),HttpStatus.OK);
	}

	@Test
	public void testDeleteBook_returnsOkStatus(){
		ResponseEntity<Boolean> response = authorsAndBooks.deleteBook("B1");
		assertEquals(response.getStatusCode(),HttpStatus.OK);
	}
	@Test
	public void testDeleteBook_ReturnsNotFoundStatus(){
		ResponseEntity<Boolean> response = authorsAndBooks.deleteBook("B2");
		assertEquals(response.getStatusCode(),HttpStatus.NOT_FOUND);
	}
	@Test
	public void testGetAllAuthors_ReturnsOkStatus(){
		ResponseEntity<ArrayList<Author>> response = authorsAndBooks.getAllAuthors("sai");
		assertEquals(response.getStatusCode(),HttpStatus.OK);
	}
	@Test
	public void testGetAllAuthors_ReturnsNotFoundStatus(){
		ResponseEntity<ArrayList<Author>> response = authorsAndBooks.getAllAuthors("charan");
		assertEquals(response.getStatusCode(),HttpStatus.NOT_FOUND);
	}




}
