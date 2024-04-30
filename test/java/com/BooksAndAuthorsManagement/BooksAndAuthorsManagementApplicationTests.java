package com.BooksAndAuthorsManagement;
import com.BooksAndAuthorsManagement.controller.AuthorController;
import com.BooksAndAuthorsManagement.controller.BookController;
import com.BooksAndAuthorsManagement.model.Author;
import com.BooksAndAuthorsManagement.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BooksAndAuthorsManagementApplicationTests {
	AuthorController authorController = new AuthorController();
	BookController bookController = new BookController();

	@Test
	public void testGetAllBooksReturnsOkStatus() {
		ResponseEntity<Book> book1  = bookController.postBook(new Book("Heaven","B2",15,"A1"));
		ResponseEntity<Book> book2  = bookController.postBook(new Book("Dream","B3",20,"A2"));
		ResponseEntity<ArrayList<Book>> response = BookController.getAllBooks("Heaven");
		assertEquals(response.getStatusCode(), HttpStatus.OK);
	}
	@Test
	public void testGetAllBooksReturnsNotFoundStatus() {
		ResponseEntity<Book> book2  = bookController.postBook(new Book("Dream","B3",20,"A1"));
		ResponseEntity<ArrayList<Book>> response = bookController.getAllBooks("done");
		assertEquals(response.getStatusCode(), HttpStatus.NOT_FOUND);
	}
	@Test
	public void testGetAllBooksReturnsValidSizeOfBooks() {
		ResponseEntity<Book> book1  = bookController.postBook(new Book("Heaven","B2",15,"A1"));
		ResponseEntity<Book> book2  = bookController.postBook(new Book("Heaven","B3",20,"A2"));
		ResponseEntity<ArrayList<Book>> response = bookController.getAllBooks("Heaven");
		assertEquals(response.getBody().size(), 2);
	}
	@Test
	public void testGetAllBooksReturnsInvalidSizeOfBooks() {
		ResponseEntity<Book> book1  = bookController.postBook(new Book("Heaven","B2",15,"A1"));
		ResponseEntity<Book> book2  = bookController.postBook(new Book("Heaven","B3",20,"A2"));
		ResponseEntity<ArrayList<Book>> response = BookController.getAllBooks("Heaven");
		assertNotEquals(response.getBody().size(),1 );
	}

	@Test
	public void testGetABookReturnValidBook(){
		ResponseEntity<Book> book1  = bookController.postBook(new Book("Heaven","B2",15,"A1"));
		ResponseEntity<Book> response = bookController.getABook("B2");
		assertEquals(response.getBody().getBookName(),"Heaven");

	}
	@Test
	public void testGetABookReturnsNull(){
		ResponseEntity<Book> book1  = bookController.postBook(new Book("Heaven","B2",15,"A1"));
		ResponseEntity<Book> response = bookController.getABook("B1");
		assertEquals(response.getBody(),null);

	}
	@Test
	public void testGetABookReturnsOkStatusCode(){
		ResponseEntity<Book> book1  = bookController.postBook(new Book("Heaven","B2",15,"A1"));
		ResponseEntity<Book> response = bookController.getABook("B2");
		assertEquals(response.getStatusCode(),HttpStatus.OK);

	}
	@Test
	public void testGetABookReturnsNotFoundStatusCode() {
		ResponseEntity<Book> book1  = bookController.postBook(new Book("Heaven","B2",15,"A1"));
		ResponseEntity<Book> response = bookController.getABook("B1");
		assertEquals(response.getStatusCode(),HttpStatus.NOT_FOUND);
	}
	@Test
	public void testPutABookReturnsOkStatusCode(){
		ResponseEntity<Book> book1  = bookController.postBook(new Book("Heaven","B2",15,"A1"));
		ResponseEntity<Book> response = bookController.updateBook(new Book("Hell","B2",20,"A2"));
		assertEquals(response.getStatusCode(),HttpStatus.OK);
	}

	@Test
	public void testDeleteBookReturnsOkStatus(){
		ResponseEntity<Book> book1  = bookController.postBook(new Book("Heaven","B2",15,"A1"));

		ResponseEntity<Boolean> response = bookController.deleteBook("B2");
		assertEquals(response.getStatusCode(),HttpStatus.OK);
	}
	@Test
	public void testDeleteBookReturnsNotFoundStatus(){
		ResponseEntity<Book> book1  = bookController.postBook(new Book("Heaven","B2",15,"A1"));
		ResponseEntity<Boolean> response = bookController.deleteBook("B1");
		assertEquals(response.getStatusCode(),HttpStatus.NOT_FOUND);
	}
	@Test
	public void testGetAllAuthorsReturnsOkStatus(){
		ResponseEntity<Author> author1  = authorController.postAuthor(new Author("sai","A1"));
		ResponseEntity<ArrayList<Author>> response = AuthorController.getAllAuthors("sai");
		assertEquals(response.getStatusCode(),HttpStatus.OK);
	}
	@Test
	public void testGetAllAuthorsReturnsNotFoundStatus(){
		ResponseEntity<Author> author1  = authorController.postAuthor(new Author("sai","A1"));
		ResponseEntity<ArrayList<Author>> response = authorController.getAllAuthors("charan");
		assertEquals(response.getStatusCode(),HttpStatus.NOT_FOUND);
	}
}
