package com.BooksAndAuthorsManagement.Service;

import com.BooksAndAuthorsManagement.model.Book;
import com.BooksAndAuthorsManagement.repo.BookRepo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TestBookService {
    @Test
    public void testBookByIdReturnsValidBookName(){
        BookRepo bookRepo = new BookRepo();
        BookService bookService = new BookService(bookRepo);
        Book book1 = bookService.saveBook(new Book("hell","B1",20,"A1"));
        Book response = bookService.findBookById("B1");
        assertEquals(book1.getName(),response.getName());
    }
    @Test
    public void testBookByIdReturnsNull(){
        BookRepo bookRepo = new BookRepo();
        BookService bookService = new BookService(bookRepo);
        bookService.saveBook(new Book("hell","B1",20,"A1"));
        Book response = bookService.findBookById("B2");
        assertNull(response);
    }
    @Test
    public void testFindAllBooksReturnsValidSize(){
        BookRepo bookRepo = new BookRepo();
        BookService bookService = new BookService(bookRepo);
        bookService.saveBook(new Book("hell","B1",20,"A1"));
        bookService.saveBook(new Book("heaven","B2",10,"A2"));
        ArrayList<Book> response = bookService.findAllBooks();
        assertEquals(2,response.size());
    }
    @Test
    public void testFindAllBooksByNameReturnsValidSize(){
        BookRepo bookRepo = new BookRepo();
        BookService bookService = new BookService(bookRepo);
        bookService.saveBook(new Book("hell","B1",20,"A1"));
        bookService.saveBook(new Book("heaven","B2",10,"A2"));
        ArrayList<Book> response = bookService.findAllBooksByName("hell");
        assertEquals(1,response.size());
    }
    @Test
    public void testFindAllBooksByNameReturnsZeroSize(){
        BookRepo bookRepo = new BookRepo();
        BookService bookService = new BookService(bookRepo);
        bookService.saveBook(new Book("hell","B1",20,"A1"));
        bookService.saveBook(new Book("heaven","B2",10,"A2"));
        ArrayList<Book> response = bookService.findAllBooksByName("dark");
        assertEquals(0,response.size());
    }
    @Test
    public void testSaveBookReturnsValidName(){
        BookRepo bookRepo = new BookRepo();
        BookService bookService = new BookService(bookRepo);
        Book response = bookService.saveBook(new Book("heaven","B2",10,"A2"));
        assertEquals("heaven",response.getName());
    }
    @Test
    public void testSaveBookReturnsNull(){
        BookRepo bookRepo = new BookRepo();
        BookService bookService = new BookService(bookRepo);
        bookService.saveBook(new Book("hell","B1",20,"A1"));
        Book response = bookService.saveBook(new Book("heaven","B1",10,"A2"));
        assertNull(response);
    }
    @Test
    public void testBookUpdateReturnsValidBookName(){
        BookRepo bookRepo = new BookRepo();
        BookService bookService = new BookService(bookRepo);
        bookService.saveBook(new Book("hell","B1",20,"A1"));
        Book response = bookService.updateBook(new Book("heaven","B1",10,"A2"));
        assertEquals("heaven",response.getName());
    }
    @Test
    public void testBookUpdateReturnsNull(){
        BookRepo bookRepo = new BookRepo();
        BookService bookService = new BookService(bookRepo);
        bookService.saveBook(new Book("hell","B1",20,"A1"));
        Book response = bookService.updateBook(new Book("heaven","B2",10,"A2"));
        assertNull(response);
    }
    @Test
    public void testRemoveBookReturnsTrue(){
        BookRepo bookRepo = new BookRepo();
        BookService bookService = new BookService(bookRepo);
        bookService.saveBook(new Book("hell","B1",20,"A1"));
        Boolean response = bookService.removeBook("B1");
        assertEquals(true, response);
    }
    @Test
    public void testRemoveBookReturnsFalse(){
        BookRepo bookRepo = new BookRepo();
        BookService bookService = new BookService(bookRepo);
        bookService.saveBook(new Book("hell","B1",20,"A1"));
        Boolean response = bookService.removeBook("B2");
        assertEquals(false, response);
    }



}
