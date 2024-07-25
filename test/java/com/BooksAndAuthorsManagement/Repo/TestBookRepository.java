//package com.BooksAndAuthorsManagement.Repo;
//
//import com.BooksAndAuthorsManagement.model.Book;
//import com.BooksAndAuthorsManagement.repo.BookRepo;
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNull;
//
//public class TestBookRepository {
//
//    @Test
//    public void testAddBookReturnsValidBookName(){
//        BookRepo bookRepo = new BookRepo();
//        Book response = bookRepo.addBook(new Book("hell", "B1",20,"A1"));
//        assertEquals("hell",response.getName());
//    }
//    @Test
//    public void testAddBookReturnsNull() {
//        BookRepo bookRepo = new BookRepo();
//        bookRepo.addBook(new Book("hell", "B1", 20, "A1"));
//        Book response = bookRepo.addBook(new Book("heaven", "B1", 20, "A2"));
//        assertNull(response);
//    }
//    @Test
//    public void testGetBookReturnsValidBookName() {
//        BookRepo bookRepo = new BookRepo();
//        bookRepo.addBook(new Book("hell", "B1", 20, "A1"));
//        Book response = bookRepo.getBook("B1");
//        assertEquals("hell",response.getName());
//    }
//    @Test
//    public void testGetBookReturnsNull() {
//        BookRepo bookRepo = new BookRepo();
//        bookRepo.addBook(new Book("hell", "B1", 20, "A1"));
//        Book response = bookRepo.getBook("B2");
//        assertNull(response);
//    }
//    @Test
//    public void testUpdateBookReturnsValidBookName() {
//        BookRepo bookRepo = new BookRepo();
//        bookRepo.addBook(new Book("hell", "B1", 20, "A1"));
//        Book response = bookRepo.updateBook(new Book("heaven", "B1", 10, "A2"));
//        assertEquals("heaven",response.getName());
//    }
//    @Test
//    public void testUpdateBookReturnsNull() {
//        BookRepo bookRepo = new BookRepo();
//        bookRepo.addBook(new Book("hell", "B1", 20, "A1"));
//        Book response = bookRepo.updateBook(new Book("heaven", "B2", 10, "A2"));
//        assertNull(response);
//    }
//    @Test
//    public void testFindAllBooksReturnsValidSize() {
//        BookRepo bookRepo = new BookRepo();
//        bookRepo.addBook(new Book("hell", "B1", 20, "A1"));
//        bookRepo.addBook(new Book("heaven", "B2", 10, "A2"));
//        ArrayList<Book> response = bookRepo.findAllBooks();
//        assertEquals(2,response.size());
//    }
//    @Test
//    public void testFindAllBooksReturnsZeroSize() {
//        BookRepo bookRepo = new BookRepo();
//        ArrayList<Book> response = bookRepo.findAllBooks();
//        assertEquals(0,response.size());
//    }
//    @Test
//    public void testFindAllBooksByNameReturnsValidSize() {
//        BookRepo bookRepo = new BookRepo();
//        bookRepo.addBook(new Book("hell", "B1", 20, "A1"));
//        bookRepo.addBook(new Book("heaven", "B2", 10, "A2"));
//        ArrayList<Book> response = bookRepo.findAllBooksByName("hell");
//        assertEquals(1,response.size());
//    }
//    @Test
//    public void testFindAllBooksByNameReturnsZeroSize() {
//        BookRepo bookRepo = new BookRepo();
//        bookRepo.addBook(new Book("hell", "B1", 20, "A1"));
//        bookRepo.addBook(new Book("heaven", "B2", 10, "A2"));
//        ArrayList<Book> response = bookRepo.findAllBooksByName("dark");
//        assertEquals(0,response.size());
//    }
//    @Test
//    public void testRemoveBookReturnsTrue() {
//        BookRepo bookRepo = new BookRepo();
//        bookRepo.addBook(new Book("hell", "B1", 20, "A1"));
//        Boolean response = bookRepo.removeBook("B1");
//        assertEquals(true,response);
//    }
//    @Test
//    public void testRemoveBookReturnsFalse() {
//        BookRepo bookRepo = new BookRepo();
//        bookRepo.addBook(new Book("hell", "B1", 20, "A1"));
//        Boolean response = bookRepo.removeBook("B2");
//        assertEquals(false,response);
//    }
//
//
//
//
//
//}
